/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.fhv.lindale.gui;

import at.fhv.lindale.api.hf.I_HibernateFacade;
import java.util.Properties;
import org.xnap.commons.i18n.I18n;

/**
 * @author Georgi Georgiev <georgi.georgiev@students.fhv.at>
 * @org FHV <fhv.at>
 * @project Lindale_GUI
 * @date 23-Dec-2013
 */
public interface I_ControllerSetters
{

    public void setTranslator(I18n translator);

    public void setFacade(I_HibernateFacade facade);
    
    public void setConfigProperty (Properties config);
    
 

}
