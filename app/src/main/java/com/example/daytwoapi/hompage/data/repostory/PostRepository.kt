package com.example.daytwoapi.hompage.data.repostory

import com.example.daytwoapi.core.api.PostRequsts
import com.example.daytwoapi.core.state.Recourc
import com.example.daytwoapi.hompage.data.model.Posts
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PostRepository {

    fun getPosts():Flow<Recourc<Posts>>{
        val server = Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create()).
            build().create(PostRequsts::class.java)
        return flow {
            emit(Recourc.Loading<Posts>())
            delay(1000)
            try {
                var reposns=  server.getPosts()
                if (reposns.isSuccessful){
                    if(reposns.body()==null){
                        emit(Recourc.Error<Posts>("NO DATA !!"))
                    }else{
                        emit(Recourc.Success<Posts>(data = reposns.body()!!))
                    }

                }else{
                    emit(Recourc.Error<Posts>("Error !!"))
                }
            }catch (errer:Exception){
                emit(Recourc.Error<Posts>("Somthing Wrong !!"))
            }


            //// Flow Post
        }
    }
}