# Esteco-Assignment

## Problem Statement

The goal of this assignment is to create a calculator program that can perform addition and multiplication operations on numbers provided as strings. The calculator should adhere to specific rules and handle various scenarios.

## Development Approach

The development of the AddCalculator program followed the Test-Driven Development (TDD) approach, which involves writing tests before implementing the actual logic. This iterative process helps ensure the correctness of the code and allows for incremental improvements.

## Setup and Dependencies

The project uses Gradle as the build automation tool. Gradle simplifies the project setup, compilation, and dependency management. To build and run the project, follow these steps:

1. Clone the project from the GitHub repository: https://github.com/Lilavati25/Esteco-Assignment.git
2. Open a terminal or command prompt and navigate to the project directory.
3. Run the following command to build the project and execute the tests:

```
./gradlew clean build
```

4. The build process will compile the code, run the tests, and generate a test report.

## Implementation Details

The AddCalculator program is implemented in the `AddCalculator` class. It provides the following methods:

- `add(String... numbersStrList)`: This method accepts a variable number of string arguments representing numbers. It follows the rules specified in the problem statement to perform addition operations on the numbers and return the sum as a string. The method also handles various scenarios, such as custom delimiters, newlines as separators, missing numbers, negative numbers, and multiple errors.

- `multiply(String... numbersStrList)`: This method is similar to the `add` method but performs multiplication operations instead of addition. It follows the same rules and handles the same scenarios.

## Testing

The project includes comprehensive unit tests to ensure the correctness of the `AddCalculator` methods. The tests cover various scenarios and edge cases, including valid inputs, error messages, custom delimiters, newlines as separators, missing numbers, negative numbers, and multiple errors. The tests are written using JUnit, a popular testing framework in Java.

To run the tests manually, follow the build steps mentioned earlier. After executing the build command, the test results will be displayed in the console, indicating the success or failure of each test case.

## Conclusion

The AddCalculator program provides a solution for performing addition and multiplication operations on numbers provided as strings. The program follows the Test-Driven Development (TDD) approach, ensuring the correctness of the code through comprehensive unit tests. Gradle is used as the build automation tool, simplifying project setup, compilation, and dependency management.

The code and tests can be found in the GitHub repository: https://github.com/Lilavati25/Esteco-Assignment.git

