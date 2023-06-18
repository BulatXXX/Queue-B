package com.example.queuev


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ExperimentalComposeApi
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@ExperimentalComposeApi
@Composable
fun BottomNavigationBar(
    items: List<BottomNavItem> ,
    navController: NavController ,
    modifier: Modifier = Modifier ,
    onItemClick: (BottomNavItem) -> Unit
) {
    val backStackEntry = navController.currentBackStackEntryAsState()
    BottomNavigation(
        modifier = modifier ,
        backgroundColor = Color.Black ,
        elevation = 5.dp
    ) {
        items.forEach { bottomNavItem ->
            val selected = bottomNavItem.route == backStackEntry.value?.destination?.route


            BottomNavigationItem(
                selected = selected ,
                onClick = { onItemClick(bottomNavItem) } ,
                selectedContentColor = Color.White ,
                unselectedContentColor = Color.Black,
                icon = {
                    Row(horizontalArrangement = Arrangement.SpaceBetween) {
                        Icon(imageVector = bottomNavItem.icon ,
                            contentDescription = null ,
                            modifier = Modifier
                                .graphicsLayer(alpha = 0.99f)
                                .drawWithCache {
                                    onDrawWithContent {
                                        drawContent()
                                        val brushGradient =
                                            Brush.verticalGradient(
                                                colors = listOf(
                                                    Color(0x8FFF00D6) ,
                                                    Color(0xFF9F4040)
                                                )
                                            )
                                        drawRect(brushGradient , blendMode = BlendMode.SrcAtop)
                                    }
                                }
                                .size(40.dp))
                    }


                }

            )
        }


    }
}

