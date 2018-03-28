
package paint;

import java.net.URL;
import static java.nio.file.Files.size;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;


/**
 *
 * @author victorchi
 */
public class PaintfxmlController implements Initializable {
    
   @FXML
   private ColorPicker colorpicker;
   
   @FXML
   private TextField brushsize;
   
   
   @FXML
     private Canvas canvas;
    
   
   
    boolean toolSelected = false;
    
    GraphicsContext brushTool;
    
    
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        brushTool = canvas.getGraphicsContext2D();
        canvas.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                 double size = Double.parseDouble(brushsize.getText());
        
                double x = e.getX() - size / 2;
                double y = e.getY() - size / 2;
                
                if(toolSelected && !brushsize.getText().isEmpty())
                {
                    brushTool.setFill(colorpicker.getValue());
                    brushTool.fillRoundRect(x, y, size, size, size, size);
                }
                ;
            }
        });
    }  
    
    @FXML
    public void toolselected(ActionEvent e)
    {
        toolSelected = true;
    }
    
}
