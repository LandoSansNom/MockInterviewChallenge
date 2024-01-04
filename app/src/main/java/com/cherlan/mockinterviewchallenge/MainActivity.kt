package com.cherlan.mockinterviewchallenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.cherlan.mockinterviewchallenge.data.model.Country
import com.cherlan.mockinterviewchallenge.ui.CountryViewModel
import com.cherlan.mockinterviewchallenge.ui.theme.MockInterviewChallengeTheme

class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<CountryViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MockInterviewChallengeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                 Countries(countryViewModel = viewModel)

                }
            }
        }
    }
}


fun String.AddLastName(lastName: String): String{
    return "$this $lastName"
}



@Composable
fun Country(country: Country) {

    Column {
        Text(
            text = "${country.name}, ${country.region}, ${country.code}",
            modifier = Modifier.fillMaxWidth(),
            fontWeight = FontWeight.Bold

        )

        Text(
            text =  country.capital,
            modifier = Modifier.fillMaxWidth()
        )
    }



}


@Composable
fun Countries(countryViewModel: CountryViewModel) {

    val countries = countryViewModel.countries.collectAsState()


        LazyColumn(modifier = Modifier.fillMaxHeight()) {
            items(countries.) { item ->
                Country(country = it)

                Text(text = "Country $item")
            }
        }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MockInterviewChallengeTheme {
        Country("United States","America", "USA", "Washington D.C")
    }
}