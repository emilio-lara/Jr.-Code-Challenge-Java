MS3 Jr. coding challenge
Emilio lara

IDE: Sprint Tool Suit 4
DB: Sqlite3

The challenge project was created in IDE Spring Tool Suit 4 as a Maven project.
It is recommended to import the project in the same IDE to work correctly.
The maven pom file import all the SQLite drivers to connect the database;
 
There are three classes named "Main," "DB," and "ReadingRecods."
The Main class has the "main" method that will run the project and executed the rest of the classes;
In the "main" method, the path for the database needs to be changed as whatever path is on your machine.
The database file is located in the project folder name "JavaSqliteInsertTable".
Please follow this format, or will not be able to find DB.
E.G	String path="C:\\Users\\16825\\Desktop\\MS3\\Java\\JavaSqliteInsertTable\\test.db";.

The main method will initialize the ReadingRecods class to read the file "ms3Interview.csv".
Also will initialize the DB class to connect with the database and create a table and insert good records.
Finally, it will close all the connections with the database.

The ReadingRecods class will create two global ArrayList and a counter to store good and bad records.
The "readFile" method will take the path of the file as a string and open "ms3Interview.csv" to read it.
A while loop will go through the lines of the file and tokenize each string into an array.
A sub for loop will check logic for empty cells or the right size of items in the row.
After that, more logic will store the good or bad records into the ArrayList and count the total amount of records.
Once the "readFile" is done will create two files into the project folder "JavaSqliteInsertTable." 
The first file is "bad_records.csv," which contains all the wrong records. 
The second one is "report.log," which contain a report of all total, failed, and successful records found in 
the "ms3Interview.csv" file.

The DB class will have methods to open connection, drop table, create table schema, insert records, and closed all connections.

The method "dbConnection" will initialized the global variable "Connection conn = null;" and "Statement statement = null;"
this will allow other methods as need it and save code lines.

The method "execute" is a helper for execute statements for queries. This will save lines of code.
The method "dropTable" will drop any old table with the same name.

The method "createTable" will create a table with schema required for the table.

The method "insert" will insert the good record into the table from the ArrayList create into the ReadingRecods class; this will separate
io operation from db operation. For insert records, the PreparedStatement is used for safer operation. This a good practice to avoid SQL injections. 

The method "closeConnections" just closed all global database connections. 

Note: Insert records into table may take long time. For every thousand records will take from 2 to 2.5 minutes.
Due to time contrains I was not able to find faster queries to insert records.


 
	
