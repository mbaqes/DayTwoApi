package com.example.daytwoapi.prudactpage.data.repository

import com.example.daytwoapi.core.api.PrudactApi
import com.example.daytwoapi.core.state.Recourc
import com.example.daytwoapi.prudactpage.data.model.Prudacts
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class PrudactRepository {
    fun getPrudact(): Flow<Recourc<Prudacts>> {
        val server = Retrofit.Builder().baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(PrudactApi::class.java)
        return flow {
            emit(Recourc.Loading<Prudacts>())
            var result = server.getPrudacts()
            if(result.isSuccessful){
                emit(Recourc.Success<Prudacts>(data = result.body()!!))
            }else{
                emit(Recourc.Error<Prudacts>(message = "Error !!"))
            }

        }
    }
}