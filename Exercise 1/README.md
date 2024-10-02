# Java Design Patterns Demonstrations

Welcome to the **Java Design Patterns Demonstrations** repository! This project showcases six fundamental software design patterns implemented in Java. Each pattern is presented with a practical use case, complete with code examples and explanations to help you understand and apply these patterns in your own projects.

## Table of Contents

- [Introduction](#introduction)
- [Design Patterns Implemented](#design-patterns-implemented)
  - [Behavioral Design Patterns](#behavioral-design-patterns)
    - [1. Observer Pattern](#1-observer-pattern)
    - [2. Strategy Pattern](#2-strategy-pattern)
  - [Creational Design Patterns](#creational-design-patterns)
    - [3. Singleton Pattern](#3-singleton-pattern)
    - [4. Factory Method Pattern](#4-factory-method-pattern)
  - [Structural Design Patterns](#structural-design-patterns)
    - [5. Decorator Pattern](#5-decorator-pattern)
    - [6. Adapter Pattern](#6-adapter-pattern)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)

## Introduction

Design patterns are proven solutions to common software design challenges. They provide a standardized approach to solving problems, making your code more maintainable, scalable, and efficient. This repository serves as a hands-on guide to understanding and implementing some of the most essential design patterns in Java.

## Design Patterns Implemented

### Behavioral Design Patterns

Behavioral patterns are concerned with algorithms and the assignment of responsibilities between objects. They help in managing complex flows of control and communication between objects.

#### 1. Observer Pattern

**Use Case:** *Weather Monitoring System*

In a weather monitoring system, multiple display elements (observers) need to be updated whenever the weather data changes. The Observer pattern facilitates this by allowing observers to subscribe to the weather data (subject) and receive updates automatically.

**Files:**
- `ObserverPattern.java`

**Sample Output:**
```
Current conditions: 25.0°C and 65.0% humidity
Current conditions: 27.0°C and 70.0% humidity
```

#### 2. Strategy Pattern

**Use Case:** *Payment Processing System*

In a payment processing system, customers can choose different payment methods (strategies) like Credit Card or PayPal. The Strategy pattern allows selecting the appropriate payment method at runtime.

**Files:**
- `StrategyPattern.java`

**Sample Output:**
```
2000.0 paid with Credit Card.
2000.0 paid using PayPal.
```

### Creational Design Patterns

Creational patterns deal with object creation mechanisms, trying to create objects in a manner suitable to the situation. They help in making the system independent of how its objects are created, composed, and represented.

#### 3. Singleton Pattern

**Use Case:** *Logger System*

A logger system ensures that only one instance of the logger exists throughout the application, preventing inconsistent logging behavior and conserving resources.

**Files:**
- `SingletonPattern.java`

**Sample Output:**
```
Log: Application started.
Log: Application running.
logger1 and logger2 are the same instance: true
```

#### 4. Factory Method Pattern

**Use Case:** *Shape Drawing Application*

A shape drawing application can create different shapes (Circle, Rectangle, Square) without specifying the exact class of the object to be created. The Factory Method pattern handles the instantiation.

**Files:**
- `FactoryMethodPattern.java`

**Sample Output:**
```
Drawing a Circle.
Drawing a Rectangle.
Drawing a Square.
Shape type not recognized.
```

### Structural Design Patterns

Structural patterns are concerned with how classes and objects are composed to form larger structures. They help ensure that if one part of a system changes, the entire system doesn't need to do the same.

#### 5. Decorator Pattern

**Use Case:** *Coffee Shop Ordering System*

In a coffee shop ordering system, customers can customize their coffee with various add-ons (decorators) like milk, sugar, or whipped cream. The Decorator pattern allows adding responsibilities to objects dynamically.

**Files:**
- `DecoratorPattern.java`

**Sample Output:**
```
Simple Coffee $2.0
Simple Coffee, Milk $2.5
Simple Coffee, Milk, Sugar $2.7
Simple Coffee, Milk, Sugar, Whipped Cream $3.4
```

#### 6. Adapter Pattern

**Use Case:** *Media Player Compatibility*

Suppose you have an existing media player that plays MP3 files, and you want to integrate a new advanced media player that supports additional formats like MP4 and VLC without altering the existing code. The Adapter pattern allows compatibility between incompatible interfaces.

**Files:**
- `AdapterPattern.java`

**Sample Output:**
```
Playing mp3 file: song.mp3
Playing mp4 file: video.mp4
Playing vlc file: movie.vlc
Invalid media. avi format not supported.
```

## Getting Started

Follow these instructions to set up and run the project on your local machine.

### Prerequisites

- **Java Development Kit (JDK):** Ensure you have JDK 8 or higher installed. You can download it from [here](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).

### Installation

1. **Clone the Repository:**

   ```bash
   git clone https://github.com/your-username/java-design-patterns.git
   ```

2. **Navigate to the Project Directory:**

   ```bash
   cd java-design-patterns
   ```

3. **Compile the Java Files:**

   Each design pattern is contained within its own Java file. You can compile them individually or all at once.

   - **Compile Individually:**

     ```bash
     javac ObserverPattern.java
     javac StrategyPattern.java
     javac SingletonPattern.java
     javac FactoryMethodPattern.java
     javac DecoratorPattern.java
     javac AdapterPattern.java
     ```

   - **Compile All at Once:**

     ```bash
     javac *.java
     ```

4. **Run the Programs:**

   Execute the compiled Java programs to see the design patterns in action.

   - **Observer Pattern:**

     ```bash
     java ObserverPattern
     ```

   - **Strategy Pattern:**

     ```bash
     java StrategyPattern
     ```

   - **Singleton Pattern:**

     ```bash
     java SingletonPattern
     ```

   - **Factory Method Pattern:**

     ```bash
     java FactoryMethodPattern
     ```

   - **Decorator Pattern:**

     ```bash
     java DecoratorPattern
     ```

   - **Adapter Pattern:**

     ```bash
     java AdapterPattern
     ```

## Usage

Each Java file corresponds to a specific design pattern and contains a `main` method to demonstrate its functionality. You can explore and modify the code to better understand how each pattern works and how it can be applied to different scenarios.

For example, to experiment with the **Decorator Pattern**, you can add more decorators or modify existing ones to see how the behavior of the coffee objects changes dynamically.

## Contributing

Contributions are welcome! If you have suggestions for improvements, additional patterns to include, or any other enhancements, feel free to open an issue or submit a pull request.

1. **Fork the Repository**

2. **Create a New Branch**

   ```bash
   git checkout -b feature/NewPattern
   ```

3. **Make Your Changes**

4. **Commit Your Changes**

   ```bash
   git commit -m "Add new design pattern implementation"
   ```

5. **Push to the Branch**

   ```bash
   git push origin feature/NewPattern
   ```
