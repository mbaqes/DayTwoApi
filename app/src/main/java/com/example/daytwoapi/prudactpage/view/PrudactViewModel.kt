package com.example.daytwoapi.prudactpage.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.daytwoapi.core.state.Recourc
import com.example.daytwoapi.prudactpage.data.model.Prudacts
import com.example.daytwoapi.prudactpage.data.repository.PrudactRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class PrudactViewModel:ViewModel() {

    val prudacctRepository = PrudactRepository()
    var currntState = Recourc.Init<Prudacts>()
    var state = MutableStateFlow<Recourc<Prudacts>>(currntState)
    init {
        getPrudatcs()
    }

    fun getPrudatcs(){
        viewModelScope.launch {
            prudacctRepository.getPrudact().onEach { newstate->
                state.value=newstate
            }.launchIn(
                this
            )
        }
    }
}