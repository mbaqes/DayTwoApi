package com.example.daytwoapi.prudactpage.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.daytwoapi.core.state.Recourc
import com.example.daytwoapi.prudactpage.data.model.Prudacts

@Composable
fun PrudactPage() {
    val prudactVm :PrudactViewModel = viewModel()
    val state = prudactVm.state.collectAsState().value
    Scaffold(modifier = Modifier.fillMaxSize()) {
        it.calculateTopPadding()
           when(state){
               is Recourc.Success<Prudacts>->{
                   LazyColumn(modifier = Modifier.fillMaxSize()){
                       items(state.data.products){ prodactitem->
                             Card() {
                                 Column() {
                                     Text(text =prodactitem.brand )
                                     Text(text =prodactitem.title )
                                     Row() {
                                       // LazyRow()
                                     }

                                 }
                             }
                       }
                   }

               }
               else->{

               }
           }
    }
}