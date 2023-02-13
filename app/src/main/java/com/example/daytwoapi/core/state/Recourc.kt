package com.example.daytwoapi.core.state

sealed class Recourc<T>{
    class Init<T>:Recourc<T>()
    class Loading<T>:Recourc<T>()
    class Success<T>(var data:T):Recourc<T>()
    class Error<T>(var message:String,):Recourc<T>()
}
