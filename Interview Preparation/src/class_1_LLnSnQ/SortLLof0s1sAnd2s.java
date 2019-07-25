package class_1_LLnSnQ;

import java.util.Scanner;

public class SortLLof0s1sAnd2s {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a1 = sc.nextInt();
        head = insert(head, a1);

        for (int i = 1; i < n; i++) {
            int a = sc.nextInt();
            head = insert(head, a);
        }

        linksort(head);
        display(head);
	}
	
	static Node head;
	
	static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public static void linksort(Node head) {
		
		Node h0 = null;
		Node h1 = null;
		Node h2 = null;

		Node t0 = null;
		Node t1 = null;
		Node t2 = null;

		Node temp = head;

		while (temp != null) {

			if (temp.data == 0) {

				if (h0 == null) {
					h0 = temp;
					t0 = temp;
				} else {
					t0.next = temp;
					t0 = temp;
				}
			}

			else if (temp.data == 1) {

				if (h1 == null) {
					h1 = temp;
					t1 = temp;
				} else {
					t1.next = temp;
					t1 = temp;
				}
			}

			else {

				if (h2 == null) {
					h2 = temp;
					t2 = temp;
				} else {
					t2.next = temp;
					t2 = temp;
				}
			}

			temp = temp.next;
		}

		SortLLof0s1sAnd2s.head = h0;
		t0.next = h1;
		t1.next = h2;
		t2.next = null;
	}
	
	public static Node insert(Node head, int data) {
		 
        if (head == null) {
            return new Node(data);
        }

        head.next = insert(head.next, data);
        return head;
    }
	
	public static void display(Node head) {
        for (Node node = head; node != null; node = node.next) {
            System.out.print(node.data + " ");
        }
    }
}