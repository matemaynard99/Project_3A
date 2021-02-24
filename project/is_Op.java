/*
 * Class to determine if String is an allowed operator
 * @Return: returns either boolean true or false depending on if the String is a valid operator
 */
public class is_Op {
	static public boolean isOperator(String s) {
		switch (s) {
		case "^": return true;
		case "*": return true;
		case "/": return true;
		case "+": return true;
		case "-": return true;
		case ">": return true;
		case ">=": return true;
		case "<=": return true;
		case "==": return true;
		case "!=": return true;
		case "&&": return true;
		case "||": return true;
		default: return false;		
		}//end switch
	}//end isOperator method
}//end class is_Op

