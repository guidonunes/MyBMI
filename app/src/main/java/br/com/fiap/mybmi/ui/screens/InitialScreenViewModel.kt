package br.com.fiap.mybmi.ui.screens

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.State
import androidx.lifecycle.viewModelScope
import br.com.fiap.mybmi.model.Weight
import br.com.fiap.mybmi.repository.WeightRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class InitialScreenViewModel(
    private val weightRepository: WeightRepository
): ViewModel() {

        val weights : StateFlow<List<Weight>> =
            weightRepository.listWeights
                .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5000),
                initialValue = emptyList()
            )

        private val _currentScreen = mutableStateOf<Screen>(Screen.WeightLedger)
        val currentScreen: State<Screen>
            get() = _currentScreen


        init {
            openWeightLedger()
        }

        fun openWeightForm(){
            _currentScreen.value = Screen.WeightForm
        }

        fun openWeightLedger(){
            _currentScreen.value = Screen.WeightLedger
        }

        fun insertWeight(weight: Weight) {
            viewModelScope.launch {
                weightRepository.insertWeight(weight)
            }
        }

        fun deleteWeight(weight: Weight) {
            viewModelScope.launch {
                weightRepository.deleteWeight(weight)
            }
        }

}