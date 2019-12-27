/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import org.xml.sax.*; //faster way to read data from XML.
import org.w3c.dom.*; //read and write XML.
import javax.xml.parsers.*; //store XML elements as DOM objects.
/**
 *
 * @author pipin
 */
public class interactWithXML {
    
    public void interact(){
        Document userFile = getDocument("./src/main/java/dataFiles/userFile.xml");
        System.out.println("The root of the XML file is: " + 
                userFile.getDocumentElement().getNodeName());
        NodeList listOfDoctors = userFile.getElementsByTagName("doctor"); 
        System.out.println("Number of doctors: " + 
                listOfDoctors.getLength());
                //Some tests
        String doctorForename = "forename";
        String doctorSurname = "surname";
        getDoctorNames(listOfDoctors, doctorForename, doctorSurname);
    }
    
    public void getDoctorNames(NodeList listOfDoctors, String doctorForename, String doctorSurname){
        //This method shows the forenames of each doctor.
        for(int i = 0; i<listOfDoctors.getLength(); i++){
            Node doctorNode = listOfDoctors.item(i);
            Element doctorElement = (Element)doctorNode;
                 //Turn it into an element                    
            NodeList fornameList = doctorElement.getElementsByTagName(doctorForename);
            NodeList surnameList = doctorElement.getElementsByTagName(doctorSurname);            
                 //Create list of elements
            Element fornameElement = (Element)fornameList.item(0);
            Element surnameElement = (Element)surnameList.item(0);
                //get first element
            NodeList forenameElementList = fornameElement.getChildNodes();
            NodeList surnameElementList = surnameElement.getChildNodes();
                //get contents of forename field
            System.out.println(
                    ((Node)forenameElementList.item(0)).getNodeValue().trim() + " " +
                    ((Node)surnameElementList.item(0)).getNodeValue().trim() );
        }
    }
    
    public static Document getDocument(String fileSource){
        try {
           DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
                    //API to convert XML into DOM tree. 
           documentFactory.setIgnoringComments(true); 
                    //Don't store comments as nodes.
           documentFactory.setIgnoringElementContentWhitespace(true);
                    //Don't store white space.
           documentFactory.setValidating(true);
                    //Validate that the XML is set up properly.
           
           DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
                    //Provide access to document data.
           
           return documentBuilder.parse(new InputSource(fileSource));
                   //Tell it where file is.
        }
        catch(Exception anyException){
            System.out.println(anyException.getMessage());
        }
        return null;
    }
    
}
