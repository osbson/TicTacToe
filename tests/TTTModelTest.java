import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TTTModelTest {
    @Test
    public void getTurn() throws Exception {
        TTTModel game = new TTTModel();
        assertEquals(Mark.CROSS, game.getTurn());
    }

    @Test
    public void getMark() throws Exception {
        TTTModel game = new TTTModel();
        assertEquals(Mark.NOUGHT, game.getMark(0, 1));
    }

    @Test
    public void markSquare() throws Exception {
        TTTModel game = new TTTModel();
        assertEquals(true, game.markSquare(0, 1));
        assertEquals(Mark.CROSS, game.getMark(0, 1));
    }

    @Test
    public void hasWon() throws Exception {
        TTTModel game = new TTTModel();
        //check horizontal win
        for (int i = 0; i < 3; i++) {
            game.grid[0][i].setMark(Mark.CROSS);
        }
        game.hasWon();
        //check vertical win
        for (int i = 0; i < 3; i++) {
            game.grid[i][0].setMark(Mark.CROSS);
        }
        game.hasWon();
        //check diagonal win
        for (int i = 0; i < 3; i++) {
            game.grid[i][i].setMark(Mark.CROSS);
        }
        game.hasWon();
    }

}