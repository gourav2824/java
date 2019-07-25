package class_1_LLnSnQ;

import java.util.Scanner;

public class MultiplyTwoLinkedLists {

	public static void main(String[] args) {
		
		Node one = new Node(3);
		one.next = new Node(2);
//		one.next.next = new Node(1);
		
		Node two = new Node(2);
//		two.next = new Node(0);
		
		multiplyTwoLists(one, two);
	}
	
	static class Node {
		
        int data;
        Node next;
        
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
	
	public static long multiplyTwoLists(Node one, Node two) {
        
        one = reverse(one);
        two = reverse(two);
        
        //--------------------------------------------
        
        int size = 0;
        Node temp = two;
        
        while(temp != null){
            size ++;
            temp = temp.next;
        }
        
        //-------------------------------------------
        
        Node res = null;
        Node temp1 = one;
        Node temp2 = two;
        
        for(int i = 0; i < size; i++){
            
            Node node = null;
            temp = null;
            
            int zeros = 0;
            while(zeros < i){
                
                Node newn = new Node(0);
                
                if(node == null){
                    node = newn;
                    temp = newn;
                }
                
                else{
                    temp.next = newn;
                    temp = newn;
                }
                
                zeros ++;
            }
            
            temp1 = one;
            int carry = 0;
            while(temp1 != null){
                
                int val = temp2.data * temp1.data;
                val += carry;
                
                carry = val / 10;
                int rem = val % 10;
                
                Node newn = new Node(rem);
                
                if(node == null){
                    node = newn;
                    temp = newn;
                }
                
                else{
                    temp.next = newn;
                    temp = newn;
                }
                
                temp1 = temp1.next;
            }
            
            if(carry > 0){
                Node newn = new Node(carry);
                temp.next = newn;
                temp = newn;
            }
            
            temp2 = temp2.next;
            
            if(i == 0) {
            	res = node;
            }
            
            else {
            	Node add = add(res, node);
            	res = add;
            }
        }
        
        res = reverse(res);
        display(res);
        
        temp = res;
        long mod = 1000000007L;
        long ans = 0;
        
        while(temp != null){
            ans = ans % mod;
            ans = ans * 10 + temp.data;
            temp = temp.next;
        }
        
        ans = ans % mod;
        return ans;
     }
	
	public static Node reverse(Node node) {
		
		Node prev = node;
		Node curr = prev.next;
		
		while(curr != null) {
			
			Node temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}
		
		node.next = null;
		node = prev;
		return node;
	}
	
	public static Node add(Node n1, Node n2) {
		
		Node t1 = n1;
		Node t2 = n2;
		
		Node ans = null;
		Node temp = null;
		int carry = 0;
		
		while(t1 != null || t2 != null || carry > 0) {
			
			if(t1 == null && t2 == null) {
				Node newn = new Node(carry);
				temp.next = newn;
				temp = newn;
				break;
			}
			
			if(t1 == null) {
				t1 = new Node(0);
			}
			
			if(t2 == null) {
				t2 = new Node(0);
			}
			
			int sum = t1.data + t2.data + carry;
			carry = sum / 10;
			int val = sum % 10;
			
			Node newn = new Node(val);
			
			if(ans == null) {
				ans = newn;
				temp = newn;
			}
			
			else {
				temp.next = newn;
				temp = newn;
			}
			
			t1 = t1.next;
			t2 = t2.next;
		}
		
		return ans;
	}
	
	public static void display(Node head) {
        for (Node node = head; node != null; node = node.next) {
            System.out.print(node.data + " ");
        }
        System.out.println();
    }
	
	public static long num(Node node) {
		
		long ans = 0;
		Node temp = node;
		
		while(temp != null) {
			ans = ans * 10 + temp.data;
			temp = temp.next;
		}
		
		return ans;
	}
	
	public static Node sub(Node n1, Node n2) {
		
		n1 = reverse(n1);
		n2 = reverse(n2);
		
		Node res = null;
		Node temp = null;
		
		Node t1 = n1;
		Node t2 = n2;
		
		int borrow = 10;
		
		while(t1 != null || t2 != null) {
			
			if(t2 == null) {
				t2 = new Node(0);
			}
			
			int val = t1.data - t2.data;
			val = val + 10;
			
			if(borrow == 0) {
				val = val - 1;
			}
			
			borrow = val / 10;
			val = val % 10;
			
			Node newn = new Node(val);
			
			if(res == null) {
				res = newn;
				temp = newn;
			}
			
			else {
				temp.next = newn;
				temp = newn;
			}
			
			t1 = t1.next;
			t2 = t2.next;
		}
		
		if(borrow != 1) {
			return null;
		}
		
		res = reverse(res);
		
		Node prev = null;
		Node curr = res;
		boolean found = false;
		
		while(curr != null) {
			
			if(curr.data != 0) {
				found = true;
				if(prev == null) {
					break;
				}
			}
			
			if(found == true) {
				prev.next = null;
				res = curr;
				break;
			}
			
			prev = curr;
			curr = prev.next;
		}
		
		if(curr == null) {
			return new Node(0);
		}
		
		return res;
	}
}