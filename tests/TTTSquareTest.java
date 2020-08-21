import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TTTSquareTest {

    @Test
    public void getMark() throws Exception{
        TTTSquare square = new TTTSquare();
        assertNull(square.getMark());
    }

    @Test
    public void setMark() throws Exception{
        TTTSquare square = new TTTSquare();
        square.setMark(Mark.CROSS);
        assertEquals(Mark.CROSS, square.getMark());
    }
}