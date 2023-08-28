package com.himanshu.compose.ui

import ShowLazyColumnScreen
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.himanshu.data.Screen

@Composable
fun AppNavigation(){

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.HomeScreen.route ){
        composable(Screen.LazyList.route) {
            ShowLazyColumnScreen()
        }
        composable(Screen.HomeScreen.route){
            ShowHomeScreen(navController)
        }
    }

}