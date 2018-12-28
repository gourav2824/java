
public class BST {

	private class Node {
		int data;
		Node left;
		Node right;
	}

	private Node root;
	private int size;

	public BST(int[] sortedArr) {
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
		size++;

		return node;
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
		str += " -> " + node.data + " <- ";
		str += node.right != null ? node.right.data : ". ";

		System.out.println(str);

		display(node.left);
		display(node.right);
	}

	public int max() {
		return max(root);
	}

	private int max(Node node) {

		if (node.right == null) {
			return node.data;
		}

		return max(node.right);
	}

	public int min() {
		return min(root);
	}

	private int min(Node node) {

		if (node.left == null) {
			return node.data;
		}

		return min(node.left);
	}

	public boolean find(int data) {
		return find(root, data);
	}

	private boolean find(Node node, int data) {

		if (node == null) {
			return false;
		}

		if (node.data == data) {
			return true;
		}

		if (node.data > data) {
			return find(node.left, data);
		}

		else
			return find(node.right, data);
	}
	
	public void printInRange(int lo, int hi) {
		printInRange(root, lo, hi);
	}
	
	private void printInRange(Node node, int lo, int hi) {
		
		if(node == null) {
			return;
		}
		
		if(node.data >= lo && node.data <= hi) {
			printInRange(node.left, lo, hi);
			System.out.print(node.data + " ");
			printInRange(node.right, lo, hi);
		}
		
		if(node.data < lo) {
			printInRange(node.right, lo, hi);
		}
		
		if(node.data > hi) {
			printInRange(node.left, lo, hi);
		}
	}
	
	private int rsum;
	
	public void replaceWithSumOfLargerNodes() {
		rsum = 0;
		replaceWithSumOfLargerNodes(root);
	}
	
	private void replaceWithSumOfLargerNodes(Node node) {
		
		if(node == null) {
			return;
		}
		
		replaceWithSumOfLargerNodes(node.right);
		
		int originalNodeData = node.data;
		node.data = rsum;
		rsum += originalNodeData;
		
		replaceWithSumOfLargerNodes(node.left);
	}
}