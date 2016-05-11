import com.sun.org.apache.xpath.internal.SourceTree;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;

public class App extends Application {
    private static final int rowCount = 19;
    private static final int colCount = 28;
    private Cell[][] cells;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Window.fxml"));
        primaryStage.setTitle("Matrix Drawer");
        primaryStage.setScene(new Scene(root, 1000, 600));
        //primaryStage.getScene().addEventFilter(MouseEvent.ANY, e -> System.out.println(e));
        primaryStage.show();

        initGrid(root);
    }

    public void initGrid(Parent root)
    {
        Group g = new Group();
        ((TilePane)((HBox)((BorderPane) root).getChildren().get(1)).getChildren().get(0)).getChildren().add(g);


        cells = new Cell[rowCount][colCount];
        for(int row = 0; row < rowCount; row++)
        {
            for(int col = 0; col < colCount; col++)
            {
                Cell cell = new Cell(col * Cell.CELL_SIZE, row * Cell.CELL_SIZE);
                g.getChildren().add(cell);
                cells[row][col] = cell;
            }
        }

        g.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                int mouseX = (int)((event.getX()) / Cell.CELL_SIZE);
                int mouseY = (int)((event.getY()) / Cell.CELL_SIZE);

                if(mouseX >= 0 && mouseX < colCount && mouseY >= 0 && mouseY < rowCount)
                {
                    if(event.isPrimaryButtonDown()) { cells[mouseY][mouseX].setColoured(true); }
                    else if(event.isSecondaryButtonDown()) { cells[mouseY][mouseX].setColoured(false); }

                    String s = "";
                    for(int row = 0; row < rowCount; row++)
                    {
                        for (int col = 0; col < colCount; col++)
                        {
                            s += cells[row][col].isColoured() ? "1" : "0";
                        }

                        String num = row < 9 ? "0" + (row + 1) : String.valueOf(row + 1);

                        s += ((TextField)((BorderPane) root).getChildren().get(2)).getText() + num + ")\n";

                    }
                    ((TextArea)((HBox)((BorderPane) root).getChildren().get(1)).getChildren().get(1)).setText(s);
                }
            }
        });
    }
}
