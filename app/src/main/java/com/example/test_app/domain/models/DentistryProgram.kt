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

/**
 * Базовый класс действий(услуг) по программе стоматологии.
 */
sealed class DentistryAction {

    /**
     * Модель действия - Подключение к медсоветнику.
     *
     * @property type Тип действия.
     * @property serviceTitle Название действия.
     * @property redirectDescription Описание действия.
     * @property redirectTelemedSpecializationId Идентификатор специализации медсоветника.
     */
    data class RedirectToTelemed(
        val type: String,
        val serviceTitle: String,
        val redirectDescription: String,
        val redirectTelemedSpecializationId: Int,
    ) : DentistryAction()

    /**
     * Модель действия - Описание услуги.
     *
     * @property type Тип действия.
     * @property title Название действия.
     * @property serviceDescription Описание услуги.
     */
    data class ServiceDescription(
        val type: String,
        val title: String,
        val serviceDescription: String,
    ) : DentistryAction()

    /**
     * Модель действия - Онлайн обращение к специалисту.
     *
     * @property type Тип действия.
     * @property description Описание действия.
     * @property buttonText Текст кнопки действия.
     * @property redirectSpecialtyId Идентификатор специальности специалиста.
     */
    data class RedirectToSpecialty(
        val type: String,
        val description: String,
        val buttonText: String,
        val redirectSpecialtyId: Int,
    ) : DentistryAction()

    /**
     * Модель действия - Запись к специалисту по звонку.
     *
     * @property type Тип действия.
     * @property number Номер телефона для записи к специалисту.
     * @property button Текст кнопки действия.
     */
    data class PhoneCall(
        val type: String,
        val number: String,
        val button: String,
    ) : DentistryAction()
}