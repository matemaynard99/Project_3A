
/*takes the created tree, runs through branches, and evaluates equation
	 * is recursive in order to save space and time.
	 */
public class eval_Tree {
	static public <T> int evaluateTree(Node.TNode<T> root) {
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
			return(equat.equation(left, right, root.toString()));
		}
	}//end evaluate tree method
}
