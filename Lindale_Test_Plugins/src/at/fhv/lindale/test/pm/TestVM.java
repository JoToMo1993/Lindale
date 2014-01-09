/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package at.fhv.lindale.test.pm;

import at.fhv.lindale.api.gui.ViewManager;
import at.fhv.lindale.api.plugin.I_Plugin_View;
import java.util.List;

/**
 * @author  Morent Jochen <jochen.morent@students.fhv.at>
 * @org     FHV <fhv.at>
 * @project Lindale_PluginManager
 * @date    06.01.2014
 */
public class TestVM implements ViewManager
{
    @Override
    public void addViewList(I_Plugin_View plugin, List<String> viewTitles)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void setSerchList(I_Plugin_View plugin, List<String> searchItemList)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
