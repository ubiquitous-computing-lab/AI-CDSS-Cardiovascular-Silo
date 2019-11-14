# AI CDSS Cardiovascular Silo (Diagnosis)
<!-- make your own badges from here: http://shields.io/ -->
[![Version](https://img.shields.io/badge/IMP-2.5-green.svg)](http://imprc.cafe24.com/)
[![License](https://img.shields.io/badge/Apache%20License%20-Version%202.0-yellowgreen.svg)](https://www.apache.org/licenses/LICENSE-2.0)

# 1. Introduction
This application is able to collect, store and manage patient data. The authorized domain experts can access and manage the patient data and can use the 
AI based servcies for intelligent intervention generation based on provided patient information.
Cardiovascular AI-CDSS is a cloud based application, which comprises different user interfaces to facilitate the physicians for making right decisions for the right patients at right time. It contains a login screen, dashboard, patient details Screen, and AI-CDSS intervention screen.

Login Screen: This screen facilitates the authorized physicians only to log in to the system with the help of their assigned credentials and rights.

Dashboard Screen: This screen shows all the existing patients at a glance to physicians with important attributes such as Patient MRN no. Patient Name, Age, Gender, Initial symptoms, and encounter date. It also facilitates the physicians to add new patient, modify existing patient, or delete some patient.

Patient Detail Screen: This screen manages the details of patients such as Patient demographic information, patient symptoms, clinical history, physical exam information, and laboratory exam information.

CDSS Intervention Screen: The CDSS intervention facilitates the physicians to make decision based on the information provided on patient detail screen. The decision provided by the system is HFpEF Confirm.



# 2. Requirements

This whole package contains two components, one is CardiovascularInterface and second is CardiovalscularServices.
CardiovascularInterface provides the code for user interace (GUI) for physicians to login, adding and modifying patients data, and finding the recommendations. The CardiovalscularServices provides the functionality to communicate the data between the user interfaces and system's database. It is responsible to retrive and persist the data into database.

## 2.1. Requirements for Cardiovascular User Interfaces

Wamp/Xampp (Apache) server
Backend services 

Installation:

Put the package to the concern folder of apache server. 
Update the services URL in the app\app.js folder.
Access the project url in the browser.

## 2.2. Requirements for Cardiovascular Web Services
Example:
- Database: Microsoft SQL Sever 2012 R2
- Java version: JDK 1.8 
- Maven: Apache-maven-3.2.2
- Tomcat: Apache-tomcat-8.0.{xx}

## 2.2 Installation
- Database Intallation:
	*	Microsoft SQL Sever 2012 and more latest version
	*	Install the database and set its password and login id
	*	Where Server name is (local)
	*	Authentication is set to “SQL Server Authentication”
	*	Create a database with Name “Cardiovascular”
	*	Select the database “Cardiovascular” and right click and select new query
	*	Download the “CardiovascularSchema.sql”.
	*	Open the “CardiovascularSchema.sql" file.
	*	Copy all the queries and paste into  new query window.
	*	Then Execute the query, it will create database with whole schema.
	*	We can open the data of patients due security and privacy issue.

- Java and JDK setup
	JDK and JAVA_HOME
	*	Make sure JDK is installed, and “JAVA_HOME” variable is added as Windows environment variable
- Apache Maven Installation
	*	Download Apache Maven and install it
	*	Visit Maven official website, download the Maven zip file,
		for example : apache-maven-3.3.9-bin.zip. Unzip it to the folder you want to install Maven.
		(Assume you unzip to this folder – C:\Program Files\Apache\maven)
	*	Add MAVEN_HOME
	*	Add  MAVEN_HOME variables in the Windows environment, and point it to your Maven folder.
	*	Add to PATH
	*	Update PATH variable, append Maven bin folder, so that you can run the Maven’s command everywhere.
	*	Verification by running  mvn –version in the command prompt.
-Apache Tomcat Installation
	*	Goto http://tomcat.apache.org ⇒ Downloads ⇒ Tomcat 8.0 ⇒ "8.0.{xx}" (where {xx} is the latest upgrade number) ⇒ Binary Distributions ⇒ Core ⇒ "ZIP" package (e.g., "apache-tomcat-8.0.{xx}.zip", about 8 MB).
	*	Create your project directory, say "drive:\myProject" or "drive:\myProject". UNZIP the downloaded file into your project directory. Tomcat will be unzipped into directory "drive:\myProject\apache-tomcat-8.0.{xx}".
	*	For ease of use, we shall shorten and rename this directory to "drive:\myProject\tomcat".
-Build Project
	*	Download src and pom file into the appropriate project folder
	*	Start Command Prompt
	*	Change the directory to your project directory and folder
	*	Run “mvn clear install” command
	*	After succesful project build  
	*	Go to Project folder and access the target folder to copy Cardiovascular.war file
	*	Go to apache-tomcat\webapps folder and paste war file there.
	*	Go to apache-tomcat\bin and start the tomcat server by click on startup.bat file.
	*	Second way, open the Cardiovascular project in eClips IDE.
	*	Right click in any place of the Cardiovascular application.Config file.
	*	Click on "Run as a Java Application".
	
# 3. Contributors

#### Principal Investigator

-  Professor Sungyoung Lee (sylee@oslab.khu.ac.kr)
-  Professor Dong-Ju Choi (djchoi@snubh.org)

#### Technical Lead 

-  Taqdir Ali (taqdir.ali@oslab.khu.ac.kr)

#### Domain Experts (Physicians)

-  Professor Dong-Ju Choi (djchoi@snubh.org)
-  Professor Jin Joo Park (jinjooparkmd@gmail.com)
