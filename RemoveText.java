package FileIO2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;




public class RemoveText {

	
	/*********(Remove text) Write a program that removes all the occurrences of a specified 
string from a text file. For example, invoking
java Exercise12_11 John filename
removes the string John from the specified file. Your program should get the 
arguments from the command line.*******/
	
	
	public static void main(String[] args) {
		
		File file = new File("removetext.txt");
		
		if(file.exists())
			System.out.println("file exists");
		else {
			System.out.println("file does not exists ");
			System.exit(0);
		}
		
		
		String newFile = ""; 
		
		//scan File
		try {
			
		Scanner readFile = new Scanner(file);
		while(readFile.hasNext()) 
		   newFile +=	readFile.next();
		
		}catch(FileNotFoundException e){
			
			e.printStackTrace();
		}
		
		
		
		
		newFile += newFile.replaceAll("john","");
		
		//write File
		try {
			
		java.io.PrintWriter writeFile = new java.io.PrintWriter(file);
		System.out.println(newFile);
		writeFile.write(newFile);
		writeFile.close();
		
		}catch(FileNotFoundException ex){
			
			ex.printStackTrace();
		}
		
	}

}
