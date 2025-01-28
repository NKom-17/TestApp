package com.example.test_app.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.test_app.data.repositories.DentistryProgramRepositoryImpl
import com.example.test_app.databinding.ActivityMainBinding
import com.example.test_app.domain.usecase.GetDentistryProgramUseCase
import kotlinx.coroutines.launch

private const val EXTENDED_DENTISTRY_PROGRAM_ID = 1
private const val BASE_DENTISTRY_PROGRAM_ID = 2

class MainActivity : AppCompatActivity() {
    private val dentistryProgramRepository = DentistryProgramRepositoryImpl()
    private val getDentistryProgramUseCase = GetDentistryProgramUseCase(dentistryProgramRepository)

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.getExtendedBtn.setOnClickListener {
            getDentistryProgram(EXTENDED_DENTISTRY_PROGRAM_ID)
        }

        binding.getBaseBtn.setOnClickListener {
            getDentistryProgram(BASE_DENTISTRY_PROGRAM_ID)
        }
    }

    private fun getDentistryProgram(dentistryId: Int) {
        lifecycleScope.launch {
            val dentistryProgram = getDentistryProgramUseCase.invoke(dentistryId)
            Log.d("TAG", "getDentistryProgram: $dentistryProgram")
        }
    }

}
