package edu.berkeley.path.scenario.dao.impl;

import edu.berkeley.path.scenario.model.ICalibrationAlgorithmType;
import edu.berkeley.path.scenario.dao.ICalibrationAlgorithmTypeDao;

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
public class CalibrationAlgorithmTypeDao implements ICalibrationAlgorithmTypeDao {

    @Autowired
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

//    @Autowired
//    private Logger logger;
//    public void setLogger(Logger logger) {
//        this.logger = logger;
//    }

    @Override
    public ICalibrationAlgorithmType getCalibrationAlgorithmType(long calibrationAlgorithmTypeId) {

        final Logger logger = LogManager.getLogger(CalibrationAlgorithmTypeDao.class.getName());
        ICalibrationAlgorithmType icat = null;

        try{
            Session session = this.sessionFactory.getCurrentSession();

            Query query = session.createQuery("from CalibrationAlgorithmType where ID = :id ");
            query.setParameter("id", calibrationAlgorithmTypeId);

            List<?> list = query.list();

            if ( ! list.isEmpty()) {
                icat = (ICalibrationAlgorithmType)list.get(0);

            }
        } catch (Exception ex) {
            logger.info("CalibrationAlgorithmTypeDao cant retrieve CalibrationAlgorithmType with id: " + calibrationAlgorithmTypeId);
            logger.info("CalibrationAlgorithmTypeDao getCalibrationAlgorithmType Exception ex: ",  ex.getMessage());
        }

        return icat;

    }

    @Override
    public List<ICalibrationAlgorithmType> getCalibrationAlgorithmTypes() {
        final Logger logger = LogManager.getLogger(CalibrationAlgorithmTypeDao.class.getName());
        List<ICalibrationAlgorithmType> icatList = null;

        try{
            Session session = this.sessionFactory.getCurrentSession();
            Query query = session.createQuery("from CalibrationAlgorithmType");

            icatList = query.list();

        } catch (Exception ex) {
            logger.info("CalibrationAlgorithmTypeDao cant retrieve CalibrationAlgorithmTypes " );
            logger.info("CalibrationAlgorithmTypeDao getCalibrationAlgorithmType Exception ex: ",  ex.getMessage());
        }

        return icatList;
    }

    @Override
    public long addCalibrationAlgorithmType( ICalibrationAlgorithmType icat ) {

        final Logger logger = LogManager.getLogger(CalibrationAlgorithmTypeDao.class.getName());
        long fdId = 0;

        try {

            Session session = this.sessionFactory.getCurrentSession();
            session.persist(icat);
            fdId = icat.getId();

        } catch (Exception ex) {
            logger.info("CalibrationAlgorithmTypeDao addCalibrationAlgorithmType Exception ex: ",  ex.toString());

        }
        return fdId;

    }

    @Override
    public void updateCalibrationAlgorithmType( ICalibrationAlgorithmType icat ) {
        final Logger logger = LogManager.getLogger(CalibrationAlgorithmTypeDao.class.getName());

        try {

            Session session = this.sessionFactory.getCurrentSession();

            session.update(icat);


        } catch (Exception ex) {
            logger.info("CalibrationAlgorithmTypeDao updateCalibrationAlgorithmType Exception ex: ",  ex.getMessage());
        }
    }

    @Override
    public void deleteCalibrationAlgorithmType( ICalibrationAlgorithmType icat ) {
        final Logger logger = LogManager.getLogger(CalibrationAlgorithmTypeDao.class.getName());

        try {

            Session session = this.sessionFactory.getCurrentSession();
            session.delete(icat);

        } catch (Exception ex) {
            logger.info("CalibrationAlgorithmTypeDao deleteCalibrationAlgorithmType Exception ex: ",  ex.getMessage());
        }
    }


}
