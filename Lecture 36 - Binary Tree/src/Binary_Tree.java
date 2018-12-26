import java.util.ArrayList;
import java.util.Stack;

public class Binary_Tree {
	
	private class Node {
		
		int data;
		Node left;
		Node right;
	}
	
	Node root;
	int size;
	
	public Binary_Tree(int[] arr) {
		
		Stack<Node> st = new Stack<>();
		
		for(int val : arr) {
			
			if(val == -1) {
				st.pop();
			}
			
			else {
				
				Node node = new Node();
				node.data = val;
				size ++;
				
				if(st.size() == 0) {
					root = node;
				}
				
				else if(st.peek().left == null) {
					st.peek().left = node;
				}
				
				else {
					st.peek().right = node;
				}
				
				st.push(node);
			}
		}
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
	
	public int size() {
		return size(root);
	}
	
	private int size(Node node) {
		
		if(node == null) {
			return 0;
		}
		
		int size = 0;
		size = size(node.left) + size(node.right) + 1;
		
		return size;
	}
	
	public int max() {
		return max(root);
	}
	
	private int max(Node node) {
		
		if(node == null) {
			return Integer.MIN_VALUE;
		}
		
		int leftMax = max(node.left);
		int rightMax = max(node.right);
		int childMax = Math.max(leftMax, rightMax);
		
		return Math.max(node.data, childMax);
	}
	
	public int min() {
		return min(root);
	}
	
	private int min(Node node) {
		
		if(node == null) {
			return Integer.MAX_VALUE;
		}
		
		int leftMax = min(node.left);
		int rightMax = min(node.right);
		int childMax = Math.min(leftMax, rightMax);
		
		return Math.min(node.data, childMax);
	}
	
	public int height() {
		return height(root);
	}
	
	private int height(Node node) {
		
		if(node == null) {
			return 0;
		}
		
		int leftHeight = height(node.left);
		int rightHeight = height(node.right);
		
		return Math.max(leftHeight, rightHeight) + 1;
	}
	
	public boolean find(int data) {
		return find(root, data);
	}
	
	public boolean find(Node node, int data) {
		
		if(node == null) {
			return false;
		}
		
		if(node.data == data) {
			return true;
		}
		
		boolean filc = find(node.left, data);
		if(filc == true) {
			return true;
		}
		
		boolean firc = find(node.right, data);
		if(firc == true) {
			return true;
		}
		
		return false;
		
//		boolean found = false;
//		found = found || node.data == data;
//		found = found || find(node.left, data);
//		found = found || find(node.right, data);
//		return found;
	}
	
	public void printSingleChild() {
		printSingleChild(root, root.left);
		printSingleChild(root, root.right);
	}
	
	private void printSingleChild(Node parent, Node child) {
		
		if(child == null) {
			return;
		}
		
		if((parent.left == child && parent.right == null) || (parent.right == child && parent.left == null)) {
			System.out.print(child.data + " ");
		}
		
		printSingleChild(child, child.left);
		printSingleChild(child, child.right);
	}
	
	public void removeLeaf() {
		removeLeaf(root, root.left);
		removeLeaf(root, root.right);
	}
	
	private void removeLeaf(Node parent, Node child) {
		
		if(child == null) {
			return;
		}
		
		if(child.left == null && child.right == null) {
			if(parent.left == child) {
				parent.left = null;
			}
			else {
				parent.right = null;
			}
		}
		
		removeLeaf(child, child.left);
		removeLeaf(child, child.right);
	}
	
	public ArrayList<Node> RootToNodePath(int data){
		return RootToNodePath(root, data);
	}
	
	private ArrayList<Node> RootToNodePath(Node node, int data){
		
		if(node == null) {
			return new ArrayList<>();
		}
		
		if(node.data == data) {
			ArrayList<Node> arrList = new ArrayList<>();
			arrList.add(node);
			return arrList;
		}
		
		ArrayList<Node> arrListLeft = RootToNodePath(node.left, data);
		if(arrListLeft.size() != 0) {
			arrListLeft.add(node);
			return arrListLeft;
		}
		
		ArrayList<Node> arrListRight = RootToNodePath(node.right, data);
		if(arrListRight.size() != 0) {
			arrListRight.add(node);
			return arrListRight;
		}
		
		return new ArrayList<>();
	}
}