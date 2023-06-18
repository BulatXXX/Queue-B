package com.example.queuev

sealed class Screen(val route: String){
    object ProfileScreen: Screen("profile_screen")
    object GroupsScreen: Screen("groups_screen")
    object QueuesScreen: Screen("queues_screen")
}
