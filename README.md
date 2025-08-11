# CS-410 

## Overview

This repository contains a modular Java application designed for managing a film catalog, simulating user interactions, and introducing game-like mechanics with cards and decks. The project demonstrates core concepts in object-oriented programming, software design, and test-driven development.

## Features

- **Film Catalog**: Add, search, and manage a collection of films with rich metadata.
- **User System**: Register and simulate users, track preferences, and ratings.
- **Card & Deck Mechanics**: Gamify interactions with a card-based system and deck management.
- **Game State Management**: Simulate sessions and track progress using a central game state.
- **Robust Testing**: Comprehensive JUnit test coverage for all core modules.
- **Utilities**: Custom data structures and helper classes (duration, rating, queue, geometry).

## Core Components

- **Catalog.java**: Central storage and management for `Film` objects.
- **Film.java**: Data structure for film information (title, genre, rating, etc.)
- **User.java / Player.java**: User modeling and gameplay features.
- **Card.java / Deck.java**: Card objects and deck logic for game mechanics.
- **GameState.java**: Orchestrates the logic and tracks the state of the application.
- **Duration.java, Rating.java, Rectangle.java, TwoLaneQueue.java**: Supporting data structures.
- **Test Files**: JUnit tests for each major class ensure correctness and reliability.

## Getting Started

### Prerequisites

- Java 8 or higher
- [JUnit 4](https://junit.org/junit4/) (for running tests)
- Git (for cloning the repository)

### Cloning the Repository

```bash
git clone https://github.com/Abdiabera/cs-410.git
cd cs-410
```

### Compiling the Code

```bash
javac *.java
```

### Running Tests

Make sure JUnit is in your classpath, then:

```bash
java org.junit.runner.JUnitCore <TestClassName>
```
Replace `<TestClassName>` with classes like `CatalogTest`, `FilmTest`, etc.

## Usage

- **Adding Films**: Instantiate `Film` and add to `Catalog`.
- **Simulating Users**: Create `User` or `Player` objects, interact with catalog and cards.
- **Running the Game**: Use `GameState` to coordinate interactions between entities.
- **Testing**: Run the associated JUnit test classes to verify logic.

## Contributing

Contributions are welcome! Please fork the repository and create a pull request with your changes. For major changes, open an issue first to discuss improvements.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgements

- Java Standard Library
- JUnit Testing Framework

---

*For detailed class/function documentation, see inline Javadoc comments in the source files.*
