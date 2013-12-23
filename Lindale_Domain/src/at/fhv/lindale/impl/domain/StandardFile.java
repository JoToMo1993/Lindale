/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package at.fhv.lindale.impl.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author  Morent Jochen <jochen.morent@students.fhv.at>
 * @org     FHV <fhv.at>
 * @project Lindale_Domain
 * @date    17.12.2013
 */
@Entity
public class StandardFile extends A_File
{
    @Column(name = "METADATA")
    private String   _metaDataJSON;
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
}
