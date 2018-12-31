import java.util.Collections;
import java.util.PriorityQueue;

public class Median_PQ {
	
	private PriorityQueue<Integer> min = new PriorityQueue<>(Collections.reverseOrder());
	private PriorityQueue<Integer> max = new PriorityQueue<>();
	
	private int size = 0;
	
	// O(log n)
	public void add(int data) {
		
		if(size == 0 || size == 1) {
			min.add(data);
			size ++;
		}
		
		else {
			
			if(data > max.peek()) {
				max.add(data);
			}
			
			else if(data < min.peek()) {
				min.add(data);
			}
			
			else {
				min.add(data);
			}
			
			size ++;
		}
		
		if(Math.abs(min.size() - max.size()) > 1) {
			
			if(min.size() > max.size()) {
				max.add(min.remove());
			}
			else {
				min.add(max.remove());
			}
		}
	}
	
	// O(log n)
	public int remove() {
		size --;
		return min.size() >= max.size() ? min.remove() : max.remove();
	}
	
	// O(1)
	public int peek() {
		return min.size() >= max.size() ? min.peek() : max.peek();
	}
	
	public int size() {
		return size;
	}
}