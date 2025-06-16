package com.example.composeapp.di

import com.example.composeapp.data.local.datastore.TokenDataStore
import com.example.composeapp.data.remote.AuthInterceptor
import com.example.composeapp.data.users.remote.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetWorkModule {


    @Provides
    fun provideAuthInterceptor(tokenDataStore: TokenDataStore): AuthInterceptor {
        return AuthInterceptor(tokenDataStore)
    }

    @Provides
    fun provideOkHttpClient(authInterceptor: AuthInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(authInterceptor)
            .build()
    }


    @Singleton //Unica instancia de retrofit
    @Provides //Provee
     fun provideRetrofit(okHttpClient: OkHttpClient):Retrofit{
         return Retrofit.Builder().baseUrl("https://backbladeup.onrender.com/api/").addConverterFactory(GsonConverterFactory.create()).build()
     }


    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService { //ApiService es la interface o donde estan los metodos de Get POST Etc...
        return retrofit.create(ApiService::class.java)
    }
}