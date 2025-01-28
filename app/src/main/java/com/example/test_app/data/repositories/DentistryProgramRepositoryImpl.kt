package com.example.test_app.data.repositories

import com.example.test_app.data.api.ApiHelper
import com.example.test_app.data.mappers.toDomain
import com.example.test_app.domain.models.DentistryProgram
import com.example.test_app.domain.repositories.DentistryProgramRepository
import com.example.test_app.util.ExceptionHandler.runWithTryCatch

/**
 * Реализация репозитория программ стоматологии
 */
class DentistryProgramRepositoryImpl : DentistryProgramRepository {

    /**
     * Реализация получения программ стоматологии
     */
    override suspend fun getDentistryProgram(dentistryId: Int): DentistryProgram {
        val result = runWithTryCatch {
            ApiHelper.apiClient.getDentistryProgram(dentistryId).await()
        }

        return result?.toDomain() ?: DentistryProgram(description = "", actions = emptyList())
    }

}