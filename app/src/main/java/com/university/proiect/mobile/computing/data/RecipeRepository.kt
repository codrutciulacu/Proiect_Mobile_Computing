package com.university.proiect.mobile.computing.data

import com.university.proiect.mobile.computing.model.Recipe
import com.university.proiect.mobile.computing.model.Review
import kotlin.random.Random

object RecipeRepository {
    val possibleRecipes = listOf(
        Recipe(
            id = "1",
            title = "Lemon Garlic Butter Pasta",
            prepTimeMinutes = 15,
            calories = 520,
            ingredients = listOf(
                "250g Spaghetti",
                "4 cloves Garlic (minced)",
                "3 tbsp Butter",
                "2 tbsp Fresh Lemon Juice",
                "50g Parmesan Cheese (grated)",
                "Fresh Parsley & Black Pepper"
            ),
            steps = listOf(
                "Bring a large pot of salted water to boil. Cook spaghetti until al dente (approx. 9 mins). Reserve 1/2 cup pasta water.",
                "In a large skillet, melt butter over medium heat. Add minced garlic and sauté for 1-2 minutes until fragrant.",
                "Transfer pasta directly into the skillet. Pour in lemon juice and a splash of reserved pasta water, tossing vigorously to create an emulsion.",
                "Remove from heat, fold in freshly grated parmesan cheese and chopped parsley. Season with black pepper and serve immediately."
            ),
            isFavorite = true,
            category = "Quick Dinner",
            rating = 4.9,
            reviews = listOf(
                Review("Andrei M.", 5, "Saved my evening after a 10-hour workday! Ready in under 15 minutes."),
                Review("Ioana D.", 5, "Zesty, rich, and super comforting. Added a pinch of chilli flakes for extra kick.")
            )
        ),
        Recipe(
            id = "2",
            title = "One-Pan Chicken Fajitas",
            prepTimeMinutes = 20,
            calories = 450,
            ingredients = listOf(
                "400g Chicken Breast (sliced)",
                "2 Bell Peppers (sliced)",
                "1 Red Onion (sliced)",
                "2 tbsp Olive Oil",
                "1 packet Fajita Seasoning",
                "4 Flour Tortillas"
            ),
            steps = listOf(
                "Slice chicken breast, bell peppers, and onion into thin even strips.",
                "Toss chicken and vegetables in a bowl with olive oil and fajita seasoning until well coated.",
                "Heat a large skillet over high heat. Sear chicken and veggies for 7-9 minutes until charred and cooked through.",
                "Warm tortillas and assemble fajitas with a squeeze of lime juice and sour cream if desired."
            ),
            isFavorite = true,
            category = "High Protein",
            rating = 4.7,
            reviews = listOf(
                Review("Mihai T.", 5, "Only one pan to wash, plenty of protein, and tastes authentic!"),
                Review("Elena V.", 4, "Great quick dinner. Next time I will add guacamole.")
            )
        ),
        Recipe(
            id = "3",
            title = "Avocado Egg Toast",
            prepTimeMinutes = 10,
            calories = 380,
            ingredients = listOf(
                "2 slices Sourdough Bread",
                "1 Ripe Avocado",
                "2 Fresh Eggs",
                "1/2 Lemon (juiced)",
                "Red Pepper Flakes & Flaky Sea Salt"
            ),
            steps = listOf(
                "Toast sourdough bread slices until golden and crisp.",
                "Cut avocado in half, remove pit, and mash flesh with lemon juice, sea salt, and black pepper.",
                "Heat non-stick pan with a drop of olive oil; fry or poach eggs to your liking (runny yolk recommended).",
                "Spread mashed avocado generously over warm toast, top with egg, and garnish with red pepper flakes."
            ),
            isFavorite = false,
            category = "Breakfast",
            rating = 4.8,
            reviews = listOf(
                Review("Raluca S.", 5, "My daily morning ritual. Healthy fats and keeps me full until lunch.")
            )
        ),
        Recipe(
            id = "4",
            title = "Quick Beef Stir Fry",
            prepTimeMinutes = 18,
            calories = 560,
            ingredients = listOf(
                "350g Beef Strips",
                "1 head Broccoli (cut into florets)",
                "3 tbsp Low-sodium Soy Sauce",
                "1 tbsp Fresh Ginger (grated)",
                "2 cloves Garlic (minced)",
                "1 tbsp Sesame Oil",
                "1 tsp Cornstarch"
            ),
            steps = listOf(
                "Whisk soy sauce, minced garlic, ginger, and cornstarch with 2 tbsp water in a small bowl.",
                "Heat sesame oil in a wok or large pan until smoking hot. Sear beef strips for 2-3 minutes, then remove to a plate.",
                "Add broccoli florets with a splash of water, cover skillet, and steam for 3 minutes until tender-crisp.",
                "Return beef to the pan, pour over sauce, and stir-fry for 1-2 minutes until sauce thickens and glazes everything evenly."
            ),
            isFavorite = true,
            category = "Quick Dinner",
            rating = 4.9,
            reviews = listOf(
                Review("Cristian P.", 5, "Way better than takeout and 10x faster than delivery!"),
                Review("Simona B.", 5, "The sauce glaze is perfection.")
            )
        )
    )

    val sampleRecipes = (1..500).map {
        possibleRecipes[Random.nextInt(4)]
    }

    val todaysMeals = mapOf(
        "Breakfast" to sampleRecipes[2],
        "Lunch" to sampleRecipes[1],
        "Dinner" to sampleRecipes[0]
    )
}
