import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;

public class TTTModel {
    public TTTSquare[][] grid;
    private Mark turn;

    public TTTModel() {
        this.grid = new TTTSquare[3][3];
        for (int i = 0; i < this.grid.length; i++) {
            for (int j = 0; j < this.grid[i].length; j++) {
                this.grid[i][j] = new TTTSquare();
                this.grid[i][j].setMark(Mark.EMPTY);
            }
        }
        this.turn = Mark.CROSS;
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

    public void hasWon() {
        Mark winner;
        if (this.turn == Mark.CROSS) {
            winner = Mark.NOUGHT;
        } else {
            winner = Mark.CROSS;
        }
        Alert a = new Alert(Alert.AlertType.NONE, winner.toString() + " wins! \n(close window after finishing)", ButtonType.FINISH);
        a.setTitle("Game Over");

        //check horizontals
        for (int i = 0; i < this.grid.length; i++) {
            if ((this.grid[i][0].getMark() == winner) && (this.grid[i][1].getMark() == winner) && (this.grid[i][2].getMark() == winner)) {
                a.show();
            }
        }
        //check verticals
        for (int j = 0; j < this.grid.length; j++) {
            if ((this.grid[0][j].getMark() == winner) && (this.grid[1][j].getMark() == winner) && (this.grid[2][j].getMark() == winner)) {
                a.show();
            }
        }
        //Check diagonals
        if ((this.grid[0][0].getMark() == winner) && (this.grid[1][1].getMark() == winner) && (this.grid[2][2].getMark() == winner)) {
            a.show();
        }
        if ((this.grid[0][2].getMark() == winner) && (this.grid[1][1].getMark() == winner) && (this.grid[2][0].getMark() == winner)) {
            a.show();
        }

        //Check if game is finished (all cells full)
        boolean full = false;
        while (!full) {
            int n = 0;
            for (int i = 0; i < this.grid.length; i++) {
                for (int j = 0; j < this.grid[i].length; j++) {
                    if (this.grid[i][j].getMark() != Mark.EMPTY) {
                        n += 1;
                    }
                }
            }
            if (n <= 9) {
                full = true;
                Alert b = new Alert(Alert.AlertType.NONE, "Draw! \n(close window after finishing)", ButtonType.FINISH);
                b.setTitle("Game Over");
                //end game & output "DRAW"
            }
        }
    }


}
