package com.example.appejercicios.data.repository

import com.example.appejercicios.data.local.ExerciseRecordDao
import com.example.appejercicios.data.local.ExerciseRecordEntity
import kotlinx.coroutines.flow.Flow

class ExerciseResultRepository(
    private val recordDao: ExerciseRecordDao
) {
    fun fetchHistoryStream(): Flow<List<ExerciseRecordEntity>> = recordDao.observeAllRecords()

    suspend fun insertRecord(record: ExerciseRecordEntity) {
        recordDao.saveRecord(record)
    }

    suspend fun deleteRecord(id: Long) {
        recordDao.removeRecordById(id)
    }

    suspend fun clearHistory() {
        recordDao.clearAllRecords()
    }
}