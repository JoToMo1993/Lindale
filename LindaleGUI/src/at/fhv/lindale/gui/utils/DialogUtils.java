/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.fhv.lindale.gui.utils;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
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

   

    public  void showDialogSuccess(String windowTitle, String localisedMessage, String localisedButtonText) throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        Pane dialog = (Pane) loader.load(getClass().getResourceAsStream("dialogSuccess.fxml"));
        DialogSuccessController controller = loader.getController();
        controller.setMsg(localisedMessage);
        controller.setBtnText(localisedButtonText);
        controller.loadImg();
        Stage stage = new Stage(StageStyle.UTILITY);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle(windowTitle);
        stage.setScene(new Scene(dialog));
        stage.show();
    }

}
