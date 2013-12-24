/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.fhv.lindale.gui;

import at.fhv.lindale.api.container.E_PluginState;
import at.fhv.lindale.api.container.E_PluginTypes;
import at.fhv.lindale.api.container.I_PluginInfo;
import java.util.Calendar;

/**
 * @author Georgi Georgiev <georgi.georgiev@students.fhv.at>
 * @org FHV <fhv.at>
 * @project Lindale_GUI
 * @date 23-Dec-2013
 */
public class FakePluginInfo implements I_PluginInfo
{

    private E_PluginTypes type;
    private String name;
    private String version;
    private String path;
    private String startClass;
    private E_PluginState state;
    private Calendar installDate;
    private int id;

    public FakePluginInfo(E_PluginTypes type, String name, String version, String path, String startClass, E_PluginState state, Calendar installDate, int id)
    {
        this.type = type;
        this.name = name;
        this.version = version;
        this.path = path;
        this.startClass = startClass;
        this.state = state;
        this.installDate = installDate;
        this.id = id;
    }

    @Override
    public E_PluginTypes getType()
    {
        return type;
    }

    @Override
    public void setType(E_PluginTypes type)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public void setName(String name)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getVersion()
    {
        return version;
    }

    @Override
    public void setVersion(String version)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getPath()
    {
        return path;
    }

    @Override
    public void setPath(String path)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getStartClass()
    {
        return startClass;
    }

    @Override
    public void setStartClass(String start)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E_PluginState getState()
    {
        return state;
    }

    @Override
    public void setState(E_PluginState state)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Calendar getInstalDate()
    {
        return installDate;
    }

    @Override
    public void setInstalDate(Calendar date)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getID()
    {
        return id;
    }

}
