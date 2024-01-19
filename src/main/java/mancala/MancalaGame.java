package mancala;

import java.util.ArrayList;

/**
 * The MancalaGame class represents the core logic for the Mancala game.
 * It manages players, the game board, and game state.
 */
public class MancalaGame {
    private Player firstPlayer; // Renamed from playerOne for clarity
    private Player secondPlayer; // Renamed from playerTwo for clarity
    private Player currentPlayer;
    private Board gameBoard;

    /**
     * Constructs a MancalaGame object and initializes the game board and players.
     */
    public MancalaGame() {
        gameBoard = new Board();
        currentPlayer = firstPlayer;
        firstPlayer = new Player("Player One");
        secondPlayer = new Player("Player Two");
        gameBoard.registerPlayers(firstPlayer, secondPlayer);
        startNewGame();
    }

    /**
     * Gets the current game board.
     *
     * @return The game board.
     */
    public Board getBoard() {
        return gameBoard;
    }

    /**
     * Gets the current player.
     *
     * @return The current player.
     */
    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    /**
     * Gets the number of stones in a specified pit.
     *
     * @param pitNum The pit number.
     * @return The number of stones in the pit.
     * @throws PitNotFoundException If the pit number is invalid.
     */
    public int getNumStones(int pitNum) throws PitNotFoundException {
        if (pitNum >= 0 && pitNum < 12) {
            return gameBoard.getNumStones(pitNum);
        } else {
            throw new PitNotFoundException(); // Throw PitNotFoundException for an invalid pitNum
        }
    }

    /**
     * Gets the list of players.
     *
     * @return The list of players.
     */
    public ArrayList<Player> getPlayers() {
        ArrayList<Player> players = new ArrayList<>();
        players.add(firstPlayer);
        players.add(secondPlayer);
        return players;
    }

    /**
     * Gets the total stone count in a player's store.
     *
     * @param player The player.
     * @return The total stone count in the player's store.
     */
    public int getStoreCount(Player player) throws NoSuchPlayerException {
        if (currentPlayer != firstPlayer && currentPlayer != secondPlayer){
            throw new NoSuchPlayerException();
        }
        return player.getStore().getTotalStones();
    }

    /**
     * Gets the winner of the game.
     *
     * @return The winner player or null if it's a tie.
     * @throws GameNotOverException If the game is not over.
     */
    public Player getWinner() throws GameNotOverException {
        if (!isGameOver()) {
            throw new GameNotOverException();
        }

        // Determine the winner as previously defined
        if (firstPlayer.getStore().getTotalStones() > secondPlayer.getStore().getTotalStones()) {
            return firstPlayer;
        } else if (firstPlayer.getStore().getTotalStones() < secondPlayer.getStore().getTotalStones()) {
            return secondPlayer;
        }

        return null;
    }

    /**
     * Checks if the game is over.
     *
     * @return True if the game is over, false otherwise.
     */
    public boolean isGameOver() {
        boolean firstPlayerPitsEmpty = true;
        boolean secondPlayerPitsEmpty = true;

        // Check pits for player one (indices 0 to 5)
        for (int i = 0; i < 6; i++) {
            if (gameBoard.getNumStones(i) != 0) {
                firstPlayerPitsEmpty = false;
                break; // No need to check further once we find a pit with stones
            }
        }

        // Check pits for player two (indices 6 to 11)
        for (int i = 6; i < 12; i++) {
            if (gameBoard.getNumStones(i) != 0) {
                secondPlayerPitsEmpty = false;
                break; // No need to check further once we find a pit with stones
            }
        }

        // If all pits for either player are empty, the game is over
        if (firstPlayerPitsEmpty || secondPlayerPitsEmpty) {
            gameBoard.summationStore();
            return true;
        }

        return false;
    }

    /**
     * Performs a move in the game.
     *
     * @param startPit The pit number to start the move from.
     * @return The sum of stones in the pits after the move.
     * @throws InvalidMoveException If the move is invalid.
     */
    public int move(int startPit) throws InvalidMoveException {
        int stones = 0;
        int pitSum = 0;

        if (currentPlayer != firstPlayer && currentPlayer != secondPlayer) {
            throw new IllegalStateException("Invalid player");
        } else if (startPit < 0 || startPit > 11) {
            throw new InvalidMoveException();
        } else {
            stones = gameBoard.moveStones(startPit, currentPlayer);
            if (stones > 0) {
                switchPlayer();
            }
        }

        if (currentPlayer == firstPlayer && startPit > 0 && startPit < 6) {
            for (int i = 0; i < 6; i++) {
                pitSum += gameBoard.getNumStones(i);
            }
        } else if (currentPlayer == secondPlayer && startPit > 6 && startPit < 12) {
            for (int i = 6; i < 12; i++) {
                pitSum += gameBoard.getNumStones(i);
            }
        }

        return pitSum;
    }

    /**
     * Sets the game board.
     *
     * @param theBoard The game board to set.
     */
    public void setBoard(Board theBoard) {
        gameBoard = theBoard;
    }

    /**
     * Sets the current player.
     *
     * @param player The player to set as the current player.
     */
    public void setCurrentPlayer(Player player) {
        currentPlayer = player;
    }

    /**
     * Sets the players for the game.
     *
     * @param onePlayer The first player.
     * @param twoPlayer The second player.
     */
    public void setPlayers(Player onePlayer, Player twoPlayer) {
        firstPlayer = onePlayer;
        secondPlayer = twoPlayer;
        gameBoard.registerPlayers(firstPlayer, secondPlayer);
        currentPlayer = firstPlayer;
    }

    /**
     * Starts a new game by resetting the board and setting the first player as the current player.
     */
    public void startNewGame() {
        gameBoard.resetBoard();
        currentPlayer = firstPlayer;
    }

    /**
     * Gets a string representation of the MancalaGame object.
     *
     * @return A string representation of the object.
     */
    public String toString() {
        return "MancalaGame: " + firstPlayer.getName() + " vs. " + secondPlayer.getName();
    }

    /**
     * Switches the current player.
     */
    public void switchPlayer() {
        if (currentPlayer == firstPlayer) {
            currentPlayer = secondPlayer;
        } else {
            currentPlayer = firstPlayer;
        }
    }
}
