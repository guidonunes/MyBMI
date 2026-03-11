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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.fiap.mybmi.ui.theme.MyBMITheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InitialScreen() {
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
            FloatingActionButton(
                onClick = {}
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "New Entry")
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
                WeightLedger()
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun InitialScreenPreview() {
    MyBMITheme {
        InitialScreen()
    }
}