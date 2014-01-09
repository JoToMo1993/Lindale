/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package at.fhv.lindale.test;

import at.fhv.lindale.api.container.I_Collection;
import at.fhv.lindale.api.container.I_File;
import at.fhv.lindale.api.hf.HibernateFactory;
import at.fhv.lindale.api.hf.I_HibernateFacade;
import java.util.List;

/**
 * @author  Morent Jochen <jochen.morent@students.fhv.at>
 * @org     FHV <fhv.at>
 * @project Lindale_API_Hibernate
 * @date    20.12.2013
 */
public class HibernateTest
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        I_HibernateFacade hibernate = HibernateFactory.GET_HIBERNATE_FACADE();
        
        List<I_Collection> col = hibernate.loadAll_Collections();
        
        for(I_Collection c : col)
        {
            System.out.println(c.getName());
        }
        
        List<I_File> file = hibernate.loadAll_Files();
        
        for(I_File f : file)
        {
            System.out.println(f.getPath());
        }
    }

}
