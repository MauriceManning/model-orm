package edu.berkeley.path.scenario;

import edu.berkeley.path.scenario.model.*;
import edu.berkeley.path.scenario.model.impl.*;
import edu.berkeley.path.scenario.service.IFundamentalDiagramManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

import java.io.File;

import org.dom4j.io.DocumentSource;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import org.junit.Ignore;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.berkeley.path.scenario.dao.IFundamentalDiagramDao;
import edu.berkeley.path.scenario.dao.IFundamentalDiagramSetDao;
import edu.berkeley.path.scenario.dao.IFundamentalDiagramProfileDao;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.XMLConstants;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.dom4j.io.DocumentResult;

/**
 *
 */

@Configuration
@ComponentScan({"edu.berkeley.path.scenario"})
public class FundamentalDiagramTest {

    // Constants for FD test values
    public static final long NULL_ID = 0L;
    public static final long MODEL_ID = 5;
    public static final long NEW_MODEL_ID = 7;
    public static final double CAPACITY = 2000.0;
    public static final double CAPACITY_DROP = 120.0;
    public static final double CONGESTION_SPEED = 10.0;
    public static final double CRITICAL_SPEED = 55.0;
    public static final double FREE_FLOW_SPEED = 70.0;
    public static final double JAM_DENSITY = 325.0;
    public static final double STDDEV_CAPACITY = 0.0;
    public static final double STDDEV_CONGESTION = 0.0;
    public static final double STDDEV_FF_SPEED = 0.0;
    private static final String MOD_STAMP = "01-APR-1982 23:23:12";
    public static final int ORDER = 1;


    private static final String NAME = "fundamental diagram set name";
    private static final String NEW_NAME = "NEW fundamental diagram set name";
    private static final String DESCRIPTION = "fundamental diagram set description";
    public static final long PROJECT_ID = 5;

    private static final String AUX_NAME = "name";
    private static final String AUX_DESCRIPTION = "description";
    private static final String NEW_AUX_NAME = "NEW name";
    private static final String NEW_AUX_DESCRIPTION = "NEW description";
    public static final int IN_USE = 1;

    public static final long LINK_ID = 5L;
    public static final long NEW_LINK_ID = 8L;
    public static final double SAMPLE_RATE = 123.0;
    public static final double START_TIME = 456.0;

    public static java.sql.Timestamp logtimestamp;

    private static IFundamentalDiagram fundamentalDiagram;
    private static IFundamentalDiagramSet fundamentalDiagramSet;
    private static IFundamentalDiagramProfile fundamentalDiagramProfile, fundamentalDiagramProfile2;
    private static ICalibrationAlgorithmType calibrationAlgorithmType;
    private static IFundamentalDiagramType fundamentalDiagramType;
    private static ILinkType linkType;

    private ClassPathXmlApplicationContext context = null;

    private IFundamentalDiagramDao fundamentalDiagramDao;
    private IFundamentalDiagramProfileDao fundamentalDiagramProfileDao;
    private IFundamentalDiagramManager fundamentalDiagramManager;


    @Before
    public void setUp() throws Exception {

        this.context = new ClassPathXmlApplicationContext("springContextModelORM.xml");

        logtimestamp = new java.sql.Timestamp( System.currentTimeMillis() );

        // Create Fundamental Diagram
        fundamentalDiagram = new FundamentalDiagram();
        fundamentalDiagram.setId(NULL_ID);
        fundamentalDiagram.setCapacity(CAPACITY);
        fundamentalDiagram.setCapacityDrop(CAPACITY_DROP);
        fundamentalDiagram.setCongestionSpeed(CONGESTION_SPEED);
        fundamentalDiagram.setCriticalSpeed(CRITICAL_SPEED);
        fundamentalDiagram.setFreeFlowSpeed(FREE_FLOW_SPEED);
        fundamentalDiagram.setJamDensity(JAM_DENSITY);
        fundamentalDiagram.setStdDevCapacity(STDDEV_CAPACITY);
        fundamentalDiagram.setStdDevCongestionSpeed(STDDEV_CONGESTION);
        fundamentalDiagram.setStdDevFreeFlowSpeed(STDDEV_FF_SPEED);
        fundamentalDiagram.setOrder(ORDER);
        fundamentalDiagram.setModelId(MODEL_ID);
        fundamentalDiagram.setModStamp(logtimestamp);


        // Create Fundamental Diagram Type
        fundamentalDiagramType = new FundamentalDiagramType();
        fundamentalDiagramType.setDescription(AUX_DESCRIPTION);
        fundamentalDiagramType.setId(0);
        fundamentalDiagramType.setName(AUX_NAME);
        fundamentalDiagramType.setInUse(IN_USE);
        fundamentalDiagramType.setModStamp(logtimestamp);

        // Create Calibration Algorithm Type
        calibrationAlgorithmType = new CalibrationAlgorithmType();
        calibrationAlgorithmType.setDescription(AUX_DESCRIPTION);
        calibrationAlgorithmType.setId(0);
        calibrationAlgorithmType.setName(AUX_NAME);
        calibrationAlgorithmType.setInUse(IN_USE);
        calibrationAlgorithmType.setModStamp(logtimestamp);


        fundamentalDiagramProfile = new FundamentalDiagramProfile();
        fundamentalDiagramProfile.setDt(1.0D);
        fundamentalDiagramProfile.setLinkId(LINK_ID);
        fundamentalDiagramProfile.setStartTime(START_TIME);
        fundamentalDiagramProfile.setModStamp(logtimestamp);

        linkType = new LinkType();



        fundamentalDiagramProfile2 = new FundamentalDiagramProfile();
        fundamentalDiagramProfile2.setDt(1.0D);
        fundamentalDiagramProfile2.setLinkId(LINK_ID);
        fundamentalDiagramProfile2.setStartTime(START_TIME);
        fundamentalDiagramProfile2.setModStamp(logtimestamp);

        fundamentalDiagramProfile.setCalibrationAlgorithmType(calibrationAlgorithmType);
        calibrationAlgorithmType.setFundamentalDiagramProfile(fundamentalDiagramProfile);

        fundamentalDiagramProfile.setFundamentalDiagramType(fundamentalDiagramType);
        fundamentalDiagramType.setFundamentalDiagramProfile(fundamentalDiagramProfile);


        List<IFundamentalDiagram> fdList = new ArrayList<IFundamentalDiagram>();
        fdList.add(fundamentalDiagram);
        fundamentalDiagramProfile.setFundamentalDiagrams(fdList);
        fundamentalDiagram.setFundamentalDiagramProfile(fundamentalDiagramProfile);

        fundamentalDiagramSet = new FundamentalDiagramSet();
        fundamentalDiagramSet.setDescription(DESCRIPTION);
        fundamentalDiagramSet.setProjectId(PROJECT_ID);
        fundamentalDiagramSet.setName(NAME);
        fundamentalDiagramSet.setModStamp(logtimestamp);

        List<IFundamentalDiagramProfile> fdpList = new ArrayList<IFundamentalDiagramProfile>();
        fdpList.add(fundamentalDiagramProfile);
        fundamentalDiagramSet.setFundamentalDiagramProfiles(fdpList);
        fundamentalDiagramProfile.setFundamentalDiagramSet(fundamentalDiagramSet);
    }

    @After
    public void tearDown() throws Exception {

        this.context.close();
    }



    @Test
    //@Ignore
    public void testFundamentalDiagramSetDao() {
        final Logger logger = LogManager.getLogger(IFundamentalDiagramSetDao.class.getName());
        fundamentalDiagramManager = this.context.getBean(IFundamentalDiagramManager.class);

        // Insert
        long fdsId = fundamentalDiagramManager.addFundamentalDiagramSet(fundamentalDiagramSet);
        assertNotEquals(fdsId, 0L);

        // Read
        IFundamentalDiagramSet ifds = fundamentalDiagramManager.getFundamentalDiagramSet(fdsId);
        assertEquals(ifds.getName(), NAME);


        // Get the profiles - Eager load means they are already in the Set
        List<IFundamentalDiagramProfile> ifdpList = ifds.getFundamentalDiagramProfiles();
        for (IFundamentalDiagramProfile ifdpItem : ifdpList) {
            assertEquals(ifdpItem.getLinkId().longValue(), LINK_ID);
            // Update a value
            ifdpItem.setLinkId(NEW_LINK_ID);

            // Check the fundamental diagrams  - Eager load means they are already in the Profile
            List<IFundamentalDiagram> ifdList = ifdpItem.getFundamentalDiagrams();
            for (IFundamentalDiagram ifdItem : ifdList) {
                assertEquals(ifdItem.getModelId(), MODEL_ID);
                // Update a value
                ifdItem.setModelId(NEW_MODEL_ID);
            }

            // Check the Calibration Algorithm Type
            ICalibrationAlgorithmType icat = ifdpItem.getCalibrationAlgorithmType();
            assertEquals(icat.getDescription(), AUX_DESCRIPTION);
            assertEquals(icat.getName(), AUX_NAME);
            // Update values
            icat.setName(NEW_AUX_NAME);
            icat.setDescription(NEW_AUX_DESCRIPTION);

            // Check the Fundamental Diagram Type
            IFundamentalDiagramType ifdt = ifdpItem.getFundamentalDiagramType();
            assertEquals(ifdt.getDescription(), AUX_DESCRIPTION);
            assertEquals(ifdt.getName(), AUX_NAME);
            // Update values
            ifdt.setName(NEW_AUX_NAME);
            ifdt.setDescription(NEW_AUX_DESCRIPTION);
        }


        // Update
        ifds.setName(NEW_NAME);
        fundamentalDiagramManager.updateFundamentalDiagramSet(ifds);

        // Verify the Update
        IFundamentalDiagramSet fdsUpdated = fundamentalDiagramManager.getFundamentalDiagramSet(fdsId);
        assertEquals(fdsUpdated.getName(), NEW_NAME);

        // Check that the profiles are updated
        List<IFundamentalDiagramProfile> ifdpList2 = fdsUpdated.getFundamentalDiagramProfiles();
        for (IFundamentalDiagramProfile ifdpItem2 : ifdpList2) {
            assertEquals(ifdpItem2.getLinkId().longValue(), NEW_LINK_ID);

            // Check the fundamental diagrams are updated - Eager load means they are already in the Profile
            List<IFundamentalDiagram> ifdList2 = ifdpItem2.getFundamentalDiagrams();
            for (IFundamentalDiagram ifdItem2 : ifdList2) {
                assertEquals(ifdItem2.getModelId(), NEW_MODEL_ID);
            }
            // Check the Calibration Algorithm Type
            ICalibrationAlgorithmType icat2 = ifdpItem2.getCalibrationAlgorithmType();
            assertEquals(icat2.getDescription(), NEW_AUX_DESCRIPTION);
            assertEquals(icat2.getName(), NEW_AUX_NAME);


            // Check the Fundamental Diagram Type
            IFundamentalDiagramType ifdt2 = ifdpItem2.getFundamentalDiagramType();
            assertEquals(ifdt2.getDescription(), NEW_AUX_DESCRIPTION);
            assertEquals(ifdt2.getName(), NEW_AUX_NAME);

        }
        ifdpList2.add(fundamentalDiagramProfile2);
        fundamentalDiagramProfile2.setFundamentalDiagramSet(fdsUpdated);


        // Update Again
        fundamentalDiagramManager.updateFundamentalDiagramSet(fdsUpdated);

        // Verify the second round of Updates - added a new FDProfile
        IFundamentalDiagramSet fdsUpdated3 = fundamentalDiagramManager.getFundamentalDiagramSet(fdsId);
        List<IFundamentalDiagramProfile> ifdpList3 = fdsUpdated3.getFundamentalDiagramProfiles();
        assertEquals(ifdpList3.size(), 2);


        // Get all sets
        List<IFundamentalDiagramSet> fdsList = fundamentalDiagramManager.getFundamentalDiagramSets();
        logger.info("testFundamentalDiagramSetDao testInsert fds list count: " + fdsList.size());
        for (IFundamentalDiagramSet f : fdsList) {
            assertEquals(f.getDescription(), DESCRIPTION);
        }

        // Delete
        fundamentalDiagramManager.deleteFundamentalDiagramSet(fdsUpdated);
        IFundamentalDiagramSet fdsDeleted = fundamentalDiagramManager.getFundamentalDiagramSet(fdsId);
        assertEquals(fdsDeleted, null);

    }


    @Test
    @Ignore
    public void testFundamentalDiagramIntoXml() {



        final Logger logger = LogManager.getLogger(IFundamentalDiagramSetDao.class.getName());
        fundamentalDiagramManager = this.context.getBean(IFundamentalDiagramManager.class);

        //Insert
        long fdsId = fundamentalDiagramManager.addFundamentalDiagramSet(fundamentalDiagramSet);
        assertNotEquals(fdsId, 0L);

        // Read
        IFundamentalDiagramSet ifds = fundamentalDiagramManager.getFundamentalDiagramSet(fdsId);

        // Create the JAXBContext
        DocumentResult dr = new DocumentResult();

        try {
            JAXBContext jc = JAXBContext.newInstance(FundamentalDiagramSet.class);
            // Marshal the POJO to a DOM4J DocumentResult
            Marshaller marshaller = jc.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            FundamentalDiagramSet fds = (FundamentalDiagramSet) ifds;
            marshaller.marshal(fds, dr);

            marshaller.marshal(fds, System.out );
        } catch (Exception ex) {
            logger.info("Exception creating xml ex: ", ex.getMessage());
        }



        // Validate the xml against the scenario.xsd
        try {
            SchemaFactory factory =
                    SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File("src/main/resources/scenario.xsd"));
            Validator validator = schema.newValidator();
            DocumentSource ds = new DocumentSource(dr.getDocument());

            validator.validate(ds);
        } catch (Exception e) {
            System.out.println("Exception: "+e.getMessage());
            return ;
        }
        return;



    }




}
