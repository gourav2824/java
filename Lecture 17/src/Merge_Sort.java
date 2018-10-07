
public class Merge_Sort {

	public static void main(String[] args) {
		
//		int[] one = {10, 20, 30, 40, 50};
//		int[] two = {11, 15, 19, 25, 35, 55, 65, 75};
//		
//		int[] res = merge(one, two);
//		for(int val : res) {
//			System.out.print(val + " ");
//		}
		
		int[] arr = {4, 9, 5, 6, 1, 2, 8, 7, 0, 3};
		int[] sorted = mergeSort(arr, 0, arr.length - 1);
		
		for(int val : sorted) {
			System.out.print(val + " ");
		}
	}
	
	public static int[] merge(int[] one, int[] two) {
		
		int n = one.length + two.length;
		int[] res = new int[n];
		
		int i=0, j=0, k=0;
		
//		for(int k=0; k<n; k++) {
//			
//			if(i == one.length) {
//				res[k] = two[j];
//				j++;
//			}
//			
//			else if(j == two.length) {
//				res[k] = one[i];
//				i++;
//			}
//			
//			else {
//				if(one[i] <= two[j]) {
//					res[k] = one[i];
//					i++;
//				}
//				
//				else {
//					res[k] = two[j];
//					j++;
//				}
//			}
//		}
		
		while(i < one.length && j < two.length) {
			
			if(one[i] <= two[j]) {
				res[k] = one[i];
				i++;
				k++;
			}
			
			else {
				res[k] = two[j];
				j++;
				k++;
			}
		}
		
		while(i < one.length) {
			res[k] = one[i];
			i++;
			k++;
		}
		
		while(j < two.length) {
			res[k] = two[j];
			j++;
			k++;
		}
		
		return res;
	}
	
	private static int[] mergeSort(int[] arr, int lo, int hi) {
		
		if(lo == hi) {
			int[] ba = new int[1];
			ba[0] = arr[lo];
			return ba;
		}
		
		int mid = (lo + hi) / 2;
		
		int[] fhalf = mergeSort(arr, lo, mid);
		int[] shalf = mergeSort(arr, mid + 1, hi);
		
		int[] sorted = merge(fhalf, shalf);
		return sorted;
	}
}