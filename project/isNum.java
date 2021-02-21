public class isNum {
	//method to check if character  is a number
	//simple method to see if char is between 1-9 and thus a number
	static public boolean isNumber(char c) {
		if(c >= '0' && c <='9')
			return true;
		else
			return false;
	}//end is number check
}
