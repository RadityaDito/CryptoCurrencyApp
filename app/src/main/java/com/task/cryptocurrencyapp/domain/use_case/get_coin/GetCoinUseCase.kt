package com.task.cryptocurrencyapp.domain.use_case.get_coin

import com.task.cryptocurrencyapp.common.Resource
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

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId : String): Flow<Resource<CoinDetail>>  {
         return repository.getCoinById(coinId)
    }
}