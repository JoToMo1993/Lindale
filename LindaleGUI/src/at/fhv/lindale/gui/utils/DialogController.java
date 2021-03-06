/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.fhv.lindale.gui.utils;

import at.fhv.lindale.gui.LindaleGUI;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Georgi Georgiev <georgi.georgiev@students.fhv.at>
 */
public class DialogController implements Initializable
{

    @FXML
    private Text _msgText;
    @FXML
    private ImageView _img;
    @FXML
    private Button _btn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
    }

    public void setMsg(String msg)
    {
        _msgText.setText(msg);
    }

    public void setBtnText(String text)
    {
        _btn.setText(text);
    }

    public void setImg(Image image)
    {
        _img.setImage(image);

    }

    public Button getButton()
    {
        return _btn;
    }

}
