package edu.berkeley.path.scenario.service;

import edu.berkeley.path.scenario.model.*;

import java.util.List;

/**
 *
 */
public interface IFundamentalDiagramManager {

    public long addFundamentalDiagramSet( IFundamentalDiagramSet set );

    public IFundamentalDiagramSet getFundamentalDiagramSet(long fundamentalDiagramSetId);

    public List<IFundamentalDiagramSet> getFundamentalDiagramSets();

    public void updateFundamentalDiagramSet( IFundamentalDiagramSet set );

    public void deleteFundamentalDiagramSet( IFundamentalDiagramSet set );

}
