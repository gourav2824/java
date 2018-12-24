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
}