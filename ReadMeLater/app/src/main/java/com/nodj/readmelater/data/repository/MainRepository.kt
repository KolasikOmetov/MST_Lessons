package com.nodj.readmelater.data.repository

import com.nodj.readmelater.data.api.ApiHelper

class MainRepository(private val apiHelper: ApiHelper) {

    suspend fun getPages() = apiHelper.getPages()
}