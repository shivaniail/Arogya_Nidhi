package com.example.arogyanidhi.di

import com.example.arogyanidhi.data.repository.AuthRepositoryImpl
import com.example.arogyanidhi.data.repository.UserRepositoryImpl
import com.example.arogyanidhi.domain.repository.AuthRepository
import com.example.arogyanidhi.domain.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindAuthRepository(
        authRepositoryImpl: AuthRepositoryImpl
    ): AuthRepository

    @Binds
    @Singleton
    abstract fun bindUserRepository(
        userRepositoryImpl: UserRepositoryImpl
    ): UserRepository
}
//package com.example.arogyanidhi.di
//
//import com.example.arogyanidhi.data.repository.UserRepositoryImpl
//import com.example.arogyanidhi.domain.repository.UserRepository
//import com.google.firebase.firestore.FirebaseFirestore
//import com.google.firebase.storage.FirebaseStorage
//import dagger.Module
//import dagger.Provides
//import dagger.hilt.InstallIn
//import dagger.hilt.components.SingletonComponent
//import javax.inject.Singleton
//
//@Module
//@InstallIn(SingletonComponent::class)
//object RepositoryModule {
//
//    @Provides
//    @Singleton
//    fun provideUserRepository(
//        firestore: FirebaseFirestore,
//        storage: FirebaseStorage
//    ): UserRepository {
//        return UserRepositoryImpl(firestore, storage)
//    }
//}