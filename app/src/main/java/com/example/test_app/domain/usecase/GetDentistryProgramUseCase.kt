package com.example.test_app.domain.usecase


import android.util.Log
import com.example.test_app.data.api.ApiHelper
import com.example.test_app.data.models.RedirectToSpecialtyActionExtended
import com.example.test_app.data.models.RedirectToTelemedActionExtended
import com.example.test_app.data.models.ServiceDescriptionActionExtended
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class GetDentistryProgramUseCase {
    fun getExtendedDentistryProgram() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = ApiHelper.apiClient.getExtendedDentistryProgram()


                if (response.isSuccessful && response.body() != null) {
                    val data = response.body()!!


                    Log.d("TAG", "getExtendedSuccess.\n${data.description}")
                    data.actions.forEachIndexed { index, action ->
                        when (action) {
                            is RedirectToTelemedActionExtended -> Log.d(
                                "TAG",
                                "$index(${action.javaClass.simpleName}): ${action.type}, ${action.redirectTelemedSpecializationId}, ${action.redirectDescription}, ${action.serviceTitle}"
                            )


                            is ServiceDescriptionActionExtended -> Log.d(
                                "TAG",
                                "$index(${action.javaClass.simpleName}): ${action.type}, ${action.title}, ${action.serviceDescription}"
                            )


                            is RedirectToSpecialtyActionExtended -> Log.d(
                                "TAG",
                                "$index(${action.javaClass.simpleName}): ${action.type}, ${action.description}, ${action.buttonText}, ${action.redirectSpecialtyId}"
                            )
                        }
                    }
                } else {
                    Log.d("TAG", "getExtendedFailure. Response: ${response.message()}")
                }


            } catch (e: Exception) {
                Log.d("TAG", "getExtendedException: ${e.message}")
            }
        }
    }


    fun getBaseDentistryProgram() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = ApiHelper.apiClient.getBaseDentistryProgram()


                if (response.isSuccessful && response.body() != null) {
                    val data = response.body()!!


                    Log.d("TAG", "getBaseSuccess. ${data.description}, ${data.actions}")
                    data.actions.forEachIndexed { index, action ->
                        Log.d("TAG", "$index: $action")
                    }
                } else {
                    Log.d("TAG", "getBaseFailure. Response: ${response.message()}")
                }


            } catch (e: Exception) {
                Log.d("TAG", "getBaseException: ${e.message}")
            }
        }
    }
}
