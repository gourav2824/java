
public class Linked_List {

	private class Node {

		int data;
		Node next;
	}

	Node head;
	Node tail;
	int size;

	public int getFirst() { // O(1)

		if (size == 0) {
			return -1;
		}

		return head.data;
	}

	public int getLast() { // O(1)

		if (size == 0) {
			return -1;
		}

		return tail.data;
	}

	public int getAt(int idx) { // O(n)

		if (idx < 0 || idx >= size) {
			System.out.print("Index Out Of Bound");
			return -1;
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

	public void addFirst(int data) { // O(1)

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

	public void addLast(int data) { // O(1)

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

	public void addAt(int idx, int data) { // O(n)

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

	public int removeFirst() { // O(1)

		if (size == 0) {
			System.out.println("Index Out Of Bound");
			return -1;
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

	public int removeLast() { // O(n)

		if (size == 0) {
			System.out.println("Index Out Of Bound");
			return -1;
		}

		else if (size == 1) {
			Node node = head;
			head = tail = null;
			size--;

			return node.data;
		}

		else {
			int temp = tail.data;

			Node sl = getNodeAt(size - 2);
			tail = sl;
			tail.next = null;
			size--;

			return temp;
		}
	}

	public int removeAt(int idx) { // O(n)

		if (idx < 0 || idx >= size) {
			System.out.println("Index Out Of Bound");
			return -1;
		}

		else if (idx == 0) {
			return removeFirst();
		}

		else if (idx == size - 1) {
			return removeLast();
		}

		else {
			Node node = getNodeAt(idx - 1);
			int temp = node.next.data;
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

	public void reverseDI() { // Reverse Data Iterative

		int left = 0;
		int right = size - 1;

		while (left < right) {

			Node n1 = getNodeAt(left);
			Node n2 = getNodeAt(right);

			int temp = n1.data;
			n1.data = n2.data;
			n2.data = temp;

			left++;
			right--;
		}
	}

	public void reversePI() { // Reverse Pointer Iterative

		if (size == 1) {
			return;
		}

		Node a = head;
		Node b = a.next;
		Node c = b.next;

		while (b != null) {

			b.next = a;
			a = b;
			b = c;

			if (c != null) {
				c = c.next;
			}
		}

		Node temp = head;
		head = tail;
		tail = temp;
		tail.next = null;
	}

	private Node IsPalindromeLeft;

	public boolean IsPalindrome() {
		IsPalindromeLeft = head;
		return IsPalindrome(head);
	}

	private boolean IsPalindrome(Node right) {

		if (right == null) {
			return true;
		}

		boolean recRes = IsPalindrome(right.next);

		if (recRes == true) {

			if (IsPalindromeLeft.data == right.data) {
				IsPalindromeLeft = IsPalindromeLeft.next;
				return true;
			}

			else {
				return false;
			}
		}

		else {
			return false;
		}
	}

	private Node FoldLeft;

	public void Fold() {

		FoldLeft = head;
		Fold(head, 0);
	}

	private void Fold(Node right, int floor) {

		if (right == null) {
			return;
		}

		Fold(right.next, floor + 1);

		if (floor > size / 2) {

			Node temp = FoldLeft.next;
			FoldLeft.next = right;
			right.next = temp;
			FoldLeft = temp;
		}

		if (floor == size / 2) {
			tail = right;
			tail.next = null;
		}
	}
	
	public int mid() {
		
		Node slow = head;
		Node fast = head;
		
		while(fast.next != null && fast.next.next != null) {
			
			slow = slow.next;
			fast = fast.next.next;
		}
		
		return slow.data;
	}
	
	public int KthFromLast(int k) {
		
		Node slow = head;
		Node fast = head;
		
		for(int i = 0; i < k; i++) {
			fast = fast.next;
		}
		
		while(fast != null) {
			slow = slow.next;
			fast = fast.next;
		}
		
		return slow.data;
	}
	
	public static Linked_List mergeTwoSortedLists(Linked_List l1, Linked_List l2) {
		
		Node p = l1.head;
		Node q = l2.head;
		
		Linked_List list = new Linked_List();
		
		while(p != null && q != null) {
			
			if(p.data <= q.data) {
				list.addLast(p.data);
				p = p.next;
			}
			
			else {
				list.addLast(q.data);
				q = q.next;
			}
		}
		
		if(p != null) {
			
			while(p != null) {
				list.addLast(p.data);
				p = p.next;
			}
		}
		
		if(q != null) {
			
			while(q != null) {
				list.addLast(q.data);
				q = q.next;
			}
		}
		
		return list;
	}
	
	public static Linked_List mergeSort(Linked_List list) {
		
		
	}
}