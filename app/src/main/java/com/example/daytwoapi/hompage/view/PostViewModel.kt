package com.example.daytwoapi.hompage.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.daytwoapi.core.state.Recourc
import com.example.daytwoapi.hompage.data.model.Posts
import com.example.daytwoapi.hompage.data.repostory.PostRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class PostViewModel:ViewModel() {
    val postRepository=PostRepository()
    var currentState = Recourc.Init<Posts>()
    var state = MutableStateFlow<Recourc<Posts>>(currentState)
    init {
       getPost()
    }
    fun getPost(){
      viewModelScope.launch {
          postRepository.getPosts().onEach {
              state.value=it
          }.launchIn(this)
      }
    }
}