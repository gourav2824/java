
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
}