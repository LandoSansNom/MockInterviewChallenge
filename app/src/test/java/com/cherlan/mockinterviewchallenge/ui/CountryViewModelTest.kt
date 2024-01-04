package com.cherlan.mockinterviewchallenge.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.cherlan.mockinterviewchallenge.MainDispatcherRule
import com.cherlan.mockinterviewchallenge.repository.FakeCountryRepository
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.mockito.MockitoAnnotations

class CountryViewModelTest{

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var mainDispatcherRule = MainDispatcherRule()


    lateinit var fakeRepository: FakeCountryRepository

    @Before
    fun setup(){
        MockitoAnnotations.initMocks(this)
    }
}