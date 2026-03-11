package br.com.fiap.mybmi.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.fiap.mybmi.repository.WeightRepository
import br.com.fiap.mybmi.ui.screens.InitialScreenViewModel

class InitialScreenViewModelFactory(
    private val weightRepository: WeightRepository
): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(InitialScreenViewModel::class.java)) {
            return InitialScreenViewModel(weightRepository) as T
    }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

