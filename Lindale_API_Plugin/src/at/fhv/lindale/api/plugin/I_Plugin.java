/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package at.fhv.lindale.api.plugin;

import at.fhv.lindale.api.utils.I_PluginManager;
import java.util.List;

/**
 * @author  Morent Jochen <jochen.morent@students.fhv.at>
 * @org     FHV <fhv.at>
 * @project Lindale_Plugin_API
 * @date    16.12.2013
 */
public interface I_Plugin
{
    public void           setup();
    public void           ativate(I_PluginManager pm);
    public List<I_Plugin> getDependencies();
}