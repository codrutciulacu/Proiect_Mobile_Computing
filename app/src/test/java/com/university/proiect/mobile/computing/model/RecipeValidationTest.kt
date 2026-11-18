package com.university.proiect.mobile.computing.model

import org.junit.Test
import org.junit.Assert.*

class RecipeValidationTest {

    private val validIngredients = listOf("Spaghetti", "Garlic", "Butter")
    private val validStep = "Boil water and cook pasta."
    private val validReview = Review("Andrei M.", 5, "Delicious!")

    @Test
    fun validRecipe_isSuccessfullyCreated() {
        val recipe = Recipe(
            id = "1",
            title = "Pasta",
            prepTimeMinutes = 15,
            calories = 400,
            ingredients = validIngredients,
            steps = listOf(validStep),
            rating = 4.5,
            reviews = listOf(validReview)
        )
        assertEquals("1", recipe.id)
        assertEquals("Pasta", recipe.title)
        assertEquals(15, recipe.prepTimeMinutes)
    }

    @Test(expected = IllegalArgumentException::class)
    fun blankId_throwsException() {
        Recipe(
            id = "",
            title = "Pasta",
            prepTimeMinutes = 15,
            calories = 400,
            ingredients = validIngredients,
            steps = listOf(validStep)
        )
    }

    @Test(expected = IllegalArgumentException::class)
    fun blankTitle_throwsException() {
        Recipe(
            id = "1",
            title = "   ",
            prepTimeMinutes = 15,
            calories = 400,
            ingredients = validIngredients,
            steps = listOf(validStep)
        )
    }

    @Test(expected = IllegalArgumentException::class)
    fun zeroOrNegativePrepTime_throwsException() {
        Recipe(
            id = "1",
            title = "Pasta",
            prepTimeMinutes = 0,
            calories = 400,
            ingredients = validIngredients,
            steps = listOf(validStep)
        )
    }

    @Test(expected = IllegalArgumentException::class)
    fun negativeCalories_throwsException() {
        Recipe(
            id = "1",
            title = "Pasta",
            prepTimeMinutes = 15,
            calories = -10,
            ingredients = validIngredients,
            steps = listOf(validStep)
        )
    }

    @Test(expected = IllegalArgumentException::class)
    fun emptyIngredients_throwsException() {
        Recipe(
            id = "1",
            title = "Pasta",
            prepTimeMinutes = 15,
            calories = 400,
            ingredients = emptyList(),
            steps = listOf(validStep)
        )
    }

    @Test(expected = IllegalArgumentException::class)
    fun emptySteps_throwsException() {
        Recipe(
            id = "1",
            title = "Pasta",
            prepTimeMinutes = 15,
            calories = 400,
            ingredients = validIngredients,
            steps = emptyList()
        )
    }

    @Test(expected = IllegalArgumentException::class)
    fun invalidRating_throwsException() {
        Recipe(
            id = "1",
            title = "Pasta",
            prepTimeMinutes = 15,
            calories = 400,
            ingredients = validIngredients,
            steps = listOf(validStep),
            rating = 5.5
        )
    }

    @Test(expected = IllegalArgumentException::class)
    fun invalidReviewRating_throwsException() {
        Review("Ion", 6, "Too good!")
    }
}
