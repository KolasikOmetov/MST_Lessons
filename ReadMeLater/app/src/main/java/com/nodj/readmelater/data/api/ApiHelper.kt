package com.nodj.readmelater.data.api

class ApiHelper(private val apiService: ApiService) {

    suspend fun getPages() = apiService.getPages()
}