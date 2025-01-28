package com.example.test_app.data.models

import com.example.test_app.data.util.DentistryProgramDeserialize
import com.google.gson.annotations.Expose
import com.google.gson.annotations.JsonAdapter
import com.google.gson.annotations.SerializedName

/**
 * Модель данных DentistryProgram.
 *
 * Модель программы стоматологии.
 *
 * @property description Осписание программы стоматологии.
 * @property actions Действия(услуги), доступные по программе стоматологии.
 */
data class DentistryProgramApiDto(
    @SerializedName("description")
    val description: String,

    @Expose
    @JsonAdapter(DentistryProgramDeserialize::class)
    @SerializedName("actions")
    val actions: List<DentistryActionApiDto>
)

/**
 * Класс данных DentistryAction.
 *
 * Базовый класс действий(услуг) по программе стоматологии.
 *
 * @property type Тип действия.
 */
sealed class DentistryActionApiDto {
    abstract val type: String

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
     * @property type Тип действия.
     * @property serviceTitle Название действия.
     * @property redirectDescription Описание действия.
     * @property redirectTelemedSpecializationId Идентификатор специализации медсоветника.
     */
    data class RedirectToTelemedApiDto(
        @SerializedName("type")
        override val type: String,

        @SerializedName("serviceTitle")
        val serviceTitle: String,

        @SerializedName("redirectDescription")
        val redirectDescription: String,

        @SerializedName("redirectTelemedSpecializationId")
        val redirectTelemedSpecializationId: Int,
    ) : DentistryActionApiDto()

    /**
     * Модель данных ServiceDescription.
     *
     * Модель действия - Описание услуги.
     *
     * @property type Тип действия.
     * @property title Название действия.
     * @property serviceDescription Описание услуги.
     */
    data class ServiceDescriptionApiDto(
        @SerializedName("type")
        override val type: String,

        @SerializedName("title")
        val title: String,

        @SerializedName("serviceDescription")
        val serviceDescription: String,
    ) : DentistryActionApiDto()

    /**
     * Модель данных RedirectToSpecialty.
     *
     * Модель действия - Онлайн обращение к специалисту.
     *
     * @property type Тип действия.
     * @property description Описание действия.
     * @property buttonText Текст кнопки действия.
     * @property redirectSpecialtyId Идентификатор специальности специалиста.
     */
    data class RedirectToSpecialtyApiDto(
        @SerializedName("type")
        override val type: String,

        @SerializedName("description")
        val description: String,

        @SerializedName("buttonText")
        val buttonText: String,

        @SerializedName("redirectSpecialtyId")
        val redirectSpecialtyId: Int,
    ) : DentistryActionApiDto()

    /**
     * Модель данных PhoneCall.
     *
     * Модель действия - Запись к специалисту по звонку.
     *
     * @property type Тип действия.
     * @property number Номер телефона для записи к специалисту.
     * @property button Текст кнопки действия.
     */
    data class PhoneCallApiDto(
        @SerializedName("type")
        override val type: String,

        @SerializedName("number")
        val number: String,

        @SerializedName("button")
        val button: String,
    ) : DentistryActionApiDto()
}