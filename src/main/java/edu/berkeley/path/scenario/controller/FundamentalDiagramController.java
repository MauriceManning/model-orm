package edu.berkeley.path.scenario.controller;

import edu.berkeley.path.scenario.model.IFundamentalDiagramSet;
import edu.berkeley.path.scenario.service.IFundamentalDiagramManager;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Outward facing manager of fundamental diagram related tasks
 */
public class FundamentalDiagramController {

    private IFundamentalDiagramManager fundamentalDiagramManager;
    public void setFundamentalDiagramManager(IFundamentalDiagramManager ifdm) {
        this.fundamentalDiagramManager = ifdm;
    }


    public long addFundamentalDiagramSet( IFundamentalDiagramSet set )  {
        return fundamentalDiagramManager.addFundamentalDiagramSet(set);
    }

    public IFundamentalDiagramSet getFundamentalDiagramSet(long fundamentalDiagramSetId)  {
        return fundamentalDiagramManager.getFundamentalDiagramSet(fundamentalDiagramSetId);
    }

    public List<IFundamentalDiagramSet> getFundamentalDiagramSets()  {
        return fundamentalDiagramManager.getFundamentalDiagramSets();
    }

    public void updateFundamentalDiagramSet( IFundamentalDiagramSet set )  {
        fundamentalDiagramManager.updateFundamentalDiagramSet(set);
    }

    public void deleteFundamentalDiagramSet( IFundamentalDiagramSet set )  {
        fundamentalDiagramManager.deleteFundamentalDiagramSet(set);
    }
}
