package com.university.proiect.mobile.computing.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.university.proiect.mobile.computing.data.RecipeRepository
import com.university.proiect.mobile.computing.ui.theme.ProiectMobileComputingTheme

data class ShoppingItem(
    val id: String,
    val name: String,
    val category: String,
    val isChecked: Boolean = false
)

@Composable
fun ShoppingListScreenView(
    modifier: Modifier = Modifier
) {
    var newItemName by remember { mutableStateOf("") }
    var shoppingItems by remember {
        mutableStateOf(
            listOf(
                ShoppingItem("1", "Spaghetti (1 pack)", "Pantry"),
                ShoppingItem("2", "Garlic (1 bulb)", "Produce"),
                ShoppingItem("3", "Butter (200g)", "Dairy"),
                ShoppingItem("4", "Lemon (2 pcs)", "Produce"),
                ShoppingItem("5", "Parmesan Cheese", "Dairy")
            )
        )
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Offline shopping banner per app-idea.md
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
                    Icons.Default.ShoppingCart,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(24.dp)
                )
                Column {
                    Text(
                        text = "Grocery Shopping List",
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                    Text(
                        text = "Works offline at the store even with zero cellular signal.",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }
            }
        }

        // Generate from Meal Plan Action Button
        Button(
            onClick = {
                val plannedIngredients = RecipeRepository.todaysMeals.values
                    .flatMap { it.ingredients }
                    .distinct()

                val newItems = plannedIngredients.mapIndexed { index, ingredient ->
                    ShoppingItem(
                        id = "gen_${System.currentTimeMillis()}_$index",
                        name = ingredient,
                        category = "Planned Meal"
                    )
                }
                // Merge without duplicates
                val existingNames = shoppingItems.map { it.name }.toSet()
                val itemsToAdd = newItems.filter { it.name !in existingNames }
                shoppingItems = shoppingItems + itemsToAdd
            },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.secondary
            )
        ) {
            Icon(Icons.Default.AutoFixHigh, contentDescription = null, modifier = Modifier.size(18.dp))
            Spacer(modifier = Modifier.width(8.dp))
            Text("Generate from Planned Meals")
        }

        // Add Item Input
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedTextField(
                value = newItemName,
                onValueChange = { newItemName = it },
                modifier = Modifier.weight(1f),
                placeholder = { Text("Add custom item...") },
                shape = RoundedCornerShape(24.dp),
                singleLine = true
            )
            Button(
                onClick = {
                    if (newItemName.isNotBlank()) {
                        shoppingItems = shoppingItems + ShoppingItem(System.currentTimeMillis().toString(), newItemName, "Custom")
                        newItemName = ""
                    }
                },
                shape = RoundedCornerShape(20.dp)
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add")
                Spacer(modifier = Modifier.width(4.dp))
                Text("Add")
            }
        }

        Text(
            text = "Shopping Items (${shoppingItems.count { it.isChecked }}/${shoppingItems.size} checked)",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold
        )

        // Items List
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(shoppingItems, key = { it.id }) { item ->
                ShoppingRowItem(
                    item = item,
                    onCheckedChange = { checked ->
                        shoppingItems = shoppingItems.map {
                            if (it.id == item.id) it.copy(isChecked = checked) else it
                        }
                    },
                    onDelete = {
                        shoppingItems = shoppingItems.filter { it.id != item.id }
                    }
                )
            }
        }
    }
}

@Composable
fun ShoppingRowItem(
    item: ShoppingItem,
    onCheckedChange: (Boolean) -> Unit,
    onDelete: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.weight(1f)
            ) {
                Checkbox(
                    checked = item.isChecked,
                    onCheckedChange = onCheckedChange
                )
                Column {
                    Text(
                        text = item.name,
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.Medium,
                        textDecoration = if (item.isChecked) TextDecoration.LineThrough else TextDecoration.None,
                        color = if (item.isChecked) MaterialTheme.colorScheme.outline else MaterialTheme.colorScheme.onSurface
                    )
                    Text(
                        text = item.category,
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.outline
                    )
                }
            }
            IconButton(onClick = onDelete) {
                Icon(Icons.Default.DeleteOutline, contentDescription = "Delete", tint = MaterialTheme.colorScheme.outline)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShoppingListPreview() {
    ProiectMobileComputingTheme {
        ShoppingListScreenView()
    }
}
