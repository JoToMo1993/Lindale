/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Domain;

import API._Container.I_Source;
<<<<<<< HEAD
=======
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
>>>>>>> 2013_12_17 - Domain Implimentation

/**
 * @author  Morent Jochen <jochen.morent@students.fhv.at>
 * @org     FHV <fhv.at>
 * @project Lindale_Domain
 * @date    16.12.2013
 */
<<<<<<< HEAD
public class Source implements I_Source
{
    
    
=======
@Entity
@Table(name="SOURCE")
public class Source implements I_Source, Serializable
{
    @Column(name = "SID")
    @Id
    private int    _ID;
    @Column(name = "ROOT_DIR")
    private String _path;
>>>>>>> 2013_12_17 - Domain Implimentation
    
    @Override
    public String getPath()
    {
<<<<<<< HEAD
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
=======
        return _path;
>>>>>>> 2013_12_17 - Domain Implimentation
    }
    @Override
    public void setPath(String path)
    {
<<<<<<< HEAD
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
=======
        _path = path;
>>>>>>> 2013_12_17 - Domain Implimentation
    }
    @Override
    public int getID()
    {
<<<<<<< HEAD
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void setID(int ID)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
=======
        return _ID;
>>>>>>> 2013_12_17 - Domain Implimentation
    }
}
