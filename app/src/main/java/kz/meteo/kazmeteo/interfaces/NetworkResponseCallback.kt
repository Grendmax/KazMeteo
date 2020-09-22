package kz.meteo.kazmeteo.interfaces

interface NetworkResponseCallback {
    fun onNetworkSuccess()
    fun onNetworkFailure(th: Throwable)
}