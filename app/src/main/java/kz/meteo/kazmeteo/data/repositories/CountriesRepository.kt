package kz.meteo.kazmeteo.data.repositories


import androidx.lifecycle.MutableLiveData
import kz.meteo.kazmeteo.data.api.RestClient
import kz.meteo.kazmeteo.interfaces.NetworkResponseCallback
import kz.meteo.kazmeteo.models.CurrentCityWeather
import kz.meteo.kazmeteo.models.FutureCityWeather
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CountriesRepository private constructor() {
    private lateinit var mCallback: NetworkResponseCallback
    private var mCountryList: MutableLiveData<CurrentCityWeather> =
        MutableLiveData<CurrentCityWeather>()
    private var mFutureWeather: MutableLiveData<FutureCityWeather> =
        MutableLiveData<FutureCityWeather>()

    companion object {
        private var mInstance: CountriesRepository? = null
        fun getInstance(): CountriesRepository {
            if (mInstance == null) {
                synchronized(this) {
                    mInstance = CountriesRepository()
                }
            }
            return mInstance!!
        }
    }


    private lateinit var mCountryCall: Call<CurrentCityWeather>
    private lateinit var mCityFutureCall: Call<FutureCityWeather>

    fun getCountries(
        callback: NetworkResponseCallback,
        cityName: String
    ): MutableLiveData<CurrentCityWeather> {
        mCallback = callback

        mCountryCall = RestClient.getInstance().getApiService().initiateGetСurrentWeather(cityName)
        mCountryCall.enqueue(object : Callback<CurrentCityWeather> {

            override fun onResponse(
                call: Call<CurrentCityWeather>,
                response: Response<CurrentCityWeather>
            ) {
                mCountryList.value = response.body()
                mCallback.onNetworkSuccess()
            }

            override fun onFailure(call: Call<CurrentCityWeather>, t: Throwable) {
                mCountryList.value = null
                mCallback.onNetworkFailure(t)
            }

        })
        return mCountryList
    }


    fun getFutureWeather(
        callback: NetworkResponseCallback,
        lat: String,
        lon: String
    ): MutableLiveData<FutureCityWeather> {
        mCallback = callback

        mCityFutureCall =
            RestClient.getInstance().getApiService().initiateGetFutureWeather(lat, lon)
        mCityFutureCall.enqueue(object : Callback<FutureCityWeather> {

            override fun onResponse(
                call: Call<FutureCityWeather>,
                response: Response<FutureCityWeather>
            ) {
                mFutureWeather.value = response.body()
                mCallback.onNetworkSuccess()
            }

            override fun onFailure(call: Call<FutureCityWeather>, t: Throwable) {
                mFutureWeather.value = null
                mCallback.onNetworkFailure(t)
            }

        })
        return mFutureWeather
    }


}