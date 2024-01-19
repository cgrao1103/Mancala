package ui;

import mancala.MancalaGame;
import mancala.Player;
import mancala.InvalidMoveException;
import mancala.Board;
import mancala.Pit;
import mancala.Store;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * The TextUI class represents the text-based user interface for the Mancala game.
 * It handles user input and displays the game state.
 */
public class TextUI {
    private static final int MAX_METHOD_LENGTH = 50;
    private static final int MAX_LINE_LENGTH = 120;

    private MancalaGame mancalaGame;
    private Scanner scanner;

    /**
     * Constructs a TextUI object and initializes the MancalaGame and Scanner.
     */
    public TextUI() {
        mancalaGame = new MancalaGame();
        scanner = new Scanner(System.in);
    }

    /**
     * Starts the Mancala game, prompting players for names and handling turns until the game is over.
     */
    public void startGame() {
        System.out.println("Welcome to Mancala!");

        Player playerOne = createPlayer("One");
        Player playerTwo = createPlayer("Two");

        mancalaGame.setPlayers(playerOne, playerTwo);
        mancalaGame.startNewGame();

        while (!mancalaGame.isGameOver()) {
            printGameState();

            Player currentPlayer = mancalaGame.getCurrentPlayer();
            System.out.println("It's " + currentPlayer.getName() + "'s turn.");

            int startPit = getPlayerMove(currentPlayer);
            performMove(currentPlayer, startPit);

            System.out.println();
        }

        printGameOver();
    }

    /**
     * Creates a player by prompting the user for a name.
     *
     * @param numberSuffix The suffix for player number (e.g., "One" or "Two").
     * @return The created Player object.
     */
    private Player createPlayer(String numberSuffix) {
        System.out.print("Enter Player " + numberSuffix + "'s name: ");
        String playerName = scanner.nextLine();
        return new Player(playerName);
    }

    /**
     * Prints the current state of the Mancala board.
     */
    private void printGameState() {
        Board board = mancalaGame.getBoard();
        ArrayList<Pit> pits = board.getPits();
        ArrayList<Store> stores = board.getStores();

        System.out.println("Player Two's Store");
        printPitsAndStores(12, 6, pits, stores);

        System.out.println("Player One's Store");
        System.out.println();
    }

    /**
     * Prints the pits and stores within a specified range.
     *
     * @param start        The starting index for pits.
     * @param end          The ending index for pits.
     * @param pits         The list of pits.
     * @param stores       The list of stores.
     */
    private void printPitsAndStores(int start, int end, ArrayList<Pit> pits, ArrayList<Store> stores) {
        System.out.print("   ");
        for (int i = start; i > end; i--) {
            System.out.print(pits.get(i - 1).getStoneCount() + " ");
        }
        System.out.println();
        System.out.println("[" + stores.get(1).getTotalStones() + "] --- --- --- --- --- --- ["
                + stores.get(0).getTotalStones() + "]");
        System.out.print("   ");
        for (int i = 1; i <= end; i++) {
            System.out.print(pits.get(i - 1).getStoneCount() + " ");
        }
        System.out.println();
    }

    /**
     * Gets the player's move by prompting for a pit number.
     *
     * @param currentPlayer The current player.
     * @return The pit number chosen by the player.
     */
    private int getPlayerMove(Player currentPlayer) {
        int startPit;
        ArrayList<Player> players = mancalaGame.getPlayers();
        if (currentPlayer == players.get(0)) {
            System.out.print("Enter the pit number to move from (1-6): ");
        } else {
            System.out.print("Enter the pit number to move from (7-12): ");
        }

        try {
            startPit = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number.");
            return getPlayerMove(currentPlayer);
        }
        return startPit;
    }

    /**
     * Performs a move for the current player and handles exceptions.
     *
     * @param currentPlayer The current player.
     * @param startPit      The pit number chosen by the player.
     */
    private void performMove(Player currentPlayer, int startPit) {
        try {
            int stonesMoved = mancalaGame.getNumStones(startPit - 1);
            mancalaGame.move(startPit - 1);
            System.out.println(currentPlayer.getName() + " moved " + stonesMoved + " stones.");
        } catch (InvalidMoveException e) {
            System.out.println("Invalid move. " + e.getMessage());
        }
    }

    /**
     * Prints the game over message along with the final game state and the winner.
     */
    private void printGameOver() {
        System.out.println("Game Over!");
        printGameState();
        Player winner = mancalaGame.getWinner();
        if (winner != null) {
            System.out.println(winner.getName() + " wins!");
        } else {
            System.out.println("It's a tie!");
        }
    }

    /**
     * The main method to start the Mancala game using the TextUI.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        TextUI textUI = new TextUI();
        textUI.startGame();
    }
}
