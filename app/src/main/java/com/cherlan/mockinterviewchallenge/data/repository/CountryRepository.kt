package com.cherlan.mockinterviewchallenge.data.repository

import com.cherlan.mockinterviewchallenge.data.model.Country
import com.cherlan.mockinterviewchallenge.utils.Result
import kotlinx.coroutines.flow.Flow

interface CountryRepository {
    suspend fun getCountries(): Flow<Result>
}