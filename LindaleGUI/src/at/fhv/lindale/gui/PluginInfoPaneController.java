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
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import org.xnap.commons.i18n.I18n;

/**
 * FXML Controller class
 *
 * @author Georgi Georgiev <georgi.georgiev@students.fhv.at>
 */
public class PluginInfoPaneController implements Initializable, I_Translateable, I_ControllerSetters
{

    @FXML
    private GridPane _PluginInfoPane;
    @FXML
    private ImageView _typeIcon;
    @FXML
    private Label _nameLabel;
    @FXML
    private Label _pluginName;
    @FXML
    private Label _versionLabel;
    @FXML
    private Label _pluginVersion;
    @FXML
    private Label _statusLabel;
    @FXML
    private Label _pluginStatus;
    @FXML
    private Label _authorLabel;
    @FXML
    private Label _pluginAuthor;
    @FXML
    private Label _websiteLabel;
    @FXML
    private Hyperlink _pluginHyperlink;
    @FXML
    private Label _installDateLabel;
    @FXML
    private Label _pluginInstallDate;
    @FXML
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

    /**
     * @return the _PluginInfoPane
     */
    public GridPane getPluginInfoPane()
    {
        return _PluginInfoPane;
    }

    /**
     * @return the _typeIcon
     */
    public ImageView getTypeIcon()
    {
        return _typeIcon;
    }

    /**
     * @return the _nameLabel
     */
    public Label getNameLabel()
    {
        return _nameLabel;
    }

    /**
     * @return the _pluginName
     */
    public Label getPluginName()
    {
        return _pluginName;
    }

    /**
     * @return the _versionLabel
     */
    public Label getVersionLabel()
    {
        return _versionLabel;
    }

    /**
     * @return the _pluginVersion
     */
    public Label getPluginVersion()
    {
        return _pluginVersion;
    }

    /**
     * @return the _statusLabel
     */
    public Label getStatusLabel()
    {
        return _statusLabel;
    }

    /**
     * @return the _pluginStatus
     */
    public Label getPluginStatus()
    {
        return _pluginStatus;
    }

    /**
     * @return the _authorLabel
     */
    public Label getAuthorLabel()
    {
        return _authorLabel;
    }

    /**
     * @return the _pluginAuthor
     */
    public Label getPluginAuthor()
    {
        return _pluginAuthor;
    }

    /**
     * @return the _websiteLabel
     */
    public Label getWebsiteLabel()
    {
        return _websiteLabel;
    }

    /**
     * @return the _pluginHyperlink
     */
    public Hyperlink getPluginHyperlink()
    {
        return _pluginHyperlink;
    }

    /**
     * @return the _installDateLabel
     */
    public Label getInstallDateLabel()
    {
        return _installDateLabel;
    }

    /**
     * @return the _pluginInstallDate
     */
    public Label getPluginInstallDate()
    {
        return _pluginInstallDate;
    }

    /**
     * @return the _translator
     */
    public I18n getTranslator()
    {
        return _translator;
    }

    /**
     * @return the _facade
     */
    public I_HibernateFacade getFacade()
    {
        return _facade;
    }

    @Override
    public void translateGUI()
    {
        _authorLabel.setText(_translator.tr(_authorLabel.getText()));
        _installDateLabel.setText(_translator.tr(_installDateLabel.getText()));
        _nameLabel.setText(_translator.tr(_nameLabel.getText()));
        _statusLabel.setText(_translator.tr(_statusLabel.getText()));
        _versionLabel.setText(_translator.tr(_versionLabel.getText()));
        _websiteLabel.setText(_translator.tr(_websiteLabel.getText()));
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
