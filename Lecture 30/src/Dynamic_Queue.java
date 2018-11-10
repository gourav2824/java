
public class Dynamic_Queue extends Queue{
	
	public Dynamic_Queue(int cap) {
		super(cap);
	}
	
	public void enqueue(int val) {
		
		if(size == arr.length) {
			
			int[] olda = arr;
			arr = new int[olda.length * 2];
			
//			int pos = 0;
//			int i = front;
//			while(i != (front + size - 1) % olda.length) {
//				
//				arr[pos] = olda[i];
//				pos ++;
//				i = (i + 1) % olda.length;
//			}
//			
//			arr[pos] = olda[i];
//			front = 0;
			
			for(int i = 0; i < size; i++) {
				int idx = (front + i) % olda.length;
				arr[i] = olda[idx];
			}
			
			front = 0;
		}
		
		super.enqueue(val);
	}
}