package hoods.com.quotesyt.data.models

data class Quotes(
    val id: String,
    val quoteAuthor: String,
    val quoteGenre: String,
    val quoteText: String,
    val currentPage: Int,
)
