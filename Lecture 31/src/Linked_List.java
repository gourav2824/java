
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
	
	public Node midNode() {
		
		Node slow = head;
		Node fast = head;
		
		while(fast.next != null && fast.next.next != null) {
			
			slow = slow.next;
			fast = fast.next.next;
		}
		
		return slow;
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
	
	private static Linked_List breakList(Node left, Node right) {
		
		Linked_List list = new Linked_List();
		list.head = left;
		list.tail = right;
		
		return list;
	}
	
	public static Linked_List mergeSort(Linked_List list) {
		
		if(list.head == list.tail) {
			
			return list;
		}
		
		Node midNode = list.midNode();
		Node midNext = midNode.next;
		
		Linked_List leftList = Linked_List.breakList(list.head, midNode);
		Linked_List rightList = Linked_List.breakList(midNode.next, list.tail);
		
		midNode.next = null;
		
		leftList = mergeSort(leftList);
		rightList = mergeSort(rightList);
		
		Linked_List SortedList = mergeTwoSortedLists(leftList, rightList);
		midNode.next = midNext;
		
		return SortedList;
	}
	
	public void kReverse(int k) {
		
		Linked_List prev = new Linked_List();
		Linked_List curr = null;
		
		while(this.size != 0) {
			
			for(int i=0; i < k && this.size != 0; i++) {
				prev.addFirstNode(this.removeFirstNode());
			}
			
			if(curr == null) {
				curr = prev;
			}
			
			else {
				curr.tail.next = prev.head;
				curr.tail = prev.tail;
				curr.size += prev.size;
			}
			
			prev = new Linked_List();
		}
		
		this.head = curr.head;
		this.tail = curr.tail;
		this.size = curr.size;
	}
	
	public void removeDuplicates() {
		
		Linked_List list = new Linked_List();
		
		while(this.size != 0) {
			
			if(list.size == 0) {
				list.addLastNode(this.removeFirstNode());
			}
			
			else {
				if(this.head.data == list.tail.data) {
					this.removeFirstNode();
				}
				else {
					list.addLastNode(this.removeFirstNode());
				}
			}
		}
		
		this.head = list.head;
		this.tail = list.tail;
		this.size = list.size;
	}
	
	public void oddEven() {
		
		Linked_List odd = new Linked_List();
		Linked_List even = new Linked_List();
		
		while(this.size != 0) {
			
			if(this.head.data % 2 == 0) {
				even.addLastNode(this.removeFirstNode());
			}
			
			else {
				odd.addLastNode(this.removeFirstNode());
			}
		}
		
		if(odd.size == 0 && even.size != 0) {
			this.head = even.head;
			this.tail = even.tail;
			this.size = even.size;
		}
		
		else if(odd.size != 0 && even.size == 0) {
			this.head = odd.head;
			this.tail = odd.tail;
			this.size = odd.size;
		}
		
		else {
			odd.tail.next = even.head;
			this.head = odd.head;
			this.tail = odd.tail;
			this.size = odd.size;
		}
	}
	
	public static int mergePoint(Linked_List list1, Linked_List list2) {		// Not Correct
		
		Node temp1 = list1.head;
		Node temp2 = list2.head;
		
//		int diff = 
		
		while(temp1 != null && temp2 != null) {
			
			if(temp1.next == temp2.next) {
				return temp1.next.data;
			}
			
			else {
				temp1 = temp1.next;
				temp2 = temp2.next;
			}
		}
		
		return -1;
	}
	
	private Node reverseDRLeft;
	
	public void ReverseDataRecursive() {
		
		reverseDRLeft = this.head;
		ReverseDataRecursive(this.head, 0);
	}
	
	private void ReverseDataRecursive(Node right, int floor) {
		
		if(right == null) {
			return;
		}
		
		ReverseDataRecursive(right.next, floor + 1);
		
		if(floor >= size / 2) {
			
			int temp = reverseDRLeft.data;
			reverseDRLeft.data = right.data;
			right.data = temp;
			reverseDRLeft = reverseDRLeft.next;
		}
	}
	
	public void ReversePointerRecursive() {
		
		ReversePointerRecursive(head, head.next);
	}
	
	private void ReversePointerRecursive(Node slow, Node fast) {
		
		if(fast == null) {
			return;
		}
		
		ReversePointerRecursive(slow.next, fast.next);
		
		fast.next = slow;
	}
}