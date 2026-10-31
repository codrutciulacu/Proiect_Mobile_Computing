# Prototype reflection: where AI stopped

## What AI did well

Where did AI genuinely accelerate you? (screens, sample data, navigation, boilerplate, ...)

- Generated very easily some mock data for our app
- Easy for mocking and prototyping
- Needed to work a bit before both us and the AI can understand how things needed to look
- Very easy to generate boiler plate which otherwise would take longer to write by hand, this way we
  can concentrate more on the actual features and system design thinking for the app

## What broke when you stressed it

Go through the checks from Part 4 and record what actually happened.

- **Rotate the device:** (did state survive?)
  - When rotating the app the state is not kept as the activity is destroyed and recreated
  - Also it always sends you back to the home page, because there is no navigation logic to keep the 
current activity state in memory
  - Some activities are not fit for rotation, like recipe catalog page where the recipes are not 
entirely visible due to the search bar blocking the view, or the shopping list
which is not even usable as the scroll is not working
- **Kill and reopen the app:**
  - State is transient, nothing is saved so killing the app will delete any state in the app
- **Airplane mode:**
  - no network work so far, so airplane mode has no effect
  - this case is not handled either so I expect it to crash
  - AI didn't think about this case without specific guidance from a human
- **500 items in a list:** 
  - for the lists using `LazyColumn` it works smoothly from the get go because is optimised to load 
    only what needs to be shown
  - when it comes to normal Columns or Rows, like the vertical list in the home page, the app does 
    not perform smoothly as it needs to load all the data. Also the time to show the activity is higher
- **Two people editing the same data:** 
  - there is no concurrent usage in the app for the moment, no network communication
- Some functionalities did not work OOTB, for example: saving a favorite

## What is missing for production

List what your prototype does not have yet. For each gap, name the lab that will address it.

| Gap in the prototype | Lab that fixes it |
|---|---|
| No separation of UI and logic; state resets | Lab 4 (architecture) |
| No data from a real server | Lab 5 (networking) |
| Right now the favorites are not saved at all| Lab 5 (networking) |
| Nothing is saved on the device | Lab 6 (persistence) |
| Does not work offline; no background sync | Lab 7 (offline-first, WorkManager) |
| Dependencies wired by hand | Lab 8 (dependency injection) |
| No tests; nothing stops a broken change | Lab 9 (testing, CI) |
| No mobile-computing concept beyond a UI | Lab 10 (integrated concept) |
| No camera interaction and ML work for recommending a recipe | Lab 10 (integrated concept) |

## One sentence

In your own words: what is the difference between what AI gave you today and a production app, and why
can AI not simply close that gap for you?

> The AI agent can easily write code or understand some functionality, but without any clear direction
> it cannot understand the full perspective of a human being and is limited to common edge cases that
> are documented, not being able to think outside the box unless specifically directed to
