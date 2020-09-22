package kz.meteo.kazmeteo.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class CurrentCityWeather() : Parcelable {
    @SerializedName("coord")
    @Expose
    var coord: Coord? = null

    @SerializedName("weather")
    @Expose
    var weather: List<Weather>? = null

    @SerializedName("base")
    @Expose
    var base: String? = null

    @SerializedName("main")
    @Expose
    var main: Main? = null

    @SerializedName("visibility")
    @Expose
    var visibility: Int? = null

    @SerializedName("wind")
    @Expose
    var wind: Wind? = null

    @SerializedName("clouds")
    @Expose
    var clouds: Clouds? = null

    @SerializedName("dt")
    @Expose
    var dt: Int? = null

    @SerializedName("sys")
    @Expose
    var sys: Sys? = null

    @SerializedName("timezone")
    @Expose
    var timezone: Int? = null

    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("cod")
    @Expose
    var cod: Int? = null

    constructor(parcel: Parcel) : this() {
        base = parcel.readString()
        visibility = parcel.readValue(Int::class.java.classLoader) as? Int
        dt = parcel.readValue(Int::class.java.classLoader) as? Int
        timezone = parcel.readValue(Int::class.java.classLoader) as? Int
        id = parcel.readValue(Int::class.java.classLoader) as? Int
        name = parcel.readString()
        cod = parcel.readValue(Int::class.java.classLoader) as? Int
    }

    inner class Clouds {
        @SerializedName("all")
        @Expose
        var all: Int? = null
    }

    inner class Coord {
        @SerializedName("lon")
        @Expose
        var lon: Double? = null

        @SerializedName("lat")
        @Expose
        var lat: Double? = null
    }

    inner class Main {
        @SerializedName("temp")
        @Expose
        var temp: Double? = null

        @SerializedName("feels_like")
        @Expose
        var feelsLike: Double? = null

        @SerializedName("temp_min")
        @Expose
        var tempMin: Double? = null

        @SerializedName("temp_max")
        @Expose
        var tempMax: Double? = null

        @SerializedName("pressure")
        @Expose
        var pressure: Int? = null

        @SerializedName("humidity")
        @Expose
        var humidity: Int? = null
    }

    inner class Sys {
        @SerializedName("type")
        @Expose
        var type: Int? = null

        @SerializedName("id")
        @Expose
        var id: Int? = null

        @SerializedName("country")
        @Expose
        var country: String? = null

        @SerializedName("sunrise")
        @Expose
        var sunrise: Int? = null

        @SerializedName("sunset")
        @Expose
        var sunset: Int? = null
    }

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

    inner class Wind {
        @SerializedName("speed")
        @Expose
        var speed: Int? = null

        @SerializedName("deg")
        @Expose
        var deg: Int? = null
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(base)
        parcel.writeValue(visibility)
        parcel.writeValue(dt)
        parcel.writeValue(timezone)
        parcel.writeValue(id)
        parcel.writeString(name)
        parcel.writeValue(cod)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CurrentCityWeather> {
        override fun createFromParcel(parcel: Parcel): CurrentCityWeather {
            return CurrentCityWeather(parcel)
        }

        override fun newArray(size: Int): Array<CurrentCityWeather?> {
            return arrayOfNulls(size)
        }
    }
}