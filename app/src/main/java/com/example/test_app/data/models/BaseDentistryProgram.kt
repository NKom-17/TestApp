package com.example.test_app.data.models

import com.google.gson.annotations.SerializedName

data class BaseDentistryProgram(
    @SerializedName("description")
    val description: String,

    @SerializedName("actions")
    val actions: List<PhoneCallActionBase>
)

data class PhoneCallActionBase(
    @SerializedName("type")
    val type: String,

    @SerializedName("number")
    val number: String,

    @SerializedName("button")
    val button: String,
)
