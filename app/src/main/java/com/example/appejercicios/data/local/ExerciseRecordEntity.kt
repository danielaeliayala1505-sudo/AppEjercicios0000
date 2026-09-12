package com.example.appejercicios.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "history_records")
data class ExerciseRecordEntity(
    @PrimaryKey(autoGenerate = true)
    val recordId: Long = 0L,
    val exerciseName: String,
    val inputValues: String,
    val computedResult: String,
    val timestamp: Long = System.currentTimeMillis()
)