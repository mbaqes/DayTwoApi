package com.example.daytwoapi.core.api

import com.example.daytwoapi.hompage.data.model.Posts
import retrofit2.Response
import retrofit2.http.GET

interface PostRequsts {
    @GET("posts")
   suspend fun getPosts():Response<Posts>
}