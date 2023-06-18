package com.example.queuev

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


@Composable
fun Navigation(navController: NavHostController){

    NavHost(navController = navController , startDestination = Screen.ProfileScreen.route){
        composable(route = Screen.ProfileScreen.route){
            ProfileScreen()
        }
        composable(route = Screen.GroupsScreen.route){
            GroupsScreen()
        }
        composable(route = Screen.QueuesScreen.route){
            QueuesScreen()
        }
    }
}

