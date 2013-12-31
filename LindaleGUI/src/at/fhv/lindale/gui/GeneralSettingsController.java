/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.fhv.lindale.gui;

import at.fhv.lindale.api.hf.I_HibernateFacade;
import at.fhv.lindale.gui.utils.DialogUtils;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import org.xnap.commons.i18n.I18n;

/**
 * FXML Controller class
 *
 * @author Georgi Georgiev <georgi.georgiev@students.fhv.at>
 */
public class GeneralSettingsController implements Initializable, I_ControllerSetters
{

    @FXML
    private GridPane _generalSettingsWindow;
    @FXML
    private Label _languageLabel;
    @FXML
    private ComboBox<Locale> _languagesBox;
    @FXML
    private Button _okButton;
    @FXML
    private RadioButton _advancedModeButton;
    private I18n _translator;
    private Properties _config;
    private Locale _currentLocale;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    }

    public void okClicked(MouseEvent e) throws IOException
    {
        if (_advancedModeButton.isSelected())
        {
            _config.setProperty("advanced.enabled", "true");
        } else
        {
            _config.setProperty("advanced.enabled", "false");
        }
        if (!_currentLocale.equals(_languagesBox.getSelectionModel().getSelectedItem()))
        {
            _config.setProperty("languages.enabled", _languagesBox.getSelectionModel().getSelectedItem().toString());
            DialogUtils utils = new DialogUtils();
            utils.showDialogSuccess("Language changed", "Language changed successfully. Restert to apply the changes", "OK");
        }

    }

    @Override
    public void setTranslator(I18n translator)
    {
        _translator = translator;
    }

    @Override
    public void setFacade(I_HibernateFacade facede)
    {
        I_HibernateFacade _facade = facede;
    }

    @Override
    public void setConfigProperty(Properties config)
    {
        _config = config;
    }

    //Sets buttons and language according to config
    public void syncWithConfig()
    {
        if ("true".equals(_config.getProperty("advanced.enabled")))
        {
            _advancedModeButton.setSelected(true);

        }
        String[] localeStrings = _config.getProperty("languages.available").split(",");
        ArrayList<Locale> locales = new ArrayList<>();
        for (String localeString : localeStrings)
        {
            String[] components = localeString.split("_");
            locales.add(new Locale(components[0], components[1]));
        }
        String currentLocaleString = _config.getProperty("languages.enabled");
        String[] components = currentLocaleString.split("_");
        _currentLocale = new Locale(components[0], components[1]);
        _languagesBox.setItems(FXCollections.observableList(locales));
        int localeIndex = 0;
        SingleSelectionModel<Locale> model = _languagesBox.getSelectionModel();
        model.selectFirst();
        while (localeIndex < locales.size() && !model.getSelectedItem().equals(_currentLocale))
        {
            localeIndex++;
            model.select(localeIndex);
        }

    }

}
