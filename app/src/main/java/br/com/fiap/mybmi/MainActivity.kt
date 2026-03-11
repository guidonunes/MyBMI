package br.com.fiap.mybmi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.fiap.mybmi.dao.BmiDb
import br.com.fiap.mybmi.factory.InitialScreenViewModelFactory
import br.com.fiap.mybmi.repository.WeightRepository
import br.com.fiap.mybmi.ui.screens.InitialScreen
import br.com.fiap.mybmi.ui.screens.InitialScreenViewModel
import br.com.fiap.mybmi.ui.theme.MyBMITheme

class MainActivity : ComponentActivity() {

    private val viewModel: InitialScreenViewModel by viewModels {
        InitialScreenViewModelFactory (
            weightRepository = WeightRepository(
                weightDao = BmiDb
                    .getDatabase(this)
                    .weightDao()
            )

        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyBMITheme {
                InitialScreen(viewModel = viewModel)
            }
        }
    }
}

