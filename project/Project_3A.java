import java.io.*;
/*
 * SAM'S TO-DO LIST
 * NEED TO CREATE A METHOD TO CONVERT STRINGS OF EXPRESSIONS FROM FILE INTO A TREE 
 * CALL EVALUATETREE METHOD IN MAIN
 * create 2 stacks, one for operators and one for operands
 * 
 */
public class Project_3A {
		
	/*supporting method to go at end of tree creation method
	 * takes the created tree, runs through branches, and evaluates equation
	 * is recursive in order to save space and time.
	 */
	static public int evaluateTree(Node root) {
		//check if node is empty
		if (root == null) {
			return 0;
		}//end if
		//checks if node is a leaf, and returns integer value if so
		if((root.left == null) && (root.right == null)) {
			return (int) root.data;
		}//end if for leaf check
		/*node is not leaf, thus should be an operator
		 * gets data from children and performs equation based off them
		 */
		else {
			int left = evaluateTree(root.left);
			int right = evaluateTree(root.right);
			return(equation(left, right, (String) root.data));
		}
	}//end evaluate tree method
	
	
	//method to check operator and run equation based on it
	static public int equation(Integer left, Integer right, String s) {
		
		switch(s) {
        
		default: return 0;
	    case "+":
	        return(left + right);
	     
	    
	    case "-":
	        return(left - right);

	        
	    case "*":
	        return(left * right);

	    case "/":
	        return(left / right);

	        
	    case "^":
	        return (int) (Math.pow(left, right));

	        
	    case ">":
	        if(left > right) {
	            return 1;
	        }
	        else {
	            return 0;
	        }
	   
	        
	    case "<":
	        if(left < right) {
	            return 1;
	        }
	        else {
	            return 0;
	        }
	      
	        
	    case ">=":
	        if(left >= right) {
	            return 1;
	        }
	        else {
	            return 0;
	        }
	  
	        
	    case "<=":
	        if(left <= right) {
	            return 1;
	        }
	        else {
	            return 0;
	        }
	
	        
	    case "==":
	        if(left == right) {
	            return 1;
	        }
	        else {
	            return 0;
	        }
	        
	        
	    case "!=":
	        if(left != right) {
	            return 1;
	        }
	        else {
	            return 0;
	        }

	        
	    case "&&":
	    	return (left & right);
	        
	    
	    
	    case "||":
	    	return (left ^ right);
	        
	    
		}//end switch
	}//end equation method
	

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
		 * Creates an array to store Expressions.txt data
		 * Splits data at ; 
		 * ; Used in Expressions.txt to separate each expression string
		 * Iterates through every element in expressions array and prints the expression
		 * After expression is printed, calls evaluateEquation method to solve expression
		 * Prints solved expression
		 */
		String[] expressions = fileData.split(";");
		for(int i = 0; i < expressions.length; i++) {
			System.out.print(expressions[i] + " solved is: ");
		}//end for loop

	}

}
