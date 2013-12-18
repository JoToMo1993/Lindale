/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package API._HibernateFacade;

import API._Container.I_Collection;
import API._Container.I_File;
import API._Container.I_PluginInfo;
import API._Container.I_Source;
import java.util.List;

/**
 * @author  Morent Jochen <jochen.morent@students.fhv.at>
 * @org     FHV <fhv.at>
 * @project Lindale_API_Hibernate
 * @date    17.12.2013
 */
public interface I_HibernateFacade
{
    public List<I_File      > loadAll_Files         ();
    public List<I_PluginInfo> loadAll_PluginInfos   ();
    public List<I_Collection> loadAll_Collections   ();
    public List<I_Source    > loadAll_Source        ();
    
    public I_File             loadByID_File         (int ID);
    public I_PluginInfo       loadByID_PluginInfo   (int ID);
    public I_Collection       loadByID_Collection   (int ID);
    public I_Source           loadByID_Source       (int ID);
    
    public void saveAll_Files       (List<I_File      > files       );
    public void saveAll_PluginInfos (List<I_PluginInfo> pluginInfos );
    public void saveAll_Collections (List<I_Collection> collections );
    public void saveAll_Sources     (List<I_Source    > sources     );
    
    public void saveFile            (I_File         file        );
    public void savePluginInfo      (I_PluginInfo   pluginInfo  );
    public void saveCollection      (I_Collection   collection  );
    public void saveSource          (I_Source       source      );
}
