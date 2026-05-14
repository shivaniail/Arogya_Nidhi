package com.example.arogyanidhi.domain

import com.example.arogyanidhi.domain.model.EligibilityData
import com.example.arogyanidhi.domain.model.Scheme

object EligibilityEngine {

    fun getEligibleSchemes(
        user: EligibilityData,
        allSchemes: List<Scheme>
    ): List<Scheme> = allSchemes.filter { isEligible(user, it) }

    private fun isEligible(
        user: EligibilityData,
        scheme: Scheme
    ): Boolean {

        // 1. Income check
        val incomeEligible =
            user.income <= scheme.maxIncome

        // 2. BPL check
        val bplEligible =
            !scheme.requiresBPL || user.isBpl

        // 3. Occupation check (empty = open to all)
        val occupationEligible =
            scheme.occupations.isEmpty() ||
                    scheme.occupations.any {
                        it.equals(
                            user.occupation,
                            ignoreCase = true
                        )
                    }

        // 4. Family size check (0 = no restriction)
        val familySizeEligible =
            scheme.minFamilySize == 0 ||
                    user.familySize >= scheme.minFamilySize

        // 5. State check (empty = all states)
        val stateEligible =
            scheme.applicableStates.isEmpty() ||
                    scheme.applicableStates.any {
                        it.equals(
                            user.state,
                            ignoreCase = true
                        )
                    }

        // 6. Gender check ("" = any gender)
        val genderEligible =
            scheme.requiredGender.isEmpty() ||
                    scheme.requiredGender.equals(
                        user.gender,
                        ignoreCase = true
                    )

        // 7. Disability check
        val disabilityEligible =
            !scheme.requiresDisability || user.hasDisability

        val ageEligible =
            user.age in scheme.minAge..scheme.maxAge

        return incomeEligible &&
                bplEligible &&
                occupationEligible &&
                familySizeEligible &&
                stateEligible &&
                genderEligible &&
                disabilityEligible&&
                ageEligible

    }
}