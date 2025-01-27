package com.example.test_app.data.mappers

import com.example.test_app.data.models.DentistryActionApiDto
import com.example.test_app.data.models.DentistryProgramApiDto
import com.example.test_app.domain.models.DentistryAction
import com.example.test_app.domain.models.DentistryProgram

object DentistryProgramMapper {

    fun DentistryProgramApiDto.toDomain(): DentistryProgram {
        val actions = this.actions.filterNotNull().map { action ->
            when (action) {
                is DentistryActionApiDto.RedirectToTelemedApiDto -> action.toDomain()

                is DentistryActionApiDto.ServiceDescriptionApiDto -> action.toDomain()

                is DentistryActionApiDto.RedirectToSpecialtyApiDto -> action.toDomain()

                is DentistryActionApiDto.PhoneCallApiDto -> action.toDomain()
            }
        }

        return DentistryProgram(this.description, actions)
    }

    private fun DentistryActionApiDto.RedirectToTelemedApiDto.toDomain(): DentistryAction.RedirectToTelemed {
        return DentistryAction.RedirectToTelemed(
            this.type,
            this.serviceTitle,
            this.redirectDescription,
            this.redirectTelemedSpecializationId
        )
    }

    private fun DentistryActionApiDto.ServiceDescriptionApiDto.toDomain(): DentistryAction.ServiceDescription {
        return DentistryAction.ServiceDescription(
            this.type,
            this.title,
            this.serviceDescription
        )
    }

    private fun DentistryActionApiDto.RedirectToSpecialtyApiDto.toDomain(): DentistryAction.RedirectToSpecialty {
        return DentistryAction.RedirectToSpecialty(
            this.type,
            this.description,
            this.buttonText,
            this.redirectSpecialtyId
        )
    }

    private fun DentistryActionApiDto.PhoneCallApiDto.toDomain(): DentistryAction.PhoneCall {
        return DentistryAction.PhoneCall(
            this.type,
            this.number,
            this.button
        )
    }
}
