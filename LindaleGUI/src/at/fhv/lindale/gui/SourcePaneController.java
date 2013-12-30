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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author Georgi Georgiev <georgi.georgiev@students.fhv.at>
 */
public class SourcePaneController implements Initializable
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    }    
    
}
