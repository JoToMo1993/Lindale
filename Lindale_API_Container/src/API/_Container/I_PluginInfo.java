/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package API._Container;

import java.util.Calendar;

/**
 * @author  Morent Jochen <jochen.morent@students.fhv.at>
 * @org     FHV <fhv.at>
 * @project Lindale_API_Container
 * @date    16.12.2013
 */
public interface I_PluginInfo
{
    /**
     * @return the type of plugin [IO|FILTER|VIEW]
     */
    public E_PluginTyps  getType();
    /**
     * @param type the type of plugin [IO|FILTER|VIEW]
     */
    public void          setType(E_PluginTyps type);
    /**
     * @return name of the plugin
     */
    public String        getName();
    /**
     * @param name name of the plugin
     */
    public void          setName(String name);
    /**
     * @return version key of plugin
     */
    public String        getVersion();
    /**
     * @param version version key of plugin
     */
    public void          setVersion(String version);
    /**
     * @return path of plugin-jar (containing jar)
     */
    public String        getPath();
    /**
     * @param path path of plugin-jar (containing jar)
     */
    public void          setPath(String path);
    /**
     * @return the main class within the jar
     */
    public String        getStartClass();
    /**
     * @param start the main class within the jar
     */
    public void          setStartClass(String start);
    /**
     * @return stat of plugin [ACTIVATED|DEACTIVATED]
     */
    public E_PluginState getState();
    /**
     * @param state stat of plugin [ACTIVATED|DEACTIVATED]
     */
    public void          setState(E_PluginState state);
    /**
     * @return the date of installing the plugin
     */
    public Calendar      getInstalDate();
    /**
     * @param date the date of installing the plugin
     */
    public void          setInstalDate(Calendar date);
}
