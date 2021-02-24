import java.util.*;
/*
 * Class to convert the expression into a tree, and return the root of the tree
 */
public class toTree {
	/**
	 * 
	 * @param <T>
	 * @param expression: String expression that is the entire current expression read from txt file
	 * 						to be split into a char array and made into a tree
	 * @return 
	 * @return: returns the root of the created tree
	 */
	public static <T> int treeBuilder(String expression) {
		/*
		 * numbers stack holds the numbers from the expression
		 * operators stack holds operators and parentheses from the expression
		 * treeNodes stack holds references to the tree roots (usually subtree roots until expression has been 
		 * 					iterated through completely in which case, this stack only holds reference to the 
		 * 					root of the tree
		 */
		Stack<Integer> numbers = new Stack<>();
		Stack<String> operators = new Stack<>();
		Stack<Node.TNode> treeNodes = new Stack<>();
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
			if (is_Num.isNumber(tokenArray[i])) {
				/**converted char to string so it can become integer
				 * unsure how to change char to int directly
				 */
				//added while loop to catch multidigit numbers
				String newNum = "";
				while(is_Num.isNumber(tokenArray[i])){					
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
				Node.TNode node = new Node.TNode(tokenArray[i+2]);
				Node.TNode nodeL = new Node.TNode(tokenArray[i+1]);
				Node.TNode nodeR = new Node.TNode(tokenArray[i+3]);
				treeNodes.add(node);
				
			}//end open parenthesis branch
			
            //if current char is simply a closing parentheses, continue since all additions to the tree 
			//are handled with the opening parentheses
			else if(tokenArray[i] == ')') {
				continue;          
		    }//end else if	
			
			/*
			 * If current char is an operator, add operator to operators Stack
			 */
			else if (!is_Num.isNumber(tokenArray[i]) && tokenArray[i]!= ' ' 
					&& tokenArray[i] != '(' && tokenArray[i] != ')'){				
				String newOp = "";
				newOp = newOp + tokenArray[i];
				i++;
				operators.push(newOp);
				/**
				 * If the stack that holds treeNodes is empty,
				 * add this subtree to the stack.
				 * Pops a number held in the numbers stack to be left node
				 * iterators one step ahead of i (i + 1) to get right node
				 * operator (where i is currently) is the root
				 */
				if (treeNodes.isEmpty()) {
					
					Node.TNode node = new Node.TNode(operators.pop());
					Node.TNode nodeL = new Node.TNode(numbers.pop());
					Node.TNode nodeR = new Node.TNode(tokenArray[i + 1]);
					nodeR.data= numbers.pop();
					nodeL.data = numbers.pop();
					node.left = nodeL;
					node.right = nodeR;
					treeNodes.add(node);
				}// end if 
				/**
				 * The way this is set up, with power operators, the left operand will already be a node in the tree (root.right)
				 * This else if creates a subtree with the previous operand as Tl, next operand as Tr
				 * Power operator is root. 
				 * temp is the current tree, with the left operand of the power operation improperly held as a right leaf
				 * TNode node holds "^", nodeL = 2, nodeR = 2
				 * Current tree is popped, and the wrongly placed 2 as right leaf becomes the subtree
				 * of the power operation
				 */
				else if (operators.peek() == "^") {
					Node.TNode node = new Node.TNode(operators.pop());
					Node.TNode nodeL = new Node.TNode(tokenArray[i-1]);
					Node.TNode nodeR = new Node.TNode(tokenArray[i + 1]);
					Node.TNode temp = new Node.TNode(treeNodes.pop());
					temp.right = node;
					treeNodes.add(temp);
				}//end else if
				/**
				 * If there is already a subtree in the treeNodes stack,
				 * add this new subtree to the stack
				 * treeLeft is the subtree already in the stack
				 * tree right is the new number to add 
				 * trees are combined and added back to the treeNodes stack
				 */
				else {
					Node.TNode node = new Node.TNode(operators.pop());
					Node.TNode nodeL = new Node.TNode(treeNodes.pop());
					Node.TNode nodeR = new Node.TNode(tokenArray[i + 1]);
					nodeR.data= numbers.pop();
					nodeL.data = numbers.pop();
					node.left = nodeL;
					node.right = nodeR;
					treeNodes.add(node);
				}//end else
			}//end else branch for operator	
			
		}//end for
		/**
		 * Gets the root of the tree and assigns it to node root
		 * returns root
		 */
		Node.TNode<T> root = new Node.TNode(treeNodes.pop());
		//TNode root = new TNode(treeNodes.pop());
		
		//return eval_Tree.evaluateTree(root);
		return eval_Tree.evaluateTree(root);
	}// end treeBuilder

}//end toTree
