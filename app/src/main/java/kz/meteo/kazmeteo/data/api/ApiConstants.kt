package kz.meteo.kazmeteo.data.api

class ApiConstants {
    companion object {
        const val BASE_URL = "https://api.openweathermap.org/data/2.5/"
        const val API_KEY = "ce822b2100b49b6767113b985bec8e2d"
        const val BASE = "https://api.openweathermap.org/data/2.5/"
        const val CURRENT = "weather?&units=metric&appid=ce822b2100b49b6767113b985bec8e2d"
        const val FUTURE =
            "onecall?appid=ce822b2100b49b6767113b985bec8e2d&lat=49.8&lon=73.1&exclude=minutely,hourly&units=metric"

        const val CURRENT_WEATHER =
            "onecall?appid=ce822b2100b49b6767113b985bec8e2d&exclude=minutely,daily,hourly&units=metric"
    }
}