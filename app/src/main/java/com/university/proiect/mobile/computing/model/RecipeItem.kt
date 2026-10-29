package com.university.proiect.mobile.computing.model

data class RecipeItem(
    val id: String,
    val title: String,
    val prepTimeMinutes: Int,
    val calories: Int,
    val ingredients: List<String>,
    val steps: List<String>,
    val isFavorite: Boolean = false,
    val category: String = "Quick Dinner"
)
