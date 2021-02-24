public class Node {
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
	}//end TNode constructor

}
