/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package at.fhv.lindale.impl.domain;

import at.fhv.lindale.api.container.I_File;
import at.fhv.lindale.api.container.I_Source;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author  Morent Jochen <jochen.morent@students.fhv.at>
 * @org     FHV <fhv.at>
 * @project Lindale_Domain
 * @date    20.12.2013
 */
@Entity
@DiscriminatorValue("F")
public abstract class A_File extends A_Collection
                             implements I_File, Serializable
{
    @JoinColumn(name = "FSID", referencedColumnName = "SID")
    @ManyToOne
    private Source _source;
    @Column(name = "FILE_PATH")
    private String   _path;
    
    @Override
    public I_Source getSource()
    {
        return _source;
    }
    @Override
    public void setSource(I_Source src)
    {
        _source = (Source)src;
    }
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
    public String getAbsolutPath()
    {
        return _source.getPath() + _path;
    }
}
