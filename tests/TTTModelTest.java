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
        TTTModel test = new TTTModel();
        test.grid[0][1].setMark(Mark.CROSS);
        assertEquals(Mark.CROSS, test.getMark(0, 1));
    }

    @Test
    public void markSquare() throws Exception {
        TTTModel test = new TTTModel();
        assertEquals(true, test.markSquare(0, 1));
        assertEquals(Mark.CROSS, test.getMark(0, 1));
    }

    @Test
    public void hasWon() throws Exception {
        TTTModel test = new TTTModel();
        //check horizontal win
        for (int i = 0; i < 3; i++) {
            test.grid[0][i].setMark(Mark.CROSS);
        }
        test.hasWon();
        //check vertical win
        for (int i = 0; i < 3; i++) {
            test.grid[i][0].setMark(Mark.CROSS);
        }
        test.hasWon();
        //check diagonal win
        for (int i = 0; i < 3; i++) {
            test.grid[i][i].setMark(Mark.CROSS);
        }
        test.hasWon();
    }

}