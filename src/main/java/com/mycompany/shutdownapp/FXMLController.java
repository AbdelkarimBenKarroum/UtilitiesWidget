package com.mycompany.shutdownapp;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class FXMLController implements Initializable {

    @FXML
    private Label shutDownBtn;

    @FXML
    private Label restartBtn;

    @FXML
    private Label logOut;

    @FXML
    private Label settingsBtn;
    private String os=null;
    private String executeCmd="";
    private Alert alert=null;
    @FXML
    private Label dragBar;
    @FXML
    private Label closeBtn;
    double Xposition,Yposition;
    @FXML
    private AnchorPane rootPane;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
            
            os=System.getProperty("os.name");
            
            
         }
    @FXML
    void logOut(MouseEvent event) {
            if (os.contains("Windows")) {
            executeCmd="shutdown -l";
            
        }
        else if (os.contains("Linux")) {
            //shutdown sentence here
        }
        else if (os.contains("Mac")) {
            //shutdown sentence here
            
        }
        else {
            alert=new Alert(AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setContentText( os +" is not supported yet");
            alert.close();
        }
        try {
            Runtime.getRuntime().exec(executeCmd);
        } catch (IOException ex) {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void restart(MouseEvent event) {
        if (os.contains("Windows")) {
            executeCmd="shutdown -r -t 120";
            
        }
        else if (os.contains("Linux")) {
            //shutdown sentence here
        }
        else if (os.contains("Mac")) {
            //shutdown sentence here
            
        }
        else {
            alert=new Alert(AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setContentText( os +" is not supported yet");
            alert.close();
        }
        try {
            Runtime.getRuntime().exec(executeCmd);
        } catch (IOException ex) {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void setPrameters(MouseEvent event) {
        if (os.contains("Windows")) {
            executeCmd="cmd /c start control";
            
        }
        else if (os.contains("Linux")) {
            //shutdown sentence here
        }
        else if (os.contains("Mac")) {
            //shutdown sentence here
        }
        else {
            alert=new Alert(AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setContentText( os +" is not supported yet");
            alert.close();
        }
        try {
            Runtime.getRuntime().exec(executeCmd);
        } catch (IOException ex) {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void shutDown(MouseEvent event) throws IOException {
        
        if (os.contains("Windows")) {
            executeCmd="shutdown -s -t 120";
            
        }
        else if (os.contains("Linux")) {
            //shutdown sentence here
            executeCmd="shutdown -h now";
        }
        else if (os.contains("Mac")) {
            //shutdown sentence here
            executeCmd="shutdown -h now";
            
        }
        else {
            alert=new Alert(AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setContentText( os +" is not supported yet");
            alert.close();
        }
        Runtime.getRuntime().exec(executeCmd);
    }

    @FXML
    private void widgetDragged(MouseEvent event) {
        double x=event.getScreenX();
        double y=event.getScreenY();
        rootPane.getScene().getWindow().setX(x-Xposition);
        rootPane.getScene().getWindow().setY(y-Yposition);
    }

    @FXML
    private void getLocationOfWidget(MouseEvent event) {
        Xposition=event.getX();
        Yposition=event.getY();
        
    }

    @FXML
    private void closeWidget(MouseEvent event) {
       // rootPane.getScene().getWindow().hide();
        Stage root=(Stage)rootPane.getScene().getWindow();
        root.close();
    }

}
