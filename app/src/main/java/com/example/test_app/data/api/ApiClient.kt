package com.example.test_app.data.api

import com.example.test_app.data.Constants
import com.example.test_app.data.models.DentistryProgramApiDto
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Интерфейс всех сетевых запросов
 */
interface ApiClient {

    /**
     * Получение программы стоматологии
     *
     * @param dentistryId Идентификатор программы стоматологии
     */
    @GET("${Constants.PREFIX_API}${Constants.STOMATOLOGY_API_CATALOG}{dentistryId}")
    fun getDentistryProgram(@Path("dentistryId") dentistryId: Int): Deferred<DentistryProgramApiDto>
}
