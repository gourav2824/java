import java.util.Collections;
import java.util.PriorityQueue;

public class PQ_Client {

	public static void main(String[] args) {
		
//		int[] arr = {9, 3, 4, 1, 6, 2, 7, 8};
//		printKLargest(arr, 3);
//		printKLargestBetter(arr, 3);
//		
//		int[] arr1 = {30, 10, 40, 20, 50, 70, 80, 60, 110, 90, 100, 120};
//		sortNearlySortedArray(arr1, 2);
		
		Median_PQ mpq = new Median_PQ();
		
		mpq.add(10);
		System.out.println(mpq.peek());
		
		mpq.add(100);
		System.out.println(mpq.peek());
		
		mpq.add(90);
		System.out.println(mpq.peek());
		
		mpq.add(80);
		System.out.println(mpq.peek());
		
		mpq.add(110);
		System.out.println(mpq.peek());
		
		mpq.add(120);
		System.out.println(mpq.peek());
		
		mpq.add(105);
		System.out.println(mpq.peek());
		
		System.out.println("----------");
		
		while(mpq.size() > 0) {
			System.out.println(mpq.remove());
		}
	}
	
	public static void printKLargest(int[] arr, int k) {		// Space = O(n) & Time = (n + k) logn
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		for(int val : arr) {
			pq.add(val);
		}
		
		for(int i = 0; i < k; i++) {
			System.out.print(pq.remove() + " ");
		}
		
		System.out.println();
	}
	
	public static void printKLargestBetter(int[] arr, int k) {		// Space = O(k) & Time = nlogk
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(int i = 0; i < arr.length; i++) {
			
			if(i < k) {
				pq.add(arr[i]);
			}
			
			else {
				if(arr[i] > pq.peek()) {
					pq.remove();
					pq.add(arr[i]);
				}
			}
		}
		
		System.out.println(pq);
	}
	
	public static void sortNearlySortedArray(int[] arr, int k) {
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(int i = 0; i < k + 1; i++) {
			pq.add(arr[i]);
		}
		
		int j = 0;
		for(int i = k + 1; i < arr.length; i++) {
			arr[j] = pq.remove();
			j++;
			pq.add(arr[i]);
		}
		
		while(pq.size() > 0) {
			arr[j] = pq.remove();
			j++;
		}
		
		for(int val : arr) {
			System.out.print(val + " ");
		}
	}
}