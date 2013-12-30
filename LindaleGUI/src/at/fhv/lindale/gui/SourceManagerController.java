/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package at.fhv.lindale.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author Georgi Georgiev <georgi.georgiev@students.fhv.at>
 */
public class SourceManagerController implements Initializable
{
    @FXML
    private BorderPane _pluginManagerPane;
    @FXML
    private Accordion _sourcesAccordion;
    @FXML
    private Button _AddBtn;
    @FXML
    private Insets x2;
    @FXML
    private Button _deleteBtn;
    @FXML
    private Button _changeBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    }    

    @FXML
    private void onAdd(ActionEvent event)
    {
    }

    @FXML
    private void onDelete(ActionEvent event)
    {
    }

    @FXML
    private void onChange(ActionEvent event)
    {
    }
    
}
