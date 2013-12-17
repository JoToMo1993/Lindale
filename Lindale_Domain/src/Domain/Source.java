/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Domain;

import API._Container.I_Source;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author  Morent Jochen <jochen.morent@students.fhv.at>
 * @org     FHV <fhv.at>
 * @project Lindale_Domain
 * @date    16.12.2013
 */
@Entity
@Table(name="SOURCE")
public class Source implements I_Source, Serializable
{
    @Column(name = "SID")
    @Id
    private int    _ID;
    @Column(name = "ROOT_DIR")
    private String _path;
    
    @Override
    public String getPath()
    {
        return _path;
    }
    @Override
    public void setPath(String path)
    {
        _path = path;
    }
    @Override
    public int getID()
    {
        return _ID;
    }
}
