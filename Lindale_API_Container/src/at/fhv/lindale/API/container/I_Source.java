/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package at.fhv.lindale.api.container;

/**
 * @author  Morent Jochen <jochen.morent@students.fhv.at>
 * @org     FHV <fhv.at>
 * @project Lindale_API_Container
 * @date    16.12.2013
 */
public interface I_Source extends I_Container
{
    /**
     * 
     * @return the absolut path to the root folder of this source
     */
    public String getPath();
    /**
     * 
     * @param path the new absolut path of the root folder
     */
    public void   setPath(String path);
//    public ______ getUserData();
//    public void   setUserData(______ UD);
}
