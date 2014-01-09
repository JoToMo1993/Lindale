/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package at.fhv.lindale.impl.pm;

import at.fhv.lindale.api.container.E_PluginState;
import at.fhv.lindale.api.container.I_PluginInfo;
import at.fhv.lindale.api.gui.ViewManager;
import at.fhv.lindale.api.hf.HibernateFactory;
import at.fhv.lindale.api.hf.I_HibernateFacade;
import at.fhv.lindale.api.plugin.I_Plugin;
import at.fhv.lindale.api.plugin.I_Plugin_Filter;
import at.fhv.lindale.api.plugin.I_Plugin_IO;
import at.fhv.lindale.api.plugin.I_Plugin_View;
import at.fhv.lindale.api.plugin.utils.I_PluginManager;
import at.fhv.lindale.impl.hf.HibernateFacade;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.ServiceLoader;

/**
 * @author  Morent Jochen <jochen.morent@students.fhv.at>
 * @org     FHV <fhv.at>
 * @project Lindale_PluginManager
 * @date    05.01.2014
 */
public class PluginManager implements I_PluginManager
{
    private final ServiceLoader<I_Plugin_IO>         _pluginLoader_IO;
    private final ServiceLoader<I_Plugin_Filter>     _pluginLoader_Filter;
    private final ServiceLoader<I_Plugin_View>       _pluginLoader_View;
    
    private final Map<String, List<I_Plugin_IO    >> _ioExtention;
    private final Map<String, List<I_Plugin_Filter>> _filterExtention;
    private final List<I_Plugin_Filter>              _autoFilter;

    private final List<I_Plugin_IO    >              _ioPlugins;
    private final List<I_Plugin_Filter>              _filterPlugins;
    private final List<I_Plugin_View  >              _viewPlugins;
    
    private       ViewManager                        _viewManager;
    
    public PluginManager()
    {
        _pluginLoader_IO     = ServiceLoader.load(I_Plugin_IO    .class);
        _pluginLoader_Filter = ServiceLoader.load(I_Plugin_Filter.class);
        _pluginLoader_View   = ServiceLoader.load(I_Plugin_View  .class);
        
        _ioExtention         = new HashMap<>();
        _filterExtention     = new HashMap<>();
        _autoFilter          = new LinkedList<>();
        
        _ioPlugins           = new LinkedList<>();
        _filterPlugins       = new LinkedList<>();
        _viewPlugins         = new LinkedList<>();
    }
    
    public List<I_Plugin> loadPlugins(ViewManager vm)
    {
        _viewManager = vm;
        
        LinkedList<I_Plugin    > pluginsLoaded = new LinkedList<>();
        HibernateFacade          hf            =
                (HibernateFacade) HibernateFactory.GET_HIBERNATE_FACADE();
        List      <I_PluginInfo> pluginsDB     = hf.loadAll_PluginInfos();
        
        if(pluginsDB == null)
        {
            pluginsDB = new LinkedList<>();
        }
        
        int lastSize = pluginsLoaded.size();
        do
        {
            lastSize = pluginsLoaded.size();
            for(I_Plugin_IO     plugin : _pluginLoader_IO    )
            {
                if(pluginsLoaded.containsAll(plugin.getDependencies()))
                {
                    pluginsLoaded.add(plugin);
                    _ioPlugins.add(plugin);
                    if(!pluginsDB.contains(plugin.getPluginInfo()))
                    {
                        plugin.setup();
                        pluginsDB.add(plugin.getPluginInfo());
                    }
                    E_PluginState state = pluginsDB.get(pluginsDB.indexOf(plugin))
                                                   .getState();
                    if(state == E_PluginState.ACTIVATED)
                    {
                        plugin.activate(this);
                    }
                }
            }
            for(I_Plugin_Filter plugin : _pluginLoader_Filter)
            {
                if(pluginsLoaded.containsAll(plugin.getDependencies()))
                {
                    pluginsLoaded.add(plugin);
                    _filterPlugins.add(plugin);
                    if(!pluginsDB.contains(plugin.getPluginInfo()))
                    {
                        plugin.setup();
                        pluginsDB.add(plugin.getPluginInfo());
                    }
                    E_PluginState state = pluginsDB.get(pluginsDB.indexOf(plugin))
                                                   .getState();
                    if(state == E_PluginState.ACTIVATED)
                    {
                        plugin.activate(this);
                    }
                }
            }
            for(I_Plugin_View   plugin : _pluginLoader_View  )
            {
                if(pluginsLoaded.containsAll(plugin.getDependencies()))
                {
                    pluginsLoaded.add(plugin);
                    _viewPlugins.add(plugin);
                    if(!pluginsDB.contains(plugin.getPluginInfo()))
                    {
                        plugin.setup();
                        pluginsDB.add(plugin.getPluginInfo());
                    }
                    E_PluginState state = pluginsDB.get(pluginsDB.indexOf(plugin))
                                                   .getState();
                    if(state == E_PluginState.ACTIVATED)
                    {
                        plugin.activate(this);
                    }
                }
            }
        } while(lastSize != pluginsLoaded.size());
        
        return pluginsLoaded;
    }
    @Override
    public void addExtention(I_Plugin_IO plugin, String extention)
    {
        List<I_Plugin_IO> list = _ioExtention.get(extention);
        
        if(list == null)
        {
            list = new LinkedList<>();
        }
        
        list.add(plugin);
        
        _ioExtention.put(extention, list);
    }
    @Override
    public void addExtentionList(I_Plugin_Filter plugin, List<String> extentions)
    {
        for(String ext : extentions)
        {
            List<I_Plugin_Filter> list = _filterExtention.get(ext);
            
            if(list == null)
            {
                list = new LinkedList<>();
            }
            
            list.add(plugin);
            
            _filterExtention.put(ext, list);
        }
    }
    @Override
    public void addAutoFilter(I_Plugin_Filter plugin)
    {
        _autoFilter.add(plugin);
    }
    @Override
    public void addViewList(I_Plugin_View plugin, List<String> viewTitles)
    {
        if(_viewManager != null)
        {
            _viewManager.addViewList(plugin, viewTitles);
        }
    }
    @Override
    public void setSerchList(I_Plugin_View plugin, List<String> searchItemList)
    {
        if(_viewManager != null)
        {
            _viewManager.setSerchList(plugin, searchItemList);
        }
    }
    @Override
    public List<String> getExtentionList()
    {
        return new LinkedList<>(_ioExtention.keySet());
    }
    @Override
    public List<I_Plugin_Filter> getFilterList()
    {
        return _filterPlugins;
    }
}
