import java.util.Collections;
import java.util.PriorityQueue;

public class Median_PQ {
	
	private PriorityQueue<Integer> pq1 = new PriorityQueue<>(Collections.reverseOrder());
	private PriorityQueue<Integer> pq2 = new PriorityQueue<>();
	
	private int size = 0;
	
	// O(log n)
	public void add(int data) {
		
		if(size == 0 || size == 1) {
			pq1.add(data);
			size ++;
		}
		
		else {
			
			if(data > pq2.peek()) {
				pq2.add(data);
			}
			
			else if(data < pq1.peek()) {
				pq1.add(data);
			}
			
			else {
				pq1.add(data);
			}
			
			size ++;
		}
		
		if(Math.abs(pq1.size() - pq2.size()) > 1) {
			
			if(pq1.size() > pq2.size()) {
				pq2.add(pq1.remove());
			}
			else {
				pq1.add(pq2.remove());
			}
		}
	}
	
	// O(log n)
	public int remove() {
		size --;
		return pq1.size() >= pq2.size() ? pq1.remove() : pq2.remove();
	}
	
	// O(1)
	public int peek() {
		return pq1.size() >= pq2.size() ? pq1.peek() : pq2.peek();
	}
	
	public int size() {
		return size;
	}
}