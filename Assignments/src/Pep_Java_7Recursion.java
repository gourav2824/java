import java.util.Scanner;

public class Pep_Java_7Recursion {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		for(int i=0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		int num = sc.nextInt();
		
//		PrintInvertedTriangle(n);
//		System.out.println(NthTriangle(n));
//		System.out.println(CheckSortedArray(arr, 0));
//		System.out.println(FindNumberInArray(arr, 0, num));
//		System.out.println(IndexOfNumber(arr, 0, num));
		System.out.println(LastIndexOfNumber(arr, 0, num));
	}
	
	private static void PrintInvertedTriangle(int n) {
		
		if(n == 0) {
			return;
		}
		
		for(int i=1; i<=n; i++) {
			System.out.print("*");
		}
		System.out.println();
		
		PrintInvertedTriangle(n-1);
	}
	
	private static void BinomialPattern(int n) {
		
		if(n == 0) {
			System.out.println("1");
			return;
		}
		
		BinomialPattern(n-1);
		printBinomialTerm(n, n);
	}
	
	private static void printBinomialTerm(int n, int r) {
		
		int KplusOne = printBinomialTerm(n, r-1) * ();
	}
	
	private static int NthTriangle(int n) {
		
		if(n == 1) {
			return 1;
		}
		
		int sum = n + NthTriangle(n-1);
		return sum;
	}
	
	private static boolean CheckSortedArray(int[] arr, int vidx) {
		
		if(vidx == arr.length - 1) {
			return true;
		}
		
		if(arr[vidx] > arr[vidx + 1]) {
			return false;
		}
		
		else {
			return CheckSortedArray(arr, vidx + 1);
		}
	}
	
	private static boolean FindNumberInArray(int[] arr, int vidx, int num) {
		
		if(vidx == arr.length) {
			return false;
		}
		
		if(arr[vidx] == num) {
			return true;
		}
		
		else {
			return FindNumberInArray(arr, vidx + 1, num);
		}
	}
	
	private static int IndexOfNumber(int[] arr, int vidx, int num) {
		
		if(vidx == arr.length) {
			return -1;
		}
		
		if(arr[vidx] == num) {
			return vidx;
		}
		
		else {
			return IndexOfNumber(arr, vidx + 1, num);
		}
	}
	
	private static int LastIndexOfNumber(int[] arr, int vidx, int num) {
		
		if(vidx == arr.length) {
			return -1;
		}
		
		int result = LastIndexOfNumber(arr, vidx + 1, num);
		
		if(result != -1) {
			return result;
		}
		
		else if(arr[vidx] == num) {
			return vidx;
		}
		
		else {
			return result;
		}
	}
	
	private void AllIndexOfNumber(int[] arr, int vidx, int num, int[] indices) {
		
		
	}
}