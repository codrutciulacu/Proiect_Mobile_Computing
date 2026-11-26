package com.university.proiect.mobile.computing.ui.screens.recipelist

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.university.proiect.mobile.computing.data.RecipeRepository
import com.university.proiect.mobile.computing.model.Recipe
import com.university.proiect.mobile.computing.ui.stateInUi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class RecipeListViewModel @Inject constructor(
    repository: RecipeRepository
) : ViewModel() {

    var searchQuery by  mutableStateOf("")
    var selectedCategory by mutableStateOf("All")


    val filteredRecipes = RecipeRepository.sampleRecipes.filter { recipe ->
        val matchesSearch = recipe.title.contains(searchQuery, ignoreCase = true) ||
                recipe.ingredients.any { it.contains(searchQuery, ignoreCase = true) }
        val matchesCategory = selectedCategory == "All" || recipe.category.equals(selectedCategory, ignoreCase = true)
        matchesSearch && matchesCategory
    }
}