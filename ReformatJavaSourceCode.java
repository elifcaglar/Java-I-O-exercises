package FileIO2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class ReformatJavaSourceCode  {
	
	/***(Reformat Java source code) Write a program that converts the Java source 
code from the next-line brace style to the end-of-line brace style. For example, 
the following Java source in (a) uses the next-line brace style. Your program 
converts it to the end-of-line brace style in (b)

****************************************************

a)nextline brace style

public class Test
{
 public static void main(String[] args)
 {
 // Some statements
 }
}

**************************************************

b)end of line brace style

public class Test {
 public static void main(String[] args) {
 // Some statements
 }
}

*************************************************
Your program can be invoked from the command line with the Java source-code 
file as the argument. It converts the Java source code to a new format. For example, the following command converts the Java source-code file Test.java to 
the end-of-line brace style.
java Exercise12_12 Test.java
*****************************************************/

	public static void main(String[] args) throws Exception {
		
		if(args.length < 2) {
			System.out.println("invalid arguments in command line");
			System.exit(0);
		}
		
		
		//create object file and check if it does exists or not
		File file = new File(args[0]);
        	
		if(file.exists()) 
        		System.out.println("FILE EXISTS");
        	else {
				System.out.println("FILE " + args[0] + "DOES NOT EXISTS");
				System.exit(0);
			}
		
		ArrayList<String> list= new ArrayList<>();
		
		String s1 = " ";
		String s2 =" ";
		
				
			
		
		
		//scan the source code and convert next line brace style to end of line style
		try(Scanner readFile = new Scanner(file)){
			s1 = readFile.nextLine();
			while(readFile.hasNext()) {
				s2 = readFile.nextLine();
				if(s2.length() > 0 && s2.charAt(s2.length() -1 ) == '{') { 
					list.add(s1.concat("{"));
					s1 = readFile.nextLine();
				
				}else {
			 	list.add(s1);
				s1 = s2;
				}
			
			}
		
		list.add(s1);
		
		}	
		
    
    
    
		try(java.io.PrintWriter writeFile = new java.io.PrintWriter(file)){
			
			for(int i = 0;i < list.size();i++)
				writeFile.print(i);
		}
	
		
			
		

	}

}
