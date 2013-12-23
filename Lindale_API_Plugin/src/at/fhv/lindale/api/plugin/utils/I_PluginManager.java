/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package at.fhv.lindale.api.plugin.utils;

import at.fhv.lindale.api.plugin.I_Plugin_Filter;
import at.fhv.lindale.api.plugin.I_Plugin_IO;
import at.fhv.lindale.api.plugin.I_Plugin_View;
import java.util.List;

/**
 * @author  Morent Jochen <jochen.morent@students.fhv.at>
 * @org     FHV <fhv.at>
 * @project Lindale_Plugin_API
 * @date    16.12.2013
 */
public interface I_PluginManager
{
    public void addExtention    (I_Plugin_IO     plugin, String       extention );
    public void addExtentionList(I_Plugin_Filter plugin, List<String> extentions);
    public void addAutoFilter   (I_Plugin_Filter plugin);
    public void addViewList     (I_Plugin_View   plugin, List<String> viewTitles);
    public void setSerchList    (I_Plugin_View   plugin, List<String> searchItemList);
    
    public List<String         > getExtentionList();
    public List<I_Plugin_Filter> getFilterList();
}
