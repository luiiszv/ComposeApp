package com.example.composeapp.di

import com.example.composeapp.data.remote.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetWorkModule {


    @Singleton //Unica instancia de retrofit
    @Provides //Provee
     fun provideRetrofit():Retrofit{
         return Retrofit.Builder().baseUrl("https://backbladeup.onrender.com/api/").addConverterFactory(GsonConverterFactory.create()).build()
     }


    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService { //ApiService es la interface o donde estan los metodos de Get POST Etc...
        return retrofit.create(ApiService::class.java)
    }
}