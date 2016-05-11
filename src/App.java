import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {
    private static final int rowCount = 28;
    private static final int colCount = 19;

    TilePane tp;
    Group display;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Window.fxml"));
        primaryStage.setTitle("Matrix Drawer");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();

        initGrid(root);
    }

    public void initGrid(Parent root)
    {
        for(int row = 0; row < rowCount; row++)
        {
            for(int col = 0; col < colCount; col++)
            {
                ((TilePane)((BorderPane) root).getChildren().get(3)).getChildren().add(new Button());
            }
        }
    }
}
