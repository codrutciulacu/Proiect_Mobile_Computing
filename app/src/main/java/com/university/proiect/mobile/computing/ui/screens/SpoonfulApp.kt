package com.university.proiect.mobile.computing.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.university.proiect.mobile.computing.model.RecipeItem
import com.university.proiect.mobile.computing.ui.theme.ProiectMobileComputingTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SpoonfulApp(modifier: Modifier = Modifier) {
    var selectedTab by remember { mutableIntStateOf(0) }
    var selectedRecipeForDetail by remember { mutableStateOf<RecipeItem?>(null) }

    if (selectedRecipeForDetail != null) {
        BackHandler {
            selectedRecipeForDetail = null
        }
        RecipeDetailScreenView(
            recipe = selectedRecipeForDetail!!,
            modifier = modifier,
            onBackClick = { selectedRecipeForDetail = null }
        )
    } else {
        Scaffold(
            modifier = modifier.fillMaxSize(),
            topBar = {
                TopAppBar(
                    title = {
                        val titleText = when (selectedTab) {
                            0 -> "Spoonful"
                            1 -> "Recipes Catalog"
                            2 -> "Meal Planner"
                            3 -> "Go-To Favorites"
                            4 -> "Shopping List"
                            else -> "Spoonful"
                        }
                        Text(text = titleText, fontWeight = FontWeight.Bold, fontSize = 22.sp)
                    },
                    actions = {
                        IconButton(onClick = { /* Profile or settings */ }) {
                            Icon(
                                Icons.Default.AccountCircle,
                                contentDescription = "Profile",
                                tint = MaterialTheme.colorScheme.secondary
                            )
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainer
                    )
                )
            },
            bottomBar = {
                NavigationBar {
                    NavigationBarItem(
                        icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
                        label = { Text("Home") },
                        selected = selectedTab == 0,
                        onClick = { selectedTab = 0 }
                    )
                    NavigationBarItem(
                        icon = { Icon(Icons.Default.RestaurantMenu, contentDescription = "Recipes") },
                        label = { Text("Recipes") },
                        selected = selectedTab == 1,
                        onClick = { selectedTab = 1 }
                    )
                    NavigationBarItem(
                        icon = { Icon(Icons.Default.CalendarMonth, contentDescription = "Planner") },
                        label = { Text("Planner") },
                        selected = selectedTab == 2,
                        onClick = { selectedTab = 2 }
                    )
                    NavigationBarItem(
                        icon = { Icon(Icons.Default.Favorite, contentDescription = "Favorites") },
                        label = { Text("Favorites") },
                        selected = selectedTab == 3,
                        onClick = { selectedTab = 3 }
                    )
                    NavigationBarItem(
                        icon = { Icon(Icons.Default.ShoppingCart, contentDescription = "Shopping") },
                        label = { Text("Shopping") },
                        selected = selectedTab == 4,
                        onClick = { selectedTab = 4 }
                    )
                }
            }
        ) { innerPadding ->
            val contentModifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)

            when (selectedTab) {
                0 -> HomeScreenView(
                    modifier = contentModifier,
                    onRecipeClick = { recipe -> selectedRecipeForDetail = recipe },
                    onSeeAllFavoritesClick = { selectedTab = 3 }
                )
                1 -> RecipeScreenView(
                    modifier = contentModifier,
                    onRecipeClick = { recipe -> selectedRecipeForDetail = recipe }
                )
                2 -> MealPlannerScreenView(
                    modifier = contentModifier,
                    onRecipeClick = { recipe -> selectedRecipeForDetail = recipe }
                )
                3 -> FavoritesScreenView(
                    modifier = contentModifier,
                    onRecipeClick = { recipe -> selectedRecipeForDetail = recipe }
                )
                4 -> ShoppingListScreenView(modifier = contentModifier)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SpoonfulAppPreview() {
    ProiectMobileComputingTheme {
        SpoonfulApp()
    }
}
