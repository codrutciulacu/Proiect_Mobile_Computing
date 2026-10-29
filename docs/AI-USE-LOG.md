# AI-use log

You are encouraged to use AI throughout this project. In return you keep this log. It is part of
every milestone, not just Lab 3, so keep adding to it all semester. It is quick if you do it as you
work and painful if you reconstruct it later.

The point is not to prove you used AI, or that you did not. The point is to show that you **own** what
you submitted: that you understood what the model produced, judged it, and decided what to keep. In
the defense you must be able to explain and modify any of it.

## How to log

One row per meaningful AI interaction. You do not need to log trivial autocompletions; do log
anything where the model produced a chunk of code or a design decision you accepted or rejected.

| Date | What you were trying to do | What you prompted (short) | What the model produced | What you accepted or rejected, and WHY |
|---|---|---|---|---|
| 2025-05-18 | Set up automated AI use logging rule | How can I set a rule for you to update AI-USE-LOG.md | Created .github/copilot-instructions.md establishing the mandatory logging rule | Accepted; ensures all future AI interactions are automatically tracked and logged per course requirements. |
| 2025-05-18 | Build mock Dashboard/HomeScreen for Spoonful | Start prototyping the app, mock dashboard/homescreen | Created RecipeItem model, RecipeRepository data, HomeScreenView composable with Material 3, bottom nav, accentuated today's meals, and photo-to-meal banner, wired into MainActivity. | Accepted; establishes the core UI architecture and home screen prototype matching the app concept. |
| 2025-05-18 | Apply peachy color palette | Now apply the peachy color back | Updated Color.kt and Theme.kt with the warm peachy primary (`#E27D60`), peach amber, soft teal, and clean light gray/white neutral backgrounds and surfaces (`#F8F9FA` / `#FFFFFF`). | Accepted; provides a modern, clean, bright white/gray or look with a warm inviting peachy accent. |
| 2025-05-18 | Refine card container colors | make the backgorund of photo miau miau and the items in go to favorites not purple please | Updated HomeScreenView.kt to use primary peachy container colors and primary tints for the Photo-to-Meal Scanner card and Go-To Favorites recipe placeholder boxes, removing purple accents. | Accepted; creates a consistent peachy theme across all dashboard components. |
| 2025-05-18 | Build Recipe Page and Navigation Container | Let's make recipe page | Created RecipeScreenView.kt with search and category filtering chips, SpoonfulApp.kt as root navigation container with bottom navigation, and wired into MainActivity. | Accepted; implements the recipe catalog screen and seamless multi-tab navigation. |
| 2025-05-18 | Fix duplicate headers and footers | why do i have 2 headers and 2 footers? | Removed the redundant inner Scaffold, TopAppBar, and NavigationBar from HomeScreenView.kt, letting SpoonfulApp act as the single root app container. | Accepted; eliminates duplicate headers/footers and ensures a single clean layout. |






## Prompts worth remembering

Optionally, keep a few prompts that worked especially well or especially badly, with a note on why.
This is useful for you, and for your team if you are working in one.

-
-
