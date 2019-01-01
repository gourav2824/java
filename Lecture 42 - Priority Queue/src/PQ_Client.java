import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class PQ_Client {

	public static void main(String[] args) {
		
		int[] arr = {9, 3, 4, 1, 6, 2, 7, 8};
//		printKLargest(arr, 3);
//		printKLargestBetter(arr, 3);
//		
		int[] arr1 = {30, 10, 40, 20, 50, 70, 80, 60, 110, 90, 100, 120};
//		sortNearlySortedArray(arr1, 2);
		
//		Median_PQ mpq = new Median_PQ();
//		
//		mpq.add(10);
//		System.out.println(mpq.peek());
//		
//		mpq.add(100);
//		System.out.println(mpq.peek());
//		
//		mpq.add(90);
//		System.out.println(mpq.peek());
//		
//		mpq.add(80);
//		System.out.println(mpq.peek());
//		
//		mpq.add(110);
//		System.out.println(mpq.peek());
//		
//		mpq.add(120);
//		System.out.println(mpq.peek());
//		
//		mpq.add(105);
//		System.out.println(mpq.peek());
//		
//		System.out.println("----------");
//		
//		while(mpq.size() > 0) {
//			System.out.println(mpq.remove());
//		}
		
//		ArrayList<Integer> l0 = new ArrayList<>();
//		l1.add(10);
//		l1.add(20);
//		l1.add(30);
//		l1.add(40);
//		
//		ArrayList<Integer> l1 = new ArrayList<>();
//		l2.add(22);
//		l2.add(27);
//		l2.add(28);
//		l2.add(35);
//		l2.add(55);
//		
//		ArrayList<Integer> l2 = new ArrayList<>();
//		l3.add(11);
//		l3.add(32);
//		l3.add(41);
//		
//		ArrayList<Integer> l3 = new ArrayList<>();
//		l4.add(5);
//		l4.add(12);
//		l4.add(26);
//		l4.add(38);
//		
//		ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
//		
//		lists.add(l0);
//		lists.add(l1);
//		lists.add(l2);
//		lists.add(l3);
		
//		ArrayList<Integer> l0 = new ArrayList<>(Arrays.asList(10, 20, 30, 40));
//		ArrayList<Integer> l1 = new ArrayList<>(Arrays.asList(22, 27, 28, 35, 55));
//		ArrayList<Integer> l2 = new ArrayList<>(Arrays.asList(11, 32, 41));
//		ArrayList<Integer> l3 = new ArrayList<>(Arrays.asList(5, 12, 26, 38));
//		
//		ArrayList<ArrayList<Integer>> lists = new ArrayList<>(Arrays.asList(l0, l1, l2, l3));
//		
//		mergeKSortedLists(lists);
		
		heapSort(arr);
		heapSort(arr1);
	}
	
	public static void heapSort(int [] arr) {
		
		Heap heap = new Heap();
		
		for(int val : arr) {
			heap.add(val);
		}
		
		while(heap.size() > 0) {
			System.out.print(heap.remove() + " ");
		}
		
		System.out.println();
	}

	public static void printKLargest(int[] arr, int k) { // Space = O(n) & Time = (n + k) logn

		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

		for (int val : arr) {
			pq.add(val);
		}

		for (int i = 0; i < k; i++) {
			System.out.print(pq.remove() + " ");
		}

		System.out.println();
	}

	public static void printKLargestBetter(int[] arr, int k) { // Space = O(k) & Time = nlogk

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int i = 0; i < arr.length; i++) {

			if (i < k) {
				pq.add(arr[i]);
			}

			else {
				if (arr[i] > pq.peek()) {
					pq.remove();
					pq.add(arr[i]);
				}
			}
		}

		System.out.println(pq);
	}

	public static void sortNearlySortedArray(int[] arr, int k) {

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int i = 0; i < k + 1; i++) {
			pq.add(arr[i]);
		}

		int j = 0;
		for (int i = k + 1; i < arr.length; i++) {
			arr[j] = pq.remove();
			j++;
			pq.add(arr[i]);
		}

		while (pq.size() > 0) {
			arr[j] = pq.remove();
			j++;
		}

		for (int val : arr) {
			System.out.print(val + " ");
		}
	}

	static class Pair implements Comparable<Pair> {

		int lidx;
		int didx;
		int val;

		public Pair(int lidx, int didx, int val) {
			this.lidx = lidx;
			this.didx = didx;
			this.val = val;
		}

		public int compareTo(Pair o) {
			return this.val - o.val;
		}
	}

	public static void mergeKSortedLists(ArrayList<ArrayList<Integer>> lists) {

		PriorityQueue<Pair> pq = new PriorityQueue<>();

		for (int i = 0; i < lists.size(); i++) {
			Pair np = new Pair(i, 0, (lists.get(i)).get(0));
			pq.add(np);
		}

		while (pq.size() > 0) {

			int lidx = pq.peek().lidx;
			int didx = pq.peek().didx;

			System.out.print(pq.remove().val + " ");
			
			if(didx + 1 < lists.get(lidx).size()) {
				pq.add(new Pair(lidx, didx + 1, lists.get(lidx).get(didx + 1)));
			}
		}
	}
}