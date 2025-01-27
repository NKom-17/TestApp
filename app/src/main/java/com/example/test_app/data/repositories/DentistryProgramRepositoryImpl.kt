package com.example.test_app.data.repositories

import com.example.test_app.data.api.ApiHelper
import com.example.test_app.data.mappers.DentistryProgramMapper.toDomain
import com.example.test_app.data.models.DentistryProgramApiDto
import com.example.test_app.domain.models.DentistryProgram
import com.example.test_app.domain.repositories.DentistryProgramRepository

class DentistryProgramRepositoryImpl : DentistryProgramRepository {
    override suspend fun getDentistryProgram(path: Int): DentistryProgram {
        val dentistryProgramApiDto = ApiHelper.apiClient.getDentistryProgram(path).await()
        val actionsNotNull = dentistryProgramApiDto.actions.filterNotNull()

        val result = DentistryProgramApiDto(
            dentistryProgramApiDto.description,
            actionsNotNull
        ).toDomain()

        return result
    }
}