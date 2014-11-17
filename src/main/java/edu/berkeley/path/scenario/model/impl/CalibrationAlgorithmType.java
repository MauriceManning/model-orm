package edu.berkeley.path.scenario.model.impl;

import edu.berkeley.path.scenario.model.ICalibrationAlgorithmType;
import edu.berkeley.path.scenario.model.IFundamentalDiagramProfile;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAttribute;


import java.util.Date;

/**
 *
 */

@Entity()
//@SequenceGenerator(name="fd_id_seq", initialValue=1)
@Table(name = "CALIB_ALG_TYPES")
public class CalibrationAlgorithmType implements ICalibrationAlgorithmType {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
//    @GeneratedValue(strategy = GenerationType.IDENTITY, generator="fd_id_seq")
//    @SequenceGenerator(name="fd_id_seq", sequenceName="fd_id_seq", allocationSize=1)@SequenceGenerator(name="seq", initialValue=1
    @Column(name = "ID", nullable = false)
    @XmlAttribute(name = "id", required = true)
    private int id;

    @Column(name = "NAME", nullable = false)
    @XmlAttribute(name = "name", required = true)
    private String name;


    @Column(name = "DESCRIPTION", nullable = true)
    @XmlAttribute(name = "description", required = true)
    private String description;

    @Column(name = "IN_USE", nullable = false)
    @XmlAttribute(name = "in_use", required = true)
    private int inUse;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "MODSTAMP", nullable = true)
    @XmlAttribute(name = "mod_stamp")
    private Date modStamp;

    @OneToOne(mappedBy = "calibrationAlgorithmType", cascade = CascadeType.ALL,  targetEntity=FundamentalDiagramProfile.class)
    protected IFundamentalDiagramProfile fundamentalDiagramProfile;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int value) {
        this.id = value;
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String value) {
        this.name = value;
    }

    @Override
    public String getDescription() {
        return description;
    }
    @Override
    public void setDescription(String value) {
        this.description = value;
    }

    @Override
    public int getInUse() {
        return inUse;
    }
    @Override
    public void setInUse(int value) {
        this.inUse = value;
    }

    @Override
    public Date getModStamp() {  return modStamp; }
    @Override
    public void setModStamp(Date value) {
        this.modStamp = value;
    }

    @Override
    public IFundamentalDiagramProfile getFundamentalDiagramProfile()   { return fundamentalDiagramProfile; }
    @Override
    public void setFundamentalDiagramProfile(IFundamentalDiagramProfile fundamentalDiagramProfile)  {this.fundamentalDiagramProfile =  fundamentalDiagramProfile; }

}
