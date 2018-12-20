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
}