package com.example.arogyanidhi.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Scheme(

    val id: String = "",

    val name: String = "",

    val description: String = "",

    val eligibilityCriteria: String = "",

    val documentsRequired: List<String> = emptyList(),

    val benefits: String = "",

    val applicationProcess: String = "",

    val category: String = "",

    val maxIncome: Int = Int.MAX_VALUE,

    val requiresBPL: Boolean = false,

    val occupations: List<String> = emptyList(),

    val minFamilySize: Int = 0,

    // ── UNCOMMENTED & ACTIVE ──────────────────────
    val requiresPregnancy: Boolean = false,

    val requiredGender: String = "",        // "" = any | "Male" | "Female"

    val minAge: Int = 0,                    // 0 = no restriction

    val maxAge: Int = Int.MAX_VALUE,        // no restriction by default

    val requiresDisability: Boolean = false,

    // ── NEW FIELDS ────────────────────────────────
    val applicableStates: List<String> = emptyList(), // empty = all states

    val officialLink: String = "",          // official apply URL

    val iconCategory: String = ""          // for UI icon: "health","pension" etc
)