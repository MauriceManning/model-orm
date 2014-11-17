package edu.berkeley.path.scenario.model;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.berkeley.path.model_objects.scenario.FundamentalDiagramProfile;

/**
 *
 */


public interface IFundamentalDiagramSet {


    /**
     * Value of the description property.
     *
     */

    public String getDescription();

    public void setDescription(String value);




    /**
     * projectId property.
     *
     */
    public long getProjectId();

    public void setProjectId(long value);

    /**
     * projectId property.
     *
     */
    public void setDiagramType(long value);

    public long getDiagramType();


    /**
     * id property.
     *
     */

    public long getId();

    public void setId(long value);

    /**
     * name property.
     *
     */
    public String getName();

    public void setName(String value);

    /**
     * modStamp property.
     *
     */

    public Date getModStamp();

    public void setModStamp(Date value);


    /**
     * Return list of FD objects
     *
     * @return FD list as List<FundamentalDiagram>
     */
    public List<IFundamentalDiagramProfile> getFundamentalDiagramProfiles();

    /**
     * Set list of FD objects
     *
     */
    public void setFundamentalDiagramProfiles(List<IFundamentalDiagramProfile> fundamentalDiagramProfiles);

}