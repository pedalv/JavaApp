#[Pluralsight's Unit Testing in Angular Course](https://github.com/joeeames/PSAngularUnitTestingCourse)

## Introduction
- Goal
1. Learn Angular Unit Testing
2. Good unit tests
3. Isolated vs. integration tests
- Demo application
- Testing & unit testing overview
- Tooling

## Automated Testing
- Unit testing
> A single “unit” of code

- End to end testing
> Live running application

> Tests exercise live application

- Integration or functional testing
> More than a unit,

> less than the complete application

- Types of Mocks
1. Dummies
2. Stubs
3. Spies
4. True mocks

## Types of Unit Tests in Angular
- Isolated unit tests
- Integration tests
1. Shallow
2. Deep

## Tools of Unit Testing with Angular
- Karma
- Jasmine === Mocha/Chai/etc
- Jest (not for angular)
- Sinon (for mocking)
- TestDouble
- Wallaby
- Cypress (for end to end test)
- End to end tools

## Writing Good Unit Tests
- Structuring Tests
> Arrange: all necessary preconditions and inputs

> Act: on the object or class under test

> Assert: that the expected results have occurred

- DRY (don’t repeat yourself)
> Remove duplication

- DAMP
> Repeat yourself if necessary

- Tell the Story
> A test should be a complete story, all within the it()

> You shouldn’t need to look around much to understand the test

> Techniques
1. Move less interesting setup into beforeEach()
2. Keep critical setup within the it()
3. Include Arrange, Act, and Assert inside the it()

## Testing DOM interaction & routing components

## Advanced topics
