import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Generic_Trees {

	private class Node {

		int data;
		ArrayList<Node> children = new ArrayList<>();
	}

	private Node root;
	private int size;

	public Generic_Trees(int[] arr) {

		Stack<Node> stack = new Stack<>();

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] == -1) {
				stack.pop();
			}

			else {
				Node node = new Node();
				this.size++;
				node.data = arr[i];

				if (stack.size() > 0) {
					stack.peek().children.add(node);
				}

				else {
					root = node;
				}

				stack.push(node);
			}
		}
	}

	public void display() {
		display(root);
	}

	private void display(Node node) {

		String str = node.data + " -> ";

		for (Node child : node.children) {
			str += child.data + ", ";
		}

		str += ".";
		System.out.println(str);

		for (Node child : node.children) {
			display(child);
		}
	}

	public int size() {
		return size(root);
	}

	private int size(Node node) {

		int size = 1;
		for (Node child : node.children) {
			size += size(child);
		}
		return size;
	}

	public int max() {
		return max(root);
	}

	private int max(Node node) {

		int max = node.data;

		for (Node child : node.children) {
			int cmax = max(child);
			if (max < cmax) {
				max = cmax;
			}
		}

		return max;
	}

	private int height;

	public int height() {
		return height(root);
	}

	private int height(Node node) {

		int height = 0;

		for (Node child : node.children) {
			int cheight = height(child);
			height = Math.max(height, cheight);
		}

		return height + 1;
	}

	public boolean find(int data) {
		return find(root, data);
	}

	private boolean find(Node node, int data) {

		if (node.data == data) {
			return true;
		}

		for (Node child : node.children) {
			if (find(child, data) == true) {
				return true;
			}
		}

		return false;
	}

	public ArrayList<Integer> nodeToRootPath(int data) {
		return nodeToRootPath(root, data);
	}

	private ArrayList<Integer> nodeToRootPath(Node node, int data) {

		if (node.data == data) {
			ArrayList<Integer> arrlist = new ArrayList<Integer>();
			arrlist.add(node.data);
			return arrlist;
		}

		for (Node child : node.children) {
			ArrayList<Integer> arrlist = nodeToRootPath(child, data);
			
			if(arrlist.size() > 0) {
				arrlist.add(node.data);
				return arrlist;
			}
		}

		return new ArrayList<>();
	}
	
	public void removeAllLeaves() {
		removeAllLeaves(root);
	}
	
	private void removeAllLeaves(Node node) {
		
		for(int i = node.children.size() - 1; i >= 0; i--) {
			
			Node child = node.children.get(i);
			
			if(child.children.size() > 0) {
				removeAllLeaves(child);
			}
			else {
				node.children.remove(child);
			}
		}
	}
	
	public void mirrorTree() {
		mirrorTree(root);
	}
	
	private void mirrorTree(Node node) {
		
//		Collections.reverse(node.children);
		
		int left = 0;
		int right = node.children.size() - 1;
		
		while(left < right) {
			
			Node leftNode = node.children.get(left);
			Node rightNode = node.children.get(right);
			node.children.set(left, rightNode);
			node.children.set(right, leftNode);
			
			left++;
			right--;
		}
		
		for(Node child : node.children) {
			mirrorTree(child);
		}
	}
	
	public void linearise() {
		linearise(root);
	}
	
	private void linearise(Node node) {
		
		for(Node child : node.children) {
			linearise(child);
		}
		
		for(int i = node.children.size() - 1; i > 0; i--) {
			
			Node lr = node.children.remove(i);
			Node sl = node.children.get(i - 1);
			Node slchild = getTail(sl);
			slchild.children.add(lr);
		}
	}
	
	private Node getTail(Node node) {
		
		Node tail = node;
		while(tail.children.size() != 0) {
			
			tail = tail.children.get(0);
		}
		
		return tail;
	}
	
	public void linearise2() {
		linearise(root);
	}
	
	private Node linearise2(Node node) {
		
		if(node.children.size() == 0) {
			return node;
		}
		
		Node lastNodeTail = linearise2(node.children.get(node.children.size() - 1));
		
		while(node.children.size() > 1) {
			
			Node lastRemoved = node.children.remove(node.children.size() - 1);
			Node secondLast = node.children.get(node.children.size() - 1);
			
			Node secondLastTail = linearise2(secondLast);
			secondLastTail.children.add(lastRemoved);
		}
		
		return lastNodeTail;
	}
	
	public static boolean areSimilarShaped(Generic_Trees gt1, Generic_Trees gt2) {			// are Isomorphic
		return areSimilarShaped(gt1.root, gt2.root);
	}
	
	private static boolean areSimilarShaped(Node node1, Node node2) {
		
		if(node1.children.size() != node2.children.size()) {
			return false;
		}
		
		for(int i = 0; i < node1.children.size() ; i++) {
			
			if(areSimilarShaped(node1.children.get(i), node2.children.get(i)) == false) {
				return false;
			}
		}
		
		return true;
	}
	
	public static boolean areMirrorImages(Generic_Trees gt1, Generic_Trees gt2) {
		return areMirrorImages(gt1.root, gt2.root);
	}
	
	private static boolean areMirrorImages(Node node1, Node node2) {
		
		if(node1.children.size() != node2.children.size()) {
			return false;
		}
		
		int left = 0;
		int right = node1.children.size() - 1;
		
		while(left < node1.children.size()) {
			
			Node leftChild = node1.children.get(left);
			Node rightChild = node2.children.get(right);
			
			boolean areChildMirrorImages = areMirrorImages(leftChild, rightChild);
			
			if(areChildMirrorImages == false) {
				return false;
			}
			
			left ++;
			right --;
		}
		
		return true;
	}
	
	public boolean isSymmetric() {
		return Generic_Trees.areMirrorImages(this, this);
	}
	
	private int msSize = 0;
	private int msMin = Integer.MAX_VALUE;
	private int msMax = Integer.MIN_VALUE;
	private int msHeight = 0;
	
	public void MultiSolver() {
		
		msSize = 0;
		msMin = Integer.MAX_VALUE;
		msMax = Integer.MIN_VALUE;
		msHeight = 0;
		
		MultiSolver(root, 0);
		
		System.out.println("Size = " + msSize);
		System.out.println("Min = " + msMin);
		System.out.println("Max = " + msMax);
		System.out.println("Height = " + msHeight);
	}
	
	private void MultiSolver(Node node, int depth) {
		
		msSize ++;
		msMin = Math.min(msMin, node.data);
		msMax = Math.max(msMax, node.data);
		msHeight = Math.max(msHeight, depth);
		
		for(Node child : node.children) {
			MultiSolver(child, depth + 1);
		}
	}
}