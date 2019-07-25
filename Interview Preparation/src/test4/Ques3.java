package test4;

import java.util.*;

public class Ques3 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		int q = sc.nextInt();
		int m = sc.nextInt();
		
		for(int i = 0; i < q; i++) {
			
			int s = sc.nextInt();
			int e = sc.nextInt();
			
			arr[s] += 1;
			if(e + 1 < n) {
				arr[e + 1] -= 1;
			}
		}
		
		for(int val : arr) {
			System.out.print(val + " ");
		}
		
		int psum = 0;
		for(int i = 0; i < n; i++) {
			psum += arr[i];
			arr[i] = psum;
		}
		
		System.out.println();
		
		for(int val : arr) {
			System.out.print(val + " ");
		}
	}
}