package FileIO2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;



public class ReadInFile {
	
	
	/*******(Reading in a sorted file) Write a method public static int 
readInFile(String line, File file) that returns the position number 
of a line in the file filename or −1 if there is no such line or file.
We assume that this file contains names of people with a name per line.
Names (and hence lines) are listed in ascending alphabetical order in the file. 
We can not find the same line twice.********/

	public static void main(String[] args) throws Exception {
		
		//create file object
		File file = new File("names.txt");
		
		
		//check if the file exists or not
		if(!file.exists()) 
			System.out.println("file does not exists");
			System.exit(0);
		
		
		String name =" ";
		System.out.println(readInFile(name, file));	
		
		
	}
	
	
	public static int readInFile(String line,File file) throws Exception  {
		int cnt = 0;
		
		try(Scanner readFile = new Scanner(file))
		{
			//read the file and increase the cnt for every line
			while(readFile.hasNext()) {
				line = readFile.next();
				cnt++;
			}
			
			//if file is empty return -1
			if(line != " ") 
				return cnt;
			else {
				return -1;
			}
				
		}
		
		 
	}  

	
}
