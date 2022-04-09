package com.adiputrastwn.viatrip.di


import com.adiputrastwn.viatrip.data.ViaTripApi
import com.adiputrastwn.viatrip.data.ViaTripApiImpl
import com.adiputrastwn.viatrip.data.mock.MockApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideViaTripApi(): ViaTripApi = ViaTripApiImpl()

    @Singleton
    @Provides
    fun provideMockApi(): MockApi = MockApi()
}