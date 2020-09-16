package main;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadingRecods {
	
	List<Schema> valid; // store good records
	List<String> failed; // store bad records
	static int recieved; // count all records

	public ReadingRecods() {
		valid = new ArrayList<Schema>();
		failed = new ArrayList();
		recieved = 0;
		
	}
	// This method will read a file from ms3Interview.csv and store good and and bad records into ArrayList and create two 
	// Files  bad_records.csv and report.log for requirements
	public void readFile(String file) throws IOException {
		FileWriter fw = new FileWriter("bad_records.csv"); // file with all bad records
		FileWriter fl = new FileWriter("report.log"); // report of records good and bad and total
		FileReader fr = new FileReader(file);
		
		PrintWriter pw = new PrintWriter(fw);
		PrintWriter pwl = new PrintWriter(fl);
		BufferedReader br = new BufferedReader(fr);
		
		String str = "";
		boolean goodRecord = true;
		while ((str = br.readLine()) != null) {
			recieved++;
			String[] array = str.split(",");
			
			for (int i = 0; i < array.length; i++) {// this loop check for empty strings
				if (array[i].equals("")) {
					goodRecord = false; // empty string is a bad record
				}
			}
			
			if (goodRecord) {
				if(array.length==11) { // make sure is the right number of items required
					    valid.add(new Schema(
					    			array[0],
					    			array[1],
					    			array[2],
					    			array[3],
					    			array[4]+array[5],
					    			array[6],
					    			array[7],
					    			array[8],
					    			array[9],
					    			array[10]
					    		
					    		
					    		));
				}
			} else {
				failed.add(str);		// adding failed record into arraylist
				pw.println(str);// writing into bad records file
			}

			goodRecord = true;
		}
		// Writing into log file 
		pwl.println(recieved+" of records received");
		pwl.println(valid.size()+" of records successful");
		pwl.println(failed.size()+" of records failed");
		
		br.close();
		pw.close();
		pwl.close();

	}

}
