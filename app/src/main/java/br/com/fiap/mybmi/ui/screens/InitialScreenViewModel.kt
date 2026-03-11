package br.com.fiap.mybmi.ui.screens

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.State

    class InitialScreenViewModel: ViewModel() {
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

}