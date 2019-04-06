
public class HeapSort {

	public static void main(String[] args) {
		
		int[] arr = {4, 2, 3, 9, 6, 1, 7};
		
		heapSort(arr);
		
		System.out.print("Sorted Array : ");
		for(int val : arr) {
			System.out.print(val + " ");
		}
	}
	
	public static void heapSort(int[] arr) {
		
		int size = arr.length;
		
		for(int i = size / 2 - 1; i >= 0; i--) {
			buildMaxHeap(arr, size, i);
		}
		
		for(int i = size - 1; i >= 0; i--) {
			
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			
			buildMaxHeap(arr, i, 0);
		}
	}
	
	public static void buildMaxHeap(int[] arr, int size, int i) {
		
		int max = i;
		int left = 2 * i + 1;
		int right = 2 * i + 2;
		
		if(left < size) {
			if(arr[left] > arr[max]) {
				max = left;
			}
		}
		
		if(right < size) {
			if(arr[right] > arr[max]) {
				max = right;
			}
		}
		
		if(max != i) {
			
			int temp = arr[i];
			arr[i] = arr[max];
			arr[max] = temp;
			
			buildMaxHeap(arr, size, max);
		}
	}
}