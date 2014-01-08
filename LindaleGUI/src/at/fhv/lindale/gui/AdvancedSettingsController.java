/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.fhv.lindale.gui;

import at.fhv.lindale.api.hf.I_HibernateFacade;
import at.fhv.lindale.gui.utils.DialogUtils;
import at.fhv.lindale.gui.utils.E_DialogTypes;
import java.io.IOException;
import java.net.URL;
import java.util.ListIterator;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import org.xnap.commons.i18n.I18n;

/**
 * FXML Controller class
 *
 * @author Georgi Georgiev <georgi.georgiev@students.fhv.at>
 */
public class AdvancedSettingsController implements Initializable, I_Synchronizable, I_ControllerSetters, I_Translateable
{

    @FXML
    private BorderPane _advancedOptionsPane;
    @FXML
    private VBox _checkBoxes;
    @FXML
    private CheckBox _copyCheckBox;
    @FXML
    private CheckBox _renameCheckBox;
    @FXML
    private CheckBox _moveCheckBox;
    @FXML
    private CheckBox _deleteCheckBox;
    @FXML
    private Label _fileOperationsLabel;
    @FXML
    private Font x2;
    @FXML
    private TextField _playerNameField;
    @FXML
    private Insets x1;
    @FXML
    private TextField _commandField;
    @FXML
    private Label _customPlayerLabel;
    @FXML
    private Button _okButton;
    private I_HibernateFacade _facade;
    private I18n _translator;
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
    public void syncWithConfig()
    {
        if ("true".equalsIgnoreCase(_config.getProperty("advanced.copy")))
        {
            _copyCheckBox.setSelected(true);
        } else
        {
            _copyCheckBox.setSelected(false);
        }
        if ("true".equalsIgnoreCase(_config.getProperty("advanced.rename")))
        {
            _renameCheckBox.setSelected(true);
        } else
        {
            _renameCheckBox.setSelected(false);
        }
        if ("true".equalsIgnoreCase(_config.getProperty("advanced.move")))
        {
            _moveCheckBox.setSelected(true);
        } else
        {
            _moveCheckBox.setSelected(false);
        }
        if ("true".equalsIgnoreCase(_config.getProperty("advanced.delete")))
        {
            _deleteCheckBox.setSelected(true);
        } else
        {
            _deleteCheckBox.setSelected(false);
        }
        if (!"".equals(_config.getProperty("player.name")))
        {
            _playerNameField.setText(_config.getProperty("player.name"));
            _commandField.setText(_config.getProperty("player.command"));
        }
        if (!"true".equalsIgnoreCase(_config.getProperty("advanced.enabled")))
        {
            ListIterator<Node> itr = _checkBoxes.getChildren().listIterator();
            while (itr.hasNext())
            {
                itr.next().setDisable(true);
            }
            _playerNameField.setDisable(true);
            _commandField.setDisable(true);
            _okButton.setDisable(true);

        }
    }

    @FXML
    private void onOk() throws IOException
    {
        if (_copyCheckBox.isSelected())
        {
            _config.setProperty("advanced.copy", "true");
        } else
        {
            _config.setProperty("advanced.copy", "false");
        }
        if (_renameCheckBox.isSelected())
        {
            _config.setProperty("advanced.rename", "true");
        } else
        {
            _config.setProperty("advanced.rename", "false");
        }
        if (_renameCheckBox.isSelected())
        {
            _config.setProperty("advanced.rename", "true");
        } else
        {
            _config.setProperty("advanced.rename", "false");
        }
        if (_deleteCheckBox.isSelected())
        {
            _config.setProperty("advanced.delete", "true");
        } else
        {
            _config.setProperty("advanced.delete", "false");
        }
        if ("".equals(_playerNameField.getText()) && "".equals(_commandField.getText()))
        {
            _config.setProperty("player.name", "");
            _config.setProperty("player.command", "");
        } else if (!"".equals(_playerNameField.getText()) && !"".equals(_commandField.getText()))
        {
            _config.setProperty("player.name", _playerNameField.getText());
            _config.setProperty("player.command", _commandField.getText());
        } else
        {
            DialogUtils util = new DialogUtils();
            util.showDialog(E_DialogTypes.ERROR, "Custom player error", "Both fields must be filled", "OK");
        }

    }

    @Override
    public void setTranslator(I18n translator
    )
    {
        _translator = translator;
    }

    @Override
    public void setFacade(I_HibernateFacade facade
    )
    {
        _facade = facade;
    }

    @Override
    public void setConfigProperty(Properties config
    )
    {
        _config = config;
    }

    @Override
    public void translateGUI()
    {
        _copyCheckBox.setText(_translator.tr(_copyCheckBox.getText()));
        _renameCheckBox.setText(_translator.tr(_copyCheckBox.getText()));
        _moveCheckBox.setText(_translator.tr(_moveCheckBox.getText()));
        _deleteCheckBox.setText(_translator.tr(_deleteCheckBox.getText()));
        _fileOperationsLabel.setText(_translator.tr(_fileOperationsLabel.getText()));
        _playerNameField.setPromptText(_translator.tr(_playerNameField.getText()));
        _commandField.setPromptText(_translator.tr(_commandField.getPromptText()));
        _okButton.setText(_translator.tr(_okButton.getText()));
    }

}
