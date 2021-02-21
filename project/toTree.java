import java.util.*;

public class toTree {
	/*
	 * trying to convert every part of the expressiom to either a number or operator (includes ( and ))
	 * Dont evaluate here, Shane wrote that already
	 * Just break the expression down into its parts and add to each stack as needed.
	 * Parentheses are important for tree 
	 * When closing paren found, pop two numbers and one operator, numbers are children operator is root
	 * may need to write further from that website design, may be over complicating. 
	 * KEEP IT SIMPLE
	 * 
	 */
	
	/*
	 *  tree node
	 */
	public class TNode<T> {
	    // Data fields
	    public T data;
	    public TNode<T> left, right;
	    // Constructors
	    public TNode(T value) { data = value; }
	    
	    public TNode(T value, TNode<T> leftChild, TNode<T> rightChild) {
	        data = value;
	        left = leftChild;
	        right = rightChild;
	    }

		public TNode() {
			// TODO Auto-generated constructor stub
		}
	    
	    
	}//end TNode
	
	public TNode treeBuilder(String expression) {
		Stack<Integer> numbers = new Stack<>();
		Stack<String> operators = new Stack<>();
		
		expression = expression + "";
		
		char[] tokenArray = expression.toCharArray();
        		
		for (int i = 0; i<tokenArray.length-1; i++) {
			//simple line to ignore spaces
			if (tokenArray[i] == ' ') {
				continue;
			}//end if
			/*
			 * Adds numbers to numbers stack
			 */
			if (isNum.isNumber(tokenArray[i])) {
				//System.out.println(tokenArray[i]);
				/**converted char to string so it can become integer
				 * unsure how to change char to int directly
				 */
				//added while loop to catch multidigit numbers
				String newNum = "";
				while(isNum.isNumber(tokenArray[i])){
					
					newNum = newNum + tokenArray[i];
					i++;
					//add to stack of numbers as an integer
					numbers.push(Integer.parseInt(newNum));
				}//end while
				/** i has to be decrimented, since it is incremented in the while loop
				 * that way the main for loop doesnt skip any tokens in the equation
				 */
				i--;
			}//end if, end add number section
			
			else if(tokenArray[i] == '(') {
				String newOp = "";
				newOp = newOp + tokenArray[i];
				operators.push(newOp);
			}//end open parenthesis branch
			//check for closing parenthesis
            
			else if(tokenArray[i] == ')') {
				//System.out.println(nums);
				while(!operators.peek().equals("(")) {
					TNode newLeafL = new TNode();
					TNode newLeafR = new TNode();
					TNode newRoot = new TNode();
					newLeafR.left = null;
					newLeafR.right = null;
					newLeafR.data = numbers.pop();
					newLeafL.left = null;
					newLeafL.right = null;
					newLeafL.data = numbers.pop();
					newRoot.data = operators.pop();
					newRoot.left = newLeafL;
					newRoot.right = newLeafR;					
				}//end while           
		    }//end else if	
			else{				
				String newOp = "";
				while(!isNum.isNumber(tokenArray[i]) && tokenArray[i]!= ' ' && tokenArray[i] != '(') {
					newOp = newOp + tokenArray[i];
					i++;				
				}//end while loop for op building
				/** i has to be decrimented, since it is incremented in the while loop
				 * that way the main for loop doesnt skip any tokens in the equation
				 */
				i--;
				if(is_Op.isOperator(newOp)) {
					if(operators.isEmpty()) {
						operators.push(newOp);
					}					
				}
				//while loop until you reach open parenthesis
				/**use while loop to check if current operator
				 * has the same or higher precendence to one 
				 * on top of the operators stack
				 * if so performs the operator on top of stack 
				 * 
				 * added !.operators.isEmpty(), as empty stack causes error for comparison
				 */
				
				
			}//end else branch for operator
			TNode root = new TNode();
			if (!operators.isEmpty()) {
				while (!operators.empty()) {
					root.data = operators.pop();
				}				
			}
		}//end for
		return root;
	}// end tb

}//end toTree

	
