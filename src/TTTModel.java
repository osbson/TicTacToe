import javafx.geometry.Orientation;

public class TTTModel {
    public TTTSquare[][] grid;
    private Mark turn;

    public TTTModel() {
        this.turn = Mark.CROSS;
        this.grid = new TTTSquare[3][3];
    }

    public Mark getTurn() {
        return this.turn;
    }

    public Mark getMark(int row, int column) {
        return this.grid[row][column].getMark();
    }

    public boolean markSquare(int row, int column) {
        if (this.grid[row][column].getMark() == Mark.EMPTY) {
            this.grid[row][column].setMark(this.turn);
            if (this.turn == Mark.CROSS) {
                this.turn = Mark.NOUGHT;
            } else {
                this.turn = Mark.CROSS;
            }
            return true;
        } else {
            return false;
        }
    }

    public void hasWon(){
        //Check if there are 3 of type in a row (every turn)
    }


}
