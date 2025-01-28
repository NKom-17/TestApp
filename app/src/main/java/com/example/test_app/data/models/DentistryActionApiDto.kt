package com.example.test_app.data.models

import com.example.test_app.domain.models.DentistryAction
import com.google.gson.annotations.SerializedName

/**
 * Класс данных DentistryAction.
 *
 * Базовый класс действий(услуг) по программе стоматологии.
 */
sealed class DentistryActionApiDto {

    /**
     * Метод для маппинга в domain модель.
     */
    abstract fun toDomain(): DentistryAction

    /**
     * Константы типов действий(услуг) программ стоматологии.
     *
     * @property REDIRECT_TO_TELEMED константа типа действия для RedirectToTelemedApiDto.
     * @property SERVICE_DESCRIPTION константа типа действия для ServiceDescriptionApiDto.
     * @property REDIRECT_TO_SPECIALITY константа типа действия для RedirectToSpecialtyApiDto.
     * @property PHONE_CALL константа типа действия для PhoneCallApiDto.
     */
    enum class Type(val value: String) {
        REDIRECT_TO_TELEMED("redirect_to_telemed"),
        SERVICE_DESCRIPTION("service_description"),
        REDIRECT_TO_SPECIALITY("redirect_to_specialty"),
        PHONE_CALL("phone_call")
    }

    /**
     * Модель данных RedirectToTelemed.
     *
     * Модель действия - Подключение к медсоветнику.
     *
     * @property serviceTitle Название действия.
     * @property redirectDescription Описание действия.
     * @property redirectTelemedSpecializationId Идентификатор специализации медсоветника.
     */
    data class RedirectToTelemedApiDto(
        @SerializedName("serviceTitle")
        val serviceTitle: String,

        @SerializedName("redirectDescription")
        val redirectDescription: String,

        @SerializedName("redirectTelemedSpecializationId")
        val redirectTelemedSpecializationId: Int,
    ) : DentistryActionApiDto() {
        override fun toDomain() =
            DentistryAction.RedirectToTelemed(
                type = Type.REDIRECT_TO_TELEMED.value,
                serviceTitle = this.serviceTitle,
                redirectDescription = this.redirectDescription,
                redirectTelemedSpecializationId = this.redirectTelemedSpecializationId
            )
    }

    /**
     * Модель данных ServiceDescription.
     *
     * Модель действия - Описание услуги.
     *
     * @property title Название действия.
     * @property serviceDescription Описание услуги.
     */
    data class ServiceDescriptionApiDto(
        @SerializedName("title")
        val title: String,

        @SerializedName("serviceDescription")
        val serviceDescription: String,
    ) : DentistryActionApiDto() {
        override fun toDomain() =
            DentistryAction.ServiceDescription(
                type = Type.SERVICE_DESCRIPTION.value,
                title = this.title,
                serviceDescription = this.serviceDescription
            )
    }

    /**
     * Модель данных RedirectToSpecialty.
     *
     * Модель действия - Онлайн обращение к специалисту.
     *
     * @property description Описание действия.
     * @property buttonText Текст кнопки действия.
     * @property redirectSpecialtyId Идентификатор специальности специалиста.
     */
    data class RedirectToSpecialtyApiDto(
        @SerializedName("description")
        val description: String,

        @SerializedName("buttonText")
        val buttonText: String,

        @SerializedName("redirectSpecialtyId")
        val redirectSpecialtyId: Int,
    ) : DentistryActionApiDto() {
        override fun toDomain() =
            DentistryAction.RedirectToSpecialty(
                type = Type.REDIRECT_TO_SPECIALITY.value,
                description = this.description,
                buttonText = this.buttonText,
                redirectSpecialtyId = this.redirectSpecialtyId
            )
    }

    /**
     * Модель данных PhoneCall.
     *
     * Модель действия - Запись к специалисту по звонку.
     *
     * @property number Номер телефона для записи к специалисту.
     * @property button Текст кнопки действия.
     */
    data class PhoneCallApiDto(
        @SerializedName("number")
        val number: String,

        @SerializedName("button")
        val button: String,
    ) : DentistryActionApiDto() {
        override fun toDomain() =
            DentistryAction.PhoneCall(
                type = Type.PHONE_CALL.value,
                number = this.number,
                button = this.button
            )
    }
}