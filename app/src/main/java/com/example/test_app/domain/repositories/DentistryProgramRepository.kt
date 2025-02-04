package com.example.test_app.domain.repositories

import com.example.test_app.domain.models.DentistryProgram

/**
 * Репозиторий программ стоматологии
 */
interface DentistryProgramRepository {
    /**
     * Получение программ стоматологии
     */
    suspend fun getDentistryProgram(dentistryId: Int): DentistryProgram
}