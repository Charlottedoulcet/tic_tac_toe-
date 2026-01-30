package com.tic_tac_toe;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AppTest {

    private Board board;

    @BeforeEach
    @SuppressWarnings("unused")
    void setUp() {
        // Inicia el juego con un tablero vacío antes de cada prueba
        board = new Board();
    }

    @Test
    @DisplayName("Should initialize board with dashes")
    void testBoardInitialization() {
        char[][] grid = board.getGrid();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals('-', grid[i][j], "Each cell should contain a dash '-'");
            }
        }
    }

    @Test
    @DisplayName("Should allow a valid move")
    void testValidMove() {
        boolean success = board.setMove(1, 1, 'X');
        assertTrue(success, "The move should be accepted");
        assertEquals('X', board.getGrid()[1][1], "The cell should now contain 'X'");
    }

    @Test
    @DisplayName("Should reject a move if the cell is already occupied")
    void testOccupiedCellMove() {
        board.setMove(0, 0, 'X');
        boolean success = board.setMove(0, 0, 'O');
        assertFalse(success, "The move should be rejected because cell (0,0) is occupied");
        assertEquals('X', board.getGrid()[0][0], "The cell should still contain the original 'X'");
    }

    @Test
    @DisplayName("Should reject moves that are out of bounds")
    void testOutOfBoundsMove() {
        assertFalse(board.setMove(-1, 0, 'X'), "Row -1 should be invalid");
        assertFalse(board.setMove(3, 0, 'X'), "Row 3 should be invalid");
        assertFalse(board.setMove(0, 5, 'X'), "Column 5 should be invalid");
    }
}
