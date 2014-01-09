/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.fhv.lindale.gui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.xnap.commons.i18n.I18n;
import org.xnap.commons.i18n.I18nFactory;

/**
 *
 * @author Morent Jochen <jochen.morent@students.fhv.at>
 */
public class LindaleGUI extends Application
{

    public static final String GRAPHICS_LOCATION = "/at/fhv/lindale/gui/graphics/";
    public static final String CONIFG_LOCATION = "config.properties";
    public static final String MESSAGES = "at.fhv.lindale.i18n.Messages";
    private Properties _config;

    @Override
    public void start(Stage stage) throws Exception
    {
        _config = loadConfig(new File(CONIFG_LOCATION));
        String[] localeString = _config.getProperty("languages.enabled").split("_");
        I18n translator = I18nFactory.getI18n(getClass(), MESSAGES, new Locale(localeString[0], localeString[1]));
        //http://stackoverflow.com/questions/10751271/accessing-fxml-controller-class
        FXMLLoader loader = new FXMLLoader();
        Parent root = (Parent) loader.load(getClass().getResourceAsStream("MainWindow.fxml"));
        MainWindowController mainController = loader.getController();
        mainController.setTranslator(translator);
        mainController.setConfigProperty(_config);
        mainController.translateGUI();
        //For Testing
        HashMap<String, ArrayList<String>> pluginMap = new HashMap();
        ArrayList<String> musicPlugin = new ArrayList<>();
        musicPlugin.add("Artist");
        musicPlugin.add("Titile");
        musicPlugin.add("Genre");
        pluginMap.put("Music", musicPlugin);
        ArrayList<String> moviePlugin = new ArrayList<>();
        moviePlugin.add("Genre");
        moviePlugin.add("Title");
        pluginMap.put("Movies", moviePlugin);
        mainController.addPlugins(pluginMap);
        mainController.setFacade(new FakeFacade());
        //Test ends here do NOT delete the code below
        stage.setScene(new Scene(root));
        stage.setTitle("Lindale");

        stage.getScene().getWindow().setOnCloseRequest(new EventHandler<WindowEvent>()
        {

            @Override
            public void handle(WindowEvent t)
            {
                try
                {
                    File configFile = new File(CONIFG_LOCATION);
                    if (!configFile.exists())
                    {

                        configFile.createNewFile();
                    }
                    _config.store(new FileOutputStream(configFile), null);
                } catch (IOException ex)
                {
                    Logger.getLogger(LindaleGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        stage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application. main() serves only as fallback in case the application can not be launched through
     * deployment artifacts, e.g., in IDEs with limited FX support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        launch(args);
    }

    private Properties loadConfig(File file) throws IOException
    {
        Properties defaults = new Properties();
        defaults.setProperty("languages.available", "en_us,de_de,bg_bg,fr_fr");
        defaults.setProperty("languages.enabled", "en_us");
        defaults.setProperty("advanced.enabled", "false");
        defaults.setProperty("advanced.copy", "false");
        defaults.setProperty("advanced.rename", "false");
        defaults.setProperty("advanced.move", "false");
        defaults.setProperty("advanced.delete", "false");
        defaults.setProperty("player.name", "");
        defaults.setProperty("player.command", "");

        if (!file.exists())
        {
            Properties config = new Properties(defaults);
            return config;
        } else
        {
            Properties config = new Properties(defaults);
            config.load(new FileInputStream(file));
            return config;
        }

    }

}
