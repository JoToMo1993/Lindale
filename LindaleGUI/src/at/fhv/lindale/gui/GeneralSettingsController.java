/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package at.fhv.lindale.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author Morent Jochen <jochen.morent@students.fhv.at>
 */
public class GeneralSettingsController implements Initializable
{
    @FXML
    private GridPane _generalSettingsWindow;
    @FXML
    private Label _languageLabel;
    @FXML
    private ComboBox<?> _languagesBox;
    @FXML
    private Button _cencelButton;
    @FXML
    private Button _okButton;
    @FXML
    private RadioButton _advancedModeButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    }    
    
}
