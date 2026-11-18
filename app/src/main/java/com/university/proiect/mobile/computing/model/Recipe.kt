package com.university.proiect.mobile.computing.model

data class Review(
    val author: String,
    val rating: Int,
    val comment: String
) {
    init {
        require(author.isNotBlank()) { "Review author cannot be blank" }
        require(rating in 1..5) { "Review rating must be between 1 and 5" }
        require(comment.isNotBlank()) { "Review comment cannot be blank" }
    }
}

data class Recipe(
    val id: String,
    val title: String,
    val prepTimeMinutes: Int,
    val calories: Int,
    val ingredients: List<String>,
    val steps: List<String>,
    val isFavorite: Boolean = false,
    val category: String = "Quick Dinner",
    val rating: Double = 0.0,
    val reviews: List<Review> = emptyList()
) {
    init {
        require(id.isNotBlank()) { "Recipe ID cannot be blank" }
        require(title.isNotBlank()) { "Recipe title cannot be blank" }
        require(prepTimeMinutes > 0) { "Prep time must be greater than 0 minutes" }
        require(calories >= 0) { "Calories cannot be negative" }
        require(ingredients.isNotEmpty()) { "Recipe must have at least one ingredient" }
        require(steps.isNotEmpty()) { "Recipe must have at least one step" }
        require(rating in 0.0..5.0) { "Recipe rating must be between 0.0 and 5.0" }
    }
}
