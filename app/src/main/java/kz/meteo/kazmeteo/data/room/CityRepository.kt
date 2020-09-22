package kz.meteo.kazmeteo.data.room

import androidx.lifecycle.LiveData
import kz.meteo.kazmeteo.models.CityEntity

class CityRepository(private val cityDao: CityDao): CityDatabaseRepository {
    override val allCities: LiveData<List<CityEntity>>
        get() = cityDao.getAllCities()

    override suspend fun insert(city: CityEntity, onSuccess: () -> Unit) {
        cityDao.insert(city)
    }

    override suspend fun delete(city: CityEntity, onSuccess: () -> Unit) {
        cityDao.delete(city)
    }
}