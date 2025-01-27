package com.example.test_app.data.util

import com.example.test_app.data.Constants
import com.example.test_app.data.models.DentistryActionApiDto
import com.google.gson.Gson
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type

class DentistryProgramDeserialize : JsonDeserializer<List<DentistryActionApiDto?>> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): List<DentistryActionApiDto?> {
        val gson = Gson()
        val actions: MutableList<DentistryActionApiDto?> = mutableListOf()

        json?.asJsonArray?.forEach { actionApiDto ->
            val type = actionApiDto.asJsonObject.get("type").asString

            val action = when (type) {
                Constants.REDIRECT_TO_TELEMED_ACTION_TYPE -> {
                    gson.fromJson(
                        actionApiDto,
                        DentistryActionApiDto.RedirectToTelemedApiDto::class.java
                    )
                }

                Constants.SERVICE_DESCRIPTION_ACTION_TYPE -> {
                    gson.fromJson(
                        actionApiDto,
                        DentistryActionApiDto.ServiceDescriptionApiDto::class.java
                    )
                }

                Constants.REDIRECT_TO_SPECIALTY_ACTION_TYPE -> {
                    gson.fromJson(
                        actionApiDto,
                        DentistryActionApiDto.RedirectToSpecialtyApiDto::class.java
                    )
                }

                Constants.PHONE_CALL_ACTION_TYPE -> {
                    gson.fromJson(actionApiDto, DentistryActionApiDto.PhoneCallApiDto::class.java)
                }

                else -> null
            }

            actions.add(action)
        }

        return actions
    }
}
