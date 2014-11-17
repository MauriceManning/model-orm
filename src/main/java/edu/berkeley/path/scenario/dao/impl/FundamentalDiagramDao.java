package edu.berkeley.path.scenario.dao.impl;

import edu.berkeley.path.scenario.dao.IFundamentalDiagramDao;

import edu.berkeley.path.scenario.model.IFundamentalDiagram;
import edu.berkeley.path.scenario.model.impl.FundamentalDiagram;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.Query;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 *
 */
@Repository
public class FundamentalDiagramDao implements IFundamentalDiagramDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @SuppressWarnings("unchecked")
    public IFundamentalDiagram getFundamentalDiagram(long fundamentalDiagramId) {

        final Logger logger = LogManager.getLogger(FundamentalDiagramDao.class.getName());
        IFundamentalDiagram ifd = null;

        try{
            Session session = this.sessionFactory.getCurrentSession();

            Query query = session.createQuery("from FundamentalDiagram where ID = :id ");
            query.setParameter("id", fundamentalDiagramId);

            List<IFundamentalDiagram> list = query.list();

            if ( ! list.isEmpty()) {
                ifd = (IFundamentalDiagram)list.get(0);

            }

        } catch (Exception ex) {
            logger.info("FundamentalDiagramDao cant retrieve FundamentalDiagram with id: " + fundamentalDiagramId);
            logger.info("FundamentalDiagramDao getFundamentalDiagram Exception ex:",  ex.getMessage());
        }

        return ifd;

    }

    @Override
    @SuppressWarnings("unchecked")
    public List<IFundamentalDiagram> getFundamentalDiagrams() {

        final Logger logger = LogManager.getLogger(FundamentalDiagramDao.class.getName());
        List<IFundamentalDiagram> fdList = null;

        try{
            Session session = this.sessionFactory.getCurrentSession();

            Query query = session.createQuery("FROM FundamentalDiagram ");
            fdList = query.list();

        } catch (Exception ex) {
            logger.info("FundamentalDiagramDao getFundamentalDiagram Exception ex: ",  ex.getMessage());

        }

        return fdList;

    }

    @Override
    public long addFundamentalDiagram( IFundamentalDiagram fd )
    {
        final Logger logger = LogManager.getLogger(FundamentalDiagramDao.class.getName());
        long fdId = 0;

        try {

            Session session = this.sessionFactory.getCurrentSession();
            session.persist(fd);

            fdId = fd.getId();

        } catch (Exception ex) {
            logger.info("FundamentalDiagramDao addFundamentalDiagram Exception ex:",  ex.getMessage());

        }
        return fdId;
    }

    @Override
    public void updateFundamentalDiagram( IFundamentalDiagram fd ) {
        final Logger logger = LogManager.getLogger(FundamentalDiagramDao.class.getName());

        try {
            Session session = this.sessionFactory.getCurrentSession();

            session.update(fd);

        } catch (Exception ex) {
            logger.info("FundamentalDiagramDao addFundamentalDiagram Exception ex:",  ex.getMessage());
        }
    }

    @Override
    public void deleteFundamentalDiagram( IFundamentalDiagram fd ) {
        final Logger logger = LogManager.getLogger(FundamentalDiagramDao.class.getName());

        try {

            Session session = this.sessionFactory.getCurrentSession();
            session.delete(fd);

        } catch (Exception ex) {
            logger.info("FundamentalDiagramDao addFundamentalDiagram Exception ex: ",  ex.getMessage());
        }
    }


}
