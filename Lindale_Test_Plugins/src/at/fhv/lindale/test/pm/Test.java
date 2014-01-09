/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package at.fhv.lindale.test.pm;

import at.fhv.lindale.impl.pm.PluginManager;

/**
 * @author  Morent Jochen <jochen.morent@students.fhv.at>
 * @org     FHV <fhv.at>
 * @project Lindale_PluginManager
 * @date    06.01.2014
 */
public class Test
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        PluginManager pm = new PluginManager();
        pm.loadPlugins(new TestVM());
    }
}
