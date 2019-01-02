
public class Linked_List<T> {

	private class Node {

		T data;
		Node next;
	}

	Node head;
	Node tail;
	int size;

	public T getFirst() { // O(1)

		if (size == 0) {
			return null;
		}

		return head.data;
	}

	public T getLast() { // O(1)

		if (size == 0) {
			return null;
		}

		return tail.data;
	}

	public T getAt(int idx) { // O(n)

		if (idx < 0 || idx >= size) {
			System.out.print("Index Out Of Bound");
			return null;
		}

		Node temp = head;

		for (int i = 0; i < idx; i++) {
			temp = temp.next;
		}

		return temp.data;
	}

	private Node getNodeAt(int idx) { // O(n)

		if (idx < 0 || idx >= size) {
			System.out.print("Index Out Of Bound");
			return null;
		}

		Node temp = head;

		for (int i = 0; i < idx; i++) {
			temp = temp.next;
		}

		return temp;
	}

	public void addFirst(T data) { // O(1)

		Node node = new Node();
		node.data = data;

		if (size == 0) {
			head = tail = node;
		}

		else {
			node.next = head;
			head = node;
		}

		size++;
	}
	
	private void addFirstNode(Node node) { // O(1)

		if (size == 0) {
			head = tail = node;
		}

		else {
			node.next = head;
			head = node;
		}

		size++;
	}

	public void addLast(T data) { // O(1)

		Node node = new Node();
		node.data = data;

		if (size == 0) {
			head = tail = node;
		}

		else {
			tail.next = node;
			tail = node;
		}
		size++;
	}
	
	public void addLastNode(Node node) { // O(1)

		if (size == 0) {
			head = tail = node;
		}

		else {
			tail.next = node;
			tail = node;
		}
		
		size++;
	}

	public void addAt(int idx, T data) { // O(n)

		if (idx < 0 || idx > size) {
			System.out.println("Index Out Of Bound");
		}

		else if (idx == 0) {
			addFirst(data);
		}

		else if (idx == size) {
			addLast(data);
		}

		else {
			Node m1 = getNodeAt(idx - 1);
			Node n = m1.next;

			Node node = new Node();
			node.data = data;

//			node.next = temp.next;
//			temp.next = node;

			m1.next = node;
			node.next = n;

			size++;
		}
	}

	public T removeFirst() { // O(1)

		if (size == 0) {
			System.out.println("Index Out Of Bound");
			return null;
		}

		else if (size == 1) {
			Node temp = head;
			head = tail = null;
			size--;

			return temp.data;
		}

		else {
			Node temp = head;
			head = head.next;
			size--;

			return temp.data;
		}
	}
	
	public Node removeFirstNode() { // O(1)

		if (size == 0) {
			System.out.println("Index Out Of Bound");
			return null;
		}

		else if (size == 1) {
			Node temp = head;
			head = tail = null;
			size--;

			return temp;
		}

		else {
			Node temp = head;
			head = head.next;
			temp.next = null;
			size--;

			return temp;
		}
	}

	public T removeLast() { // O(n)

		if (size == 0) {
			System.out.println("Index Out Of Bound");
			return null;
		}

		else if (size == 1) {
			Node node = head;
			head = tail = null;
			size--;

			return node.data;
		}

		else {
			T temp = tail.data;

			Node sl = getNodeAt(size - 2);
			tail = sl;
			tail.next = null;
			size--;

			return temp;
		}
	}

	public T removeAt(int idx) { // O(n)

		if (idx < 0 || idx >= size) {
			System.out.println("Index Out Of Bound");
			return null;
		}

		else if (idx == 0) {
			return removeFirst();
		}

		else if (idx == size - 1) {
			return removeLast();
		}

		else {
			Node node = getNodeAt(idx - 1);
			T temp = node.next.data;
			node.next = node.next.next;
			size--;

			return temp;
		}
	}

	public int size() { // O(1)
		return size;
	}

	public boolean isEmpty() { // O(1)
		return size == 0;
	}

	public void display() { // O(n)

		for (Node node = head; node != null; node = node.next) {
			System.out.print(node.data + " -> ");
		}
		System.out.println(".");
	}
}