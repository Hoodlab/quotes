package hoods.com.quotesyt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.paging.compose.collectAsLazyPagingItems
import hoods.com.quotesyt.ui.quotes.QuotesScreen
import hoods.com.quotesyt.ui.quotes.viewmodel.QuotesViewModel
import hoods.com.quotesyt.ui.theme.QuotesYTTheme

class MainActivity : ComponentActivity() {
    val quotesViewModel: QuotesViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuotesYTTheme {
                val quotesPagingItems = quotesViewModel.quotes.collectAsLazyPagingItems()
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    QuotesScreen(quotesPagingItems)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    QuotesYTTheme {
        Greeting("Android")
    }
}