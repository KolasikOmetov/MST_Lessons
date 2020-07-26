package com.nodj.readmelater.data.api

import com.nodj.readmelater.data.model.Page
import retrofit2.http.GET

interface ApiService {

    @GET("pages")
    suspend fun getPages(): List<Page>

}