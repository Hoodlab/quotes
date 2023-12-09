package hoods.com.quotesyt.data.remote.api

import hoods.com.quotesyt.data.remote.models.ApiQuotes
import hoods.com.quotesyt.utils.K
import retrofit2.http.GET
import retrofit2.http.Query

interface QuotesService {

    @GET(K.API_END_POINTS)
    suspend fun getQuotes(
        @Query("page") page: Int,
        @Query("limit") limit: Int,
        @Query("genre") genre: String = "motivational",
    ):ApiQuotes

}