/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package API._Plugin;

import API._Container.I_File;
import java.util.List;

/**
 * @author  Morent Jochen <jochen.morent@students.fhv.at>
 * @org     FHV <fhv.at>
 * @project Lindale_Plugin_API
 * @date    16.12.2013
 */
public interface I_Plugin_Filter
{
    public List<I_File> filter(List<I_File> files);
}
