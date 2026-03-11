package br.com.fiap.mybmi.ui.screens

sealed class Screen {
    object InitialScreen : Screen()
    object WeightForm : Screen()
    companion object {
        val WeightLedger: Screen
    }
}


