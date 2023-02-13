package com.example.daytwoapi.hompage.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.daytwoapi.core.state.Recourc
import com.example.daytwoapi.hompage.data.model.Posts

@Composable
fun PostPage() {
    val vm :PostViewModel = viewModel()
    val state = vm.state.collectAsState().value
    Scaffold() {
        it.calculateTopPadding()
      
        Column(modifier = Modifier.fillMaxSize(), 
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {
            Text(text = "قائمة المنشورات")
            when(state){
                is Recourc.Loading<Posts> ->{
                      CircularProgressIndicator(modifier = Modifier.size(80.dp))
                }
                is Recourc.Success<Posts> ->{
                    LazyColumn(modifier = Modifier.fillMaxSize() ){
                        items(state.data){postItem->
                            Card() {
                                Row(modifier = Modifier.fillMaxWidth()) {
                                    Column() {
                                        Text(text = postItem.title)
                                        Text(text = postItem.body)
                                    }
                                }
                            }
                            
                        }
                    }
                }
                else->{
                    Text(text = "No Data !!!")
                }
            }
           
        }
    }
    
}