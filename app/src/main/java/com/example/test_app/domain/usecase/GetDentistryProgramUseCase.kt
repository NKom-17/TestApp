package com.example.test_app.domain.usecase

import com.example.test_app.domain.repositories.DentistryProgramRepository
import javax.inject.Inject

class GetDentistryProgramUseCase @Inject constructor(
    private val dentistryProgramRepository: DentistryProgramRepository
) {

    suspend fun invoke(dentistryId: Int) =
        dentistryProgramRepository.getDentistryProgram(dentistryId)

}
