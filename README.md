# ea-project

## Branch Policy

### Main Branch
- The `main` branch is the primary branch and should always be in a deployable state.
- Direct commits to the `main` branch are prohibited. All changes must be made through pull requests (PRs).

### Development Branch
- The `development` branch is where active development happens.
- Feature branches should be created off of `development` and merged back into `development` after review.

### Feature Branches
- Feature branches should be named descriptively, e.g., `feature/login-functionality`.
- Regularly pull changes from `development` to keep your feature branch up-to-date.

### Pull Requests
- Ensure your branch is up-to-date with the `development` branch before creating a PR.
- All PRs must be reviewed and approved by at least one other team member.
- Include a meaningful description of the changes in the PR.
- Ensure all checks and tests pass before requesting a review.

### Code Reviews
- Be respectful and provide constructive feedback.
- Reviewers should check for code quality, functionality, and adherence to coding standards.
- Authors should address all feedback before merging the PR.

### Merging
- Only approved PRs can be merged into `development`.
- Use squash merging to keep the commit history clean.

### Hotfixes
- Hotfix branches should be created from `main` and merged back into both `main` and `development` after approval.
- Hotfix branches should be named using the prefix `hotfix/`.

### Documentation
- Update documentation as part of your PR if your changes affect how the application is used or developed.