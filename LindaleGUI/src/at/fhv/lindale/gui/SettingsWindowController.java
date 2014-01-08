/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.fhv.lindale.gui;

import at.fhv.lindale.api.hf.I_HibernateFacade;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
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
import javafx.scene.layout.Pane;
import org.xnap.commons.i18n.I18n;

/**
 * FXML Controller class
 *
 * @author Georgi Georgiev <georgi.georgiev@students.fhv.at>
 */
public class SettingsWindowController implements Initializable, I_ControllerSetters, I_Translateable
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
    @FXML
    private Label _advancedLabel;
    @FXML
    private Label _pluginManagerLabel;
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
    private void onGeneralSelected(MouseEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        
        GridPane generalSettings = (GridPane) loader.load(getClass().getResourceAsStream("GeneralSettings.fxml"));
        GeneralSettingsController controller = loader.getController();
        controller.setConfigProperty(_config);
        controller.setFacade(_facade);
        controller.setTranslator(_translator);
        controller.syncWithConfig();
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

    @FXML
    private void onAdvancedSelected(MouseEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        Pane pane = (Pane) loader.load(getClass().getResourceAsStream("AdvancedSettings.fxml"));
        AdvancedSettingsController controller = loader.getController();
        controller.setConfigProperty(_config);
        controller.setFacade(_facade);
        controller.setTranslator(_translator);
        controller.syncWithConfig();
        _currentSettingsPane.setContent(pane);
    }
    
    @FXML
    private void onPluginManagerSelected(MouseEvent event) throws IOException, Exception
    {
        FXMLLoader loader = new FXMLLoader();
        Pane pane = (Pane) loader.load(getClass().getResourceAsStream("PluginManager.fxml"));
        PluginManagerController controller = loader.getController();
        controller.setFacade(_facade);
        controller.setTranslator(_translator);
        controller.fillPluginInfo();
        _currentSettingsPane.setContent(pane);
        
    }

    @Override
    public void setTranslator(I18n translator)
    {
        _translator = translator;
    }

    @Override
    public void setFacade(I_HibernateFacade facede)
    {
        _facade = facede;
    }

    @Override
    public void setConfigProperty(Properties config)
    {
        _config = config;
    }

    @Override
    public void translateGUI()
    {
        _generalLabel.setText(_translator.tr(_generalLabel.getText()));
        _advancedLabel.setText(_translator.tr(_advancedLabel.getText()));
        _playerSettingsLabel.setText(_translator.tr(_playerSettingsLabel.getText()));
        _pluginManagerLabel.setText(_translator.tr(_pluginManagerLabel.getText()));
        _searchSettingsLabel.setText(_translator.tr(_searchSettingsLabel.getText()));
        _shortcutsLabel.setText(_translator.tr(_shortcutsLabel.getText()));
        _sourceManagerLabel.setText(_translator.tr(_sourceManagerLabel.getText()));
    }

}
