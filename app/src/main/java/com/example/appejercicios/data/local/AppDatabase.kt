package com.example.appejercicios.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [ExerciseRecordEntity::class],
    version = 1,
    exportSchema = true
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun exerciseRecordDao(): ExerciseRecordDao
}

object DatabaseProvider {
    @Volatile
    private var databaseInstance: AppDatabase? = null

    fun getDatabase(context: Context): AppDatabase {
        return databaseInstance ?: synchronized(this) {
            databaseInstance ?: Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "user_exercises_db.db"
            ).build().also { databaseInstance = it }
        }
    }
}