import javafx.event.EventHandler;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Created by Ash on 11/05/2016.
 */
public class Cell extends Rectangle {
    public static final int CELL_SIZE = 20;
    public static final float CELL_STROKE_SIZE = 0.1f;
    private boolean isColoured;

    public Cell(int x, int y)
    {
        super(x, y, CELL_SIZE, CELL_SIZE);
        setFill(Color.WHITE);
        setStroke(Color.GREY);
        setStrokeWidth(CELL_STROKE_SIZE);

        setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(event.isPrimaryButtonDown()) { setColoured(true); }
                else if(event.isSecondaryButtonDown()) { setColoured(false); }
            }
        });
    }

    // Accessors
    public boolean isColoured() { return isColoured; }

    // Mutators
    public void setColoured(boolean isColoured)
    {
        this.isColoured = isColoured;
        if(isColoured) { setFill(Color.MAGENTA); }
        else { setFill(Color.WHITE); }
    }
}
