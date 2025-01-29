package com.example.test_app.data.mappers

import com.example.test_app.data.models.DentistryActionApiDto
import com.example.test_app.data.models.DentistryProgramApiDto
import com.example.test_app.domain.models.DentistryProgram

/**
 * Маппер data модели программы стоматологии в domain модель.
 * @return Объект [DentistryProgram]
 */
fun DentistryProgramApiDto.toDomain(): DentistryProgram {
    val actions = this.actions.map { action ->
        when (action) {
            is DentistryActionApiDto.RedirectToTelemedApiDto -> action.toDomain()

            is DentistryActionApiDto.ServiceDescriptionApiDto -> action.toDomain()

            is DentistryActionApiDto.RedirectToSpecialtyApiDto -> action.toDomain()

            is DentistryActionApiDto.PhoneCallApiDto -> action.toDomain()
        }
    }

    return DentistryProgram(this.description, actions)
}