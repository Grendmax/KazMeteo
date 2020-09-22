package kz.meteo.kazmeteo.screens

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kz.meteo.kazmeteo.databinding.FragmentWeatherBinding
import kz.meteo.kazmeteo.models.CurrentCityWeather
import kz.meteo.kazmeteo.models.FutureCityWeather
import kz.meteo.kazmeteo.screens.city.CityFragmentViewModel


class WeatherFragment : Fragment() {

    private var _binding: FragmentWeatherBinding? = null
    private val mBinding get() = _binding!!
    private lateinit var mViewModel: CityFragmentViewModel
    private var mContext: Context? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        return inflater.inflate(R.layout.fragment_weather, container, false)
        _binding = FragmentWeatherBinding.inflate(layoutInflater, container, false)
        mContext = context
        return mBinding.root
    }


    override fun onStart() {
        super.onStart()
        initialization()
        initializeObservers()
    }


    private fun initialization() {
        mViewModel = ViewModelProvider(this).get(CityFragmentViewModel::class.java)
        mViewModel.initDatabase()
    }

    private fun initializeObservers() {

        val bundle: Bundle? = this.arguments
        val city: CurrentCityWeather? = bundle?.getParcelable("cityFromCityFragment")

        Log.d("items", city?.name.toString())
        Log.d("items", city?.coord?.lat.toString())

        var futureWeather = FutureCityWeather()
        var currentCity = mutableListOf<CurrentCityWeather>()
        mViewModel.fetchFutureWeatherFromServer(
            mContext!!,
            city?.coord?.lat.toString(),
            city?.coord?.lon.toString()
        ).observe(this, Observer { kt ->
            futureWeather = kt
        })
        Log.d("items", futureWeather.toString())


    }


}