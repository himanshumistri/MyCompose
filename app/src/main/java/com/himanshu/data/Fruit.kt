package com.himanshu.data

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

data class Fruit (var fruitName:String){
    var isSwitchOn:MutableState<Boolean> = mutableStateOf(false)
}