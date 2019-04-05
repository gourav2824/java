import java.util.ArrayList;
import java.util.Scanner;

public class YetAgainASubarrayProblem {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int tno = 0;
		
		while(tno < t) {
			
			int n = sc.nextInt();
			int k = sc.nextInt();
			
			int[] a = new int[n];
			
			for(int i = 0; i < n; i++) {
				a[i] = sc.nextInt();
			}
			
			tno ++;
		}
		
		int[] arr = {1, 2, 3};
		int[] res = {};
		subArrays(arr, res);
		
		for(Integer[] ai : subarrs) {
			for(int i : ai) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
	
	static ArrayList<Integer[]> subarrs = new ArrayList<>();
	
	private static void subArrays(int[] arr, int[] res) {
		
//		if(arr.size() == 0) {
//			if(res.size() > 0) {
//				System.out.println(res);
//			}
//			return;
//		}
//		
//		ArrayList<Integer> narr = arr;
//		ArrayList<Integer> nres = res;
//		
//		nres.add(narr.remove(0));
//		
//		subArrays(narr, res);
//		subArrays(narr, nres);
		
		if(arr.length == 0) {
			if(res.length > 0) {
				Integer[] resn = new Integer[res.length];
				for(int i = 0; i < res.length; i++) {
					resn[i] = res[i];
				}
				subarrs.add(resn);
			}
			return;
		}
		
		int[] ros = new int[arr.length - 1];
		for(int i = 0; i < arr.length; i++) {
			if(i != 0) {
				ros[i - 1] = arr[i];
			}
		}
		
		int[] nres = new int[res.length + 1];
		for(int i = 0; i < res.length; i++) {
			nres[i] = res[i];
		}
		
		nres[nres.length - 1] = arr[0];
		
		subArrays(ros, res);
		subArrays(ros, nres);
	}
}