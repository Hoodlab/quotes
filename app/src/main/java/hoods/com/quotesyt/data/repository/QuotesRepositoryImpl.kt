package hoods.com.quotesyt.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import hoods.com.quotesyt.data.models.Quotes
import hoods.com.quotesyt.data.pagination.QuotesPagingSource
import hoods.com.quotesyt.data.remote.api.QuotesService
import kotlinx.coroutines.flow.Flow

class QuotesRepositoryImpl(
    private val api: QuotesService,
) : QuotesRepository {

    override fun getQuotes(): Flow<PagingData<Quotes>> {
        return Pager(
            config = PagingConfig(pageSize = 20, enablePlaceholders = false),
            pagingSourceFactory = { QuotesPagingSource(api) }
        ).flow
    }
}