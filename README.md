# SFU-Course-Planner

The students of SFU face some problems during the time of enrollment for the next semesters and they want to know the complete information about the course. Students want to know about the previous terms in which this course was offered and which professors offered the course and how many students enrolled in the course and in which year and semester. In order to create this help for the students, there was a need of one stop webApp for SFU students and hence this app was designed so that students can get all the information about the courses during the time of their enrollment.

## Getting Started

The website is not hosted on the server yet. Hence the user needs to clone the project and run the website on the localhost. The user might want to download an IDE for java in order to easily understand the code and to run on the localhost. 

## Technical Information

Front end : HTML/CSS/axiom
Back end : Java
Requirements to run the application : IDE to support Java, Java SDK, JDK 8 
Dependencies : Java Spring for REST API
API used:
"api/about" - Tells about the author of the website and the functionality of the website
"api/dump-model" -  Clears the database so it can reloaded
"api/departments" - Gives list of all departments in SFU
"api/departments/{id}/courses" - Gives list of all courses offered in a particular department in SFU
"api/departments/{id}/courses/{courseId}/offerings" -  Gives list of all courses offered in a particular department in SFU in particular semester of the year
"api/stats/students-per-semester" - Give status of students enrolled in the class or on a waitlist
"/api/watchers" -  Adds a watcher for a particular course to notify students about the status of the course


No database is used and backend is store in a CSV file

## Contributing

If you think that there can be some changes that can be made in order to make the backend faster, the changes are welcome. You can make a change and generate a pull request and add some description to explain what was the need for the change and how it can be helpful and it will be considered.
