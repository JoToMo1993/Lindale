/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.fhv.lindale.gui;

import java.util.ArrayList;
import java.util.HashMap;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Morent Jochen <jochen.morent@students.fhv.at>
 */
public class LindaleGUI extends Application
{

    @Override
    public void start(Stage stage) throws Exception
    {
        //http://stackoverflow.com/questions/10751271/accessing-fxml-controller-class
        FXMLLoader loader = new FXMLLoader();
        Parent root = (Parent) loader.load(getClass().getResourceAsStream("MainWindow.fxml"));
        MainWindowController mainController = (MainWindowController) loader.getController();
//        Parent root = FXMLLoader.load(getClass().getResource("MainWindow.fxml"));
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

        Scene scene = new Scene(root);

        stage.setScene(scene);
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

}
