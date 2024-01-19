package mancala;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    private Board board;
    private Player playerOne;
    private Player playerTwo;

    @BeforeEach
    void setUp() {
        // Set up the board and players for each test
        board = new Board();
        playerOne = new Player("Player One");
        playerTwo = new Player("Player Two");
    }

    @Test
    void testCaptureStones() throws PitNotFoundException {
        // Test the captureStones method
        int stoppingPoint = 4; // Change the stopping point for testing
        int capturedStones = board.captureStones(stoppingPoint);
        assertEquals(0, capturedStones); // Initial assumption, update based on your implementation
    }

    @Test
    void testDistributeStones() throws PitNotFoundException {
        // Test the distributeStones method
        // Set up the board with a known state for testing
        board.resetBoard();
        board.registerPlayers(playerOne, playerTwo);
        int startingPoint = 1; // Change the starting point for testing
        board.getPits().get(startingPoint).addStone();
        int stonesAdded = board.distributeStones(startingPoint);
        assertTrue(stonesAdded > 0);
    }

    @Test
    void testGetNumStones() throws PitNotFoundException {
        // Test the getNumStones method
        int pitNum = 2; // Change the pit number for testing
        int numStones = board.getNumStones(pitNum);
        assertEquals(4, numStones); // Initial assumption, update based on your implementation
    }

    @Test
    void testIsSideEmpty() throws PitNotFoundException {
        // Test the isSideEmpty method
        int pitNum = 3; // Change the pit number for testing
        assertFalse(board.isSideEmpty(pitNum)); // Initial assumption, update based on your implementation
    }

    @Test
    void testResetBoard() {
        // Test the resetBoard method
        assertDoesNotThrow(() -> board.resetBoard()); // Initial assumption, update based on your implementation
    }

    @Test
    void testRegisterPlayers() {
        // Test the registerPlayers method
        assertDoesNotThrow(() -> board.registerPlayers(playerOne, playerTwo)); // Initial assumption, update based on your implementation
    }
}
