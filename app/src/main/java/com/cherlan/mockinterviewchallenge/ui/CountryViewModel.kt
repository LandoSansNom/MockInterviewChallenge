package com.cherlan.mockinterviewchallenge.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cherlan.mockinterviewchallenge.data.repository.CountryRepository
import com.cherlan.mockinterviewchallenge.data.repository.CountryRepositoryImpl
import com.cherlan.mockinterviewchallenge.utils.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class CountryViewModel(private val countryRepository: CountryRepository = CountryRepositoryImpl()) : ViewModel() {

   private val _countries = MutableStateFlow<Result>(Result.Loading)
    val countries = _countries.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                countryRepository.getCountries().collect { list ->
                    _countries.value = list
                }
            } catch (e: Exception) {

            }
        }
    }

}