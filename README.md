# Tic Tac Toe Game

## Description

This is a classic Tic Tac Toe game built using Java and the Swing framework for the graphical user interface. It allows two players to play the game on a 3x3 grid. The first player to get three of their marks in a row (either horizontally, vertically, or diagonally) wins the game.

## Features

- Graphical user interface using Java Swing
- Interactive 3x3 grid for gameplay
- Alternates turns between Player X and Player O
- Displays the current game status
- Detects and announces the winner
- Handles game draw situations

## Prerequisites

- Java Development Kit (JDK) installed on your system
- An IDE or text editor for Java development (e.g., IntelliJ IDEA, Eclipse, NetBeans, VS Code)

## Code Overview

### Main Components

- **JFrame frame:** The main window of the game.
- **JLabel textLabel:** Displays the game status and messages.
- **JPanel textPanel:** Holds the text label.
- **JPanel boardPanel:** Holds the 3x3 grid of buttons representing the game board.
- **JButton[][] board:** A 2D array of buttons representing the game board.
- **String playerX:** Represents player X.
- **String playerO:** Represents player O.
- **String currentPlayer:** Tracks the current player.
- **boolean gameOver:** Indicates if the game is over.
- **int turns:** Tracks the number of turns taken.

### Game Initialization

The game initializes the main frame, sets up the text label, and creates the 3x3 grid of buttons. Each button is set up with an action listener to handle player moves.

### Game Logic

- **Action Listener:** Each button on the grid has an action listener that handles the player's move.
- **Turn Alternation:** The game alternates turns between Player X and Player O.
- **Win Detection:** The game checks for winning conditions after each move.
- **Draw Detection:** The game checks for a draw if all tiles are filled without a winner.

## Screenshot

![Tic Tac Toe Win Screenshot](tictactoewin.png)
![Tic Tac Toe Tie Screenshot](tictactoetie.png)

## Contributing

If you want to contribute to this project, feel free to fork the repository and submit a pull request.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgments

- The Java Swing framework for providing the graphical components.
- Tutorials and online resources that helped in understanding the implementation of the game logic.

--
