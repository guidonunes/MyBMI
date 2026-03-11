package br.com.fiap.mybmi.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import br.com.fiap.mybmi.model.Weight

import br.com.fiap.mybmi.ui.theme.MyBMITheme

@Composable
fun WeightLedger(weight: List<Weight>) {
    Column() {
        Text(
            text = "My Progress",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(8.dp)
        )
        LazyColumn(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxSize()
                .clip(shape = RoundedCornerShape(8.dp))
                .background(Color(0xFFF5F5F5)),
            contentPadding = PaddingValues(top = 16.dp, bottom = 64.dp),
        ) {
            items(weight) { weight ->
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    Text(
                        text = weight.date
                    )
                    Text(
                        text = "${weight.weight} Kg"
                    )
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Card(
                            colors = CardDefaults.cardColors(
                                containerColor = Color(0xFFFFC107)
                            )
                        ) {
                            Text(
                                text = "BMI: ${String.format("%.1f", weight.bmi)}  - ${weight.statusBmi}",
                                fontWeight = FontWeight.Bold, color = Color.White,
                                modifier = Modifier.padding(
                                    horizontal = 8.dp,
                                    vertical = 2.dp
                                )
                            )
                        }
                        IconButton(
                            onClick = {}
                        ) {
                            Icon(
                                imageVector = Icons.Default.Delete,
                                contentDescription = "New entry",
                                tint = Color(0xFFFF0000)
                            )
                        }
                    }
                }
                HorizontalDivider()
            }
        }
    }
}

@Preview
@Composable
private fun WeightLedgerPreview() {
    MyBMITheme()  {
        WeightLedger(
            weight = emptyList()
        )
    }
}