
public class Queue {
	
	private int[] arr;
	private int front = 0;
	private int size = 0;
	
	public Queue(int cap) {
		this.arr = new int[cap];
	}
	
	public void enqueue(int val) {
		
		if(size == arr.length) {
			System.out.println("Queue is Full");
			return;
		}
		
		int last = (front + size) % arr.length;
		
		arr[last] = val;
		size ++;
	}
	
	public int dequeue() {
		
		if(size == 0) {
			System.out.println("Queue is Empty");
			return -1;
		}
		
		int val = arr[front];
		arr[front] = 0;
		
		front = (front + 1) % arr.length;
		
		size --;
		return val;
	}
	
	public int front() {
		
		if(size == 0) {
			System.out.println("Queue is Empty");
			return -1;
		}
		
		int val = arr[front];
		return val;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void display() {
		
		if(size == 0) {
			System.out.println("Queue is Empty");
			return;
		}
		
		for(int i = 0; i < size; i++) {
			
			int idx = (front + i) % arr.length;
			System.out.print(arr[idx] + " ");
		}
		
		System.out.println();
	}
}