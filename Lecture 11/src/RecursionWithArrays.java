import java.util.Scanner;

public class RecursionWithArrays {

	public static void main(String[] args) {
		
		int arr[] = {6, 2, 12, 33, 8, 1, 12, 1, 28};
		
		//Display(arr, 0);
		//ReverseDisplay(arr, 0);
		//System.out.println(Max(arr, 0));
		//System.out.println(FindStupid(arr, 34, 0));
		//System.out.println(FindSmart(arr, 33, 0));
		//System.out.println(FirstIndex(arr, 12, 0));
		//System.out.println(LastIndex(arr, 12, 0));
//		int[] res = AllIndices(arr, 1, 0, 0);
//		for(int i=0; i<res.length; i++) {
//			System.out.print(res[i] + " ");
//		}
		
		BubbleSort(arr, 0, arr.length-1);
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		
	}
	
	public static void Display(int[] arr, int vidx) {
		
		if(vidx == arr.length)
			return;
		
		System.out.println(arr[vidx]);
		Display(arr, vidx+1);
	}
	
	public static void ReverseDisplay(int[] arr, int vidx) {
		
		if(vidx == arr.length)
			return;
		
		ReverseDisplay(arr, vidx+1);
		System.out.print(arr[vidx] + " ");
	}
	
	public static int Max(int[] arr, int vidx) {
		
		if(vidx == arr.length-1)
			return arr[vidx];
		
		int misa = Max(arr, vidx+1);
		if(misa > arr[vidx])
			return misa;
		
		else
			return arr[vidx];
	}
	
	public static boolean FindStupid(int[] arr, int data, int vidx) {
		
		if(vidx == arr.length)
			return false;
		
		boolean check = FindStupid(arr, data, vidx+1);
		if(check)
			return true;
		
		if(arr[vidx] == data)
			return true;
		else
			return false;
	}
	
	public static boolean FindSmart(int[] arr, int data, int vidx) {
		
		if(vidx == arr.length)
			return false;
		
		if(arr[vidx] == data)
			return true;
		
		return FindSmart(arr, data, vidx+1);
	}
	
	public static int FirstIndex(int[] arr, int data, int vidx) {
		
		if(vidx == arr.length)
			return -1;
		
		if(arr[vidx] == data) {
			return vidx;
		}
		
		return FirstIndex(arr, data, vidx+1);
	}
	
	public static int LastIndex(int[] arr, int data, int vidx) {
		
		if(vidx == arr.length)
			return -1;
		
		int pos = LastIndex(arr, data, vidx+1);
		if(pos != -1)
			return pos;
		
		if(arr[vidx] == data)
			return vidx;
		else
			return -1;
	}
	
	public static int[] AllIndices(int[] arr, int data, int vidx, int count) {
		
		if(vidx == arr.length) {
			int a[] = new int[count];
			return a;
		}
		
//		if(arr[vidx] == data)
//			count++;
//		
//		int pos[] = AllIndices(arr, data, vidx+1, count);
//		
//		if(arr[vidx] == data) {
//			pos[count-1] = vidx;
//			count--;
//		}
//		
//		return pos;
		
		if(arr[vidx] == data) {
			int[] res = AllIndices(arr, data, vidx+1, count+1);
			res[count] = vidx;
			return res;
		}
		
		else {
			int[] res = AllIndices(arr, data, vidx+1, count);
			return res;
		}
	}
	
	public static void BubbleSort(int[] arr, int s, int e) {
		
		if(s == e)
			return;
		
		if(arr[s] > arr[s+1]) {
			int temp = arr[s];
			arr[s] = arr[s+1];
			arr[s+1] = temp;
		}
		
		BubbleSort(arr, s+1, e);
		BubbleSort(arr, 0, e-1);
	}
}