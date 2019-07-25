package test4;

public class QuickSelect {

	public static void main(String[] args) {
		
		int[] arr = {3, 1, 5, 2, 6, 9, 8, 7, 4};
		
		for(int i = 1; i <= arr.length; i++) {
			System.out.println(i + "th Smallest = " + kthSmallest(arr, i, 0, arr.length - 1));
		}
	}
	
	public static int kthSmallest(int[] arr, int k, int low, int hi) {
		
		int pivot = arr[hi];
		int pi = low;
		
		for(int i = low; i <= hi; i++) {
			
			if(arr[i] <= pivot) {
				int temp = arr[pi];
				arr[pi] = arr[i];
				arr[i] = temp;
				
				pi++;
			}
		}
		
		pi = pi - 1;
		
		if(pi + 1 == k) {
			return arr[pi];
		}
		
		if(pi + 1 < k) {
			low = pi + 1;
		}
		
		else {
			hi = pi - 1;
		}
		
		return kthSmallest(arr, k, low, hi);
	}
}