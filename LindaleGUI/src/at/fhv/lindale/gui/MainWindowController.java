/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.fhv.lindale.gui;

import at.fhv.lindale.api.hf.I_HibernateFacade;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TitledPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.xnap.commons.i18n.I18n;

/**
 *
 * @author Georgi Georgiev <georgi.georgiev@students.fhv.at>
 */
public class MainWindowController implements Initializable, I_ControllerSetters
{

    @FXML
    private MenuBar _menuBar;
    @FXML
    private ScrollPane _pluginsScrollPane;
    @FXML
    private Accordion _pluginsAccordion;
    @FXML
    private Pane _viewPluginPane;
    @FXML
    private ScrollPane _errorScrollPane;
    @FXML
    private ListView _errorListView;

    private I18n _translator;

    private I_HibernateFacade _facade;

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
            for (; _pluginIndex < pluginViews.size(); _pluginIndex++)
            {

                Label currentLabel = new Label(pluginViews.get(_pluginIndex));
                currentLabel.setOnMouseClicked(new EventHandler<MouseEvent>()
                {
                    private final int _pluginIndex = MainWindowController.this._pluginIndex;

                    @Override
                    public void handle(MouseEvent t)
                    {

                        System.out.println("Loading plugin at index " + _pluginIndex);
                        //TODO: Plugin.getView(_pluginIndex) goes here
                    }
                });
                viewLabels.add(currentLabel);
            }
            pluginBox.getChildren().addAll(viewLabels);
            TitledPane pluginPane = new TitledPane(pluginName, pluginBox);
            _pluginsAccordion.getPanes().add(pluginPane);
        }
        //Fixed in FXML
//        _pluginsScrollPane.setFitToWidth(true);
//        _errorScrollPane.setFitToHeight(true);
//        _errorScrollPane.setFitToWidth(true);

    }

    public void setTranslator(I18n translator)
    {
        if (_translator == null)
        {
            _translator = translator;
            translateGui();
        }

    }

    public void setFacade (I_HibernateFacade facede)
    {
        _facade = facede;
    }

    private void translateGui()
    {
        ObservableList<Menu> menus = _menuBar.getMenus();
        for (Menu currentMenu : menus)
        {
            currentMenu.setText(_translator.tr(currentMenu.getText()));
            ObservableList<MenuItem> items = currentMenu.getItems();
            for (MenuItem currentItem : items)
            {
                currentItem.setText(_translator.tr(currentItem.getText()));
            }
        }
    }

    @FXML
    public void showAbout(ActionEvent e)
    {
    }

    @FXML
    public void showHelp(ActionEvent e)
    {
    }

    @FXML
    public void exit(ActionEvent e)
    {
        Platform.exit();
    }

    @FXML
    public void newCollection(ActionEvent e) throws IOException
    {
        // StgeStyle remove minimaze and maximaze button from window decoration
        Stage stage = new Stage(StageStyle.UTILITY);
        stage.setTitle("New Collection");
        stage.setResizable(false);
        stage.initModality(Modality.APPLICATION_MODAL);
        Pane root = FXMLLoader.load(getClass().getResource("NewCollectionDialog.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    public void addMode(ActionEvent e)
    {
    }

    @FXML
    public void deleteCollection(ActionEvent e)
    {
    }

    @FXML
    public void showSettings(ActionEvent e) throws IOException
    {
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(new Scene((Parent) FXMLLoader.load(getClass().getResource("SettingsWindow.fxml"))));
        stage.setTitle("Settings");
        stage.show();
    }

    @FXML
    public void showPluginManager(ActionEvent e) throws IOException, Exception
    {
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.initModality(Modality.APPLICATION_MODAL);
        FXMLLoader loader = new FXMLLoader();
        Parent parent = (Parent)loader.load(getClass().getResourceAsStream("PluginManager.fxml"));
        stage.setScene(new Scene(parent));
        PluginManagerController pluginManagerController = loader.getController();
        pluginManagerController.setFacade(_facade);
        pluginManagerController.setTranslator(_translator);
        pluginManagerController.fillPluginInfo();
        stage.setTitle("PluginManager");
        stage.show();
    }

    @FXML
    public void showSourceManager(ActionEvent e)
    {
    }

}
