package com.example.test_app.util

/**
 * Утилиты для обработки исключений
 */
object ExceptionHandler {

    /**
     * Блок try/cath
     */
    suspend fun <T> runWithTryCatch(block: suspend () -> T): T? {
        return try {
            block()
        } catch (e: Exception) {
            println("Exception: ${e.message}")
            null
        }
    }

}