# airecruiter
VanHack - Artificially Intelligent Recruiter

My (late) submit to the April/2017 Vanhackaton. It is a simple Applicant Tracking System (ATS) application.

Instructions:

1) First, you create tables using the src/main/sql/tables.sql MySQL script.

2) Configure database connection in src/main/resources/META-INF/persistence.xml file.

3) You run the com.vanhack.airecruiter.Main class, which is a batch process. It populates the new JOBCOMPATIBILITY table with pre-processed data.

4) You build the application in Maven and deploy the resulting WAR file. In /airecruiter/list-jobs.html web URL you can list all available jobs. Click in any of them will open a second screen listing all users, together with a compatibility score for that job, ranging from 0% to 100%. The user list is sorted by score.

Compatibility score is calculated by crossing data between job skills and user skills.

Technologies employed:
JAVA EE, JPA/Hibernate, Spring MVC, JSON, REST, HTML 5, Javascript, Angular.js.

Tested in a Firefox/Wildfly/MySQL infrastructure.