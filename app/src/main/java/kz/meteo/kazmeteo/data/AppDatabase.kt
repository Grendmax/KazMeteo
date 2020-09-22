package kz.meteo.kazmeteo.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kz.meteo.kazmeteo.data.room.CityDao
import kz.meteo.kazmeteo.models.CityEntity

@Database(entities = [CityEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getCityDao(): CityDao

    companion object {
        private var database: AppDatabase? = null

        @Synchronized
        fun getInstance(context: Context): AppDatabase {
            return if (database == null) {
                database = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "database"
                ).build()
                database as AppDatabase
            } else database as AppDatabase
        }
    }

}