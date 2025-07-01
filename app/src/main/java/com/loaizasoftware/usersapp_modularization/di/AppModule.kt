package com.loaizasoftware.usersapp_modularization.di

import android.content.Context
import com.loaizasoftware.data.api.RetrofitApiClient
import com.loaizasoftware.data.api.RetrofitApiService
import com.loaizasoftware.data.repositories_impl.UsersRepositoryImpl
import com.loaizasoftware.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun providesRetrofitApiService(@ApplicationContext context: Context): RetrofitApiService {
        return RetrofitApiClient().apiService
    }

    @Provides
    @Singleton
    fun providesUserRepository(apiService: RetrofitApiService): UserRepository {
        return UsersRepositoryImpl(apiService)
    }

}