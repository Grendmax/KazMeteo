package kz.meteo.kazmeteo.data.room

import androidx.lifecycle.LiveData
import kz.meteo.kazmeteo.models.CityEntity

interface CityDatabaseRepository {
    val allCities:LiveData<List<CityEntity>>
    suspend fun insert(city: CityEntity, onSuccess:() ->Unit)
    suspend fun delete(city: CityEntity, onSuccess:() ->Unit)
}