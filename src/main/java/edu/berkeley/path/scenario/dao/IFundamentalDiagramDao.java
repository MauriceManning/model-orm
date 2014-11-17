package edu.berkeley.path.scenario.dao;

import edu.berkeley.path.scenario.model.impl.FundamentalDiagram;
import edu.berkeley.path.scenario.model.IFundamentalDiagram;

import java.util.List;

/**
 *
 */

public interface IFundamentalDiagramDao {

    IFundamentalDiagram getFundamentalDiagram(long fundamentalDiagramId);

    List<IFundamentalDiagram> getFundamentalDiagrams();

    public long addFundamentalDiagram( IFundamentalDiagram fd );

    public void updateFundamentalDiagram( IFundamentalDiagram fd );

    public void deleteFundamentalDiagram( IFundamentalDiagram fd );

}
