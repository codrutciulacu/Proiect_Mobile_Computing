# Prototype reflection: where AI stopped

Fill this in after Part 4, once you have stress-tested your prototype. This is the bridge from Lab 3
to the rest of the course. Be honest and specific; a vague "it works fine" means you did not push
hard enough.

## What AI did well

Where did AI genuinely accelerate you? (screens, sample data, navigation, boilerplate, ...)

- Whith AI it was very fast to make the screens, without having any ideas how our style should look like, whithout any figma project first. We just corrected the color theme of the app, also with the help of AI.
- It was very fast to get our main screens going, without having to think of organizing code, app logic and such. Just the main features of our application.

## What broke when you stressed it

Go through the checks from Part 4 and record what actually happened.

- **Rotate the device:** (did state survive?)
- **Kill and reopen the app:** (was anything saved?)
- **Airplane mode:** (graceful, blank, or crash?)
- **500 items in a list:** (still smooth?)
- **Two people editing the same data:** (any sync or conflict handling?)

## What is missing for production

List what your prototype does not have yet. For each gap, name the lab that will address it.

| Gap in the prototype | Lab that fixes it |
|---|---|
| No separation of UI and logic; state resets | Lab 4 (architecture) |
| No data from a real server | Lab 5 (networking) |
| Nothing is saved on the device | Lab 6 (persistence) |
| Does not work offline; no background sync | Lab 7 (offline-first, WorkManager) |
| Dependencies wired by hand | Lab 8 (dependency injection) |
| No tests; nothing stops a broken change | Lab 9 (testing, CI) |
| No mobile-computing concept beyond a UI | Lab 10 (integrated concept) |

Add any gaps specific to your app that are not in the table above.
- We just added the main app screens, without any screen logic or backend to support it. Only visual for now.

## One sentence

In your own words: what is the difference between what AI gave you today and a production app, and why
can AI not simply close that gap for you?

> For now we only have visuals, the production app should have the whole implementation, plus we will need to adjust the user experience to fit our target users. It is a long way to go and, although AI is helping us code faster, we willneed to make decisions and see where the AI logic breaks.
