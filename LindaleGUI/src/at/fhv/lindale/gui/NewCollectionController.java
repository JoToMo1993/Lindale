/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.fhv.lindale.gui;

import at.fhv.lindale.api.hf.I_HibernateFacade;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.xnap.commons.i18n.I18n;

/**
 * @author Georgi Georgiev <georgi.georgiev@students.fhv.at>
 * @org FHV <fhv.at>
 * @project LindaleGUI
 * @date 21-Dec-2013
 */
public class NewCollectionController implements Initializable, I_ControllerSetters, I_Translateable
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
    private I18n _translator;
    private I_HibernateFacade _facade;
    private Properties _config;
    @FXML
    private Label _dialogTitle;

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

    @Override
    public void setTranslator(I18n translator)
    {
        _translator = translator;
    }

    @Override
    public void setFacade(I_HibernateFacade facade)
    {
        _facade = facade;
    }

    @Override
    public void setConfigProperty(Properties config)
    {
        _config = config;
    }

    @Override
    public void translateGUI()
    {
        _fieldLabel.setText(_translator.tr(_fieldLabel.getText()));
        _cencelButton.setText(_translator.tr(_cencelButton.getText()));
        _okButton.setText(_translator.tr(_okButton.getText()));
        _dialogTitle.setText(_translator.tr(_dialogTitle.getText()));
    }

}
