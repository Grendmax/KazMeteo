package kz.meteo.kazmeteo.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class CurrentWeather {
    @SerializedName("lat")
    @Expose
    var lat: Double? = null

    @SerializedName("lon")
    @Expose
    var lon: Double? = null

    @SerializedName("timezone")
    @Expose
    var timezone: String? = null

    @SerializedName("timezone_offset")
    @Expose
    var timezoneOffset: Int? = null

    @SerializedName("current")
    @Expose
    var current: Current? = null

    inner class Current {
        @SerializedName("dt")
        @Expose
        var dt: Int? = null

        @SerializedName("sunrise")
        @Expose
        var sunrise: Int? = null

        @SerializedName("sunset")
        @Expose
        var sunset: Int? = null

        @SerializedName("temp")
        @Expose
        var temp: Int? = null

        @SerializedName("feels_like")
        @Expose
        var feelsLike: Double? = null

        @SerializedName("pressure")
        @Expose
        var pressure: Int? = null

        @SerializedName("humidity")
        @Expose
        var humidity: Int? = null

        @SerializedName("dew_point")
        @Expose
        var dewPoint: Double? = null

        @SerializedName("uvi")
        @Expose
        var uvi: Double? = null

        @SerializedName("clouds")
        @Expose
        var clouds: Int? = null

        @SerializedName("visibility")
        @Expose
        var visibility: Int? = null

        @SerializedName("wind_speed")
        @Expose
        var windSpeed: Int? = null

        @SerializedName("wind_deg")
        @Expose
        var windDeg: Int? = null

        @SerializedName("wind_gust")
        @Expose
        var windGust: Int? = null

        @SerializedName("weather")
        @Expose
        var weather: List<Weather>? = null

        inner class Weather {
            @SerializedName("id")
            @Expose
            var id: Int? = null

            @SerializedName("main")
            @Expose
            var main: String? = null

            @SerializedName("description")
            @Expose
            var description: String? = null

            @SerializedName("icon")
            @Expose
            var icon: String? = null
            override fun toString(): String {
                return "Weather(id=$id, main=$main, description=$description, icon=$icon)"
            }
        }

        override fun toString(): String {
            return "Current(dt=$dt, sunrise=$sunrise, sunset=$sunset, temp=$temp, feelsLike=$feelsLike, pressure=$pressure, humidity=$humidity, dewPoint=$dewPoint, uvi=$uvi, clouds=$clouds, visibility=$visibility, windSpeed=$windSpeed, windDeg=$windDeg, windGust=$windGust, weather=$weather)"
        }
    }

    override fun toString(): String {
        return "CurrentWeather(lat=$lat, lon=$lon, timezone=$timezone, timezoneOffset=$timezoneOffset, current=$current)"
    }
}