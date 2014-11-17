package edu.berkeley.path.scenario.model;

import edu.berkeley.path.model_objects.shared.CrudFlag;

import java.util.Date;


/**
 *
 */

public interface IFundamentalDiagram {


    /**
     * Capacity as double
     *
     */

    public double getCapacity();

    public void setCapacity(double cap);

    /**
     * Free flow speed as double
     *
     */
    public double getFreeFlowSpeed();

    public void setFreeFlowSpeed(double vf);

    /**
     * Congestion speed as double
     *
     */
    public double getCongestionSpeed();

    public void setCongestionSpeed(double w);

    /**
     * Critical speed as double
     *
     */

    public Double getCriticalSpeed();

    public void setCriticalSpeed(Double speed);

    /**
     * Jam density as double
     *
     */
    public Double getJamDensity();

    public void setJamDensity(Double d);

    /**
     * Capacity drop as double
     *
     */
    public double getCapacityDrop();

    public void setCapacityDrop(Double d);

    /**
     * Capacity standard deviation as Double
     *
     */
    public Double getStdDevCapacity();

    public void setStdDevCapacity(Double d);

    /**
     * Free flow speed standard deviation as Double
     *
     */
    public Double getStdDevFreeFlowSpeed();

    public void setStdDevFreeFlowSpeed(Double d);

    /**
     * Congestion speed standard deviation as Double
     *
     */
    public Double getStdDevCongestionSpeed();

    public void setStdDevCongestionSpeed(Double d);

    /**
     * FD id as long
     *
     */
    public long getId();

    public void setId(long l);

    /**
     * Model id as long
     *
     */
    public void setModelId(long value);

    public long getModelId();

    /**
     * ModStamp as Date
     *
     */
    public Date getModStamp();

    public void setModStamp(Date value);


    /**
     * FD order as int
     *
     */
    public Integer getOrder();

    public void setOrder(Integer i);


    /**
     * FundamentalDiagramProfile reference
     *
     */
    public IFundamentalDiagramProfile getFundamentalDiagramProfile();

    public void setFundamentalDiagramProfile(IFundamentalDiagramProfile value);
}
