import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class TTTFX extends Application {

    Stage window;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        TTTModel game = new TTTModel();
        window = primaryStage;
        window.setTitle("Tic Tac Toe");

        Button button1 = new Button("X");

        GridPane grid = new GridPane();
        grid.add(button1, 0,0);


        Scene scene = new Scene(grid, 200, 200);
        window.setScene(scene);
        window.show();
    }
}
