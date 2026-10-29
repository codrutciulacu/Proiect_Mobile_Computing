# App idea

Fill this in before you start prototyping. Keep it short and concrete. You will defend these answers
in the project spot-check, especially the mobile-computing framing at the bottom.

## The basics

- **App name: Spoonful**
- **One-line pitch: Savorly helps you plan meals, save recipes, and build a shopping list that you 
can use whenever you'd like, even when you don't have internet.** 
- **The problem: I want to be able to eat well without too much planning and executing effort**
- **Target users: "corporatistii", when they get off work tired and do not want to plan a 
complicated meal for those close to them**

## The prototype scope

Keep this tiny: one or two screens for Lab 3.

- **Core screen(s):**
  - **Home/Dashboard**: Today’s meals, upcoming plans, and quick links.
  - **Recipes**: Browse saved recipes and the online catalog; search and filter.
  - **Meal Planner**: Plan the week and assign recipes to meal slots.
  - **Favorites**: Keep go-to recipes easy to find.
  - **Shopping List**: Generate a list from planned meals and check items off.
  - **Photo to meal screen** -> TBD when starting working on the integrated concept, but either 
    make a photo and tell us the ingredients or scan products and propose a meal
- The main "thing" the app manages:  **recipes** 
- A few fields of that thing: **name, ingredients, prep time, photo, steps, reviews** 

## The data

- **What records does the app create or collect?** - recipes, ingredients, photos, users
- **Where does data come from?** - user input, an api/backend
- **Where does data need to go?** - some might stay local(ingredients, personal info), while
  some might be stored in the backend(recipes)

## Mobile-computing framing (required)

This is what makes it a mobile-computing project rather than just an app. Answer honestly; rough
answers are fine for now.

- **What must persist on the device** - 
  - local caches when internet not available
  - meal plan because is short time and only one user uses it
  - favorite recipes
  - photos/ingredients used for recognition
- **What crosses the network** - 
  - recipes
  - users?
  - reviews
  - favorite recipes
- **What must still work with no signal**
  - meal plan
  - favorite recipes
  - shopping list
  - photo to recipe, or a backup that recommends a recipe if no picture provided
- **The placement question:** is there any computation that could run on-device instead of in the
  cloud (for example a model, a search, image processing)?
  - the integrated feature should stay locally due to both computation(not so intensive), but
  also due to privacy and governance concerns
  - backup for picture to recipe, if picture to recipe is to intensive for the device

