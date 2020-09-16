package main;

import java.io.IOException;
import java.sql.SQLException;

public class Main {
	
	// The main method is use as start to call the additional classes to implement DB operations and read and create files
	public static void main(String[] args) {
		String file = "ms3Interview.csv"; // File to read
		String dbPath="C:\\Users\\16825\\Desktop\\MS3\\Jr.-Code-Challenge-Java\\Java\\JavaSqliteInsertTable\\test.db"; // DB path location
		String table = "records"; // name of the table to be create
		
		DB db= new DB();// Initialize class DB
		ReadingRecods records = new ReadingRecods(); // Initialized class ReadingRecords
		try {
			records.readFile(file);
			//System.out.println(records.valid.get(0).getA());
			db.dbConnection(dbPath);
			db.dropTable( table);
			db.createTable(table);
			db.insert(table, records.valid);
			db.closeConnection();
		}catch (SQLException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}

}
