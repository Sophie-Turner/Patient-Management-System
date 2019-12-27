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
        Document userFile = getDocument("./src/main/java/Model/userFile.xml");
        System.out.println("The root of the XML file is: " + 
                userFile.getDocumentElement().getNodeName());
        NodeList listOfDoctors = userFile.getElementsByTagName("doctor"); 
        System.out.println("Number of doctors: " + 
                listOfDoctors.getLength());
                //Some tests.
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
