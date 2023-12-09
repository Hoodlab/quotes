package hoods.com.quotesyt.data.repository

import androidx.paging.PagingData
import hoods.com.quotesyt.data.models.Quotes
import kotlinx.coroutines.flow.Flow

interface QuotesRepository {
    fun getQuotes():Flow<PagingData<Quotes>>
}