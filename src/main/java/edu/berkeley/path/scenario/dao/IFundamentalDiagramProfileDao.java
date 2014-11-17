package edu.berkeley.path.scenario.dao;

import edu.berkeley.path.scenario.model.IFundamentalDiagramProfile;

import java.util.List;

/**
 *
 */
public interface IFundamentalDiagramProfileDao {

    public long addFundamentalDiagramProfile( IFundamentalDiagramProfile fdp );


    IFundamentalDiagramProfile getFundamentalDiagramProfile(long fundamentalDiagramProfileId);

    List<IFundamentalDiagramProfile> getFundamentalDiagramProfiles();


    public void updateFundamentalDiagramProfile( IFundamentalDiagramProfile fds );

    public void deleteFundamentalDiagramProfile( IFundamentalDiagramProfile fds );
}
