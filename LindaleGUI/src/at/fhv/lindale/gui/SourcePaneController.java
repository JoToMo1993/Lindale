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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import org.xnap.commons.i18n.I18n;

/**
 * FXML Controller class
 *
 * @author Georgi Georgiev <georgi.georgiev@students.fhv.at>
 */
public class SourcePaneController implements Initializable, I_ControllerSetters, I_Translateable
{
    @FXML
    private GridPane _sourcePane;
    @FXML
    private Label _userNameLabel;
    @FXML
    private TextField _userNameField;
    @FXML
    private Label _passwordLabel;
    @FXML
    private PasswordField _passwordField;
    @FXML
    private Label _pathLabel;
    @FXML
    private TextField _pathField;
    @FXML
    private Label _protocolLabel;
    @FXML
    private TextField _protocloField;
    @FXML
    private Label _rootFolderLabel;
    @FXML
    private Label _rootFolder;
    @FXML
    private Label _nOfFilesLabel;
    @FXML
    private Label _fileCount;
    private I18n _translator;
    private I_HibernateFacade _facade;
    private Properties _config;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
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
        _nOfFilesLabel.setText(_translator.tr(_nOfFilesLabel.getText()));
        _passwordLabel.setText(_translator.tr(_passwordLabel.getText()));
        _pathLabel.setText(_translator.tr(_pathLabel.getText()));
        _protocolLabel.setText(_translator.tr(_protocolLabel.getText()));
        _rootFolderLabel.setText(_translator.tr(_rootFolderLabel.getText()));
        _userNameLabel.setText(_translator.tr(_userNameLabel.getText()));
    }
    
}
