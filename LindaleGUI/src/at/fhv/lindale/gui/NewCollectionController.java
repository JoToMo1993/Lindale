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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * @author Georgi Georgiev <georgi.georgiev@students.fhv.at>
 * @org FHV <fhv.at>
 * @project LindaleGUI
 * @date 21-Dec-2013
 */
public class NewCollectionController implements Initializable
{

    @FXML
    private BorderPane _pane;
    @FXML
    private Label _fieldLabel;
    @FXML
    private TextField _nameInputField;
    @FXML
    private Button _cencelButton;
    @FXML
    private Button _okButton;
    @FXML
    private Label _erorrLabel;

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {

    }

    @FXML
    public void okClicked(ActionEvent e)
    {
        boolean success = false;
        String input = _nameInputField.getText();
        if (input.isEmpty())
        {
            _erorrLabel.setVisible(true);
        } //TODO send to main programm here if success close dialog
        else
        {
            //For Testing
            System.out.println(input);
            Stage stage = (Stage) _cencelButton.getScene().getWindow();
            stage.close();

        }

    }

    @FXML
    public void cencelClicked(ActionEvent e)
    {
        Stage stage = (Stage) _cencelButton.getScene().getWindow();
        stage.close();
    }

}
