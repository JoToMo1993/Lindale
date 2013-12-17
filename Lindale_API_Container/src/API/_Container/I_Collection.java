/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package API._Container;

import java.util.List;

/**
 * @author  Morent Jochen <jochen.morent@students.fhv.at>
 * @org     FHV <fhv.at>
 * @project Lindale_API_Container
 * @date    16.12.2013
 */
public interface I_Collection extends I_AbstractCollection
{
    /**
     * @return the collection's name
     */
    public String getName();
    /**
     * @param name the collection's
     */
    public void   getName(String name);
    /**
     * @return list of all sub-collections [Collection|File]
     */
    public List<I_AbstractCollection> getSubs();
    /**
     * @param subs list of all sub-collections [Collection|File]
     */
    public void   setSubs(List<I_AbstractCollection> subs);
    /**
     * @return the plugin made this collection
     */
    public String getRelatedPlugin();
    /**
     * @param plugin the plugin made this collection
     */
    public void   setRelatedPlugin(I_PluginInfo plugin);
}
