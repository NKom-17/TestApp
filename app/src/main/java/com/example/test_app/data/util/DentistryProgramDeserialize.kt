package com.example.test_app.data.util

import com.example.test_app.data.models.DentistryActionApiDto
import com.google.gson.Gson
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type

class DentistryProgramDeserialize : JsonDeserializer<List<DentistryActionApiDto>> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): List<DentistryActionApiDto> {
        val gson = Gson()
        val actions: MutableList<DentistryActionApiDto> = mutableListOf()

        json?.asJsonArray?.forEach { actionApiDto ->
            val type = actionApiDto.asJsonObject.get("type").asString

            val action = when (type) {
                DentistryActionApiDto.Type.REDIRECT_TO_TELEMED.value -> {
                    gson.fromJson(
                        actionApiDto,
                        DentistryActionApiDto.RedirectToTelemedApiDto::class.java
                    )
                }

                DentistryActionApiDto.Type.SERVICE_DESCRIPTION.value -> {
                    gson.fromJson(
                        actionApiDto,
                        DentistryActionApiDto.ServiceDescriptionApiDto::class.java
                    )
                }

                DentistryActionApiDto.Type.REDIRECT_TO_SPECIALITY.value -> {
                    gson.fromJson(
                        actionApiDto,
                        DentistryActionApiDto.RedirectToSpecialtyApiDto::class.java
                    )
                }

                DentistryActionApiDto.Type.PHONE_CALL.value -> {
                    gson.fromJson(actionApiDto, DentistryActionApiDto.PhoneCallApiDto::class.java)
                }

                else -> null
            }

            if (action != null) actions.add(action)
        }

        return actions
    }
}
