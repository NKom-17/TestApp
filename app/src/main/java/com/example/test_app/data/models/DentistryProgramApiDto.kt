package com.example.test_app.data.models

import com.example.test_app.data.util.DentistryProgramDeserialize
import com.google.gson.annotations.Expose
import com.google.gson.annotations.JsonAdapter
import com.google.gson.annotations.SerializedName

/**
 * Модель данных DentistryProgram.
 */
data class DentistryProgramApiDto(
    @SerializedName("description")
    val description: String,

    @Expose
    @JsonAdapter(DentistryProgramDeserialize::class)
    @SerializedName("actions")
    val actions: List<DentistryActionApiDto?>
)

/**
 * Класс данных DentistryAction.
 */
sealed class DentistryActionApiDto {

    /**
     * Модель данных RedirectToTelemed.
     */
    data class RedirectToTelemedApiDto(
        @SerializedName("type")
        val type: String,

        @SerializedName("serviceTitle")
        val serviceTitle: String,

        @SerializedName("redirectDescription")
        val redirectDescription: String,

        @SerializedName("redirectTelemedSpecializationId")
        val redirectTelemedSpecializationId: Int,
    ) : DentistryActionApiDto()

    /**
     * Модель данных ServiceDescription.
     */
    data class ServiceDescriptionApiDto(
        @SerializedName("type")
        val type: String,

        @SerializedName("title")
        val title: String,

        @SerializedName("serviceDescription")
        val serviceDescription: String,
    ) : DentistryActionApiDto()

    /**
     * Модель данных RedirectToSpecialty.
     */
    data class RedirectToSpecialtyApiDto(
        @SerializedName("type")
        val type: String,

        @SerializedName("description")
        val description: String,

        @SerializedName("buttonText")
        val buttonText: String,

        @SerializedName("redirectSpecialtyId")
        val redirectSpecialtyId: Int,
    ) : DentistryActionApiDto()

    /**
     * Модель данных PhoneCall.
     */
    data class PhoneCallApiDto(
        @SerializedName("type")
        val type: String,

        @SerializedName("number")
        val number: String,

        @SerializedName("button")
        val button: String,
    ) : DentistryActionApiDto()
}