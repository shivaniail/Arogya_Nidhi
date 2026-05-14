package com.example.arogyanidhi.ui.eligibility

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.arogyanidhi.data.local.SchemeDataSource
import com.example.arogyanidhi.domain.EligibilityEngine
import com.example.arogyanidhi.domain.model.EligibilityData
import com.example.arogyanidhi.domain.model.Scheme
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EligibilityViewModel @Inject constructor() : ViewModel() {

    private val _eligibilityData =
        MutableStateFlow(EligibilityData())
    val eligibilityData: StateFlow<EligibilityData> =
        _eligibilityData.asStateFlow()

    private val _eligibleSchemes =
        MutableStateFlow<List<Scheme>>(emptyList())
    val eligibleSchemes: StateFlow<List<Scheme>> =
        _eligibleSchemes.asStateFlow()

    // ── Update functions ──────────────────────────────

    fun updateIncome(income: Double) {
        _eligibilityData.value =
            _eligibilityData.value.copy(income = income)
    }

    fun updateBpl(isBpl: Boolean) {
        _eligibilityData.value =
            _eligibilityData.value.copy(isBpl = isBpl)
    }

    fun updateOccupation(occupation: String) {
        _eligibilityData.value =
            _eligibilityData.value.copy(occupation = occupation)
    }

    fun updateState(state: String) {
        _eligibilityData.value =
            _eligibilityData.value.copy(state = state)
    }

    fun updateFamilySize(size: Int) {
        _eligibilityData.value =
            _eligibilityData.value.copy(familySize = size)
    }

    fun updateGender(gender: String) {
        _eligibilityData.value =
            _eligibilityData.value.copy(gender = gender)
    }

    fun updateDisability(hasDisability: Boolean) {
        _eligibilityData.value =
            _eligibilityData.value.copy(
                hasDisability = hasDisability
            )
    }
    fun updateAge(age: Int) {
        _eligibilityData.value =
            _eligibilityData.value.copy(age = age)
    }

    fun resetEligibility() {
        _eligibilityData.value = EligibilityData()
        _eligibleSchemes.value = emptyList()
    }

    // ── Check eligibility ─────────────────────────────

    fun checkEligibility() {
        viewModelScope.launch {
            val result = EligibilityEngine.getEligibleSchemes(
                user = _eligibilityData.value,
                allSchemes = SchemeDataSource.allSchemes
            )
            _eligibleSchemes.value = result
        }
    }
}
//package com.example.arogyanidhi.ui.eligibility
//
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.example.arogyanidhi.data.local.SchemeDataSource
//import com.example.arogyanidhi.domain.EligibilityEngine
//import com.example.arogyanidhi.domain.model.EligibilityData
//import com.example.arogyanidhi.domain.model.Scheme
//import dagger.hilt.android.lifecycle.HiltViewModel
//import kotlinx.coroutines.flow.MutableStateFlow
//import kotlinx.coroutines.flow.StateFlow
//import kotlinx.coroutines.flow.asStateFlow
//import kotlinx.coroutines.launch
//import javax.inject.Inject
//
//@HiltViewModel
//class EligibilityViewModel @Inject constructor() : ViewModel() {
//
//    private val _eligibilityData = MutableStateFlow(EligibilityData())
//    val eligibilityData: StateFlow<EligibilityData> = _eligibilityData.asStateFlow()
//
//    private val _eligibleSchemes = MutableStateFlow<List<Scheme>>(emptyList())
//    val eligibleSchemes: StateFlow<List<Scheme>> = _eligibleSchemes.asStateFlow()
//
//    // ── Update functions ──────────────────────────────
//
//    fun updateIncome(income: Double) {
//        _eligibilityData.value = _eligibilityData.value.copy(income = income)
//    }
//
//    fun updateBpl(isBpl: Boolean) {
//        _eligibilityData.value = _eligibilityData.value.copy(isBpl = isBpl)
//    }
//
//    fun updateOccupation(occupation: String) {
//        _eligibilityData.value = _eligibilityData.value.copy(occupation = occupation)
//    }
//
//    fun updateState(state: String) {
//        _eligibilityData.value = _eligibilityData.value.copy(state = state)
//    }
//
//    fun updateFamilySize(size: Int) {
//        _eligibilityData.value = _eligibilityData.value.copy(familySize = size)
//    }
//
//    fun updateGender(gender: String) {
//        _eligibilityData.value = _eligibilityData.value.copy(gender = gender)
//    }
//
//    fun updateDisability(hasDisability: Boolean) {
//        _eligibilityData.value = _eligibilityData.value.copy(hasDisability = hasDisability)
//    }
//
//    fun updateAge(age: Int) {
//        _eligibilityData.value = _eligibilityData.value.copy(age = age)
//    }
//
//    fun resetEligibility() {
//        _eligibilityData.value = EligibilityData()
//        _eligibleSchemes.value = emptyList()
//    }
//
//    // ── Check eligibility ─────────────────────────────
//
//    fun checkEligibility() {
//        viewModelScope.launch {
//            val result = EligibilityEngine.getEligibleSchemes(
//                user = _eligibilityData.value,
//                allSchemes = SchemeDataSource.allSchemes
//            )
//            _eligibleSchemes.value = result
//        }
//    }
//}