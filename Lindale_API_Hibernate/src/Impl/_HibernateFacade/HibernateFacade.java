/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Impl._HibernateFacade;

import API._Container.I_Collection;
import API._Container.I_Container;
import API._Container.I_File;
import API._Container.I_PluginInfo;
import API._Container.I_Source;
import API._HibernateFacade.I_HibernateFacade;
import Domain.Collection;
import Domain.PluginInfo;
import Domain.Source;
import Domain.StandardFile;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

/**
 * @author  Morent Jochen <jochen.morent@students.fhv.at>
 * @org     FHV <fhv.at>
 * @project Lindale_API_Hibernate
 * @date    17.12.2013
 */
public final class HibernateFacade implements I_HibernateFacade
{
    private static HibernateFacade hibernateFacade;
    
    /**
     * @return singelton HibernateFacade
     */
    public  synchronized static final HibernateFacade GET_HIBERNATE_FACADE()
    {
        if(hibernateFacade == null)
        {
            hibernateFacade = new HibernateFacade();
        }
        return hibernateFacade;
    }
    
    private final SessionFactory sessionFactory;
    
    private HibernateFacade()
    {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }
    
    @Override
    public List<I_File>         loadAll_Files       ()
    {
        Session        session = null;
        List<I_File>   ret     = null;
        try {
            session = sessionFactory.openSession();
            
            ret = session.createCriteria(StandardFile.class).list();
        } catch(HibernateException ex) {
            
        } finally {
            if(session != null)
            {
                session.close();
            }
        }
        return ret;
    }
    @Override
    public List<I_PluginInfo>   loadAll_PluginInfos ()
    {
        Session             session = null;
        List<I_PluginInfo>  ret     = null;
        try {
            session = sessionFactory.openSession();
            
            ret = session.createCriteria(PluginInfo.class).list();
        } catch(HibernateException ex) {
            
        } finally {
            if(session != null)
            {
                session.close();
            }
        }
        return ret;
    }
    @Override
    public List<I_Collection>   loadAll_Collections ()
    {
        Session             session = null;
        List<I_Collection>  ret     = null;
        try {
            session = sessionFactory.openSession();
            
            ret = session.createCriteria(Collection.class).list();
        } catch(HibernateException ex) {
            
        } finally {
            if(session != null)
            {
                session.close();
            }
        }
        return ret;
    }
    @Override
    public List<I_Source>       loadAll_Source      ()
    {
        Session        session = null;
        List<I_Source> ret     = null;
        try {
            session = sessionFactory.openSession();
            
            ret = session.createCriteria(Source.class).list();
        } catch(HibernateException ex) {
            
        } finally {
            if(session != null)
            {
                session.close();
            }
        }
        return ret;
    }

    @Override
    public I_File               loadByID_File       (int ID)
    {
        Session session = null;
        I_File  ret     = null;
        try {
            session = sessionFactory.openSession();
            
            ret = (I_File) session.createCriteria(StandardFile.class)
                                  .add( Restrictions.idEq(ID))
                                  .uniqueResult();
        } catch(HibernateException ex) {
            
        } finally {
            if(session != null)
            {
                session.close();
            }
        }
        return ret;
    }
    @Override
    public I_PluginInfo         loadByID_PluginInfo (int ID)
    {
        Session      session = null;
        I_PluginInfo ret     = null;
        try {
            session = sessionFactory.openSession();
            
            ret = (I_PluginInfo) session.createCriteria(PluginInfo.class)
                                        .add( Restrictions.idEq(ID))
                                        .uniqueResult();
        } catch(HibernateException ex) {
            
        } finally {
            if(session != null)
            {
                session.close();
            }
        }
        return ret;
    }
    @Override
    public I_Collection         loadByID_Collection (int ID)
    {
        Session      session = null;
        I_Collection ret     = null;
        try {
            session = sessionFactory.openSession();
            
            ret = (I_Collection) session.createCriteria(Collection.class)
                                        .add( Restrictions.idEq(ID))
                                        .uniqueResult();
        } catch(HibernateException ex) {
            
        } finally {
            if(session != null)
            {
                session.close();
            }
        }
        return ret;
    }
    @Override
    public I_Source             loadByID_Source     (int ID)
    {
        Session  session = null;
        I_Source ret     = null;
        try {
            session = sessionFactory.openSession();
            
            ret = (I_Source) session.createCriteria(Source.class)
                                    .add( Restrictions.idEq(ID))
                                    .uniqueResult();
        } catch(HibernateException ex) {
            
        } finally {
            if(session != null)
            {
                session.close();
            }
        }
        return ret;
    }

    @Override
    public void saveAll_Files       (List<I_File        > files         )
    {
        for(I_File f : files)
        {
            saveFile(f);
        }
    }
    @Override
    public void saveAll_PluginInfos (List<I_PluginInfo  > pluginInfos   )
    {
        for(I_PluginInfo pi : pluginInfos)
        {
            savePluginInfo(pi);
        }
    }
    @Override
    public void saveAll_Collections (List<I_Collection  > collections   )
    {
        for(I_Collection c : collections)
        {
            saveCollection(c);
        }
    }
    @Override
    public void saveAll_Sources     (List<I_Source      > sources       )
    {
        for(I_Source s : sources)
        {
            saveSource(s);
        }
    }

    @Override
    public void saveFile        (I_File       file)
    {
        saveContainer(file);
    }
    @Override
    public void savePluginInfo  (I_PluginInfo pluginInfo)
    {
        saveContainer(pluginInfo);
    }
    @Override
    public void saveCollection  (I_Collection collection)
    {
        saveContainer(collection);
    }
    @Override
    public void saveSource      (I_Source     source)
    {
        saveContainer(source);
    }
    
    private void saveContainer  (I_Container  container)
    {
        Session        session = null;
        Transaction    tx      = null;
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            session.save(container);
            tx.commit();
        } catch(HibernateException ex) {
            if(tx != null)
            {
                tx.rollback();
            } 
        } finally {
            if(session != null)
            {
                session.close();
            }
        }
    }
}
