package com.example.test_app.data.repositories

import com.example.test_app.data.api.ApiClient
import com.example.test_app.data.mappers.toDomain
import com.example.test_app.domain.models.DentistryProgram
import com.example.test_app.domain.repositories.DentistryProgramRepository
import com.example.test_app.util.ExceptionHandler.runWithTryCatch
import javax.inject.Inject

/**
 * Реализация репозитория программ стоматологии
 */
class DentistryProgramRepositoryImpl @Inject constructor(
    private val apiClient: ApiClient
) : DentistryProgramRepository {

    /**
     * Реализация получения программ стоматологии
     */
    override suspend fun getDentistryProgram(dentistryId: Int): DentistryProgram {
        val result = runWithTryCatch {
            apiClient.getDentistryProgram(dentistryId).await()
        }

        return result?.toDomain() ?: DentistryProgram(description = "", actions = emptyList())
    }

}