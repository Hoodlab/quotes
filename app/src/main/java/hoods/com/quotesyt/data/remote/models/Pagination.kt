package hoods.com.quotesyt.data.remote.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Pagination(
    @SerialName("currentPage")
    val currentPage: Int = 0,
    @SerialName("nextPage")
    val nextPage: Int = 0,
    @SerialName("totalPages")
    val totalPages: Int = 0
)