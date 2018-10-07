
public class Quick_Sort {

	public static void main(String[] args) {
		
		int arr[] = {10, 5, 28, 27, 9, 22, 17};
		
//		int pi = partition(arr, 19);
//		System.out.println("Pivot Index = " + pi);
//		
//		for(int val : arr) {
//			System.out.print(val + " ");
//		}
		
		QuickSort(arr, 0, arr.length - 1);
		
		for(int val : arr) {
			System.out.print(val + " ");
		}
		
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

}
