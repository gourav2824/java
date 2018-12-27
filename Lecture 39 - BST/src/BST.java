
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
		
		if(lo > hi) {
			return null;
		}
		
		Node node = new Node();
		
		int mid = (lo + hi) / 2;
		node.data = sortedArr[mid];
		
		node.left = construct(sortedArr, lo, mid - 1);
		node.right = construct(sortedArr, mid + 1, hi);
		size ++;
		
		return node;
	}
	
	public void display() {
		display(root);
	}
	
	private void display(Node node) {
		
		if(node == null) {
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
}