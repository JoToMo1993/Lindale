/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package API._HibernateFacade;

import Impl._HibernateFacade.HibernateFacade;

/**
 * @author  Morent Jochen <jochen.morent@students.fhv.at>
 * @org     FHV <fhv.at>
 * @project Lindale_API_Hibernate
 * @date    17.12.2013
 */
public class HibernateFactory
{
    /**
     * methode to get a data-base-connection
     * @return the connection to the data-base
     */
    public synchronized final static I_HibernateFacade GET_HIBERNATE_FACADE()
    {
        return HibernateFacade.GET_HIBERNATE_FACADE();
    }
}
