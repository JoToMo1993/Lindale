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
import javafx.geometry.Insets;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import org.xnap.commons.i18n.I18n;

/**
 * FXML Controller class
 *
 * @author Georgi Georgiev <georgi.georgiev@students.fhv.at>
 */
public class SourceManagerController implements Initializable, I_Translateable, I_ControllerSetters
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

    @Override
    public void translateGUI()
    {
        _AddBtn.setText(_translator.tr(_AddBtn.getText()));
        _changeBtn.setText(_translator.tr(_changeBtn.getText()));
        _deleteBtn.setText(_translator.tr(_deleteBtn.getText()));
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
    
}
