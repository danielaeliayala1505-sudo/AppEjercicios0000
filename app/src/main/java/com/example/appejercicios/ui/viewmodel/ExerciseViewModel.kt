package com.example.appejercicios.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.appejercicios.data.local.DatabaseProvider
import com.example.appejercicios.data.local.ExerciseRecordEntity
import com.example.appejercicios.data.repository.ExerciseResultRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class ExerciseViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: ExerciseResultRepository

    init {
        val database = DatabaseProvider.getDatabase(application)
        repository = ExerciseResultRepository(database.exerciseRecordDao())
    }

    val allRecords: StateFlow<List<ExerciseRecordEntity>> = repository.fetchHistoryStream()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    fun saveExerciseRecord(name: String, inputs: String, result: String) {
        viewModelScope.launch {
            val newRecord = ExerciseRecordEntity(
                exerciseName = name,
                inputValues = inputs,
                computedResult = result
            )
            repository.insertRecord(newRecord)
        }
    }

    fun deleteRecordById(id: Long) {
        viewModelScope.launch {
            repository.deleteRecord(id)
        }
    }

    fun clearAllHistory() {
        viewModelScope.launch {
            repository.clearHistory()
        }
    }
}