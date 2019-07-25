package class_8_HashMap_n_Heaps;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class KSmallestElementInOrder {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();
		int k = scn.nextInt();

		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		
		print_k_smallest_elements_in_their_original_order(n, k, arr);
	}

	public static void print_k_smallest_elements_in_their_original_order(int n, int k, int[] arr) {

		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

		for (int i = 0; i < k; i++) {
			pq.add(arr[i]);
		}

		for (int i = k; i < n; i++) {

			if (pq.peek() > arr[i]) {
				pq.remove();
				pq.add(arr[i]);
			}
		}

		for (int i = 0; i < n; i++) {

			if (pq.size() > 0 && arr[i] < pq.peek()) {
				System.out.print(arr[i] + " ");
			}

			else if (pq.size() > 0 && arr[i] == pq.peek()) {
				System.out.print(pq.remove() + " ");
			}
		}
	}
}