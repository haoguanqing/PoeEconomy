package com.ghao.lib.core.network

import com.ghao.lib.core.data.League
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

interface PoeApiService {
    @GET("/league")
    fun getLeagues(): Flow<List<League>>

    companion object {
        // https://www.pathofexile.com/developer/docs/reference#leagues
        const val POE_API_URL = "https://api.pathofexile.com/"
    }
}
