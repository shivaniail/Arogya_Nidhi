package com.example.arogyanidhi.data.repository

import com.example.arogyanidhi.domain.model.UserProfile
import com.example.arogyanidhi.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor() : UserRepository {

    private val _profiles = mutableMapOf<String, UserProfile>()

    override fun getUserProfile(uid: String): Flow<UserProfile?> = flow {
        val profile = _profiles[uid] ?: UserProfile(
            uid = uid,
            name = "Dummy User",
            email = "dummy@example.com"
        )
        emit(profile)
    }

    override suspend fun saveUserProfile(userProfile: UserProfile): Result<Unit> {
        _profiles[userProfile.uid] = userProfile
        return Result.success(Unit)
    }

    override suspend fun uploadProfileImage(uid: String, imageBytes: ByteArray): Result<String> {
        return Result.success("https://dummy-image-url.com")
    }
}