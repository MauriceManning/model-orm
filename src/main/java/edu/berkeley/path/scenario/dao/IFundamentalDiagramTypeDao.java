package edu.berkeley.path.scenario.dao;

import edu.berkeley.path.scenario.model.IFundamentalDiagramType;

import java.util.List;

/**
 *
 */
public interface IFundamentalDiagramTypeDao {

    IFundamentalDiagramType getFundamentalDiagramType(long fundamentalDiagramTypeId);

    List<IFundamentalDiagramType> getFundamentalDiagramTypes();

    public long addFundamentalDiagramType( IFundamentalDiagramType fdt );

    public void updateFundamentalDiagramType( IFundamentalDiagramType fdt );

    public void deleteFundamentalDiagramType( IFundamentalDiagramType fdt );

}
