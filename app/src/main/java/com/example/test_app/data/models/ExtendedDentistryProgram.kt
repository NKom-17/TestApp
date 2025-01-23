package com.example.test_app.data.models

import com.example.test_app.util.ExtendedDentistryProgramDeserialize
import com.google.gson.annotations.Expose
import com.google.gson.annotations.JsonAdapter
import com.google.gson.annotations.SerializedName

data class ExtendedDentistryProgram(
    @Expose
    @SerializedName("description")
    val description: String,

    @Expose
    @SerializedName("actions")
    val actions: List<ExtendedDentistryAction>
)

@JsonAdapter(ExtendedDentistryProgramDeserialize::class)
sealed class ExtendedDentistryAction

data class RedirectToTelemedActionExtended(
    @Expose
    @SerializedName("type")
    val type: String,

    @Expose
    @SerializedName("serviceTitle")
    val serviceTitle: String,

    @Expose
    @SerializedName("redirectDescription")
    val redirectDescription: String,

    @Expose
    @SerializedName("redirectTelemedSpecializationId")
    val redirectTelemedSpecializationId: Int,
) : ExtendedDentistryAction()

data class ServiceDescriptionActionExtended(
    @Expose
    @SerializedName("type")
    val type: String,

    @Expose
    @SerializedName("title")
    val title: String,

    @Expose
    @SerializedName("serviceDescription")
    val serviceDescription: String,
) : ExtendedDentistryAction()

data class RedirectToSpecialtyActionExtended(
    @Expose
    @SerializedName("type")
    val type: String,

    @Expose
    @SerializedName("description")
    val description: String,

    @Expose
    @SerializedName("buttonText")
    val buttonText: String,

    @Expose
    @SerializedName("redirectSpecialtyId")
    val redirectSpecialtyId: Int,
) : ExtendedDentistryAction()