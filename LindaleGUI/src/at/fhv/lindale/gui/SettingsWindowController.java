/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.fhv.lindale.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author Georgi Georgiev <georgi.georgiev@students.fhv.at>
 */
public class SettingsWindowController implements Initializable
{

    @FXML
    private BorderPane _settingsWindow;
    @FXML
    private ScrollPane _currentSettingsPane;
    @FXML
    private Label _generalLabel;
    @FXML
    private Label _sourceManagerLabel;
    @FXML
    private Label _playerSettingsLabel;
    @FXML
    private Label _shortcutsLabel;
    @FXML
    private Label _searchSettingsLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    }



    @FXML
    private void onGeneralSelected(MouseEvent event) throws IOException
    {
        GridPane generalSettings = FXMLLoader.load(getClass().getResource("GeneralSettings.fxml"));
        _currentSettingsPane.setContent(generalSettings);
    }

    @FXML
    private void onSourceManagerSelected(MouseEvent event)
    {
        System.out.println("source manager");
    }

    @FXML
    private void onPlayerSettingsSelected(MouseEvent event)
    {
        System.out.println("player settings");
    }

    @FXML
    private void onShortcutsSelected(MouseEvent event)
    {
        System.out.println("shortcut settings");
    }

    @FXML
    private void onSearchSettingsSelected(MouseEvent event)
    {
        System.out.println("search settings");
    }

}
