/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Domain;

import API._Container.I_File;
import API._Container.I_Source;
import java.io.Serializable;
import java.util.Map;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author  Morent Jochen <jochen.morent@students.fhv.at>
 * @org     FHV <fhv.at>
 * @project Lindale_Domain
 * @date    17.12.2013
 */
@Entity
@Table(name="COLLECTION")
public class StandardFile implements I_File, Serializable
{
    @Column(name = "CID")
    @Id
    private int      _ID;
    @JoinColumn(name = "FSID", referencedColumnName = "SID")
    @ManyToOne
    private I_Source _source;
    @Column(name = "FILE_PATH")
    private String   _path;
    @Column(name = "MATADATA")
    private String   _metaDataJSON;
    @Column(name = "CHECKSUM")
    private String   _checksum;
    
    @Override
    public I_Source getSource()
    {
        return _source;
    }
    @Override
    public void setSource(I_Source src)
    {
        _source = src;
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
    @Override
    public String getHash()
    {
        return _checksum;
    }
    @Override
    public void setHash(String hash)
    {
        _checksum = hash;
    }
    @Override
    public String getMetaData(String tag)
    {
        if("JSON".equals(tag.toUpperCase()))
        {
            return _metaDataJSON;
        }
        return null;
    }
    @Override
    public void setMetaData(String tag, String meta)
    {
        if("JSON".equals(tag.toUpperCase()))
        {
            _metaDataJSON = meta;
        }
    }
    @Override
    public int getID()
    {
        return _ID;
    }
}
