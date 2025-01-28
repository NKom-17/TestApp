package com.example.test_app.data.mappers

import com.example.test_app.data.models.DentistryActionApiDto
import com.example.test_app.data.models.DentistryProgramApiDto
import com.example.test_app.domain.models.DentistryAction
import com.example.test_app.domain.models.DentistryProgram

/**
 * Интерфейс для мапперов data моделей программы стоматологии в domain.
 */
sealed class DentistryProgramToDomainMapper<in From, out To> {
    /**
     * Функция для маппинга data модели в domain.
     */
    abstract fun toDomain(from: From): To
}

/**
 * Маппер DentistryProgramApiDto в DentistryProgram.
 */
data object DentistryProgramMapper :
    DentistryProgramToDomainMapper<DentistryProgramApiDto, DentistryProgram>() {

    override fun toDomain(from: DentistryProgramApiDto): DentistryProgram {
        val actions = from.actions.map { action ->
            when (action) {
                is DentistryActionApiDto.RedirectToTelemedApiDto -> RedirectToTelemedMapper.toDomain(
                    action
                )

                is DentistryActionApiDto.ServiceDescriptionApiDto -> ServiceDescriptionMapper.toDomain(
                    action
                )

                is DentistryActionApiDto.RedirectToSpecialtyApiDto -> RedirectToSpecialtyMapper.toDomain(
                    action
                )

                is DentistryActionApiDto.PhoneCallApiDto -> PhoneCallMapper.toDomain(action)
            }
        }

        return DentistryProgram(description = from.description, actions = actions)
    }

}

/**
 * Маппер RedirectToTelemedApiDto в RedirectToTelemed.
 */
private data object RedirectToTelemedMapper :
    DentistryProgramToDomainMapper<DentistryActionApiDto.RedirectToTelemedApiDto, DentistryAction.RedirectToTelemed>() {
    override fun toDomain(from: DentistryActionApiDto.RedirectToTelemedApiDto) =
        DentistryAction.RedirectToTelemed(
            type = from.type,
            serviceTitle = from.serviceTitle,
            redirectDescription = from.redirectDescription,
            redirectTelemedSpecializationId = from.redirectTelemedSpecializationId
        )
}

/**
 * Маппер ServiceDescriptionApiDto в ServiceDescription.
 */
private data object ServiceDescriptionMapper :
    DentistryProgramToDomainMapper<DentistryActionApiDto.ServiceDescriptionApiDto, DentistryAction.ServiceDescription>() {
    override fun toDomain(from: DentistryActionApiDto.ServiceDescriptionApiDto) =
        DentistryAction.ServiceDescription(
            type = from.type,
            title = from.title,
            serviceDescription = from.serviceDescription
        )
}

/**
 * Маппер RedirectToSpecialtyApiDto в RedirectToSpecialty.
 */
private data object RedirectToSpecialtyMapper :
    DentistryProgramToDomainMapper<DentistryActionApiDto.RedirectToSpecialtyApiDto, DentistryAction.RedirectToSpecialty>() {
    override fun toDomain(from: DentistryActionApiDto.RedirectToSpecialtyApiDto) =
        DentistryAction.RedirectToSpecialty(
            type = from.type,
            description = from.description,
            buttonText = from.buttonText,
            redirectSpecialtyId = from.redirectSpecialtyId
        )
}

/**
 * Маппер PhoneCallApiDto в PhoneCall.
 */
private data object PhoneCallMapper :
    DentistryProgramToDomainMapper<DentistryActionApiDto.PhoneCallApiDto, DentistryAction.PhoneCall>() {
    override fun toDomain(from: DentistryActionApiDto.PhoneCallApiDto) =
        DentistryAction.PhoneCall(
            type = from.type,
            number = from.number,
            button = from.button
        )
}
