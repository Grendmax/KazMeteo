package kz.meteo.kazmeteo.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class FutureCityWeather : Parcelable {
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

    @SerializedName("daily")
    @Expose
    var daily: List<Daily>? = null

    constructor(parcel: Parcel) : this() {
        lat = parcel.readValue(Double::class.java.classLoader) as? Double
        lon = parcel.readValue(Double::class.java.classLoader) as? Double
        timezone = parcel.readString()
        timezoneOffset = parcel.readValue(Int::class.java.classLoader) as? Int
    }

    constructor()

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
        }
    }

    inner class Daily {
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
        var temp: Temp? = null

        @SerializedName("feels_like")
        @Expose
        var feelsLike: FeelsLike? = null

        @SerializedName("pressure")
        @Expose
        var pressure: Int? = null

        @SerializedName("humidity")
        @Expose
        var humidity: Int? = null

        @SerializedName("dew_point")
        @Expose
        var dewPoint: Double? = null

        @SerializedName("wind_speed")
        @Expose
        var windSpeed: Double? = null

        @SerializedName("wind_deg")
        @Expose
        var windDeg: Int? = null

        @SerializedName("weather")
        @Expose
        var weather: List<Weather_>? = null

        @SerializedName("clouds")
        @Expose
        var clouds: Int? = null

        @SerializedName("pop")
        @Expose
        var pop: Int? = null

        @SerializedName("rain")
        @Expose
        var rain: Double? = null

        @SerializedName("uvi")
        @Expose
        var uvi: Double? = null

        inner class FeelsLike {
            @SerializedName("day")
            @Expose
            var day: Double? = null

            @SerializedName("night")
            @Expose
            var night: Double? = null

            @SerializedName("eve")
            @Expose
            var eve: Double? = null

            @SerializedName("morn")
            @Expose
            var morn: Double? = null
        }

        inner class Temp {
            @SerializedName("day")
            @Expose
            var day: Double? = null

            @SerializedName("min")
            @Expose
            var min: Double? = null

            @SerializedName("max")
            @Expose
            var max: Double? = null

            @SerializedName("night")
            @Expose
            var night: Double? = null

            @SerializedName("eve")
            @Expose
            var eve: Double? = null

            @SerializedName("morn")
            @Expose
            var morn: Double? = null
        }

        inner class Weather_ {
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
        }
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(lat)
        parcel.writeValue(lon)
        parcel.writeString(timezone)
        parcel.writeValue(timezoneOffset)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<FutureCityWeather> {
        override fun createFromParcel(parcel: Parcel): FutureCityWeather {
            return FutureCityWeather(parcel)
        }

        override fun newArray(size: Int): Array<FutureCityWeather?> {
            return arrayOfNulls(size)
        }
    }


}