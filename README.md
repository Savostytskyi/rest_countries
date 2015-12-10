# REST - countries service
<h2>How to run:</h2>

1. Run Tomcat server.
2. Run MySQL server and import database from ../db/countries.sql.
3. Install Gradle if needed.
3. Open cmd, navigate to root project folder.
4. Type: <code><b>gradle deploylocal -Ptomhome="$path_to_tomcat"</b></code> (e.g. "C:/xampp/tomcat").
5. Wait for deploy on tomcat finished. 
6. For test REST service type: <code><b>gradle unittest</b></code>

<b>SUCCESS!</b>
