package edu.berkeley.path.scenario.model.impl;




import edu.berkeley.path.model_objects.shared.DateTime;

import edu.berkeley.path.scenario.model.*;
import org.hibernate.annotations.*;


import javax.persistence.*;
//import javax.persistence.CascadeType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 */


@Entity()
@SequenceGenerator(name="FDP_ID_SEQ", sequenceName="SEQ_FUND_DIAG_PROFS_ID",allocationSize=1)
@Table(name = "FUND_DIAG_PROFS")
public class FundamentalDiagramProfile implements IFundamentalDiagramProfile {


    @Id
    @GeneratedValue(generator="FDP_ID_SEQ", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID", nullable = false)
    protected long id;

    @Column(name = "LINK_ID", nullable = false)
    protected Long linkId;

    @Column(name = "NUM_LANES", nullable = true)
    protected Double numLanes;

    @Column(name = "SENSOR_ID", nullable = true)
    protected Long sensorId;

    @Column(name = "START_TIME", nullable = false)
    protected Double startTime;

    @Column(name = "SAMPLE_RATE", nullable = false)
    protected Double dt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "MODSTAMP", nullable = false)
    protected Date modStamp;

    @Column(name = "AGG_RUN_ID", nullable = true)
    protected Long aggRunId;

    @Column(name = "SPEED_LIMIT", nullable = true)
    protected Double speedLimit;

    @OneToOne(targetEntity=CalibrationAlgorithmType.class, cascade=CascadeType.ALL)
    @JoinColumn(name = "CAL_ALG_TYPE",  nullable=true)
    protected ICalibrationAlgorithmType calibrationAlgorithmType;

    @OneToOne(targetEntity=FundamentalDiagramType.class, cascade=CascadeType.ALL )
    @JoinColumn(name = "FUND_DIAG_TYPE", nullable=true)
    protected  IFundamentalDiagramType fundamentalDiagramType;

    @OneToOne(targetEntity=LinkType.class, cascade=CascadeType.ALL )
    @JoinColumn(name = "LINK_TYPE",  nullable=true)
    protected  ILinkType linkType;

    @OneToMany(mappedBy="fundamentalDiagramProfile", cascade=CascadeType.ALL, targetEntity=FundamentalDiagram.class, fetch=FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    //@OrderBy("number")
    private List<IFundamentalDiagram> fundamentalDiagrams;

    @ManyToOne(targetEntity=FundamentalDiagramSet.class, cascade=CascadeType.ALL )
    @JoinColumn(name = "FUND_DIAG_SET", nullable = false)
    private IFundamentalDiagramSet fundamentalDiagramSet;

    @Override
    public long getId() {
        return id;
    }
    @Override
    public void setId(long value) {
        this.id = value;
    }
    @Override
    public Long getLinkId() {
        return linkId;
    }
    @Override
    public void setLinkId(Long value) {
        this.linkId = value;
    }

    @Override
    public Long getSensorId() {
        return sensorId;
    }
    @Override
    public void setSensorId(Long value) {
        this.sensorId = value;
    }

    @Override
    public double getStartTime() {
        if (startTime == null) {
            return  0.0D;
        } else {
            return startTime;
        }
    }
    @Override
    public void setStartTime(Double value) {
        this.startTime = value;
    }

    @Override
    public Double getDt() {
        return dt;
    }
    @Override
    public void setDt(Double value) {
        this.dt = value;
    }
    @Override
    public Date getModStamp() {  return modStamp; }
    @Override
    public void setModStamp(Date value) {
        this.modStamp = value;
    }

    @Override
    public Long getAggRunId() {
        return aggRunId;
    }
    @Override
    public void setAggRunId(Long value) {
        this.aggRunId = value;
    }


    @Override
    public ICalibrationAlgorithmType getCalibrationAlgorithmType() {
        return calibrationAlgorithmType;
    }
    @Override
    public void setCalibrationAlgorithmType(ICalibrationAlgorithmType value) {
        this.calibrationAlgorithmType = value;
    }

    @Override
    public IFundamentalDiagramType getFundamentalDiagramType() {
        return fundamentalDiagramType;
    }
    @Override
    public void setFundamentalDiagramType(IFundamentalDiagramType value) {
        this.fundamentalDiagramType = value;
    }

    @Override
    public List<IFundamentalDiagram> getFundamentalDiagrams() { return fundamentalDiagrams; }
    @Override
    public void setFundamentalDiagrams(List<IFundamentalDiagram> fundamentalDiagrams) { this.fundamentalDiagrams = fundamentalDiagrams; }

    @Override
    public IFundamentalDiagramSet getFundamentalDiagramSet() { return fundamentalDiagramSet; }
    @Override
    public void setFundamentalDiagramSet(IFundamentalDiagramSet value) { this.fundamentalDiagramSet = value; }

    @Override
    public ILinkType getLinkType() { return linkType; }

    @Override
    public void setLinkType(ILinkType value) { this.linkType = value; }


    @Override
    public Double getNumLanes() { return numLanes; }

    @Override
    public void setNumLanes(Double value) { this.numLanes = value; }

    @Override
    public Double getSpeedLimit() { return speedLimit; }

    @Override
    public void setSpeedLimit(Double value) { this.speedLimit = value; }

}
