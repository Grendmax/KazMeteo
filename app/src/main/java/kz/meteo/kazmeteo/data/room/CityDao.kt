package kz.meteo.kazmeteo.data.room

import androidx.lifecycle.LiveData
import androidx.room.*
import kz.meteo.kazmeteo.models.CityEntity

@Dao
interface CityDao {
    @Query("SELECT * FROM cities")
    fun getAllCities():LiveData<List<CityEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(city: CityEntity)

    @Delete
    suspend fun delete(city: CityEntity)
}