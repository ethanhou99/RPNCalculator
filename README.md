# RPN Calculator
This is a commandline-based Reverse Polish Notation(RPN) calculator.

## Environment
- Java JDK 1.8+
- Maven Build tool
- Junit 4.12

## Compiling

## Unit Test
```mvn test```

## Design Pattern
- Factory method

## Directory Tree
```
├── src/main/java.                            #Source folder
|              ├── Operation                  #Collection of operations
|              │   ├── Addition.java
|              │   ├── Clear.java
|              │   ├── Divition.java
|              │   ├── Inverse.java
|              │   ├── Multiplication.java
|              │   ├── Operators.java
|              │   ├── SquareRoot.java
|              │   ├── Subtraction.java
|              │   └── Undo.java
|              ├── rpn
|              │   ├── RpnCalculator.java     #Rpn Calculator class
|              │   └── RpnMain.java           #Main class of the project
|              └── util
|                  ├── ErrorHandler.java      #Print out the errors
|                  ├── StackPrint.java        #Print out the stack contents
|                  └── InputCheck.java        #Check the input grammar
├── test/java                                 #Test folder
└── README.md                                 #README file
```

## Algorithm
- __Arithmetic:__ Using a number stack to save numbers from the input, while meeting the operator, poll out the first two numbers from the number stack and calculate the result, the offer the result back to the number stack.
- __Undo:__ Using an Object stack to save the numbers and symbols from the input string.
  - If the Object stack peek is a symbol, poll out the symbol, the top two elements in the object stuck should be pushed back to number stack.
  - If the Object stack peek is a number, we need to do the inverse calculation of the number stack peek and object stack peek. The operation of inverse calculation is depends on the second top object in the object stuck(rules: - => +, + => -, * => /, / => *).
- __Clear:__ Clear the number stack and Object stack.

## Supported Operations

| Operation  | Operator | Example | Result
| ------------- | ------------- | ------------- | ------------- |
| Addition  | `+`  | `2 3 +` |  5 |
| Subtraction  | `-` | `3 2 -` | 1 |
|Multiplication| `*` | `2 3 *` | 6 |
|Division| `/` | `6 2 /` | 3 |
|Square Root| sqrt | `4 sqrt` | 2|
|Undo | undo |`1 2 *` | `1 2` |
|Clear| clear | `1 2 *` | empty stack |
