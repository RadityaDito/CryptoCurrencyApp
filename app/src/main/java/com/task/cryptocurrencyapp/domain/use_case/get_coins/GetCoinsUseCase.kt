package com.task.cryptocurrencyapp.domain.use_case.get_coins

import com.task.cryptocurrencyapp.common.Resource
import com.task.cryptocurrencyapp.data.remote.dto.toCoin
import com.task.cryptocurrencyapp.domain.model.Coin
import com.task.cryptocurrencyapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>>  {
       return repository.getCoins()
    }
}