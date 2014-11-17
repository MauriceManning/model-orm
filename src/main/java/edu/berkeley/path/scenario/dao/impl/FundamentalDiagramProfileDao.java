package edu.berkeley.path.scenario.dao.impl;

import edu.berkeley.path.scenario.dao.IFundamentalDiagramProfileDao;


import edu.berkeley.path.scenario.model.IFundamentalDiagramProfile;
import edu.berkeley.path.scenario.model.impl.FundamentalDiagramProfile;
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
 */
@Repository
public class FundamentalDiagramProfileDao implements IFundamentalDiagramProfileDao {

    @Autowired
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public long addFundamentalDiagramProfile( IFundamentalDiagramProfile ifdp ) {

        final Logger logger = LogManager.getLogger(FundamentalDiagramProfileDao.class.getName());
        long fdpId = 0;

        try {

            Session session = this.sessionFactory.getCurrentSession();
            session.persist(ifdp);
            fdpId = ifdp.getId();

        } catch (Exception ex) {
            logger.info("FundamentalDiagramProfileDao addFundamentalDiagramProfile Exception ex: ",  ex.getMessage());

        }
        return fdpId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public IFundamentalDiagramProfile getFundamentalDiagramProfile(long fundamentalDiagramProfileId) {

        final Logger logger = LogManager.getLogger(FundamentalDiagramProfileDao.class.getName());
        IFundamentalDiagramProfile ifdp = null;

        try{
            Session session = this.sessionFactory.getCurrentSession();

            Query query = session.createQuery("from FundamentalDiagramProfile where ID = :id ");
            query.setParameter("id", fundamentalDiagramProfileId);

            List<?> list = query.list();

            if ( ! list.isEmpty()) {
                ifdp = (IFundamentalDiagramProfile)list.get(0);

            }

        } catch (Exception ex) {
            logger.info("FundamentalDiagramProfileDao cant retrieve FundamentalDiagramProfile with id: " + fundamentalDiagramProfileId);
            logger.info("FundamentalDiagramProfileDao getFundamentalDiagramProfile Exception ex: ",  ex.getMessage());

        }

        return ifdp;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<IFundamentalDiagramProfile> getFundamentalDiagramProfiles() {
        final Logger logger = LogManager.getLogger(FundamentalDiagramProfileDao.class.getName());
        List<IFundamentalDiagramProfile> ifdpList = null;

        try{
            Session session = this.sessionFactory.getCurrentSession();
            Query query = session.createQuery("from FundamentalDiagramProfile");

            ifdpList = query.list();

        } catch (Exception ex) {
            logger.info("FundamentalDiagramProfileDao cant retrieve FundamentalDiagramProfiles " );
            logger.info("FundamentalDiagramProfileDao getFundamentalDiagramProfiles Exception ex:",  ex.getMessage());

        }

        return ifdpList;

    }

    @Override
    public void updateFundamentalDiagramProfile( IFundamentalDiagramProfile ifdp ) {
        final Logger logger = LogManager.getLogger(FundamentalDiagramProfileDao.class.getName());

        try {

            Session session = this.sessionFactory.getCurrentSession();
            session.update(ifdp);

        } catch (Exception ex) {
            logger.info("FundamentalDiagramProfileDao updateFundamentalDiagramProfile Exception ex: ",  ex.getMessage());

        }
    }

    @Override
    public void deleteFundamentalDiagramProfile( IFundamentalDiagramProfile ifdp ) {
        final Logger logger = LogManager.getLogger(FundamentalDiagramProfileDao.class.getName());

        try {
            Session session = this.sessionFactory.getCurrentSession();
            session.delete(ifdp);

        } catch (Exception ex) {
            logger.info("FundamentalDiagramProfileDao deleteFundamentalDiagramProfile Exception ex: ",  ex.getMessage());

        }
    }



}
