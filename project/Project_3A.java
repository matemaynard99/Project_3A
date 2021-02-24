import java.io.*;

public class Project_3A {

	public static void main(String[] args) throws IOException {
		/*
		 * File and buffer reader to read the data from Expressions.txt
		 * Separates each expressions using the ';' char
		 */
		FileReader fr = new FileReader("Expressions.txt");
		BufferedReader br = new BufferedReader(fr);
		String fileData="", l="";
		while((l=br.readLine())!=null) { 
		    fileData += l;
		}
		br.close();
		 
		/**
		 * Creates an array to store Expressions file data
		 * Splits data at ; 
		 * ; Used in Expressions.txt to separate each expression string
		 * Iterates through every element in expressions array and prints the expression
		 * After expression is printed, calls evaluateEquation method to solve expression
		 * Prints solved expression
		 */
		String[] expressions = fileData.split(";");
		for(int i = 0; i < expressions.length; i++) {
			System.out.println(toTree.treeBuilder(expressions[i]));
		}//end for loop
		
	}//end main

}//end class

