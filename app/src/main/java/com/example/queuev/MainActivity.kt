package com.example.queuev

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ExperimentalComposeApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toBitmap
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.queuev.ui.theme.QueueVTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    @OptIn(ExperimentalComposeApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {


            QueueVTheme {

                MainScreens()


            }
        }
    }


}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@OptIn(ExperimentalComposeApi::class)
@Composable
private fun MainScreens() {
    val navController = rememberNavController()
    Scaffold(bottomBar = {
        BottomNavigationBar(
            items = listOf(
                BottomNavItem(
                    name = Screen.QueuesScreen.route ,
                    route = Screen.QueuesScreen.route ,
                    icon = ImageVector.vectorResource(id = R.drawable.queue)
                ) ,
                BottomNavItem(
                    name = Screen.GroupsScreen.route ,
                    route = Screen.GroupsScreen.route ,
                    icon = ImageVector.vectorResource(id = R.drawable.group)
                ) ,
                BottomNavItem(
                    name = Screen.ProfileScreen.route ,
                    route = Screen.ProfileScreen.route ,
                    icon = ImageVector.vectorResource(id = R.drawable.user)
                )
            ) ,
            navController = navController ,
            onItemClick = { navController.navigate(it.route) }
        )
    }
    ) {
        Navigation(navController = navController)
    }
}

