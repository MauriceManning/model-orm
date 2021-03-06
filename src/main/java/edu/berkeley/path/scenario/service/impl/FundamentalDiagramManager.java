package edu.berkeley.path.scenario.service.impl;

import edu.berkeley.path.scenario.dao.*;
import edu.berkeley.path.scenario.model.*;
import edu.berkeley.path.scenario.service.IFundamentalDiagramManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@Service
public class FundamentalDiagramManager implements IFundamentalDiagramManager {

    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private IFundamentalDiagramDao fundamentalDiagramDao;
    public void setFundamentalDiagramDao(IFundamentalDiagramDao fdd){
        this.fundamentalDiagramDao=fdd;
    }

    private IFundamentalDiagramSetDao fundamentalDiagramSetDao;
    public void setFundamentalDiagramSetDao(IFundamentalDiagramSetDao fdsDao){
        this.fundamentalDiagramSetDao=fdsDao;
    }

    private IFundamentalDiagramProfileDao fundamentalDiagramProfileDao;
    public void setFundamentalDiagramProfileDao(IFundamentalDiagramProfileDao fdpDao) {  this.fundamentalDiagramProfileDao=fdpDao; }

    private IFundamentalDiagramTypeDao  fundamentalDiagramTypeDao;
    public void setFundamentalDiagramTypeDao(IFundamentalDiagramTypeDao fdtDao ) { this.fundamentalDiagramTypeDao = fdtDao; }

    private ICalibrationAlgorithmTypeDao   calibrationAlgorithmTypeDao;
    public void setCalibrationAlgorithmTypeDao(ICalibrationAlgorithmTypeDao catDao) { this.calibrationAlgorithmTypeDao = catDao; }



    @Override
    @Transactional
    public long addFundamentalDiagramSet( IFundamentalDiagramSet set )
    {
        return fundamentalDiagramSetDao.addFundamentalDiagramSet(set);
    }

    @Override
    @Transactional
    public IFundamentalDiagramSet getFundamentalDiagramSet(long fundamentalDiagramSetId)
    {
        return fundamentalDiagramSetDao.getFundamentalDiagramSet(fundamentalDiagramSetId);
    }

    @Override
    @Transactional
    public List<IFundamentalDiagramSet> getFundamentalDiagramSets()
    {
        return fundamentalDiagramSetDao.getFundamentalDiagramSets();
    }


    @Override
    @Transactional
    public void updateFundamentalDiagramSet( IFundamentalDiagramSet set )
    {
        fundamentalDiagramSetDao.updateFundamentalDiagramSet(set);
    }

    @Override
    @Transactional
    public void deleteFundamentalDiagramSet( IFundamentalDiagramSet set )
    {
        fundamentalDiagramSetDao.deleteFundamentalDiagramSet(set);
    }

}
