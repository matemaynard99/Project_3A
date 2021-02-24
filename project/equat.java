
public class equat {
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
		        
		    case "%":
		    	return(left % right);
		        
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

}//end equate class
