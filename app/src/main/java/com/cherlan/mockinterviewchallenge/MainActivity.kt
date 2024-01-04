package com.cherlan.mockinterviewchallenge

import android.os.Bundle
import android.widget.Toast
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.cherlan.mockinterviewchallenge.data.model.Country
import com.cherlan.mockinterviewchallenge.ui.CountryViewModel
import com.cherlan.mockinterviewchallenge.ui.theme.MockInterviewChallengeTheme
import com.cherlan.mockinterviewchallenge.utils.Result

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

    val context = LocalContext.current
    val result = countryViewModel.countries.collectAsState().value


    when(result){
        is Result.Loading -> Toast.makeText(context,"Loading",Toast.LENGTH_LONG).show()
        is Result.Success -> {
            LazyColumn(modifier = Modifier.fillMaxHeight()) {
                items(result.countries) { item ->
                    Country(country = item)

                    Text(text = "Country $item")
                }
            }
        }
        is Result.Error -> Toast.makeText(context,result.errorMsg,Toast.LENGTH_LONG).show()

    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MockInterviewChallengeTheme {
        Country("United States","America", "USA", "Washington D.C")
    }
}