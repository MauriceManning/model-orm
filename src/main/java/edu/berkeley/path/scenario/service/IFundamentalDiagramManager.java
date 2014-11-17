package edu.berkeley.path.scenario.service;

import edu.berkeley.path.scenario.model.*;

import java.util.List;

/**
 *
 */
public interface IFundamentalDiagramManager {

//    public IFundamentalDiagram getFundamentalDiagram(long id);
//    public List<IFundamentalDiagram> getFundamentalDiagramList(long profileId );
//
//    public IFundamentalDiagramProfile getFundamentalDiagramProfile(long id );
//    public List<IFundamentalDiagramProfile> getFundamentalDiagramProfileList(long setId );

    public ICalibrationAlgorithmType getCalibrationAlgorithmType(long id );

    public IFundamentalDiagramType getFundamentalDiagramType(long id );



    public long addFundamentalDiagramSet( IFundamentalDiagramSet set );

    public IFundamentalDiagramSet getFundamentalDiagramSet(long fundamentalDiagramSetId);

    public List<IFundamentalDiagramSet> getFundamentalDiagramSets();

    public void updateFundamentalDiagramSet( IFundamentalDiagramSet set );

    public void deleteFundamentalDiagramSet( IFundamentalDiagramSet set );

}
