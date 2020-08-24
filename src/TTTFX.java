/*
*
* Author: Ore Benson
*
* */


import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TTTFX extends Application {

    Stage window;

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        TTTModel game = new TTTModel();
        Alert start = new Alert(Alert.AlertType.NONE, "X Starts", ButtonType.OK);
        start.setTitle("Start");

        window = primaryStage;
        window.setTitle("Tic Tac Toe");

        GridPane pane = new GridPane();
        //fill grid with labels of empty marks
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                String text = game.getMark(x, y).toString();
                Label label = new Label(text);

                label.setMinWidth(150);
                label.setMinHeight(150);
                label.setStyle("-fx-border-color: black;");
                label.setFont(new Font("Arial", 80));
                label.setAlignment(Pos.CENTER);

                pane.add(label, y, x, 1, 1);
            }
        }

        Scene scene = new Scene(pane, 450, 450);

        //identify and change label on mouse click
        scene.setOnMouseClicked(mouseEvent -> {
            int x = (int) Math.floor(mouseEvent.getX() / (pane.getWidth() / 3));
            int y = (int) Math.floor(mouseEvent.getY() / (pane.getHeight() / 3));
            Label cellLabel = (Label) pane.getChildren().get(y * 3 + x);
            game.markSquare(x, y);
            cellLabel.setText(game.getMark(x, y).toString());
            game.hasWon();
        });

        window.setResizable(false);
        window.setScene(scene);
        window.show();
        start.show();
    }
}
