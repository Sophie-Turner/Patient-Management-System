/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.w3c.dom.NodeList;
import org.w3c.dom.*;
import Model.InteractWithXML;

/**
 *
 * @author pipin
 */
public class InteractWithXMLTest {
    private String filesource;
    
    public InteractWithXMLTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        filesource = "./src/main/java/dataFiles/userFile.xml";
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testGetDocument() {
        System.out.println("Testing getDocument");
        assertFalse("See if the file failed to be parsed and returned. Hopefully this will be false.", 
                InteractWithXML.getDocument(filesource) == null);
        
    }

    @Test
    public void testGetAllPatientNames() {
        String patientName;
        String expectedName = "Mona Lotte";
        System.out.println("Testing retrieving one patient's name.");
        Document file=InteractWithXML.getDocument(filesource);
        NodeList listOfPatients = file.getElementsByTagName("patient");
        Node patientNode = listOfPatients.item(0);
        Element patientElement = (Element)patientNode;
        NodeList nameList = patientElement.getElementsByTagName("name");
        Element nameElement = (Element)nameList.item(0);
        NodeList nameElementList = nameElement.getChildNodes();
        patientName = ((Node)nameElementList.item(0)).getNodeValue();
        assertEquals("Name should be Mona Lotte", expectedName, patientName);
        
        System.out.println("Testing getAllPatientNames");
        int expectedNumber = 4;
        String[] patientList = InteractWithXML.getAllPatientNames();
        int countedList = patientList.length;
        assertEquals("patientList should contain 4 different names.", expectedNumber, countedList);
    }

    @Test
    public void testGetAllDoctorNames() {
    }

    @Test
    public void testGetAllMedicineNames() {
    }

    @Test
    public void testGetAllDoctorComments() {
    }

    @Test
    public void testGetAllDoctorRatings() {
    }
    
}
