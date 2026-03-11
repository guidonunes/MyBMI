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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.fiap.mybmi.ui.theme.MyBMITheme


@Composable
fun WeightForm(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.LightGray)
            .safeContentPadding()
    ) {
        Text(
            text = "New entry",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 32.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Please, enter your data",
            style = MaterialTheme.typography.bodyLarge
        )
        Spacer(modifier = Modifier.height(48.dp))
        TextField(
            value = "",
            onValueChange = {},
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Date")
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = "",
            onValueChange = {},
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Height")
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = "",
            onValueChange = {},
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Weight")
            }
        )
        Spacer(modifier = Modifier.height(48.dp))
        Button (
            onClick = {},
            modifier = Modifier.fillMaxWidth()
        ){
            Text(text = "Save entry")
        }
        Spacer(modifier = Modifier.height(48.dp))
        TextButton(
            onClick = {},
            modifier = Modifier.fillMaxWidth()
        ){
            Text(text = "Cancel")
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun WeightFormPreview() {
    MyBMITheme {
        WeightForm()
    }
}