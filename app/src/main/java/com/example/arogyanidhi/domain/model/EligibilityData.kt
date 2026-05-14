package com.example.arogyanidhi.domain.model

data class EligibilityData(
    val income: Double = 0.0,
    val isBpl: Boolean = false,
    val occupation: String = "",
    val state: String = "",
    val familySize: Int = 1,
    val gender: String = "",
    val hasDisability: Boolean = false,
    val age: Int = 0
)