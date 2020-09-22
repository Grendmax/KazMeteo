package kz.meteo.kazmeteo.screens.city

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import kz.meteo.kazmeteo.data.AppDatabase
import kz.meteo.kazmeteo.data.repositories.CountriesRepository
import kz.meteo.kazmeteo.data.room.CityRepository
import kz.meteo.kazmeteo.interfaces.NetworkResponseCallback
import kz.meteo.kazmeteo.models.CurrentCityWeather
import kz.meteo.kazmeteo.models.FutureCityWeather
import kz.meteo.kazmeteo.utilits.CITY_REPOSITORY
import kz.meteo.kazmeteo.utilits.NetworkHelper

class CityFragmentViewModel(application: Application) : AndroidViewModel(application) {
    private val mContext = application
    private var mList: MutableLiveData<CurrentCityWeather> = MutableLiveData<CurrentCityWeather>()
    private var mFutureWeather: MutableLiveData<FutureCityWeather> =
        MutableLiveData<FutureCityWeather>()
    var mShowProgressBar: MutableLiveData<Boolean> = MutableLiveData()
    private var mShowNetworkError: MutableLiveData<Boolean> = MutableLiveData()
    private var mShowApiError: MutableLiveData<Boolean> = MutableLiveData()
    private var mRepository = CountriesRepository.getInstance()

    fun getCountriesList() = mList

    fun fetchCountriesFromServer(
        context: Context,
        cityName: String
    ): MutableLiveData<CurrentCityWeather> {
        if (NetworkHelper.isOnline(context)) {
            mShowProgressBar.value = true
            mList = mRepository.getCountries(object : NetworkResponseCallback {
                override fun onNetworkFailure(th: Throwable) {
                    mShowApiError.value = true
                }

                override fun onNetworkSuccess() {
                    mShowProgressBar.value = false
                }
            }, cityName)
        } else {
            mShowNetworkError.value = true
        }
        return mList
    }


    fun fetchFutureWeatherFromServer(
        context: Context,
        lat: String,
        lon: String
    ): MutableLiveData<FutureCityWeather> {
        if (NetworkHelper.isOnline(context)) {
            mShowProgressBar.value = true
            mFutureWeather = mRepository.getFutureWeather(object : NetworkResponseCallback {
                override fun onNetworkFailure(th: Throwable) {
                    mShowApiError.value = true
                }

                override fun onNetworkSuccess() {
                    mShowProgressBar.value = false
                }
            }, lat, lon)
        } else {
            mShowNetworkError.value = true
        }
        return mFutureWeather
    }


    fun initDatabase() {
        val dao = AppDatabase.getInstance(mContext).getCityDao()
        CITY_REPOSITORY = CityRepository(dao)
    }

}