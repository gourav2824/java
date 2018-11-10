
public class Stack {
	
	protected int[] arr;
	protected int tos = -1;
	
	public Stack(int cap) {
		
		this.arr = new int[cap];
	}
	
	public void push(int item) {
		
		if(tos == arr.length - 1) {
			System.out.println("Stack is Full");
			return;
		}
		
		tos++;
		arr[tos] = item;
	}
	
	public int pop() {
		
		if(tos == -1) {
			System.out.println("Stack is Empty");
			return -1;
		}
		
		int top = arr[tos];
		arr[tos] = 0;
		tos--;
		return top;
	}
	
	public int top() {
		
		if(tos == -1) {
			System.out.println("Stack is Empty");
			return -1;
		}
		
		int top = arr[tos];
		return top;
	}
	
	public int size() {
		return tos + 1;
	}
	
	public boolean isEmpty() {
		return tos == -1;
	}
	
	public void display() {
		
		for(int i = tos; i >= 0; i--) {
			
			System.out.print(arr[i] + " ");
		}
		System.out.println(".");
	}
}