/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package at.fhv.lindale.gui;

import at.fhv.lindale.api.container.E_PluginState;
import at.fhv.lindale.api.container.E_PluginTypes;
import at.fhv.lindale.api.container.I_Collection;
import at.fhv.lindale.api.container.I_File;
import at.fhv.lindale.api.container.I_PluginInfo;
import at.fhv.lindale.api.container.I_Source;
import at.fhv.lindale.api.hf.I_HibernateFacade;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * @author  Georgi Georgiev <georgi.georgiev@students.fhv.at>
 * @org     FHV <fhv.at>
 * @project Lindale_GUI
 * @date    23-Dec-2013
 */
public class FakeFacade implements I_HibernateFacade{

    @Override
    public List<I_File> loadAll_Files()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<I_PluginInfo> loadAll_PluginInfos()
    {
        Calendar cal = Calendar.getInstance();
        cal.set(2012, 6, 30);
        FakePluginInfo plugin1 = new FakePluginInfo(E_PluginTypes.IO_PLUGIN, "MP3IO", "1.2", null, null, E_PluginState.ACTIVATED, cal, 1);
        cal.set(2013, 9, 9);
        FakePluginInfo plugin2 = new FakePluginInfo(E_PluginTypes.FILTER_PLUGIN, "MP3_Filter", "2.2", null, null, E_PluginState.DEACTIVATED, cal, 2);
        cal.set(6, 6, 2011);
        FakePluginInfo plugin3 = new FakePluginInfo(E_PluginTypes.VIEW_PLUGIN, "MP3_View", "1.0", null, null, E_PluginState.ACTIVATED, cal, 3);
        ArrayList<I_PluginInfo> result = new ArrayList<>();
        result.add(plugin3);
        result.add(plugin2);
        result.add(plugin1);
        return  result;
    }

    @Override
    public List<I_Collection> loadAll_Collections()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<I_Source> loadAll_Source()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public I_File loadByID_File(int ID)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public I_PluginInfo loadByID_PluginInfo(int ID)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public I_Collection loadByID_Collection(int ID)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public I_Source loadByID_Source(int ID)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveAll_Files(List<I_File> files)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveAll_PluginInfos(List<I_PluginInfo> pluginInfos)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveAll_Collections(List<I_Collection> collections)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveAll_Sources(List<I_Source> sources)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveFile(I_File file)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void savePluginInfo(I_PluginInfo pluginInfo)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveCollection(I_Collection collection)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveSource(I_Source source)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
