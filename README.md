# Tic Tac Toe — Java Console Application

## Project Description

This project consists of the development of a **Tic Tac Toe (Tres en Raya)** game implemented entirely in **Java**, designed to be played via the **terminal**.

The game supports two players (X and O) who take turns placing their moves on a 3x3 board. The system validates each move, updates the board state, checks for winning conditions or a draw, and displays the final result to the users.

The project focuses on applying core programming concepts, object-oriented design, and collaborative development practices using version control.

---

## Objectives

- Develop a functional Tic Tac Toe game in Java
- Run the application entirely in the terminal
- Apply object-oriented programming principles
- Practice team collaboration using agile methodologies
- Follow Java best practices and clean code conventions

---

## Technologies

- Java 21

---

## Tools

- Visual Studio Code
- Git / GitHub
- Trello or Jira (project management)

---

## Project Structure (Proposed)
src/
├── Main.java
├── Game.java
├── Board.java
├── Player.java
└── utils/
└── InputValidator.java


*The structure may evolve during development.*

---

## Functional Overview

- The game initializes with an empty 3x3 board.
- Players take turns, starting with player X.
- Each move is entered by specifying row and column numbers.
- The system validates that the selected position is available.
- After each move, the board is displayed.
- The game checks for a winner after every turn.
- If the board is full and no player has won, the game ends in a draw.
- A final message indicates the result of the game.

---

## Testing

Basic testing is implemented to validate:
- Valid and invalid moves
- Win conditions
- Draw scenarios

---

## How to Run the Project

1. Clone the repository:
git clone https://github.com/Charlottedoulcet/tic_tac_toe-.git

2. Navigate to the project directory::
cd tic_tac_toe

3. Compile the project:
javac src/*.java

4. Run the application:
java src/Main

Team
Product Owner: __________________
Scrum Master: __________________
Developer: __________________
Developer: Lorena Ferreira