/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Domain;

import API._Container.E_PluginState;
import API._Container.E_PluginTypes;
import API._Container.I_PluginInfo;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 * @author  Morent Jochen <jochen.morent@students.fhv.at>
 * @org     FHV <fhv.at>
 * @project Lindale_Domain
 * @date    17.12.2013
 */
@Entity
@Table(name="PLUGIN")
public class PluginInfo implements I_PluginInfo
{
    @Column(name = "PID")
    @Id
    private int           _ID;
    @Column(name = "STATE", columnDefinition = "enum('ACTIVATED','DEACTIVATED')")
    @Enumerated(EnumType.STRING)
    private E_PluginState _state;
    @Column(name = "TYPE", columnDefinition = "enum('IO_PLUGIN',"
                                                 + "'FILERT_PLUGNIN',"
                                                 + "'VIEW_PLUGIN')")
    @Enumerated(EnumType.STRING)
    private E_PluginTypes _type;
    @Column(name = "INSTALLED_ON")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar      _instaledDate;
    @Column(name = "VERSION")
    private String        _version;
    @Column(name = "NAME")
    private String        _name;
    @Column(name = "PLUGIN_PATH")
    private String        _pluginPath;
    @Column(name = "PLUGIN_TABLE")
    private String        _pluginTabel;
    @Column(name = "START_CLASS")
    private String        _startClass;
    
    
    @Override
    public E_PluginTypes getType()
    {
        return _type;
    }
    @Override
    public void setType(E_PluginTypes type)
    {
        _type = type;
    }
    @Override
    public String getName()
    {
        return _name;
    }
    @Override
    public void setName(String name)
    {
        _name = name;
    }
    @Override
    public String getVersion()
    {
        return _version;
    }
    @Override
    public void setVersion(String version)
    {
        _version = version;
    }
    @Override
    public String getPath()
    {
        return _pluginPath;
    }
    @Override
    public void setPath(String path)
    {
        _pluginPath = path;
    }
    @Override
    public String getStartClass()
    {
        return _startClass;
    }
    @Override
    public void setStartClass(String start)
    {
        _startClass = start;
    }
    @Override
    public E_PluginState getState()
    {
        return _state;
    }
    @Override
    public void setState(E_PluginState state)
    {
        _state = state;
    }
    @Override
    public Calendar getInstalDate()
    {
        return _instaledDate;
    }
    @Override
    public void setInstalDate(Calendar date)
    {
        _instaledDate = date;
    }
}
