/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package at.fhv.lindale.impl.domain;

import at.fhv.lindale.api.container.I_AbstractCollection;
import at.fhv.lindale.api.container.I_Collection;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 * @author  Morent Jochen <jochen.morent@students.fhv.at>
 * @org     FHV <fhv.at>
 * @project Lindale_Domain
 * @date    17.12.2013
 */
@Entity
@DiscriminatorValue("C")
public class Collection extends A_Collection 
                        implements I_Collection, Serializable
{
    @Column(name = "NAME")
    private String _name;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "TOPSUBCOLL",
               joinColumns        = {@JoinColumn(name = "TCID",
                                                 referencedColumnName = "CID")},
               inverseJoinColumns = {@JoinColumn(name = "SCID",
                                                 referencedColumnName = "CID")})
    List<A_Collection> _subs;
    
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
        return new LinkedList(_subs);
    }
    @Override
    public void setSubs(List<I_AbstractCollection> subs)
    {
        /*_subs = subs;*/
    }
}
