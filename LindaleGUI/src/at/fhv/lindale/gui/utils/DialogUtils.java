/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.fhv.lindale.gui.utils;

import at.fhv.lindale.gui.LindaleGUI;
import java.io.IOException;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * @author Georgi Georgiev <georgi.georgiev@students.fhv.at>
 * @org FHV <fhv.at>
 * @project Lindale_GUI
 * @date 30-Dec-2013
 */
public class DialogUtils
{

 

    public void showDialog(E_DialogTypes type, String windowTitle, String localisedMessage, String localisedButtonText) throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        Pane dialog = (Pane) loader.load(getClass().getResourceAsStream("Dialog.fxml"));
        DialogController controller = loader.getController();
        controller.setMsg(localisedMessage);
        controller.setBtnText(localisedButtonText);
        if (type == E_DialogTypes.SUCCESS)
        {
            controller.setImg(new Image(getClass().getResourceAsStream(LindaleGUI.GRAPHICS_LOCATION + "success.png")));
        } else
        {
            controller.setImg(new Image(getClass().getResourceAsStream(LindaleGUI.GRAPHICS_LOCATION + "error.png")));
        }
        final Button btn = controller.getButton();
        if (type != E_DialogTypes.FATAL_ERROR)
        {
            btn.setOnAction(new EventHandler<ActionEvent>()
            {

                @Override
                public void handle(ActionEvent t)
                {
                    btn.getScene().getWindow().hide();
                }
            });
        } else
        {
            btn.setOnAction(new EventHandler<ActionEvent>()
            {

                @Override
                public void handle(ActionEvent t)
                {
                    Platform.exit();
                }
            });
        }
        Stage stage = new Stage(StageStyle.UTILITY);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle(windowTitle);
        stage.setScene(new Scene(dialog));
        stage.show();
    }

}
