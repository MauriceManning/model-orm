package edu.berkeley.path.scenario.model.impl;

import edu.berkeley.path.scenario.model.IFundamentalDiagram;
import edu.berkeley.path.scenario.model.IFundamentalDiagramProfile;
import edu.berkeley.path.scenario.model.IFundamentalDiagramSet;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
//import org.hibernate.annotations.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 */

@Entity()
@SequenceGenerator(name="FDS_ID_SEQ", sequenceName="SEQ_FUND_DIAG_SETS_ID",allocationSize=1)
@Table(name = "FUND_DIAG_SETS")
@XmlRootElement
public class FundamentalDiagramSet implements IFundamentalDiagramSet{


    @Id
    @GeneratedValue(generator="FDS_ID_SEQ", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID", nullable = false)
    protected long id;


    @Column(name = "PROJECT_ID", nullable = false)
    protected long projectId;

    @Column(name = "FUND_DIAG_TYPE", nullable = false)
    protected long diagramType;

    @Column(name = "NAME", nullable = false)
    protected String name;

    @Column(name = "DESCRIPTION", nullable = true)
    protected String description;


    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "MODSTAMP", nullable = true)
    protected Date modStamp;

    @OneToMany(mappedBy="fundamentalDiagramSet",  cascade = CascadeType.ALL, targetEntity=FundamentalDiagramProfile.class, fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    //@OrderBy("number")
    private List<IFundamentalDiagramProfile> fundamentalDiagramProfiles;

    @Override
    public String getDescription() {
        return description;
    }
    @Override
    public void setDescription(String value) {
        this.description = value;
    }

    @Override
    public long getId() {
        return id;
    }
    @Override
    public void setId(long value) {
        this.id = value;
    }

    @Override
    public long getProjectId() {
        return projectId;
    }
    @Override
    public void setDiagramType(long value) {
        this.diagramType = value;
    }
    @Override
    public long getDiagramType() {
        return diagramType;
    }
    @Override
    public void setProjectId(long value) {
        this.projectId = value;
    }
    @Override
    public String getName() {
        if (name == null) {
            return "";
        } else {
            return name;
        }
    }
    @Override
    public void setName(String value) {
        this.name = value;
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
    public List<IFundamentalDiagramProfile> getFundamentalDiagramProfiles() { return fundamentalDiagramProfiles; }
    @Override
    public void setFundamentalDiagramProfiles(List<IFundamentalDiagramProfile> list) { this.fundamentalDiagramProfiles = list; }

}
