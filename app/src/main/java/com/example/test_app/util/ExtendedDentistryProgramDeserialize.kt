package com.example.test_app.util

import com.example.test_app.app.Constants
import com.example.test_app.data.models.ExtendedDentistryAction
import com.example.test_app.data.models.RedirectToSpecialtyActionExtended
import com.example.test_app.data.models.RedirectToTelemedActionExtended
import com.example.test_app.data.models.ServiceDescriptionActionExtended
import com.google.gson.Gson
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type

class ExtendedDentistryProgramDeserialize : JsonDeserializer<ExtendedDentistryAction?> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): ExtendedDentistryAction {
        val gson = Gson()

        val type = json?.asJsonObject?.get("type")?.asString ?: ""
        var action: ExtendedDentistryAction? = null

        if (type.isNotEmpty()) {
            when (type) {
                Constants.REDIRECT_TO_TELEMED_ACTION_TYPE -> {
                    action = gson.fromJson(json, RedirectToTelemedActionExtended::class.java)
                }

                Constants.SERVICE_DESCRIPTION_ACTION_TYPE -> {
                    action = gson.fromJson(json, ServiceDescriptionActionExtended::class.java)
                }

                Constants.REDIRECT_TO_SPECIALTY_ACTION_TYPE -> {
                    action = gson.fromJson(json, RedirectToSpecialtyActionExtended::class.java)
                }
            }
        }

        return action!!
    }
}
