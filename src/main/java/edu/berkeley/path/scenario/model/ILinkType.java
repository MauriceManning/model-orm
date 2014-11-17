package edu.berkeley.path.scenario.model;

import java.util.Date;

/**
 *
 */
public interface ILinkType {
    /**
     * Gets the value of the id property.
     *
     */
    public int getId();

    /**
     * Sets the value of the id property.
     *
     */
    public void setId(int value);

    /**
     * Gets the value of the name property.
     */
    public String getName();

    /**
     * Sets the value of the name property.
     *
     */
    public void setName(String value);

    /**
     * Gets the value of the description property.
     *
     */
    public String getDescription();

    /**
     * Sets the value of the description property.
     *
     */
    public void setDescription(String value);

    /**
     * Gets the value of the inUse property.
     *
     */
    public int getInUse();

    /**
     * Sets the value of the inUse property.
     *
     */
    public void setInUse(int value);

    /**
     * Gets the value of the modStamp property.
     *
     */
    public Date getModStamp();

    /**
     * Sets the value of the modStamp property.
     *
     */
    public void setModStamp(Date value);

    public IFundamentalDiagramProfile getFundamentalDiagramProfile();

    public void setFundamentalDiagramProfile(IFundamentalDiagramProfile fundamentalDiagramProfile);
}
