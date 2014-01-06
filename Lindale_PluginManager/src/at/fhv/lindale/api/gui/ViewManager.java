/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package at.fhv.lindale.api.gui;

import at.fhv.lindale.api.plugin.I_Plugin_View;
import java.util.List;

/**
 * @author  Morent Jochen <jochen.morent@students.fhv.at>
 * @org     FHV <fhv.at>
 * @project Lindale_PluginManager
 * @date    05.01.2014
 */
public interface ViewManager
{
    public void addViewList (I_Plugin_View plugin, List<String> viewTitles);
    public void setSerchList(I_Plugin_View plugin, List<String> searchItemList);
}
