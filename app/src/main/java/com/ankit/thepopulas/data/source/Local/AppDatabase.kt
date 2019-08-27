package com.ankit.thepopulas.data.source.Local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ankit.thepopulas.model.PopularTVObj
import com.ankit.thepopulas.model.Result
import com.ankit.thepopulas.utils.DBConvertors

@Database(entities = [Result::class], version = 1, exportSchema = false)
@TypeConverters(value = arrayOf(DBConvertors::class))
abstract class AppDatabase : RoomDatabase() {
        abstract fun tmdbDao(): TMDBDao

        companion object {
                private var INSTANCE: AppDatabase? = null

                private val lock = Any()

                fun getInstance(context: Context): AppDatabase {
                        synchronized(lock) {
                                if (INSTANCE == null) {
                                        INSTANCE = Room.databaseBuilder(
                                                context.applicationContext,
                                                AppDatabase::class.java, "Populas.db"
                                        ).fallbackToDestructiveMigration()
                                                .build()
                                }
                                return INSTANCE!!
                        }
                }
        }
}