package com.task.cryptocurrencyapp.di

import com.task.cryptocurrencyapp.common.Constants
import com.task.cryptocurrencyapp.data.api.CoinRepositoryImpl
import com.task.cryptocurrencyapp.data.remote.CoinPaprikaApi
import com.task.cryptocurrencyapp.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class) //Life as long as the application
object AppModule {
    @Provides
    @Singleton //Make sure only one instance of this class is created
    fun providePaprikaApi(): CoinPaprikaApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(
                GsonConverterFactory.create()
            )
            .build()
            .create(CoinPaprikaApi::class.java)
    }


    //Because of the repository is interface so we need to provide it and return the implementation
    @Provides
    @Singleton
    fun provideCoinRepository(api: CoinPaprikaApi): CoinRepository {
        return CoinRepositoryImpl(api)
    }
}