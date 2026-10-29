# AI Assistant Instructions for Proiect Mobile Computing

## Mandatory Logging Rule (`AI-USE-LOG.md`)
Whenever you (the AI assistant) help the user with a meaningful design decision, architectural change, or generate/modify code blocks in this project, you **MUST** automatically update `docs/AI-USE-LOG.md` by appending a new row to the markdown table before concluding the task.

### Table Format
Use the existing table format in `docs/AI-USE-LOG.md`:
| Date | What you were trying to do | What you prompted (short) | What the model produced | What you accepted or rejected, and WHY |

- **Date**: Current date (YYYY-MM-DD).
- **What you were trying to do**: Brief description of the task or feature.
- **What you prompted (short)**: Summary of the user's prompt.
- **What you produced**: Summary of code, files, or design decisions created/modified.
- **What you accepted or rejected, and WHY**: Explanation of what was kept/modified and the reasoning.

Do not log trivial auto-completions, but always log significant tasks, code implementations, or refactoring steps.
