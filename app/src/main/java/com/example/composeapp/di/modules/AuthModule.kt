package com.example.composeapp.di.modules

import com.example.composeapp.data.auth.repository.AuthRepositoryImp
import com.example.composeapp.domain.auth.repository.AuthRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract  class AuthModule {


    @Binds
    @Singleton
    abstract fun bindAuthRepository(authRepositoryImp: AuthRepositoryImp): AuthRepository
}