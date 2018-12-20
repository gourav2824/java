import java.util.ArrayList;
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
		
		for(int i=0; i < arr.length; i++) {
			
			if(arr[i] == -1) {
				stack.pop();
			}
			
			else {
				Node node = new Node();
				this.size++;
				node.data = arr[i];
				
				if(stack.size() > 0) {
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
		
		for(Node child : node.children) {
			str += child.data + ", ";
		}
		
		str += ".";
		System.out.println(str);
		
		for(Node child : node.children) {
			display(child);
		}
	}
	
	public int size() {
		return size(root);
	}
	
	private int size(Node node) {
		
		int size = 1;
		for(Node child : node.children) {
			size += size(child);
		}
		return size;
	}
	
	private int max = Integer.MIN_VALUE;
	
	public int max() {
		return max(root);
	}
	
	private int max(Node node) {
		
		if(max < node.data) {
			max = node.data;
		}
		
		for(Node child : node.children) {
			int data = max(child);
			if(max < data) {
				max = data;
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
		
		for(Node child : node.children) {
			int cheight = height(child);
			height = Math.max(height, cheight);
		}
		
		return height + 1;
	}
	
	public boolean find(int data) {
		
	}
	
	private boolean find(Node node, int data) {
		
	}
}