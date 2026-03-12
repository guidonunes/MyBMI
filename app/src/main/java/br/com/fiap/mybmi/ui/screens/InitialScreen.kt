package br.com.fiap.mybmi.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import br.com.fiap.mybmi.ui.theme.MyBMITheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InitialScreen(viewModel: InitialScreenViewModel) {

    val weights by viewModel.weights.collectAsStateWithLifecycle(
        initialValue = emptyList()
    )

    val currentScreen = viewModel.currentScreen.value

    Scaffold(
        modifier = Modifier
            .background(color = Color.LightGray),
        topBar = {
            TopAppBar(
                title = {
                    Column() {
                        Text(
                            text = "My BMI",
                        )
                        Text(
                            text = "Dashboard",
                            style = MaterialTheme.typography.labelSmall
                        )
                    }
                },
                colors = TopAppBarDefaults
                    .topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        titleContentColor = MaterialTheme.colorScheme.onPrimary
                    )
            )
        },
        floatingActionButton = {
            if (currentScreen is Screen.WeightLedger){
                FloatingActionButton(
                    onClick = {
                        viewModel.openWeightForm()
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "New entry"
                    )
                }
            }

        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .padding(paddingValues)
                .background(Color.LightGray)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
               when (currentScreen) {
                   is Screen.WeightForm -> WeightForm(
                       onCancel = {
                           viewModel.openWeightLedger()
                       },
                       onRegisterWeight = { weight ->
                           viewModel.insertWeight(
                               weight = weight
                           )
                           viewModel.openWeightLedger()
                       }
                   )
                   is Screen.WeightLedger -> WeightLedger(
                       weights,
                       onDelete = { weight ->
                           viewModel.deleteWeight(weight)
                       }
                   )
               }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun InitialScreenPreview() {
    MyBMITheme {
//        InitialScreen(
//            viewModel = InitialScreenViewModel()
//        )
    }
}
