package test2;

import java.util.Scanner;
import java.util.Stack;

public class ques1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		nse(arr);
	}
	
	public static void nse(int[] arr) {
		
		Stack<Integer> st = new Stack<>();
		int[] nse = new int[arr.length];
//		nse[nse.length - 1] = -1;
//		st.push(arr[arr.length - 1]);
		
		for(int i = arr.length - 1; i >= 0; i--) {
			
			while(st.size() > 0 && st.peek() >= arr[i]) {
				st.pop();
			}
			
			if(st.size() == 0) {
				nse[i] = -1;
			}
			
			else {
				nse[i] = st.peek();
			}
			
			st.push(arr[i]);
		}
		
		for(int val : nse) {
			System.out.println(val);
		}
	}
	
	public static void nser(int[] arr) {
		
		Stack<Integer> st = new Stack<>();
		int[] nse = new int[arr.length];
		
		for(int i = 0; i < arr.length; i++) {
			
			while(st.size() > 0 && arr[st.peek()] > arr[i]) {
				nse[st.peek()] = arr[i];
				st.pop();
			}
			
			st.push(i);
		}
		
		while(st.size() > 0) {
			nse[st.pop()] = -1;
		}
		
		for(int val : nse) {
			System.out.println(val);
		}
	}

}
