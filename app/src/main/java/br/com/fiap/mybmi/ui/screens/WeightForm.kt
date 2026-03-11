package br.com.fiap.mybmi.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.fiap.mybmi.model.Weight
import br.com.fiap.mybmi.ui.theme.MyBMITheme
import br.com.fiap.mybmi.utils.BmiHelper
import java.time.LocalDate

@Composable
fun WeightForm(
    onCancel: () -> Unit,
    onRegisterWeight: (weight: Weight) -> Unit
) {

    var weightDate by remember {
        mutableStateOf(LocalDate.now().toString())
    }

    var height by remember {
        mutableStateOf("")
    }

    var weight by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.LightGray)
            .safeContentPadding()
    ) {
        Text(
            text = "New Entry",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 32.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Please, enter the following data",
            style = MaterialTheme.typography.bodyLarge
        )
        Spacer(modifier = Modifier.height(48.dp))
        TextField(
            value = weightDate,
            onValueChange = { weightDate = it },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Entry date")
            },
            readOnly = true
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = height,
            onValueChange = { height = it },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Height")
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = weight,
            onValueChange = { weight = it },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Weight")
            }
        )
        Spacer(modifier = Modifier.height(48.dp))
        Button (
            onClick = {
                val bmi = BmiHelper
                    .calculateBmi(
                        weight.toDouble(),
                        height.toDouble()
                    )
                val statusBmi = BmiHelper
                    .getBmiStatus(
                        bmi
                    ).keys.first()
                val color = BmiHelper
                    .getBmiStatus(
                        bmi
                    ).values.first()
                val weight = Weight(
                    id = 0,
                    date = weightDate,
                    height = height.toDouble(),
                    weight = weight.toDouble(),
                    bmi = bmi,
                    statusBmi = statusBmi,
                    color = color
                )
                onRegisterWeight(weight)
            },
            modifier = Modifier.fillMaxWidth()
        ){
            Text(text = "Registrar peso")
        }
        Spacer(modifier = Modifier.height(48.dp))
        TextButton(
            onClick = {
                onCancel()
            },
            modifier = Modifier.fillMaxWidth()
        ){
            Text(text = "Cancel & Go Back")
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun WeightFormPreview() {
    MyBMITheme() {
        WeightForm(
            onCancel = {},
            onRegisterWeight = {}
        )
    }
}