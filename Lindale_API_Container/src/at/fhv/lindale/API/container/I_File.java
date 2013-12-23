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
public interface I_File extends I_AbstractCollection
{
    /**
     * @return the source of the file (root-folder, login-data)
     */
    public I_Source getSource();
    /**
     * @param src the source of the file (root-folder, login-data)
     */
    public void     setSource(I_Source src);
    /**
     * @return relative path within the root-folder
     */
    public String   getPath();
    /**
     * @param path relative path within the root-folder
     */
    public void     setPath(String path);
    /**
     * @return concatenation of ther root-folder and the relative path
     */
    public String   getAbsolutPath();
    /**
     * @return hash of the file (used for duplicates)
     */
    public String   getMetaData(String tag);
    /**
     * @param tag the mata-data's tag ("JSON" is for the standard implementation)
     * @param meta the meta-data
     */
    public void     setMetaData(String tag, String meta);
}
