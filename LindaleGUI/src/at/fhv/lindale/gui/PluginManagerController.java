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
import javafx.scene.control.Accordion;

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

    public void fillPluginInfo()
    {
        List<I_PluginInfo> pluginInfos = _facade.loadAll_PluginInfos();
        for (I_PluginInfo current : pluginInfos)
        {
            TitledPane pane = new TitledPane();
            pane.setText(current.getName() + "\t" + current.getState() + "\t" + current.getVersion());
            _pluginsAccordion.getPanes().add(pane);
            
        }
    }

}
