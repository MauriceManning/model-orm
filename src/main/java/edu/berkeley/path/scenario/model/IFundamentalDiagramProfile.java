package edu.berkeley.path.scenario.model;


import java.util.Date;
import java.util.List;

/**
 *
 */
public interface IFundamentalDiagramProfile {

    /**
     * Gets the value of the fundamentalDiagramType property.
     *
     */
    public IFundamentalDiagramType getFundamentalDiagramType();

    /**
     * Sets the value of the fundamentalDiagramType property.
     *
     */
    public void setFundamentalDiagramType(IFundamentalDiagramType value);

    /**
     * Gets the value of the calibrationAlgorithmType property.
     *
     */
    public ICalibrationAlgorithmType getCalibrationAlgorithmType();

    /**
     * Sets the value of the calibrationAlgorithmType property.
     *
     */
    public void setCalibrationAlgorithmType(ICalibrationAlgorithmType value);

    /**
     * Return list of FD objects
     *
     * @return FD list as List<FundamentalDiagram>
     */
    public List<IFundamentalDiagram> getFundamentalDiagrams();

    /**
     * Set list of FD objects
     *
     */
    public void setFundamentalDiagrams(List<IFundamentalDiagram> fundamentalDiagrams);

    /**
     * FundamentalDiagramSet reference
     *
     */
    public IFundamentalDiagramSet getFundamentalDiagramSet();

    public void setFundamentalDiagramSet(IFundamentalDiagramSet value);


    /**
     * Gets the value of the id property.
     *
     */
    public long getId();

    /**
     * Sets the value of the id property.
     *
     */
    public void setId(long value);

    /**
     * Gets the value of the linkId property.
     *
     */
    public Long getLinkId();

    /**
     * Sets the value of the linkId property.
     *
     */
    public void setLinkId(Long value);

    /**
     * Get the type reference to the Link_Types table.
     *
     */
    public ILinkType getLinkType();

    /**
     *  Set the type reference to the Link_Types table.
     *
     */
    public void setLinkType(ILinkType value);

    /**
     * Get the number of lanes on this link.
     *
     */
    public Long getNumLanes();

    /**
     *  Set the number of lanes on this link.
     *
     */
    public void setNumLanes(Long value);

    /**
     * Gets the value of the sensorId property.
     *
     */
    public Long getSensorId();

    /**
     * Sets the value of the sensorId property.
     *
     */
    public void setSensorId(Long value);

    /**
     * Gets the value of the startTime property.
     *
     */
    public double getStartTime();

    /**
     * Sets the value of the startTime property.
     *
     */
    public void setStartTime(Double value);

    /**
     * Gets the value of the dt property.
     *
     */
    public Double getDt();

    /**
     * Sets the value of the dt property.
     *
     */
    public void setDt(Double value);

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

    /**
     * Gets the value of the aggRunId property.
     *
     */
    public Long getAggRunId();

    /**
     * Sets the value of the aggRunId property.
     *
     */
    public void setAggRunId(Long value);



}
