//package com.example.arogyanidhi.ui.profile
//
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.example.arogyanidhi.domain.model.UserProfile
//import com.example.arogyanidhi.domain.repository.AuthRepository
//import com.example.arogyanidhi.domain.repository.UserRepository
//import dagger.hilt.android.lifecycle.HiltViewModel
//import kotlinx.coroutines.flow.MutableStateFlow
//import kotlinx.coroutines.flow.StateFlow
//import kotlinx.coroutines.flow.asStateFlow
//import kotlinx.coroutines.launch
//import javax.inject.Inject
//
//@HiltViewModel
//class ProfileViewModel @Inject constructor(
//    private val authRepository: AuthRepository,
//    private val userRepository: UserRepository
//) : ViewModel() {
//
//    private val _userProfile = MutableStateFlow<UserProfile?>(null)
//    val userProfile: StateFlow<UserProfile?> = _userProfile.asStateFlow()
//
//    init {
//        viewModelScope.launch {
//            authRepository.currentUser.collect { user ->
//                user?.let {
//                    userRepository.getUserProfile(it.uid).collect { profile ->
//                        _userProfile.value = profile
//                    }
//                }
//            }
//        }
//    }
//
//    fun saveProfile(profile: UserProfile) {
//        viewModelScope.launch {
//            userRepository.saveUserProfile(profile)
//        }
//    }
//}
package com.example.arogyanidhi.ui.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.arogyanidhi.domain.model.UserProfile
import com.example.arogyanidhi.domain.repository.AuthRepository
import com.example.arogyanidhi.domain.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val authRepository: AuthRepository,
    private val userRepository: UserRepository
) : ViewModel() {

    private val _userProfile = MutableStateFlow<UserProfile?>(null)
    val userProfile: StateFlow<UserProfile?> = _userProfile.asStateFlow()

    // Store current uid so saveProfile can attach it
    private var currentUid: String = ""

    init {
        viewModelScope.launch {
            authRepository.currentUser.collect { user ->
                user?.let {
                    currentUid = it.uid  // ✅ Save uid so we use it when saving
                    userRepository.getUserProfile(it.uid).collect { profile ->
                        _userProfile.value = profile
                    }
                }
            }
        }
    }

    fun saveProfile(profile: UserProfile) {
        viewModelScope.launch {
            // ✅ FIX: Always attach the correct uid before saving.
            // Previously if userProfile was null (first time), uid was blank "",
            // so Firestore saved to document "" which you could never read back.
            val profileWithUid = profile.copy(uid = currentUid)
            userRepository.saveUserProfile(profileWithUid)
        }
    }
}