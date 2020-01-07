
package Model;
import org.xml.sax.*; //faster way to read data from XML.
import org.w3c.dom.*; //read and write XML.
import javax.xml.parsers.*; //store XML elements as DOM objects.
/**
 *
 * @author pipin
 * Reads data from the XML file and sends it to the program.
 * Clean up these methods later. 
 * Reduce repeated code and separate classes in keeping with SOLID. 
 */
public class InteractWithXML {
    
    /* A test
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
    */
    
    //Clean up these methods later. Reduce repeated code and separate classes in keeping with SOLID. 
    
    /**
     * Gets the XML file and puts it into DOM so it can be read.
     * @param fileSource The location of the XML file.
     * @return 
     * 
     */
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
    
    /**
     * Finds the names of all the patients by looping through the XML file and sends them back to
     * where the method was called as a string array.
     * @return 
     */
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
    
    /**
     * Finds the names of all the doctors by looping through the XML file and sends them back to
     * where the method was called as a string array.
     * @return the listOfDoctors array.
     */
    public static String[] getAllDoctorNames(){
        Document userFile = getDocument("./src/main/java/dataFiles/userFile.xml");
        NodeList listOfDoctors = userFile.getElementsByTagName("doctor");
        String[] allDoctorNames = new String[listOfDoctors.getLength()];
        for(int i = 0; i<listOfDoctors.getLength(); i++){
            Node doctorsNode = listOfDoctors.item(i);
            Element doctorsElement = (Element)doctorsNode;
                 //Turn it into an element                    
            NodeList nameList = doctorsElement.getElementsByTagName("name");           
                 //Create list of elements
            Element nameElement = (Element)nameList.item(0);
                //get first element
            NodeList nameElementList = nameElement.getChildNodes();
                //get contents of name fields
            allDoctorNames[i] = 
                    ((Node)nameElementList.item(0)).getNodeValue();
            //Fill array with each name
        }
        return allDoctorNames;
    }
    
    /**
     * Finds the names of all the medicines by looping through the XML file and sends them back to
     * where the method was called as a string array.
     * @return the listOfMeds array.
     */
    public static String[] getAllMedicineNames(){
        Document medsFile = getDocument("./src/main/java/dataFiles/medicineFile.xml");
        NodeList listOfMeds = medsFile.getElementsByTagName("medicine");
        String[] allMedsNames = new String[listOfMeds.getLength()];
        for(int i = 0; i<listOfMeds.getLength(); i++){
            Node MedsNode = listOfMeds.item(i);
            Element MedsElement = (Element)MedsNode;
                 //Turn it into an element                    
            NodeList nameList = MedsElement.getElementsByTagName("name");           
                 //Create list of elements
            Element nameElement = (Element)nameList.item(0);
                //get first element
            NodeList nameElementList = nameElement.getChildNodes();
                //get contents of name fields
            allMedsNames[i] = 
                    ((Node)nameElementList.item(0)).getNodeValue();
            //Fill array with each name
        }
        return allMedsNames;
    }
    
    /**
     * Finds the comments for all the doctors by looping through the XML file and sends them back to
     * where the method was called as a string array.
     * @return the listOfComments array.
     */
    public static String[] getAllDoctorComments(){
        Document userFile = getDocument("./src/main/java/dataFiles/userFile.xml");
        NodeList listOfDoctors = userFile.getElementsByTagName("doctor");
        String[] allDoctorComments = new String[listOfDoctors.getLength()];
        for(int i = 0; i<listOfDoctors.getLength(); i++){
            Node doctorsNode = listOfDoctors.item(i);
            Element doctorsElement = (Element)doctorsNode;
                 //Turn it into an element                    
            NodeList commentList = doctorsElement.getElementsByTagName("feedComment");           
                 //Create list of elements
            Element commentElement = (Element)commentList.item(0);
                //get first element
            NodeList commentElementList = commentElement.getChildNodes();
                //get contents of name fields
            allDoctorComments[i] = 
                    ((Node)commentElementList.item(0)).getNodeValue();
            //Fill array with each name
        }
        return allDoctorComments;      
    }
    
    /**
     * Finds the ratings of all the doctors by looping through the XML file and sends them back to
     * where the method was called as a string array.
     * @return the listOfRatings array.
     */
     public static String[] getAllDoctorRatings(){
        Document userFile = getDocument("./src/main/java/dataFiles/userFile.xml");
        NodeList listOfDoctors = userFile.getElementsByTagName("doctor");
        String[] allDoctorRatings = new String[listOfDoctors.getLength()];
        for(int i = 0; i<listOfDoctors.getLength(); i++){
            Node doctorsNode = listOfDoctors.item(i);
            Element doctorsElement = (Element)doctorsNode;
                 //Turn it into an element                    
            NodeList ratingList = doctorsElement.getElementsByTagName("averageRating");           
                 //Create list of elements
            Element ratingElement = (Element)ratingList.item(0);
                //get first element
            NodeList ratingElementList = ratingElement.getChildNodes();
                //get contents of name fields
            allDoctorRatings[i] = 
                    ((Node)ratingElementList.item(0)).getNodeValue();
            //Fill array with each name
        }
        return allDoctorRatings;      
    }
    
    /*Finish this method later for one doctor.
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
