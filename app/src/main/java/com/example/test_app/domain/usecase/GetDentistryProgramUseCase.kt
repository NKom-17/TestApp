package com.example.test_app.domain.usecase

import android.util.Log
import com.example.test_app.domain.repositories.DentistryProgramRepository

class GetDentistryProgramUseCase(private val dentistryProgramRepository: DentistryProgramRepository) {

    suspend fun invoke(path: Int) {
        try {
            val response = dentistryProgramRepository.getDentistryProgram(path)
            Log.d("TAG", "GetDentistryProgramUseCase.Success: $response")
        } catch (e: Exception) {
            Log.e("TAG", "GetDentistryProgramUseCase.Exception: ${e.message}")
        }
    }
}
