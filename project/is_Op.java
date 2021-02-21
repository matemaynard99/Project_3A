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
}
