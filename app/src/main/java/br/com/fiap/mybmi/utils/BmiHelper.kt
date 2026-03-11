package br.com.fiap.mybmi.utils

object BmiHelper {
    fun calculateBmi(weight: Double, height: Double): Double {
        return weight / (height * height)

    }

    fun getBmiStatus(bmi: Double): Map<String, String> {
        return when {
            bmi < 18.5 -> mapOf("Underweight" to "FFF54927")
            bmi < 25.0 -> mapOf("Normal Weight" to "FF62A172")
            bmi < 30.0 -> mapOf("Overweight" to "FFED8618")
            else -> mapOf("Obesity" to "FFF54927")
        }
    }
}