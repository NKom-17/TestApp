package com.example.test_app.domain.repositories

import com.example.test_app.domain.models.DentistryProgram

interface DentistryProgramRepository {
    suspend fun getDentistryProgram(path: Int): DentistryProgram
}