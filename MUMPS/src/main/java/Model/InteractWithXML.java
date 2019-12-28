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
public class InteractWithXML {
    
    public void interact(){
        Document userFile = getDocument("./src/main/java/dataFiles/userFile.xml");
        System.out.println("The root of the XML file is: " + 
                userFile.getDocumentElement().getNodeName());
        NodeList listOfDoctors = userFile.getElementsByTagName("doctor"); 
        System.out.println("Number of doctors: " + 
                listOfDoctors.getLength());
                //Some tests
        String name = "name";
        getDoctorNames(listOfDoctors, name);
    }
    
    public void getDoctorNames(NodeList listOfDoctors, String name){
        //This method shows the names of each doctor.
        for(int i = 0; i<listOfDoctors.getLength(); i++){
            Node doctorNode = listOfDoctors.item(i);
            Element doctorElement = (Element)doctorNode;
                 //Turn it into an element                    
            NodeList nameList = doctorElement.getElementsByTagName(name);         
                 //Create list of elements
            Element nameElement = (Element)nameList.item(0);
                //get first element
            NodeList nameElementList = nameElement.getChildNodes();
                //get contents of name fields
            System.out.println(
                    ((Node)nameElementList.item(0)).getNodeValue().trim() );
        }
    }
    
    public static Document getDocument(String fileSource){
        try {
           DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
                    //API to convert XML into DOM tree. 
           documentFactory.setIgnoringComments(true); 
                    //Don't store comments as nodes.
           documentFactory.setIgnoringElementContentWhitespace(false);
                    //Store white space.
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
    
    public static String[] getAllPatientNames(){
        Document userFile = getDocument("./src/main/java/dataFiles/userFile.xml");
        NodeList listOfPatients = userFile.getElementsByTagName("patient");
        String[] allPatientNames = new String[listOfPatients.getLength()];
        for(int i = 0; i<listOfPatients.getLength(); i++){
            Node patientNode = listOfPatients.item(i);
            Element patientElement = (Element)patientNode;
                 //Turn it into an element                    
            NodeList nameList = patientElement.getElementsByTagName("name");           
                 //Create list of elements
            Element nameElement = (Element)nameList.item(0);
                //get first element
            NodeList nameElementList = nameElement.getChildNodes();
                //get contents of name fields
            allPatientNames[i] = 
                    ((Node)nameElementList.item(0)).getNodeValue();
            //Fill array with each name
        }
        return allPatientNames;
    }
    
    /*Finish this method later.
    public String[] getFeedbackComments(String doctorSurname, NodeList listOfDoctors){
        
        for(int i = 0; i<listOfDoctors.getLength(); i++){
            
            if ( == doctorSurname){
                
                String[] feedbackComments = new String[]{};
                //Create an array to hold all feedback comments for this doctor
            }
        }
        return feedbackComments;
    }
    public String getFeedbackRating(String doctorSurname){
        
        return("");
    }
    */
}
