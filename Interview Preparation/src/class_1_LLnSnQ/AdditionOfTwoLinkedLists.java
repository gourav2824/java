package class_1_LLnSnQ;

import java.util.Scanner;

public class AdditionOfTwoLinkedLists {
	
	static Node head1;
    static Node head2;
    static Node head3;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int a1 = sc.nextInt();

        Node tail;
        head1 = tail = insert(null, a1);

        for (int i = 1; i < n1; i++) {
            int a = sc.nextInt();
            tail = insert(tail, a);
        }

        int n2 = sc.nextInt();
        int a2 = sc.nextInt();

        head2 = tail = insert(null, a2);

        for (int i = 1; i < n2; i++) {
            int a = sc.nextInt();
            tail = insert(tail, a);
        }

        head3 = addTwoNumbers(head1, head2);
        display(head3);
	}
	
	private static class Node {
		
        int data;
        Node next;
        
        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
	
	public static Node insert(Node tail, int data) {
		 
        if (tail == null) {
            return new Node(data, null);
        }

        Node nn = new Node(data, null);
        tail.next = nn;
        return nn;
    }
	
	public static Node addTwoNumbers(Node n1, Node n2) {
        
        n1 = reverse(n1);
        n2 = reverse(n2);
        
        Node ans = null;
        Node temp = null;
        
        Node t1 = n1;
        Node t2 = n2;
        
        int carry = 0;
        
        while(t1 != null && t2 != null){
            
            int sum = t1.data + t2.data + carry;
            carry = sum / 10;
            int val = sum % 10;
            
            Node newn = new Node(val, null);
            
            if(ans == null){
                ans = newn;
                temp = newn;
            }
            
            else{
                temp.next = newn;
                temp = newn;
            }
            
            t1 = t1.next;
            t2 = t2.next;
        }
        
        if(t1 != null){
            while(t1 != null){
                int sum = t1.data + carry;
                carry = sum / 10;
                int val = sum % 10;
                
                Node newn = new Node(val, null);
                temp.next = newn;
                temp = newn;
                
                t1 = t1.next;
            }
        }
        
        if(t2 != null){
            while(t2 != null){
                int sum = t2.data + carry;
                carry = sum / 10;
                int val = sum % 10;
                
                Node newn = new Node(val, null);
                temp.next = newn;
                temp = newn;
                
                t2 = t2.next;
            }
        }
        
        if(carry > 0){
            Node newn = new Node(carry, null);
            temp.next = newn;
            temp = newn;
        }
        
        ans = reverse(ans);
        return ans;
    }
	
	public static Node reverse(Node node){
        
        Node prev = node;
        Node curr = prev.next;
        
        while(curr != null){
            
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        
        node.next = null;
        node = prev;
        return node;
    }
	
	public static void display(Node head) {
        for (Node node = head; node != null; node = node.next) {
            System.out.print(node.data + " ");
        }
        System.out.println();
    }
}