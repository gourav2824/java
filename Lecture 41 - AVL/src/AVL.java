
public class AVL {
	
	private class Node {
		int data;
		Node left;
		Node right;
		int height;
		int balance;
	}
	
	private Node root;
	private int size;
	
	public AVL(int[] sortedArr) {
		root = construct(sortedArr, 0, sortedArr.length - 1);
	}

	private Node construct(int[] sortedArr, int lo, int hi) {

		if (lo > hi) {
			return null;
		}

		Node node = new Node();

		int mid = (lo + hi) / 2;
		node.data = sortedArr[mid];

		node.left = construct(sortedArr, lo, mid - 1);
		node.right = construct(sortedArr, mid + 1, hi);
		setHeightAndBalance(node);
		
		size++;

		return node;
	}
	
	private void setHeightAndBalance(Node node) {
		
		int leftHeight = node.left != null ? node.left.height : 0;
		int righttHeight = node.right != null ? node.right.height : 0;
		
		node.height = Math.max(leftHeight, righttHeight) + 1;
		node.balance = leftHeight - righttHeight;
	}

	public void display() {
		display(root);
	}

	private void display(Node node) {

		if (node == null) {
			return;
		}

		String str = "";

		str += node.left != null ? node.left.data : " .";
		str += " -> " + node.data + " [" + node.height + ", " + node.balance + "] <- ";
		str += node.right != null ? node.right.data : ". ";

		System.out.println(str);

		display(node.left);
		display(node.right);
	}
	
	public void add(int data) {
		root = add(root, data);
	}

	private Node add(Node node, int data) {

		if (node == null) {
			node = new Node();
			node.data = data;
			node.height = 1;
			return node;
		}

		if (node.data > data) {
			node.left = add(node.left, data);
		}

		else if (node.data < data) {
			node.right = add(node.right, data);
		}
		
		setHeightAndBalance(node);
		
		if(node.balance > 1 && data < node.left.data) {				// LL
			node = rightRotate(node);
		}
		
		else if(node.balance > 1 && data > node.left.data) {		// LR
			node.left = leftRotate(node.left);
			node = rightRotate(node);
		}
		
		else if(node.balance < -1 && data > node.right.data) {		// RR
			node = leftRotate(node);
		}
		
		else if(node.balance < -1 && data < node.right.data) {		// RL
			node.right = rightRotate(node.right);
			node = leftRotate(node);
		}

		return node;
	}
	
	private Node rightRotate(Node z) {
		
		Node y = z.left;
		Node t3 = y.right;
		
		y.right = z;
		z.left = t3;
		
		setHeightAndBalance(z);
		setHeightAndBalance(y);
		
		return y;
	}
	
	private Node leftRotate(Node z) {
		
		Node y = z.right;
		Node t3 = y.left;
		
		y.left = z;
		z.right = t3;
		
		setHeightAndBalance(z);
		setHeightAndBalance(y);
		
		return y;
	}
}