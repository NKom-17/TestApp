package com.example.test_app.domain.models

/**
 * Модель программы стоматологии.
 *
 * @property description Осписание программы стоматологии.
 * @property actions Действия(услуги), доступные по программе стоматологии.
 */
data class DentistryProgram(
    val description: String,
    val actions: List<DentistryAction>
)
