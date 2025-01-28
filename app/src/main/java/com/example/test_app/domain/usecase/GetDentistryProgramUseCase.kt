package com.example.test_app.domain.usecase

import com.example.test_app.domain.repositories.DentistryProgramRepository

class GetDentistryProgramUseCase(private val dentistryProgramRepository: DentistryProgramRepository) {

    suspend fun invoke(dentistryId: Int) =
        dentistryProgramRepository.getDentistryProgram(dentistryId)

}
