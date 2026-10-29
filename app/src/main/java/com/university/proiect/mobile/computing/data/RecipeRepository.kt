package com.university.proiect.mobile.computing.data

import com.university.proiect.mobile.computing.model.RecipeItem

object RecipeRepository {
    val sampleRecipes = listOf(
        RecipeItem(
            id = "1",
            title = "Lemon Garlic Butter Pasta",
            prepTimeMinutes = 15,
            calories = 520,
            ingredients = listOf("Spaghetti", "Garlic", "Butter", "Lemon juice", "Parmesan cheese"),
            steps = listOf(
                "Boil pasta in salted water until al dente.",
                "Melt butter in a pan and sauté minced garlic until fragrant.",
                "Toss pasta in garlic butter with lemon juice and pasta water.",
                "Top with freshly grated parmesan and serve."
            ),
            isFavorite = true,
            category = "Quick Dinner"
        ),
        RecipeItem(
            id = "2",
            title = "One-Pan Chicken Fajitas",
            prepTimeMinutes = 20,
            calories = 450,
            ingredients = listOf("Chicken breast", "Bell peppers", "Onions", "Fajita seasoning", "Tortillas"),
            steps = listOf(
                "Slice chicken breast, bell peppers, and onions into thin strips.",
                "Season chicken and vegetables with fajita spices.",
                "Cook in a hot skillet until chicken is cooked through and peppers are tender.",
                "Serve warm in tortillas."
            ),
            isFavorite = true,
            category = "High Protein"
        ),
        RecipeItem(
            id = "3",
            title = "Avocado Egg Toast",
            prepTimeMinutes = 10,
            calories = 380,
            ingredients = listOf("Sourdough bread", "Ripe avocado", "Eggs", "Red pepper flakes", "Salt & Pepper"),
            steps = listOf(
                "Toast slice of sourdough bread.",
                "Mash avocado with salt, pepper, and lemon juice, then spread on toast.",
                "Fry or poach an egg and place on top of the avocado.",
                "Sprinkle with red pepper flakes."
            ),
            isFavorite = false,
            category = "Breakfast"
        ),
        RecipeItem(
            id = "4",
            title = "Quick Beef Stir Fry",
            prepTimeMinutes = 18,
            calories = 560,
            ingredients = listOf("Beef strips", "Broccoli florets", "Soy sauce", "Ginger", "Garlic", "Sesame oil"),
            steps = listOf(
                "Sauté beef strips in sesame oil until browned.",
                "Add broccoli florets and a splash of water, cover to steam for 3 minutes.",
                "Stir in soy sauce, ginger, and garlic.",
                "Serve hot over rice."
            ),
            isFavorite = true,
            category = "Quick Dinner"
        )
    )

    val todaysMeals = mapOf(
        "Breakfast" to sampleRecipes[2],
        "Lunch" to sampleRecipes[1],
        "Dinner" to sampleRecipes[0]
    )
}
