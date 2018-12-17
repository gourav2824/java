
public class Linked_List {
	
	private class Node{
		
		int data;
		Node next;
	}
	
	Node head;
	Node tail;
	int size;
	
	public int getFirst() {
		
	}
	
	public int getLast() {
		
	}
	
	public int getAt(int idx) {
		
	}
	
	public void addFirst(int data) {
		
	}
	
	public void addLast(int data) {
		
		Node node = new Node();
		node.data = data;
		
		if(size == 0) {
			head = tail = node;
		}
		
		else {
			tail.next = node;
			tail = node;
		}
		size++;
	}
	
	public void addAt(int data, int idx) {
		
	}
	
	public int removeFirst() {
		
	}
	
	public int removeLast() {
		
	}
	
	public int removeAt(int idx) {
		
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void display() {
		
		for(Node node = head; node != null; node = node.next) {
			System.out.print(node.data + " -> ");
		}
		System.out.println(".");
	}
}