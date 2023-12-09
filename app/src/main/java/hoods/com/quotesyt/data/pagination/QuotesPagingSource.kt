package hoods.com.quotesyt.data.pagination

import androidx.paging.PagingSource
import androidx.paging.PagingState
import hoods.com.quotesyt.data.models.Quotes
import hoods.com.quotesyt.data.remote.api.QuotesService
import hoods.com.quotesyt.data.remote.models.toQuotes
import retrofit2.HttpException
import java.io.IOException

class QuotesPagingSource(
    private val api: QuotesService,
) : PagingSource<Int, Quotes>() {
    companion object {
        private const val STARTING_KEY = 1
    }

    override fun getRefreshKey(state: PagingState<Int, Quotes>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Quotes> {
        val startKey = params.key ?: STARTING_KEY
        return try {
            val quotes = api.getQuotes(startKey, params.loadSize)
            val nextKey = if (quotes.data.isEmpty()) null else quotes.pagination.nextPage
            LoadResult.Page(
                data = quotes.data.map { it.toQuotes(quotes.pagination.currentPage) },
                prevKey = if (startKey == STARTING_KEY) null else startKey - 1,
                nextKey = nextKey
            )


        } catch (e: IOException) {
            return LoadResult.Error(e)
        } catch (httpException: HttpException) {
            return LoadResult.Error(httpException)
        }
    }
}










