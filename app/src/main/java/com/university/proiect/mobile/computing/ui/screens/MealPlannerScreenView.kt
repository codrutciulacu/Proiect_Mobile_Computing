package com.university.proiect.mobile.computing.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.university.proiect.mobile.computing.data.RecipeRepository
import com.university.proiect.mobile.computing.model.RecipeItem
import com.university.proiect.mobile.computing.ui.theme.ProiectMobileComputingTheme

@Composable
fun MealPlannerScreenView(
    modifier: Modifier = Modifier,
    onRecipeClick: (RecipeItem) -> Unit = {}
) {
    val daysOfWeek = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    var selectedDay by remember { mutableStateOf("Monday") }

    // Mock state mapping day -> meal slot -> recipe
    var weeklyPlan by remember {
        mutableStateOf(
            mapOf(
                "Monday" to mapOf(
                    "Breakfast" to RecipeRepository.sampleRecipes[2],
                    "Lunch" to RecipeRepository.sampleRecipes[1],
                    "Dinner" to RecipeRepository.sampleRecipes[0]
                ),
                "Tuesday" to mapOf(
                    "Breakfast" to RecipeRepository.sampleRecipes[2],
                    "Lunch" to RecipeRepository.sampleRecipes[3],
                    "Dinner" to RecipeRepository.sampleRecipes[1]
                ),
                "Wednesday" to mapOf(
                    "Breakfast" to RecipeRepository.sampleRecipes[2],
                    "Lunch" to RecipeRepository.sampleRecipes[0],
                    "Dinner" to RecipeRepository.sampleRecipes[3]
                )
            )
        )
    }

    val currentDayMeals = weeklyPlan[selectedDay] ?: emptyMap()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Banner highlighting offline-first capability per app-idea.md
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer
            ),
            shape = RoundedCornerShape(12.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Icon(
                    Icons.Default.OfflineBolt,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(24.dp)
                )
                Column {
                    Text(
                        text = "Local Weekly Planner",
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                    Text(
                        text = "Plans are stored locally and work seamlessly offline.",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }
            }
        }

        // Days of week selector
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            daysOfWeek.forEach { day ->
                FilterChip(
                    selected = selectedDay == day,
                    onClick = { selectedDay = day },
                    label = { Text(day) },
                    leadingIcon = if (selectedDay == day) {
                        { Icon(Icons.Default.Event, contentDescription = null, modifier = Modifier.size(16.dp)) }
                    } else null
                )
            }
        }

        Text(
            text = "$selectedDay's Meals",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )

        // Meal slots for selected day
        val slots = listOf("Breakfast", "Lunch", "Dinner")
        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            slots.forEach { slot ->
                val assignedRecipe = currentDayMeals[slot]
                MealSlotCard(
                    slotName = slot,
                    recipe = assignedRecipe,
                    onAssignClick = {
                        val updatedDayMeals = currentDayMeals.toMutableMap()
                        updatedDayMeals[slot] = RecipeRepository.sampleRecipes.random()
                        weeklyPlan = weeklyPlan + (selectedDay to updatedDayMeals)
                    },
                    onRemoveClick = {
                        val updatedDayMeals = currentDayMeals.toMutableMap()
                        updatedDayMeals.remove(slot)
                        weeklyPlan = weeklyPlan + (selectedDay to updatedDayMeals)
                    },
                    onRecipeClick = onRecipeClick
                )
            }
        }
    }
}

@Composable
fun MealSlotCard(
    slotName: String,
    recipe: RecipeItem?,
    onAssignClick: () -> Unit,
    onRemoveClick: () -> Unit,
    onRecipeClick: (RecipeItem) -> Unit = {}
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = slotName.uppercase(),
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.ExtraBold
                )
                if (recipe != null) {
                    TextButton(onClick = onRemoveClick) {
                        Text("Remove", color = MaterialTheme.colorScheme.error)
                    }
                }
            }

            if (recipe != null) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(8.dp))
                        .clickable { onRecipeClick(recipe) }
                        .padding(vertical = 4.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                        modifier = Modifier.weight(1f)
                    ) {
                        Box(
                            modifier = Modifier
                                .size(48.dp)
                                .clip(RoundedCornerShape(8.dp))
                                .background(MaterialTheme.colorScheme.primaryContainer),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                Icons.Default.Restaurant,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.primary
                            )
                        }
                        Column {
                            Text(
                                text = recipe.title,
                                style = MaterialTheme.typography.bodyLarge,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "${recipe.prepTimeMinutes}m • ${recipe.calories} kcal",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.outline
                            )
                        }
                    }
                }
            } else {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(MaterialTheme.colorScheme.surfaceVariant),
                    contentAlignment = Alignment.Center
                ) {
                    TextButton(onClick = onAssignClick) {
                        Icon(Icons.Default.Add, contentDescription = null, modifier = Modifier.size(16.dp))
                        Spacer(modifier = Modifier.width(4.dp))
                        Text("Assign Recipe")
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MealPlannerPreview() {
    ProiectMobileComputingTheme {
        MealPlannerScreenView()
    }
}
