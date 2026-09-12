package com.example.appejercicios.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ExerciseRecordDao {
    @Insert
    suspend fun saveRecord(record: ExerciseRecordEntity)

    @Query("SELECT * FROM history_records ORDER BY timestamp DESC")
    fun observeAllRecords(): Flow<List<ExerciseRecordEntity>>

    @Query("DELETE FROM history_records WHERE recordId = :id")
    suspend fun removeRecordById(id: Long)

    @Query("DELETE FROM history_records")
    suspend fun clearAllRecords()
}