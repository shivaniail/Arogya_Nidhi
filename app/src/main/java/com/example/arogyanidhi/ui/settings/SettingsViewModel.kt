//package com.example.arogyanidhi.ui.settings
//
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.example.arogyanidhi.data.local.PreferenceManager
//import com.example.arogyanidhi.domain.repository.AuthRepository
//import dagger.hilt.android.lifecycle.HiltViewModel
//import kotlinx.coroutines.launch
//import javax.inject.Inject
//
//@HiltViewModel
//class SettingsViewModel @Inject constructor(
//    private val authRepository: AuthRepository,
//    private val preferenceManager: PreferenceManager
//) : ViewModel() {
//
//    // Logout user from Firebase
//    fun logout() {
//        viewModelScope.launch {
//            authRepository.logout()   // FirebaseAuth.signOut() internally
//        }
//    }
//
//    // Reset onboarding flag (show intro again)
//    fun resetOnboarding() {
//        viewModelScope.launch {
//            preferenceManager.setOnboardingCompleted(false)
//        }
//    }
//}

//package com.example.arogyanidhi.ui.settings
//
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.example.arogyanidhi.data.local.PreferenceManager
//import com.example.arogyanidhi.domain.repository.AuthRepository
//import dagger.hilt.android.lifecycle.HiltViewModel
//import kotlinx.coroutines.launch
//import javax.inject.Inject
//
//@HiltViewModel
//class SettingsViewModel @Inject constructor(
//    private val preferenceManager: PreferenceManager,
//    private val authRepository: AuthRepository
//) : ViewModel() {
//
//    // ── Logout ───────────────────────────────────────────────────────────
//    // Clears Firebase session. Navigation back to Login is handled
//    // by SettingsScreen calling onLogout() after this.
//    fun logout() {
//        viewModelScope.launch {
//            authRepository.logout()
//        }
//    }
//
//    // ── Reset Onboarding ─────────────────────────────────────────────────
//    // Sets the DataStore flag back to false so OnboardingScreen
//    // will show again on next app launch.
//    // This is what was MISSING — SettingsScreen called viewModel.resetOnboarding()
//    // but the function didn't exist.
//    fun resetOnboarding() {
//        viewModelScope.launch {
//            preferenceManager.setOnboardingCompleted(false)
//
//        }
//    }
//}

package com.example.arogyanidhi.ui.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.arogyanidhi.data.local.PreferenceManager
import com.example.arogyanidhi.domain.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val preferenceManager: PreferenceManager,
    private val authRepository: AuthRepository
) : ViewModel() {

    // ── Logout ───────────────────────────────────────────────────────────
    // Clears Firebase session. Navigation back to Login is handled
    // by SettingsScreen calling onLogout() after this.
    fun logout() {
        viewModelScope.launch {
            authRepository.logout()
        }
    }

    // ── Reset Onboarding ─────────────────────────────────────────────────
    // Sets the DataStore flag back to false so OnboardingScreen
    // will show again on next app launch.
    // This is what was MISSING — SettingsScreen called viewModel.resetOnboarding()
    // but the function didn't exist.
    fun resetOnboarding() {
        viewModelScope.launch {
            preferenceManager.setOnboardingCompleted(false)
        }
    }
}