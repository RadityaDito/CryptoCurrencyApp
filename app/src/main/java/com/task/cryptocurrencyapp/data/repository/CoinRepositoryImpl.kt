package com.task.cryptocurrencyapp.data.api

import com.task.cryptocurrencyapp.common.Resource
import com.task.cryptocurrencyapp.data.remote.CoinPaprikaApi
import com.task.cryptocurrencyapp.data.remote.dto.CoinDetailDto
import com.task.cryptocurrencyapp.data.remote.dto.CoinDto
import com.task.cryptocurrencyapp.data.remote.dto.toCoin
import com.task.cryptocurrencyapp.data.remote.dto.toCoinDetail
import com.task.cryptocurrencyapp.domain.model.Coin
import com.task.cryptocurrencyapp.domain.model.CoinDetail
import com.task.cryptocurrencyapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {
    override fun getCoins(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val coins = api.getCoins().map { it.toCoin() }
            emit(Resource.Success(coins))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (IoException: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }
    }

    override fun getCoinById(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading())
            val coin = api.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success(coin))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (IoException: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }
    }
}/**/