
public class Node<T> {
	// Data fields
    public T data;
    public Node<T> left, right;
	
    // Constructors
    public Node(T value) { data = value; }
    public Node(T value, Node<T> leftChild, Node<T> rightChild) {
        data = value;
        left = leftChild;
        right = rightChild;
    }
}