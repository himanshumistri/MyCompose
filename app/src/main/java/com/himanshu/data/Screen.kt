package com.himanshu.data
sealed class Screen(val route: String){
    object LazyList : Screen("LazyListScreen")
    object HomeScreen : Screen("HomeScreen")
}
