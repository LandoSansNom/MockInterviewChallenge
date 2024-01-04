package com.cherlan.mockinterviewchallenge.utils

import com.cherlan.mockinterviewchallenge.data.model.Country
import kotlin.Result

sealed class Result{
    data class Success(val countries: List<Country>) : com.cherlan.mockinterviewchallenge.utils.Result()
    data class Error(val errorMsg: String) : com.cherlan.mockinterviewchallenge.utils.Result()
    object Loading : com.cherlan.mockinterviewchallenge.utils.Result()
}
