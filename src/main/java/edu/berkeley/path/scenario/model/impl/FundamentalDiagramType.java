package edu.berkeley.path.scenario.model.impl;

import edu.berkeley.path.scenario.model.IFundamentalDiagramType;
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
@SequenceGenerator(name="FDT_ID_SEQ", sequenceName="SEQ_FUND_DIAG_TYPES_ID",allocationSize=1)
@Table(name = "FUND_DIAG_TYPES")
public class FundamentalDiagramType implements IFundamentalDiagramType {

    @Id
    @GeneratedValue(generator="FDT_ID_SEQ", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID", nullable = false)
    @XmlAttribute(name = "id", required = true)
    protected int id;

    @Column(name = "NAME", nullable = false)
    @XmlAttribute(name = "name", required = true)
    protected String name;

    @Column(name = "DESCRIPTION", nullable = true)
    @XmlAttribute(name = "description")
    protected String description;

    @Column(name = "IN_USE", nullable = false)
    @XmlAttribute(name = "in_use")
    protected Integer inUse;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "MODSTAMP", nullable = true)
    @XmlAttribute(name = "mod_stamp")
    protected Date modStamp;

    @OneToOne(mappedBy = "fundamentalDiagramType", cascade = CascadeType.ALL, targetEntity=FundamentalDiagramProfile.class)
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
