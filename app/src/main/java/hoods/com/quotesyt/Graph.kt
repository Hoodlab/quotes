package hoods.com.quotesyt

import android.content.Context
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import hoods.com.quotesyt.data.remote.api.QuotesService
import hoods.com.quotesyt.data.repository.QuotesRepository
import hoods.com.quotesyt.data.repository.QuotesRepositoryImpl
import hoods.com.quotesyt.utils.K
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

object Graph {
    private val json = Json {
        coerceInputValues = true
        ignoreUnknownKeys = true
    }
    lateinit var api: QuotesService
    val repository: QuotesRepository by lazy {
        QuotesRepositoryImpl(api)
    }

    fun provide(context: Context) {
        val contentType = "application/json".toMediaType()
        api = Retrofit.Builder()
            .baseUrl(K.BASE_URL)
            .addConverterFactory(json.asConverterFactory(contentType))
            .build()
            .create(QuotesService::class.java)
    }
}







