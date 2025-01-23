package com.example.test_app.data.api

import com.example.test_app.app.Constants
import com.example.test_app.data.models.BaseDentistryProgram
import com.example.test_app.data.models.ExtendedDentistryProgram
import retrofit2.Response
import retrofit2.http.GET

interface ApiClient {
    @GET("${Constants.PREFIX_API}1")
    suspend fun getExtendedDentistryProgram(): Response<ExtendedDentistryProgram>

    @GET("${Constants.PREFIX_API}2")
    suspend fun getBaseDentistryProgram(): Response<BaseDentistryProgram>
}
