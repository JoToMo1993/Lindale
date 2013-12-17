/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Domain;

import API._Container.I_AbstractCollection;
import API._Container.I_Collection;
import API._Container.I_PluginInfo;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

/**
 * @author  Morent Jochen <jochen.morent@students.fhv.at>
 * @org     FHV <fhv.at>
 * @project Lindale_Domain
 * @date    17.12.2013
 */
@Entity
@Table(name="COLLECTION")
public class Collection implements I_Collection, Serializable
{
    @Column(name = "CID")
    @Id
    private int    _ID;
    @Column(name = "NAME")
    private String _name;
    @JoinTable(name = "TOPSUBCOLL",
               joinColumns        = {@JoinColumn(name = "CID",
                                                 referencedColumnName = "TCID")},
               inverseJoinColumns = {@JoinColumn(name = "CID",
                                                 referencedColumnName = "SCID")})
    List<I_AbstractCollection> _subs;
    
    @Override
    public String getName()
    {
        return _name;
    }
    @Override
    public void getName(String name)
    {
        _name = name;
    }
    @Override
    public List<I_AbstractCollection> getSubs()
    {
        return _subs;
    }
    @Override
    public void setSubs(List<I_AbstractCollection> subs)
    {
        _subs = subs;
    }
    @Override
    public String getRelatedPlugin()
    {
        //TODO noch keine Spalte in der Datenbank
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void setRelatedPlugin(I_PluginInfo plugin)
    {
        //TODO noch keine Spalte in der Datenbank
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public int getID()
    {
        return _ID;
    }
}
