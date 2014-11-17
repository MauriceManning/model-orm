package edu.berkeley.path.scenario.dao;

import edu.berkeley.path.scenario.model.IFundamentalDiagram;
import edu.berkeley.path.scenario.model.IFundamentalDiagramSet;


import java.util.List;

/**
 *
 */
public interface IFundamentalDiagramSetDao {


    public long addFundamentalDiagramSet( IFundamentalDiagramSet fds );


    IFundamentalDiagramSet getFundamentalDiagramSet(long fundamentalDiagramSetId);

    List<IFundamentalDiagramSet> getFundamentalDiagramSets();


    public void updateFundamentalDiagramSet( IFundamentalDiagramSet fds );

    public void deleteFundamentalDiagramSet( IFundamentalDiagramSet fds );
}
