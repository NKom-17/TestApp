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
