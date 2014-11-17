package edu.berkeley.path.scenario.model.impl;



import javax.persistence.*;
import java.util.Date;

import edu.berkeley.path.scenario.model.IFundamentalDiagram;
import edu.berkeley.path.scenario.model.IFundamentalDiagramProfile;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

/**
 *
 */

@Entity()
@Table(name = "FUND_DIAGRAMS")
@SequenceGenerator(name="FD_ID_SEQ", sequenceName="SEQ_FUND_DIAGRAMS_ID", allocationSize=1)
public class FundamentalDiagram implements IFundamentalDiagram {

    @Column(name = "CRUDFLAG", nullable = true)
    protected String crudFlag;

    @Id
    @GeneratedValue(generator="FD_ID_SEQ", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID", nullable = false)
    protected long id;

    @Column(name = "MODELID", nullable = false)
    protected long model_id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "MODSTAMP", nullable = true)
    protected Date modStamp;

    @Column(name = "DIAG_ORDER", nullable = false)
    protected Integer order;

    @Column(name = "CAPACITY", nullable = false)
    protected double capacity;

    @Column(name = "CAPACITY_DROP", nullable = true)
    protected Double capacityDrop;

    @Column(name = "CAPACITY_STD", nullable = true)
    protected Double stdDevCapacity;

    @Column(name = "FREE_FLOW_SPEED", nullable = true)
    protected double freeFlowSpeed;

    @Column(name = "CONG_WAVE_SPEED", nullable = true)
    protected double congestionSpeed;

    @Column(name = "CRITICAL_SPEED", nullable = true)
    protected Double criticalSpeed;

    @Column(name = "FREE_FLOW_SPEED_STD", nullable = true)
    protected Double stdDevFreeFlowSpeed;

    @Column(name = "CONG_WAVE_SPEED_STD", nullable = true)
    protected Double stdDevCongestionSpeed;

    @Column(name = "JAM_DENSITY", nullable = true)
    protected Double jamDensity;

    @ManyToOne(targetEntity=FundamentalDiagramProfile.class, cascade=CascadeType.ALL)
    @JoinColumn(name = "FUND_DIAG_PROF_ID", nullable = true)
    private IFundamentalDiagramProfile fundamentalDiagramProfile;


//    public String getCrudFlag() {
//        return crudFlag;
//    }
//
//    public void setCrudFlag(String value) {
//        this.crudFlag = value;
//    }

    @Override
    public long getId() {
        return id;
    }
    @Override
    public void setId(long value) {
        this.id = value;
    }

    @Override
    public void setModelId(long value) {
        this.model_id = value;
    }
    @Override
    public long getModelId() {
        return model_id;
    }

    @Override
    public Date getModStamp() {
            return modStamp;
    }
    @Override
    public void setModStamp(Date value) {
        this.modStamp = value;
    }

    @Override
    public Integer getOrder() {
        return order;
    }
    @Override
    public void setOrder(Integer value) {
        this.order = value;
    }

    @Override
    public double getCapacity() {
        return capacity;
    }
    @Override
    public void setCapacity(double value) {
        this.capacity = value;
    }

    @Override
    public double getCapacityDrop() {
        if (capacityDrop == null) {
            return  0.0D;
        } else {
            return capacityDrop;
        }
    }
    @Override
    public void setCapacityDrop(Double value) {
        this.capacityDrop = value;
    }

    @Override
    public Double getStdDevCapacity() {
        return stdDevCapacity;
    }
    @Override
    public void setStdDevCapacity(Double value) {
        this.stdDevCapacity = value;
    }

    @Override
    public double getFreeFlowSpeed() {
        return freeFlowSpeed;
    }
    @Override
    public void setFreeFlowSpeed(double value) {
        this.freeFlowSpeed = value;
    }

    @Override
    public double getCongestionSpeed() {
        return congestionSpeed;
    }

    public void setCongestionSpeed(double value) {
        this.congestionSpeed = value;
    }

    @Override
    public Double getCriticalSpeed() {
        return criticalSpeed;
    }
    @Override
    public void setCriticalSpeed(Double value) {
        this.criticalSpeed = value;
    }

    @Override
    public Double getStdDevFreeFlowSpeed() {
        return stdDevFreeFlowSpeed;
    }
    @Override
    public void setStdDevFreeFlowSpeed(Double value) {
        this.stdDevFreeFlowSpeed = value;
    }

    @Override
    public Double getStdDevCongestionSpeed() {
        return stdDevCongestionSpeed;
    }
    @Override
    public void setStdDevCongestionSpeed(Double value) {
        this.stdDevCongestionSpeed = value;
    }

    @Override
    public Double getJamDensity() {
        return jamDensity;
    }
    @Override
    public void setJamDensity(Double value) {
        this.jamDensity = value;
    }

    @Override
    public IFundamentalDiagramProfile getFundamentalDiagramProfile() { return fundamentalDiagramProfile; }
    @Override
    public void setFundamentalDiagramProfile(IFundamentalDiagramProfile value) { this.fundamentalDiagramProfile = value; }
}
