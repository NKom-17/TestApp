package com.example.test_app.di

import com.example.test_app.data.api.ApiClient
import com.example.test_app.data.repositories.DentistryProgramRepositoryImpl
import com.example.test_app.domain.repositories.DentistryProgramRepository
import com.example.test_app.domain.usecase.GetDentistryProgramUseCase
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun provideGetDentistryProgramUseCase(dentistryProgramRepository: DentistryProgramRepository): GetDentistryProgramUseCase {
        return GetDentistryProgramUseCase(dentistryProgramRepository)
    }

    @Provides
    fun provideDentistryProgramRepository(apiClient: ApiClient): DentistryProgramRepository {
        return DentistryProgramRepositoryImpl(apiClient)
    }
}
