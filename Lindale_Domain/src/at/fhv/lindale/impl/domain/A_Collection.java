/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package at.fhv.lindale.impl.domain;

import at.fhv.lindale.api.container.I_AbstractCollection;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import static javax.persistence.InheritanceType.SINGLE_TABLE;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author  Morent Jochen <jochen.morent@students.fhv.at>
 * @org     FHV <fhv.at>
 * @project Lindale_Domain
 * @date    20.12.2013
 */
@Entity
@Inheritance(strategy=SINGLE_TABLE)
@DiscriminatorColumn(name="CTYPE")
@Table(name="COLLECTION")
public abstract class A_Collection implements I_AbstractCollection, Serializable
{
    @ManyToMany
    private List<Collection> collections;
    @Column(name = "CID")
    @Id
    private int    _ID;

    @Override
    public int getID()
    {
        return _ID;
    }
}
