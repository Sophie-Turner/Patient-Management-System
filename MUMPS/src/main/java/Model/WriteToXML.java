/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.transform.stream.StreamResult;
/**
 *
 * @author pipin
 * 
 */
public class WriteToXML {
    public WriteToXML(){}
    WriteToXML writeData = new WriteToXML();
    String userFile = "./src/main/java/dataFiles/userFile.xml";
    String medicineFile = "./src/main/java/dataFiles/medicineFile.xml";
    File newUserFile = new File(userFile);
    File newMedicineFile = new File (medicineFile);
    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder dBuilder;
    
    
   /**
    * @param userId the Id number of the patient to be removed from the system.
    */
    public void saveData(String userId){
        try {
           dBuilder = dbFactory.newDocumentBuilder();
            Document userDoc = dBuilder.parse(newUserFile);
            userDoc.getDocumentElement().normalize();
            
            removeUser(userDoc, userId);
            
            //write the updated document to file
            userDoc.getDocumentElement().normalize();
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(userDoc);
            StreamResult result = new StreamResult(new File("userFile.xml"));
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(source, result);
            System.out.println("XML file updated successfully");
        }catch(SAXException | ParserConfigurationException | IOException | TransformerException e1) {
            e1.printStackTrace();
        } 
        
        
    }
   
    /**
     * Delete a patient from the system.
     * @param doc the XML file
     */
public void removeUser(Document doc, String userId){
    //make a list of doctors
        NodeList listOfPatients = doc.getElementsByTagName("patient");

        //loop through the doctors
        for(int i = 0; i<listOfPatients.getLength(); i++){
            //move to the next doctor
            Node patientNode = listOfPatients.item(i);
            //put it into an element
            Element patientElement = (Element)patientNode;
            
            //Get the userId element for this doctor
            NodeList userIdList = patientElement.getElementsByTagName("userId");
            //put it into an element
            Element userIdElement = (Element)userIdList.item(0);           
            //get the value/s 
            NodeList userIdElementList = userIdElement.getChildNodes();            
            //see if this is the correct userId
            if(userIdElementList.item(0).getNodeValue() == userId){
               doc.removeChild(patientNode);
            }
        }
    }
}




