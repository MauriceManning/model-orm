package edu.berkeley.path.scenario.dao.impl;

import edu.berkeley.path.scenario.model.ICalibrationAlgorithmType;
import edu.berkeley.path.scenario.model.IFundamentalDiagramType;
import edu.berkeley.path.scenario.dao.IFundamentalDiagramTypeDao;

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
public class FundamentalDiagramTypeDao implements IFundamentalDiagramTypeDao {

    @Autowired
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @SuppressWarnings("unchecked")
    public IFundamentalDiagramType getFundamentalDiagramType(long fundamentalDiagramTypeId) {
        final Logger logger = LogManager.getLogger(FundamentalDiagramTypeDao.class.getName());
        IFundamentalDiagramType ifdt = null;

        try{
            Session session = this.sessionFactory.getCurrentSession();

            Query query = session.createQuery("from FundamentalDiagramType where ID = :id ");
            query.setParameter("id", fundamentalDiagramTypeId);

            List<?> list = query.list();

            if ( ! list.isEmpty()) {
                ifdt = (IFundamentalDiagramType)list.get(0);

            }

        } catch (Exception ex) {
            logger.info("FundamentalDiagramTypeDao cant retrieve FundamentalDiagramType with id: " + fundamentalDiagramTypeId);
            logger.info("FundamentalDiagramTypeDao getFundamentalDiagramType Exception ex: {}",  ex.getMessage());

        }

        return ifdt;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<IFundamentalDiagramType> getFundamentalDiagramTypes() {
        final Logger logger = LogManager.getLogger(FundamentalDiagramTypeDao.class.getName());
        List<IFundamentalDiagramType> ifdtList = null;

        try{
            Session session = this.sessionFactory.getCurrentSession();

            Query query = session.createQuery("from FundamentalDiagramType ");

            ifdtList = query.list();


        } catch (Exception ex) {
            logger.info("FundamentalDiagramTypeDao cant retrieve FundamentalDiagramTypes" );
            logger.info("FundamentalDiagramTypeDao getFundamentalDiagramTypes Exception ex: {}",  ex.getMessage());

        }

        return ifdtList;
    }

    @Override
    public long addFundamentalDiagramType( IFundamentalDiagramType ifdt ) {
        final Logger logger = LogManager.getLogger(FundamentalDiagramTypeDao.class.getName());
        long fdtId = 0;

        try {

            Session session = this.sessionFactory.getCurrentSession();
            session.persist(ifdt);
            fdtId = ifdt.getId();

        } catch (Exception ex) {
            logger.info("FundamentalDiagramTypeDao addFundamentalDiagramType Exception ex: {}",  ex.getMessage());

        }
        return fdtId;
    }

    @Override
    public void updateFundamentalDiagramType( IFundamentalDiagramType ifdt ) {
        final Logger logger = LogManager.getLogger(FundamentalDiagramTypeDao.class.getName());

        try {

            Session session = this.sessionFactory.getCurrentSession();
            session.update(ifdt);

        } catch (Exception ex) {
            logger.info("FundamentalDiagramTypeDao updateFundamentalDiagramType Exception ex: {}",  ex.getMessage());


        }
    }

    @Override
    public void deleteFundamentalDiagramType( IFundamentalDiagramType ifdt ) {
        final Logger logger = LogManager.getLogger(FundamentalDiagramTypeDao.class.getName());

        try {

            Session session = this.sessionFactory.getCurrentSession();
            session.delete(ifdt);

        } catch (Exception ex) {
            logger.info("FundamentalDiagramTypeDao deleteFundamentalDiagramType Exception ex: {}",  ex.getMessage());

        }
    }


}
