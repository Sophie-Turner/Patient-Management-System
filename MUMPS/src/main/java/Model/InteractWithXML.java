
package Model;
import org.xml.sax.*; //faster way to read data from XML.
import org.w3c.dom.*; //read and write XML.
import javax.xml.parsers.*; //store XML elements as DOM objects.
/**
 *
 * @author pipin
 * Reads data from the XML file and sends it to the program.
 * <p>
 * Clean up these methods later. 
 * Some of these methods are polymorphisms of one another.
 * Reduce repeated code and separate classes in keeping with SOLID. 
 * Use relevant design pattern.
 * </p>
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
     * This method recalculates the average rating of a doctor each time a new piece of feedback is approved. 
     * @param userId the doctor's username.
     * @param newRating the rating from the newly approved feedback.
     * @return the newly calculated average.
     * <p>It loops through the doctors to do a linear search for the doctor in question.
     * Then it counts the number of approved feedbacks. Then it gets the average rating of that doctor so far, 
     * and adds the new rating to it. It adds 1 to the number of feedbacks and divides to get the new average.</p> 
     */
    public float calculateAverageRating(String userId, float newRating){
        float averageRating=0;
        int numOfFeedbacks = 1;
        
        //Get the file
        Document userFile = getDocument("./src/main/java/dataFiles/userFile.xml");
        
        //make a list of doctors
        NodeList listOfDoctors = userFile.getElementsByTagName("doctor");
        
        //loop through the doctors
        for(int i = 0; i<listOfDoctors.getLength(); i++){
            //move to the next doctor
            Node doctorNode = listOfDoctors.item(i);
            //put it into an element
            Element doctorElement = (Element)doctorNode;
            
            //Get the userId element for this doctor
            NodeList userIdList = doctorElement.getElementsByTagName("userId");
            //put it into an element
            Element userIdElement = (Element)userIdList.item(0);           
            //get the value/s 
            NodeList userIdElementList = userIdElement.getChildNodes();            
            //see if this is the correct userId
            if(userIdElementList.item(0).getNodeValue() == userId){
                
                //get the feedback element for this doctor
                NodeList feedbackList = doctorElement.getElementsByTagName("feedback");                
                
                //loop through the feedback
                for(int j=0;j<feedbackList.getLength();j++){                
                    //move to the next feedback
                    Node feedbackNode = feedbackList.item(j);
                    //put it into an element
                    Element feedbackElement = (Element)feedbackNode;
                    
                    //Get the approved element for this feedback
                    NodeList approvedList=feedbackElement.getElementsByTagName("feedApproved");
                    //put it into an element
                    Element approvedElement = (Element)approvedList.item(0);
                    //get the value
                    NodeList approvedElementList = approvedElement.getChildNodes();                                       
                    //See if the feedback was approved.
                    if(approvedElementList.item(0).getNodeValue() == "true"){
                        numOfFeedbacks++;                        
                    }
                }
            //get the average element for this doctor
            NodeList averageList = doctorElement.getElementsByTagName("averageRating");
            //put it into an element
            Element averageElement = (Element)averageList.item(0);           
            //get the value/s 
            NodeList averageElementList = averageElement.getChildNodes();            
            //convert the value to a number 
            averageRating = Float.parseFloat(averageElementList.item(0).getNodeValue());
            //now do the calculation.
            averageRating = (averageRating + newRating)/numOfFeedbacks;
            //no need to continue looping through doctors.
            break;
            }
        }
        return averageRating;
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
                //get contents of fields
            allDoctorComments[i] = 
                    ((Node)commentElementList.item(0)).getNodeValue();
            //Fill array with each comment
        }
        return allDoctorComments;      
    }
    
    /**
     * Do a linear search through the doctors for the doctor we want. 
     * Then loop through their feedback and return feedback that has been approved.
     * @param whichDoctor
     * @return 
     */
    public static String[] getOneDoctorComments(String whichDoctor){
        //Get the file
        Document userFile = getDocument("./src/main/java/dataFiles/userFile.xml");
        
        //make a list of doctors
        NodeList listOfDoctors = userFile.getElementsByTagName("doctor");
        //make a string array to hold the result later
        String[] oneDoctorComments=null;
        //loop through the doctors
        for(int i = 0; i<listOfDoctors.getLength(); i++){
            //move to the next doctor
            Node doctorNode = listOfDoctors.item(i);
            //put it into an element
            Element doctorElement = (Element)doctorNode;
            
            //Get the userId element for this doctor
            NodeList userIdList = doctorElement.getElementsByTagName("userId");
            //put it into an element
            Element userIdElement = (Element)userIdList.item(0);           
            //get the value/s 
            NodeList userIdElementList = userIdElement.getChildNodes();            
            //see if this is the correct userId
            if(userIdElementList.item(0).getNodeValue() == whichDoctor){
                
                //get the feedback element for this doctor
                NodeList feedbackList = doctorElement.getElementsByTagName("feedback");
                //now we have the feedback list we can set the length of the array               
                oneDoctorComments = new String[feedbackList.getLength()];
                //loop through the feedback
                for(int j=0;j<feedbackList.getLength();j++){                
                    //move to the next feedback
                    Node feedbackNode = feedbackList.item(j);
                    //put it into an element
                    Element feedbackElement = (Element)feedbackNode;
                    
                    //Get the approved element for this feedback
                    NodeList approvedList=feedbackElement.getElementsByTagName("feedApproved");
                    //put it into an element
                    Element approvedElement = (Element)approvedList.item(0);
                    //get the value
                    NodeList approvedElementList = approvedElement.getChildNodes();                                       
                    //See if the feedback was approved.
                    if(approvedElementList.item(0).getNodeValue() == "true"){
                        
                        //get the comment element for this feedback
                        NodeList commentList = feedbackElement.getElementsByTagName("feedComment");
                        //put it into an element
                        Element commentElement = (Element)commentList.item(0);
                        //get the value
                        NodeList commentElementList = commentElement.getChildNodes();
                        //Put the feedback into the array.
                        oneDoctorComments[j]=((Node)commentElementList.item(0)).getNodeValue();
                    }else{
                        //or not
                        oneDoctorComments[j]="Unapproved comment.";
                    }
                }
            break;
            }
        }
        return oneDoctorComments;
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
    
public static String[][] getDoctorFeedbackObject(){
        String[][] doctorFeedbackObject = new String[][]{};
        Document userFile = getDocument("./src/main/java/dataFiles/userFile.xml");
        NodeList listOfDoctors = userFile.getElementsByTagName("doctor");

        for(int i = 0; i<listOfDoctors.getLength(); i++){
            Node doctorNode = listOfDoctors.item(i);
            Element doctorElement = (Element)doctorNode;
            
            //get the name
            NodeList nameList = doctorElement.getElementsByTagName("name");           
                 //Create list of elements
            Element nameElement = (Element)nameList.item(0);
                //get first element
            NodeList nameElementList = nameElement.getChildNodes();
                //get contents of name fields
            
            //Put the name into the object
            doctorFeedbackObject[i][0] = ((Node)nameElementList.item(0)).getNodeValue();
            
            //get the average rating
            NodeList ratingList = doctorElement.getElementsByTagName("averageRating");           
                 //Create list of elements
            Element ratingElement = (Element)ratingList.item(0);
                //get first element
            NodeList ratingElementList = ratingElement.getChildNodes();
            
            //Put the avg ragint into the object
            doctorFeedbackObject[i][1] = ((Node)ratingElementList.item(0)).getNodeValue();
            
            //get the feedback element for this doctor
            NodeList feedbackList = doctorElement.getElementsByTagName("feedback");
            //move to the next feedback
            Node feedbackNode = feedbackList.item(0);
            //put it into an element
            Element feedbackElement = (Element)feedbackNode;

            //Get the approved element for this feedback
            NodeList approvedList=feedbackElement.getElementsByTagName("feedApproved");
            //put it into an element
            Element approvedElement = (Element)approvedList.item(0);
            //get the value
            NodeList approvedElementList = approvedElement.getChildNodes();                                       
            //See if the feedback was approved.
            if(approvedElementList.item(0).getNodeValue() == "true"){
                                
                //get the comment element for this feedback
                NodeList commentList = feedbackElement.getElementsByTagName("feedComment");
                //put it into an element
                Element commentElement = (Element)commentList.item(0);
                //get the value
                NodeList commentElementList = commentElement.getChildNodes();
                
                //Put the comment into the object
                doctorFeedbackObject[i][2] = ((Node)commentElementList.item(0)).getNodeValue();
                
            }else{
                doctorFeedbackObject[i][2] = "";
            }
        }        
        
        return doctorFeedbackObject;
    } 
}
