package br.com.fiap.mybmi.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "TB_WEIGHT")
data class Weight(
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    val date: String,
    val height: Double,
    val weight: Double,
    val bmi: Double,
    val status: String,
    val color: String
)
