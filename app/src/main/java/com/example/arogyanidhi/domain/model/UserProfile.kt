package com.example.arogyanidhi.domain.model

data class UserProfile(
    val uid: String = "",
    val name: String = "",
    val email: String = "",
    val phone: String = "",
    val age: Int = 0,
    val district: String = "",
    val state: String = "",
    val profileImageUrl: String? = null,


    val annualIncome: Int = 0,

    val occupation: String = "",

    val hasBPLCard: Boolean = false,

    val familySize: Int = 0
)