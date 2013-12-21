/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.fhv.lindale.gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Accordion;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TitledPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 *
 * @author Morent Jochen <jochen.morent@students.fhv.at>
 */
public class MainWindowController implements Initializable
{

    @FXML
    private MenuBar _menuBar;
    @FXML
    private ScrollPane _pluginsScrollPane;
    @FXML
    private Accordion _pluginsAccordion;
    //Used for creating mouse events see addPlugins
    private int _pluginIndex = 0;

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO

    }

    // Parameters will change
    public void addPlugins(HashMap<String, ArrayList<String>> plugins)
    {
        Iterator<String> itr = plugins.keySet().iterator();
        while (itr.hasNext())
        {
            String pluginName = itr.next();
            _pluginIndex = 0;
            ArrayList<String> pluginViews = plugins.get(pluginName);
            VBox pluginBox = new VBox();
            ArrayList<Label> viewLabels = new ArrayList<>();
            for (;_pluginIndex < pluginViews.size(); _pluginIndex++)
            {
                
                Label currentLabel = new Label(pluginViews.get(_pluginIndex));
                currentLabel.setOnMouseClicked(new EventHandler<MouseEvent>()
                {
                    private final int _pluginIndex = MainWindowController.this._pluginIndex;
                    @Override
                    public void handle(MouseEvent t)
                    {
                        
                        System.out.println("Loading plugin at index "+ _pluginIndex);
                        //TODO: Plugin.getView(_pluginIndex) goes here
                    }
                });
                viewLabels.add(currentLabel);
            }
            pluginBox.getChildren().addAll(viewLabels);
            TitledPane pluginPane = new TitledPane(pluginName, pluginBox);
            _pluginsAccordion.getPanes().add(pluginPane);
        }
    }

}
