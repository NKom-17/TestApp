package com.example.test_app.data.api

import com.example.test_app.data.Constants
import com.example.test_app.data.models.DentistryProgramApiDto
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiClient {
    @GET("${Constants.PREFIX_API}{path}")
    fun getDentistryProgram(@Path("path") path: Int): Deferred<DentistryProgramApiDto>
}
