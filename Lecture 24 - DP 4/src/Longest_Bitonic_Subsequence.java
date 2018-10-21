
public class Longest_Bitonic_Subsequence {

	public static void main(String[] args) {
		
		int[] arr = {10, 22, 9, 33, 21, 50, 41, 60, 80, 1};
		LongestBitonicSubsequence(arr);
	}
	
	private static void LongestBitonicSubsequence(int[] arr) {
		
		int[] lis = new int[arr.length];
		int[] lds = new int[arr.length];
		
		lis = LongestIncreasingSubsequence(arr);
		lds = LongestDecreasingSubsequence(arr);
		
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < arr.length; i++) {
			
			max = Math.max(lis[i] + lds[i], max);
		}
		
		System.out.println("Length of Longest Bitonic Subsequence = " + (max - 1));
	}
	
	private static int[] LongestIncreasingSubsequence(int[] arr) {
		
		int[] strg = new int[arr.length];
		
		strg[0] = 1;
		
		for(int i = 1; i < strg.length; i++) {
			
			strg[i] = 1;
			for(int j = 0; j < i; j++) {
				
				if(arr[i] > arr[j]) {
					strg[i] = Math.max(strg[j] + 1, strg[i]);
				}
			}
		}
		
		return strg;
	}
	
	private static int[] LongestDecreasingSubsequence(int[] arr) {
		
		int[] strg = new int[arr.length];
		
		strg[strg.length - 1] = 1;
		
		for(int i = strg.length - 2; i >= 0; i--) {
			
			strg[i] = 1;
			for(int j = i+1; j < strg.length; j++) {
				
				if(arr[i] > arr[j]) {
					strg[i] = Math.max(strg[j] + 1, strg[i]);
				}
			}
		}
		
		return strg;
	}
}