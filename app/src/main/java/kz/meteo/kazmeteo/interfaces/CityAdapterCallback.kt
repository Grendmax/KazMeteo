package kz.meteo.kazmeteo.interfaces

import kz.meteo.kazmeteo.models.CurrentCityWeather

interface CityAdapterCallback {
    fun onMethodCallback(futureWeather: CurrentCityWeather)
}