/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.fhv.lindale.gui;

import at.fhv.lindale.api.container.E_PluginState;
import at.fhv.lindale.api.hf.I_HibernateFacade;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.BorderPane;
import org.xnap.commons.i18n.I18n;
import at.fhv.lindale.api.container.I_PluginInfo;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author Georgi Georgiev <georgi.georgiev@students.fhv.at>
 */
public class PluginManagerController implements Initializable, I_ControllerSetters
{

    @FXML
    private BorderPane _pluginManagerPane;
    @FXML
    private Accordion _pluginsAccordion;
    @FXML
    private Insets x2;
    private I18n _translator;
    private I_HibernateFacade _facade;
    @FXML
    private Button _activateDeactivateBtn;
    @FXML
    private Button _uninstallBtn;
    @FXML
    private Button _installBtn;
    private HashMap<Integer, I_PluginInfo> _pluginInfosMap = new HashMap<>();
    private HashMap<Pane, Integer> _paneIDMap = new HashMap<>();

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
    public void setFacade(I_HibernateFacade facede)
    {
        _facade = facede;
    }

    public void fillPluginInfo() throws IOException, Exception
    {
        List<I_PluginInfo> pluginInfos = _facade.loadAll_PluginInfos();
        for (I_PluginInfo currentInfo : pluginInfos)
        {
            TitledPane titledPane = new TitledPane();
            titledPane.setText(currentInfo.getName() + "\t" + currentInfo.getState() + "\t" + currentInfo.getVersion());
            FXMLLoader loader = new FXMLLoader();
            GridPane infoPane = (GridPane) loader.load(getClass().getResourceAsStream("PluginInfoPane.fxml"));
            _pluginInfosMap.put(currentInfo.getID(), currentInfo);
            // every infoPane is associated with the id of the plugin described in the pane
            _paneIDMap.put(infoPane, currentInfo.getID());
            PluginInfoPaneController paneController = loader.getController();
            paneController.getPluginName().setText(currentInfo.getName());
            paneController.getPluginStatus().setText(currentInfo.getState().toString());
            paneController.getPluginVersion().setText(currentInfo.getVersion());

            switch (currentInfo.getType())
            {
                case IO_PLUGIN:
                    paneController.getTypeIcon().setImage(new Image(getClass().getResourceAsStream(LindaleGUI.GRAPHICS_LOCATION + "ioPlugin.png")));
                    Tooltip ioTooltip = new Tooltip("IO Plugin");
                    Tooltip.install(paneController.getTypeIcon(), ioTooltip);
                    break;
                case FILTER_PLUGIN:
                    paneController.getTypeIcon().setImage(new Image(getClass().getResourceAsStream(LindaleGUI.GRAPHICS_LOCATION + "filterPlugin.png")));
                    Tooltip filterTooltip = new Tooltip("Filter Plugin");
                    Tooltip.install(paneController.getTypeIcon(), filterTooltip);
                    break;
                case VIEW_PLUGIN:
                    paneController.getTypeIcon().setImage(new Image(getClass().getResourceAsStream(LindaleGUI.GRAPHICS_LOCATION + "viewPlugin.png")));
                    Tooltip viewTooltip = new Tooltip("View Plugin");
                    Tooltip.install(paneController.getTypeIcon(), viewTooltip);
                    break;
                default:
                    throw new Exception("Code should not be reached");
            }
            ScrollPane scrollPane = new ScrollPane();
            scrollPane.setContent(infoPane);
            titledPane.setContent(scrollPane);

            _pluginsAccordion.getPanes().add(titledPane);

        }

        _pluginsAccordion.expandedPaneProperty().addListener(new ChangeListener<TitledPane>()
        {

            @Override
            public void changed(ObservableValue<? extends TitledPane> observable, TitledPane oldValue, TitledPane newValue)
            {
                if (newValue == null)
                {
                    _activateDeactivateBtn.setDisable(true);
                    _uninstallBtn.setDisable(true);
                } else
                {
                    _activateDeactivateBtn.setDisable(false);
                    _uninstallBtn.setDisable(false);
                    Pane grid = (GridPane) ((ScrollPane) newValue.getContent()).getContent();
                    int pluginID = _paneIDMap.get(grid);
                    switch (_pluginInfosMap.get(pluginID).getState())
                    {
                        case ACTIVATED:
                            _activateDeactivateBtn.setText("Deactivate");
                            break;
                        case DEACTIVATED:
                            _activateDeactivateBtn.setText("Activate");
                    }
                }
            }
        });
    }

    @FXML
    private void onActivateDeactivate(ActionEvent event) throws Exception
    {
        Pane grid = (Pane) ((ScrollPane) _pluginsAccordion.getExpandedPane().getContent()).getContent();
        int pluginID = _paneIDMap.get(grid);
        switch (_pluginInfosMap.get(pluginID).getState())
        {
            case ACTIVATED:
                deactivatePlugin(pluginID);
                break;
            case DEACTIVATED:
                activatePlugin(pluginID);
                break;
            default:
                throw new Exception("Code should not be reached");

        }
    }

    @FXML
    private void onUninstall(ActionEvent event)
    {
        Pane grid = (Pane) ((ScrollPane) _pluginsAccordion.getExpandedPane().getContent()).getContent();
        int pluginID = _paneIDMap.get(grid);
        uninstallPlugin(pluginID);
        _pluginsAccordion.getExpandedPane().setDisable(true);
        _pluginsAccordion.getExpandedPane().setExpanded(false);

    }

    @FXML
    private void onInstall(ActionEvent event)
    {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Install Plugin");
        chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Java archive", "*.jar"));
        File pluginFile = chooser.showOpenDialog(_pluginsAccordion.getScene().getWindow());
        System.out.println("Installing plugin from" + pluginFile.getAbsolutePath());
    }

    private void deactivatePlugin(int id)
    {
        System.out.println("Deactivating plugin " + id);
    }

    private void activatePlugin(int id)
    {
        System.out.println("Activate plugin " + id);
    }

    private void uninstallPlugin(int id)
    {
        System.out.println("uninstalling plugin with " + id);
        
    }

}
