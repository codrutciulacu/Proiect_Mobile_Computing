# Prototype reflection: where AI stopped

<!-- Fill this in after Part 4, once you have stress-tested your prototype. This is the bridge from Lab 3
to the rest of the course. Be honest and specific; a vague "it works fine" means you did not push
hard enough. -->

## Main user flow and design choices

The main flow in the prototype is:
- browse recipes (search + category filters) -> open a recipe's details (ingredients, steps, reviews, 
favorite)
- in the Meal Planner, pick a day and see its meals -> "assign" fills a slot with a random recipe
- in the Shopping List, check off items or add new ones (the list is fixed, not built from the plan)

We built 6 screens: 5 tabs in one bottom navigation bar (Home, Recipes, Meal Planner, Favorites,
Shopping List) plus a Recipe Detail screen, to ease up our work in the future.

The **trade-off** is that most screens only display data and have no real logic yet. Recipe data
comes from a single in-memory repository with hardcoded data and each screen keeps its own UI state.

## What AI did well

<!-- Where did AI genuinely accelerate you? (screens, sample data, navigation, boilerplate, ...) -->

- generated complete Compose + Material 3 screens and sample data fast
- wired the bottom navigation and opening a recipe's details from Home, Recipes, Meal Planner and
  Favorites
- made fast styling changes

Beside everything good, it also gave us a little headache:
- it introduced a bug (duplicate headers and footers from nested `Scaffold`s) that we had 
to spot and ask it to fix

## What broke when you stressed it

<!-- Go through the checks from Part 4 and record what actually happened. -->

- **Rotate the device:** 
  - all UI state resets, because it is kept only with `remember` (no `rememberSaveable`, no ViewModel)
- **Kill and reopen the app:** 
  - nothing is saved (added shopping items, reviews and plan changes)
- **Airplane mode:** 
  - the app keeps working, only because it has no network at all
  - the "offline" banners (Meal Planner, Shopping List, Favorites, Recipe Detail) promise local
    storage that does not exist yet
- **500 items in a list:** 
  - Recipes, Favorites and Shopping List use `LazyColumn` and stay smooth
  - Home and Recipe Detail use a scrolling `Column`, so long lists there would not scale
- **Two people editing the same data:**
  - each device has its own copy
  - there is no server, sync or conflict handling

## What is missing for production

<!-- List what your prototype does not have yet. For each gap, name the lab that will address it. -->

| Gap in the prototype                                                                       | Lab that fixes it |
|--------------------------------------------------------------------------------------------|---|
| no separation of UI and logic <br/>state resets                                            | Lab 4 (architecture) |
| no data from a real server                                                                 | Lab 5 (networking) |
| nothing is saved on the device                                                             | Lab 6 (persistence) |
| does not work offline <br/>no background sync                                              | Lab 7 (offline-first, WorkManager) |
| dependencies wired by hand                                                                 | Lab 8 (dependency injection) |
| no tests <br/>nothing stops a broken change                                                | Lab 9 (testing, CI) |
| no mobile-computing concept beyond a UI                                                    | Lab 10 (integrated concept) |
| shopping list is not generated from the meal plan and does not combine quantities or units | Lab 6 (M2) |
| meal plan has no rules for an occupied slot or a deleted recipe                            | Lab 6 (M2) |
| meal plan is mock data ("assign" picks a random recipe)                                    | Lab 4 / Lab 6 (M2) |
| recipe model was designed for display only, not for storage or sync                        | Lab 4 / Lab 6 (M2) |
| "Photo to meal" is only a banner                                                           | Lab 10 (M3) |

## One sentence

<!-- In your own words: what is the difference between what AI gave you today and a production app,
and why can AI not simply close that gap for you? -->

> AI gave us the look of the app, but not the decisions behind it (what is stored, where and what 
> happens offline or on conflict). Those decisions depend on our app’s constraints, so we have to 
> make them ourselves and then build the app with AI as a helper, not by letting it take full control.
