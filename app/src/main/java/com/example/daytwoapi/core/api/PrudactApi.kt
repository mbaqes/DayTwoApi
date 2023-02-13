package com.example.daytwoapi.core.api

import com.example.daytwoapi.prudactpage.data.model.Prudacts
import retrofit2.Response
import retrofit2.http.GET

interface PrudactApi {
    @GET("products")
   suspend fun getPrudacts():Response<Prudacts>
}