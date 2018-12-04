Travelport uAPI Sessionless Universal Record Cancel Reference Implementation Java
===============
### Overview:
The reference implementation was completed in Java using Spring Boot to connect with Travelport Universal API. The workflows these implementions are showcasing universal record cancel. Minimum fields to complete this workflow have been done using best practices in Java, TDD, and restful web services. The implementation is meant as a starting point for anyone to consume uAPI and additional modifiers can be added for additional business needs. 


### Software requirements:
1. [Eclipse Oxygen](www.eclipse.org/oxygen/)
2. [Apache Maven 3.5.2](www.maven.apache.org/download/cgi)
3. [Spring boot](www.spring.io)
3. [Apache CXF 3.2.1](www.cxf.apache.org)
4. [Postman](www.getpostman.com)

### Credentials
1. Application.yml are the credentials that will need to be populated before sending a request
2. Directory location of application.yml: uAPIBook_Java\src\main\resources\application.yml
3. The four fields to populate are: username, password, branch, and endpoint

## Run project

### Travelport API type: uAPI [(Universal API)](https://support.travelport.com/webhelp/uapi/uAPI.htm)
* Version: 18.2
* Schema: v_45_0
* Workflow: [Universal Record Cancel](https://support.travelport.com/webhelp/uapi/uAPI.htm#Booking/Cancel/Canceling_Bookings.htm%3FTocPath%3DUniversal%2520Records%2520and%2520Bookings%7CCanceling%2520Bookings%7C_____0)

* WSDL used for Universal Record Cancel include: air_v45_0, common_v_45_0, and universal_v45_0

### Eclipse

1. Clone the project
2. Open Eclipse and import the project into the workspace
3. Open terminal on Eclipse: Go to Window/Show View/Terminal
4. CD (change directory) to the root folder of the project where the pom.xml lives
4. Run command "mvn install"
5. Run application.java as a "Java Application"  

#### Testing
1. All tests are located inside src/test
2. Run ...test.java by running as a "Junit Test"

### Postman  Universal Record Cancel
1. Open postman and make a post request
2. URL set to: http://localhost:9010/RecordCancel
3. Set headers for the request with:
 	* Key set to: Content-Type
 	* Value set to: application/json 
4. You can view the request schema at http://localhost:9010/swagger-ui.html
5. Example of a body for the request:

		{
		"traceId": "C53E94E40A07643B58B7AD4FEAB482B6",
		"locatorCode": "UQ6X1W",
		"version": "1"
		}
5. Click "Send"