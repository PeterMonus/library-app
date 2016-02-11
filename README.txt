RUN
mvn jetty:run OR run.bat 
The run.bat also sets the port number to 8081 incase the default port is already bound

CONNECT
http://localhost:8081/

DATABASE
Location: library-app/library.db
This is an Sqlite database. It is already populated with people and books
Quick lightweight way to browse/populate the database is the sqlite manager addon for Firefox:
https://addons.mozilla.org/en-US/firefox/addon/sqlite-manager/

ECLIPSE
Import > Maven > Existing Maven Projects