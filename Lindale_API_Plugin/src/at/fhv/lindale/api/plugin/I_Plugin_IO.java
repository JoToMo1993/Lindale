/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package at.fhv.lindale.api.plugin;

import at.fhv.lindale.api.container.I_File;

/**
 * @author  Morent Jochen <jochen.morent@students.fhv.at>
 * @org     FHV <fhv.at>
 * @project Lindale_Plugin_API
 * @date    16.12.2013
 */
public interface I_Plugin_IO
{
    public I_File fillMetaTags(I_File file);
}
