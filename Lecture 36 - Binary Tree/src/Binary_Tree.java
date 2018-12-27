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
	
	private void printkDown(Node node, int k) {
		
		if(k < 0 || node == null) {
			return;
		}
		
		if(k == 0) {
			System.out.print(node.data + " ");
			return;
		}
		
		printkDown(node.left, k - 1);
		printkDown(node.right, k - 1);
	}
	
	public Binary_Tree(int[] preOrder, int[] inOrder) {
		root = construct(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1);
	}
	
	private Node construct(int[] pre, int psi, int pei, int[] in, int isi, int iei) {
		
		if(isi >  iei && psi > pei) {
			return null;
		}
		
		Node node = new Node();
		node.data = pre[psi];
		size ++;
		
		int idx = -1;
		for(int i = isi; i <= iei; i++) {
			if(in[i] == node.data) {
				idx = i;
				break;
			}
		}
		
		int lhs = idx - isi;
		node.left = construct(pre, psi + 1, psi + lhs, in, isi, idx - 1);
		node.right = construct(pre, psi + lhs + 1, pei, in, idx + 1, iei);
		
		return node;
	}
	
	public Binary_Tree(int[] postOrder, int[] inOrder, boolean dummyVariable) {
		root = construct1(postOrder, 0, postOrder.length - 1, inOrder, 0, inOrder.length - 1);
	}
	
	private Node construct1(int[] post, int psi, int pei, int[] in, int isi, int iei) {
		
		if(isi > iei || psi > pei) {
			return null;
		}
		
		Node node = new Node();
		node.data = post[pei];
		size ++;
		
		int idx = -1;
		for(int i = isi; i <= iei; i++) {
			if(in[i] == node.data) {
				idx = i;
				break;
			}
		}
		
		int lhs = idx - isi;
		node.left = construct1(post, psi + 0, psi + lhs - 1, in, isi, idx - 1);
		node.right = construct1(post, psi + lhs, pei - 1, in, idx + 1, iei);
		
		return node;
	}
	
	private class Pair {
		Node node;
		int workCounter = 0;
		
		public Pair(Node node, int wc) {
			this.node = node;
			this.workCounter = wc;
		}
	}
	
	public void preOrderIteratively() {
		
		Stack<Pair> stack = new Stack<>();
		
		Pair rootPair = new Pair(root, 0);
		stack.push(rootPair);
		
		while(stack.size() > 0) {
			
			Pair top = stack.peek();
			
			if(top.workCounter == 0) {
				System.out.print(top.node.data + " ");
			}
			
			else if(top.workCounter == 1) {
				if(top.node.left != null) {
					Pair leftPair = new Pair(top.node.left, 0);
					stack.push(leftPair);
				}
			}
			
			else if(top.workCounter == 2) {
				if(top.node.right != null) {
					Pair rightPair = new Pair(top.node.right, 0);
					stack.push(rightPair);
				}
			}
			
			else {
				stack.pop();
			}
			
			top.workCounter ++;
		}
	}
	
	public void inOrderIteratively() {
		
		Stack<Pair> stack = new Stack<>();
		
		Pair rootPair = new Pair(root, 0);
		stack.push(rootPair);
		
		while(stack.size() > 0) {
			
			Pair top = stack.peek();
			
			if(top.workCounter == 0) {
				if(top.node.left != null) {
					Pair leftPair = new Pair(top.node.left, 0);
					stack.push(leftPair);
				}
			}
			
			else if(top.workCounter == 1) {
				System.out.print(top.node.data + " ");
			}
			
			else if(top.workCounter == 2) {
				if(top.node.right != null) {
					Pair rightPair = new Pair(top.node.right, 0);
					stack.push(rightPair);
				}
			}
			
			else {
				stack.pop();
			}
			
			top.workCounter ++;
		}
	}
	
	public void postOrderIteratively() {
		
		Stack<Pair> stack = new Stack<>();
		
		Pair rootPair = new Pair(root, 0);
		stack.push(rootPair);
		
		while(stack.size() > 0) {
			
			Pair top = stack.peek();
			
			if(top.workCounter == 0) {
				if(top.node.left != null) {
					Pair leftPair = new Pair(top.node.left, 0);
					stack.push(leftPair);
				}
			}
			
			else if(top.workCounter == 1) {
				if(top.node.right != null) {
					Pair rightPair = new Pair(top.node.right, 0);
					stack.push(rightPair);
				}
			}
			
			else if(top.workCounter == 2) {
				System.out.print(top.node.data + " ");
			}
			
			else {
				stack.pop();
			}
			
			top.workCounter ++;
		}
	}
	
	public boolean isBalanced() {
		return isBalanced(root);
	}
	
	private boolean isBalanced(Node node) {				// O(n^2)
		
		if(node == null) {
			return true;
		}
		
		int leftHeight = height(node.left);
		int rightHeight = height(node.right);
		int delta = Math.abs(rightHeight - leftHeight);
		
		if(delta > 1) {
			return false;
		}
		
		boolean isLeftBalanced = isBalanced(node.left);
		if(isLeftBalanced == false) {
			return false;
		}
		
		boolean isRightBalanced = isBalanced(node.right);
		if(isRightBalanced == false) {
			return false;
		}
		
		return true;
	}
	
	private class BalPair {
		int height;
		boolean isBalanced;
	}
	
	public boolean isBalancedInOn() {
		return isBalancedInOn(root).isBalanced;
	}
	
	private BalPair isBalancedInOn(Node node) {
		
		if(node == null) {
			BalPair bp = new BalPair();
			bp.height = 0;
			bp.isBalanced = true;
			return bp;
		}
		
		BalPair leftPair = isBalancedInOn(node.left);
		BalPair rightPair = isBalancedInOn(node.right);
		
		BalPair myPair = new BalPair();
		myPair.height = Math.max(leftPair.height, rightPair.height) + 1;
		myPair.isBalanced = leftPair.isBalanced && rightPair.isBalanced && (Math.abs(leftPair.height - rightPair.height) <= 1);
		
		return myPair;
	}
	
	public boolean isBST() {
		return isBST(root);
	}
	
	private boolean isBST(Node node) {
		
		if(node == null) {
			return true;
		}
		
		if(isBST(node.left) == false) {
			return false;
		}
		
		if(isBST(node.right) == false) {
			return false;
		}
		
		if(node.left != null && node.data < max(node.left)) {
			return false;
		}
		
		if(node.right != null && node.data > min(node.right)) {
			return false;
		}
		
		return true;
	}
	
	private class BSTPair {
		int max;
		int min;
		boolean isBST;
	}
	
	public boolean isBSTinOn() {
		
		
	}
}