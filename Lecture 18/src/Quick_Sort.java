import java.util.Arrays;

public class Quick_Sort {

	public static void main(String[] args) {
		
//		int arr[] = {10, 5, 28, 27, 9, 22, 17};
//		QuickSort(arr, 0, arr.length - 1);
//		
//		for(int val : arr) {
//			System.out.print(val + " ");
//		}
		
//		int arr[] = {0,1,1,0,0,1,1,1,0,1,0};
//		sort01(arr);
		
//		int arr[] = {9,0,0,9,6,5,0,0,7};
//		MoveZeroesToEnd(arr);
		
//		int[] arr = {0,1,1,2,2,2,0,1,2,0,0,1,1,2};
//		sort012(arr);
//		for(int val : arr) {
//			System.out.print(val + " ");
//		}
		
//		int val = getPolyVal(2, 3);
//		System.out.print(val);
		
		SieveOfEratosthenes(30);
	}
	
	private static void QuickSort(int[] arr, int lo, int hi) {
		
		if(lo >= hi) {
			return;
		}
		
		int pivot = arr[hi];
		
		int pi = partition(arr, lo, hi, pivot);
		QuickSort(arr, lo, pi - 1);
		QuickSort(arr, pi + 1, hi);
	}
	
	private static int partition(int[] arr, int lo, int hi, int pivot) {
		
		int i=lo, p=lo;
		
		while(i <= hi) {
			
			if(arr[i] > pivot) {
				i++;
			}
			
			else {
				swap(arr, i, p);
				i++;
				p++;
			}
		}
		
		return p-1;
	}
	
	private static void swap(int[] arr, int i, int j) {
		
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	private static void sort01(int[] arr) {
		
//		partition(arr, 0, arr.length - 1, 0);
		
		int i=0, j=0;
		
		while(i < arr.length) {
			
		}
		
		for(int val : arr) {
			System.out.print(val + " ");
		}
	}
	
	private static void MoveZeroesToEnd(int[] arr) {
		
	}
	
	private static void sort012(int[] arr) {
		
		int i=0, j=0, k=0;
		
		while(k < arr.length) {
			
			if(arr[k] == 2) {
				k++; // 2's region grows
			}
			
			else if(arr[k] == 1) {
				swap(arr, j, k);
				k++;
				j++;
			}
			
			else {
				swap(arr, j, k);
				k++;
				swap(arr, j, i);
				j++;
				i++;
			}
		}
	}
	
	private static int getPolyVal(int x, int n) {
		
		int sum = 0, x_val = x;
		
		for(int i=n; i > 0; i--) {
			
			sum += i * x_val;
			x_val *= x;
		}
		
		return sum;
	}
	
	private static void SieveOfEratosthenes(int n) {
		
		boolean[] primes = new boolean[n+1];
		Arrays.fill(primes, true);
		
		primes[0] = false;
		primes[1] = false;
		
		for(int i=2; i * i <= n; i++) {
			if(primes[i] == true) {
				
				for(int j=i; j * i <= n; j++) {
					primes[j * i] = false;
				}
			}
		}
		
		for(int i=0; i < primes.length; i++) {
			if(primes[i] == true) {
				System.out.print(i + " ");
			}
		}
	}
}