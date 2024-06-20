package com.task.cryptocurrencyapp.domain.repository

import com.task.cryptocurrencyapp.common.Resource
import com.task.cryptocurrencyapp.data.remote.dto.CoinDetailDto
import com.task.cryptocurrencyapp.data.remote.dto.CoinDto
import com.task.cryptocurrencyapp.domain.model.Coin
import com.task.cryptocurrencyapp.domain.model.CoinDetail
import kotlinx.coroutines.flow.Flow

interface CoinRepository {

    fun getCoins(): Flow<Resource<List<Coin>>>

    fun getCoinById(coinId: String): Flow<Resource<CoinDetail>>
}