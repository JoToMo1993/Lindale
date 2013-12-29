/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.fhv.lindale.gui;

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
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Accordion;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;

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
        for (I_PluginInfo current : pluginInfos)
        {
            TitledPane titledPane = new TitledPane();
            titledPane.setText(current.getName() + "\t" + current.getState() + "\t" + current.getVersion());
            FXMLLoader loader = new FXMLLoader();
            GridPane infoPane = (GridPane) loader.load(getClass().getResourceAsStream("PluginInfoPane.fxml"));
            PluginInfoPaneController paneController = loader.getController();
            paneController.getPluginName().setText(current.getName());
            paneController.getPluginStatus().setText(current.getState().toString());
            paneController.getPluginVersion().setText(current.getVersion());
            switch (current.getType())
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
    }

}
