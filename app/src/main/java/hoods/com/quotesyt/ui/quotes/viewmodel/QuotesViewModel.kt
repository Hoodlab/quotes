package hoods.com.quotesyt.ui.quotes.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import hoods.com.quotesyt.Graph
import hoods.com.quotesyt.data.models.Quotes
import hoods.com.quotesyt.data.repository.QuotesRepository
import kotlinx.coroutines.flow.Flow

class QuotesViewModel(
    private val quotesRepository: QuotesRepository = Graph.repository,
) : ViewModel() {
    val quotes: Flow<PagingData<Quotes>> = quotesRepository
        .getQuotes()
        .cachedIn(viewModelScope)
}





