# NASAApiProject
 


#API Details: 

APOD API
One of the most popular websites at NASA is the Astronomy Picture of the Day.


#HTTP Request
GET https://api.nasa.gov/planetary/apod


#Query Parameters
Parameter	Type	Default	Description
date	YYYY-MM-DD	today	The date of the APOD image to retrieve
start_date	YYYY-MM-DD	none	The start of a date range, when requesting date for a range of dates. Cannot be used with date.
end_date	YYYY-MM-DD	today	The end of the date range, when used with start_date.
count	int	none	If this is specified then count randomly chosen images will be returned. Cannot be used with date or start_date and end_date.
thumbs	bool	False	Return the URL of video thumbnail. If an APOD is not a video, this parameter is ignored.
api_key	string	DEMO_KEY	api.nasa.gov key for expanded usage

#Example query
https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY

#Author/Contributor
Jeevitha

#Prerequisites
java version "1.8.0_201"+
Eclipse/IntelliJ with Maven&TestNg Plugins


#Tools & Technologies Used 
Tech - java Plugin's - Maven & TestNg Dependencies - testng v 6.8.5 , poi - 3.10-FINAL, poi-ooxml - 3.10-FINAL , rest-assured - 4.3.2, extentreports - 3.0.5


#Framework & Design Pattern
For this project TestNg Framework used in Page Object Model(POM) designed pattern . Page class contains web elements and methods to interact with web elements and object of these Page Classes and interact with web elements by calling the methods of these classes

#Reporting
Used aventstack Extent reports to genearate test results report 

#Steps to Run the Script 
Step 1 : Make sure system having all Prerequisites 
Step 2 : Clone project from Git Repo to local directory 
Step 3 : Import project into IDE (Import as Maven Project) 
Step 4 : Run As ‘NasaProjectApiSuite.xml’ with TestNg (userdir\TestRunner\NasaProjectApiSuite.xml) 
Step 5 : Wait for test completion 
Step 6 : Test Results Reports will be generated under Reports folder in framework (userdir/Reports)


