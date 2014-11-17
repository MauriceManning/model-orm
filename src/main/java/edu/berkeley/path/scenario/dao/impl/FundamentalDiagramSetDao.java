package edu.berkeley.path.scenario.dao.impl;

import edu.berkeley.path.model_objects.scenario.FundamentalDiagramProfile;
import edu.berkeley.path.scenario.dao.IFundamentalDiagramSetDao;

import edu.berkeley.path.scenario.model.IFundamentalDiagramSet;
import edu.berkeley.path.scenario.model.impl.FundamentalDiagramSet;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 *
 */
@Repository
public class FundamentalDiagramSetDao implements IFundamentalDiagramSetDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public IFundamentalDiagramSet getFundamentalDiagramSet(long fundamentalDiagramSetId) {
        final Logger logger = LogManager.getLogger(FundamentalDiagramSetDao.class.getName());
        IFundamentalDiagramSet fds = null;

        try{
            Session session = this.sessionFactory.getCurrentSession();

            Query query = session.createQuery("from FundamentalDiagramSet where ID = :id ");
            query.setParameter("id", fundamentalDiagramSetId);

            List<?> list = query.list();

            if ( ! list.isEmpty()) {
                fds = (IFundamentalDiagramSet)list.get(0);
            }

        } catch (Exception ex) {
            logger.info("FundamentalDiagramSetDao getFundamentalDiagramSet Exception ex: ",  ex.getMessage());
        }

        return fds;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<IFundamentalDiagramSet> getFundamentalDiagramSets() {
        final Logger logger = LogManager.getLogger(FundamentalDiagramSetDao.class.getName());
        List<IFundamentalDiagramSet> fdsList = null;

        try{
            Session session = this.sessionFactory.getCurrentSession();

            Query query = session.createQuery("from FundamentalDiagramSet ");

            fdsList = query.list();

        } catch (Exception ex) {
            logger.info("FundamentalDiagramSetDao getFundamentalDiagramSet Exception ex:",  ex.getMessage());
        }

        return fdsList;
    }

    @Override
    @SuppressWarnings("unchecked")
    public long addFundamentalDiagramSet( IFundamentalDiagramSet fds )
    {
        final Logger logger = LogManager.getLogger(FundamentalDiagramSetDao.class.getName());
        long fdsId = 0;

        try {

            Session session = this.sessionFactory.getCurrentSession();
            session.persist(fds);
            logger.info("FundamentalDiagramSetDao addFundamentalDiagramSet new id: " + fds.getId());
            logger.info("FundamentalDiagramSetDao addFundamentalDiagramSet new obj: " + fds.toString() );
            fdsId = fds.getId();


        } catch (Exception ex) {
            logger.info("FundamentalDiagramSetDao addFundamentalDiagramSet Exception ex: ",  ex.getMessage());
        }
        return fdsId;
    }

    @Override
    public void updateFundamentalDiagramSet( IFundamentalDiagramSet fds ) {
        final Logger logger = LogManager.getLogger(FundamentalDiagramSetDao.class.getName());

        try {

            Session session = this.sessionFactory.getCurrentSession();
            session.update(fds);

        } catch (Exception ex) {
            logger.info("FundamentalDiagramSetDao updateFundamentalDiagramSet Exception ex:",  ex.getMessage());
        }

    }

    @Override
    public void deleteFundamentalDiagramSet( IFundamentalDiagramSet fds ) {
        final Logger logger = LogManager.getLogger(FundamentalDiagramSetDao.class.getName());

        try {

            Session session = this.sessionFactory.getCurrentSession();
            session.delete(fds);

        } catch (Exception ex) {
            logger.info("FundamentalDiagramSetDao deleteFundamentalDiagramSet Exception ex:",  ex.getMessage());
        }
    }


    /**
     * Function to validate FD set.
     *
     * @return True if FD set is valid
     */
    public Boolean isValid() {
        // TODO: Implement, return true for now.
        return true;
    }



}
