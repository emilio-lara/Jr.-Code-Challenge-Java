package main;

import java.sql.*;
import java.util.List;

/*
 * 	This class will create all DB need to create new table and insert records into 
 */
public class DB {
	Connection conn = null;
	Statement statement = null;

	public Statement dbConnection(String dbPath) throws SQLException {

		conn = DriverManager.getConnection("jdbc:sqlite:" + dbPath);
		statement = conn.createStatement();
		System.out.println("connected");

		return statement;

	}
	// This will create table and the schema 
	public void createTable(String table) throws SQLException {
		String querie = "CREATE TABLE IF NOT EXISTS " + table +"(" +
				" A TEXT," +
				" B TEXT," +
				" C TEXT," +
				" D TEXT," +
				" E TEXT," +
				" F TEXT," +
				" G TEXT," +
				" H TEXT," +
				" I TEXT," +
				" J TEXT )";

		execute(querie);
		System.out.println("table created");
	}
	// This method will insert records from a arraylist
	public void insert(String table, List rec) throws SQLException {
		long startTime = System.currentTimeMillis();
		long endTime = 0;
	
		
		PreparedStatement pstatement = conn
				.prepareStatement("INSERT INTO " + table + "(A,B,C,D,E,F,G,H,I,J) " + "VALUES(?,?,?,?,?,?,?,?,?,?)");
		for (int i = 1; i <rec.size(); i++) {
			System.out.println("insert record# " + i);
		
			pstatement.setString(1, ((Schema) rec.get(i)).getA());
			pstatement.setString(2, ((Schema) rec.get(i)).getB());
			pstatement.setString(3, ((Schema) rec.get(i)).getC());
			pstatement.setString(4, ((Schema) rec.get(i)).getD());
			pstatement.setString(5, ((Schema) rec.get(i)).getE());
			pstatement.setString(6, ((Schema) rec.get(i)).getF());
			pstatement.setString(7, ((Schema) rec.get(i)).getG());
			pstatement.setString(8, ((Schema) rec.get(i)).getH());
			pstatement.setString(9, ((Schema) rec.get(i)).getI());
			pstatement.setString(10, ((Schema) rec.get(i)).getJ());
		
			pstatement.executeUpdate(); 
		}
		pstatement.close();
		
		endTime = System.currentTimeMillis();
		
		long totalTime =  (-1*(startTime - endTime) /1000);
		int secondLeft = (int) (totalTime%60);
		int minutes = (int) (totalTime/60);
		System.out.println("total time execution= minutes "+minutes+" seconds "+secondLeft);
		

	}
	// this method will drop a table 
	public void dropTable(String table) throws SQLException {
		String querie = "DROP TABLE IF EXISTS " + table;
		execute(querie);
		System.out.println("table droped");

	}
	// This method use as helper to execute the statement 
	public void execute(String querie) throws SQLException {
		statement.execute(querie);

	}
	
	// Method that close all DB connections 
	public void closeConnection() throws SQLException {
		conn.close();
		statement.close();
	}

}
