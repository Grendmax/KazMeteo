package kz.meteo.kazmeteo.data.api

import kz.meteo.kazmeteo.models.CurrentCityWeather
import kz.meteo.kazmeteo.models.FutureCityWeather
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {


    @GET(ApiConstants.CURRENT)
    fun initiateGetСurrentWeather(@Query("q") city: String): Call<CurrentCityWeather>

    @GET(ApiConstants.FUTURE)
    fun initiateGetFutureWeather(
        @Query("lat") lat: String,
        @Query("lon") lon: String
    ): Call<FutureCityWeather>


}