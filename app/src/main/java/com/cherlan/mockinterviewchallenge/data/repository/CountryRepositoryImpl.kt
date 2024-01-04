package com.cherlan.mockinterviewchallenge.data.repository

import com.cherlan.mockinterviewchallenge.data.model.Country
import com.cherlan.mockinterviewchallenge.utils.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn


class CountryRepositoryImpl: CountryRepository {
    override suspend fun getCountries(): Flow<Result> {

        return flow {
            val countries = listOf(Country("United States of America","NA","USA", "Washington D.C"),Country("Uruguay","SA","UY", "Montevideo"))
            emit(Result.Success(countries))
        }.flowOn(Dispatchers.IO)
    }
}