/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author victorchi
 */
public class TestFXMLController implements Initializable {

       @FXML
    private JFXButton save_but;

    @FXML
    private JFXButton cancel;

       @FXML
    private AnchorPane anchorPane;

    @FXML
    private JFXHamburger handb;

    @FXML
    private JFXDrawer drawer;

    
    
    
    
    
       @FXML
    void onCancel(ActionEvent event) {
        System.exit(0);
    }

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        HamburgerBackArrowBasicTransition bugerTask = new HamburgerBackArrowBasicTransition(handb);
        bugerTask.setRate(-1);
        
        handb.addEventHandler(MouseEvent.MOUSE_PRESSED, (e) -> {
        bugerTask.setRate(bugerTask.getRate() * -1);
        bugerTask.play();
        
        if(drawer.isShown())
        {
           drawer.close();
        }else
        {
          drawer.open();
        }
            
        });
        
    }    
    
}

  
 