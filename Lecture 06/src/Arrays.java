import java.util.Scanner;

public class Arrays {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
//		System.out.print("Enter the Count of Elements : ");
//		int n = sc.nextInt();
//		int[] arr = new int[20];

//		System.out.print("Enter the Elements : ");
//		for (int i = 0; i < n; i++) {
//			arr[i] = sc.nextInt();
//		}
		
		int[] arr1 = {10,20,30,40,50,60,70};
		int[] arr2 = {3,2,4,0,1};
		int[] arr3 = {1,2,3,4,5,6,7,8,9};
		int[] arr4 = {10,20,30,40};
		int r = 3;
		//int n1=40;
		
		//FindMax(arr1);
		//LinearSearch(arr1, sc);
		//BinarySearch(arr1,n1);
		//ReverseArray(arr1);
		//Inverse(arr2);
		//Rotate(arr3, r);
		//SubArrays(arr4);
		SubSets(arr4);
		
	}

	private static void FindMax(int[] arr) {

		int largest = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > largest)
				largest = arr[i];
		}
		System.out.print("Largest Element = " + largest);
	}

	private static void LinearSearch(int[] arr, Scanner sc) {

		System.out.print("Enter the Element to be Searched : ");
		int num = sc.nextInt();
		int pos = -1;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == num) {
				pos = i;
				break;
			}
		}

		System.out.print(pos);
	}

	private static void BinarySearch(int[] arr, int num) {

		int low = 0, high = (arr.length - 1), mid;

		while (low <= high) {
			mid = (low + high) / 2;

			if (arr[mid] == num) {
				// pos = mid;
				System.out.print("Element is found at " + mid);
				return;
			}

			else if (arr[mid] < num) {
				low = mid + 1;
			}

			else if (arr[mid] > num) {
				high = mid - 1;
			}
		}

		// if(pos == -1)
		System.out.print("Element not found");
	}
	
	private static void ReverseArray(int[] arr) {
		
		int left=0, right=arr.length-1, temp;
		
		while(left < right)
		{
			temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			
			left++;
			right--;
		}
		
		for(int val : arr) {
			System.out.print(val + " ");
		}
	}
	
	private static void Inverse(int[] arr) {
		
		int[] narr = new int[arr.length];
		
		for(int i=0; i<arr.length; i++)
		{
			narr[arr[i]] = i;
		}
		
		for(int val : narr)
		{
			System.out.print(val + " ");
		}
	}
	
	private static void Rotate(int[] arr, int r) {
		
		Reverse(arr, 0, arr.length - 1 - r);
		Reverse(arr, arr.length - r,arr.length-1);
		Reverse(arr, 0, arr.length - 1);
		Display(arr);
		
	} 
	
	private static void Reverse(int[] arr, int left, int right) {
		
		while(left < right)
		{
			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			
			left++;
			right--;
		}
	}
	
	private static void Display(int[] arr) {
		
		for(int val : arr)
		{
			System.out.print(val + " ");
		}
	}
	
	private static void swap(int a, int b) {
		
			int temp = a;
			a = b;
			b = temp;
	}
	
	private static void SubArrays(int[] arr) {
		
		for(int i=0; i < arr.length; i++)
		{
			for(int j=i; j < arr.length; j++)
			{
				PrintASubArray(arr, i, j);
			}
		}
	}
	
	private static void PrintASubArray(int[] arr, int start, int end) {
		
		for(int k=start; k <= end; k++)
		{
			System.out.print(arr[k] + " ");
		}
		System.out.println();
	}
	
	private static void SubSets(int[] arr) {
		
		int len = arr.length;
		
		for(int i=0; i < (1 << len); i++)
		{
			for(int j = 0; j < len; j++)
			{
				int b2c = len - 1 - j;
				int bm = 1 << b2c;
				
				if((i & bm) != 0)
					System.out.print(arr[j] + " ");
			}
			System.out.println();
		}
	}
	
	private static void SubArrayMaxSum(int[] arr) {
		
		
	}
}