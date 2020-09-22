package kz.meteo.kazmeteo.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cities")
data class CityEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo var city_name: String = "",
    @ColumnInfo var lon: String = "",
    @ColumnInfo var lat: String = "",
    @ColumnInfo var weather_description: String = "",
    @ColumnInfo var temperature: String = "",
    @ColumnInfo var weather_icon: String = ""
)