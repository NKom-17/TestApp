package com.example.test_app.data.api

import com.example.test_app.app.Constants
import com.example.test_app.util.ExtendedDentistryProgramDeserialize
import com.example.test_app.data.models.ExtendedDentistryAction
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiHelper {
    private val logging = HttpLoggingInterceptor().apply {
        setLevel(HttpLoggingInterceptor.Level.BASIC)
    }

    private val httpClient = OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()

    private val gson = GsonBuilder().registerTypeAdapter(
        ExtendedDentistryAction::class.java,
        ExtendedDentistryProgramDeserialize()
    ).create()

    val apiClient: ApiClient = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .client(httpClient)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
        .create(ApiClient::class.java)
}
