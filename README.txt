RUN
mvn jetty:run OR run.bat

The run.bat also sets the port number to 8081 incase the default port is already bound 
and also prints the full stacktrace should any exceptions happen

CONNECT
http://localhost:8080/ (default)
http://localhost:8081/ (run.bat as is)

USE
1. List of library members shown at top
2. List of all books shown at bottom
3. Click on member's ID number to update book list and display books rented by that person
4. Click on "All Books" button to go back to displaying all books

DATABASE
Location: library-app/library.db
This is an Sqlite database. It is already populated with people and books
Quick lightweight way to browse/populate the database is the sqlite manager addon for Firefox:
https://addons.mozilla.org/en-US/firefox/addon/sqlite-manager/

ECLIPSE
Import > Maven > Existing Maven Projects