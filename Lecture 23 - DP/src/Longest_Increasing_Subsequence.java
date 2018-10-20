
public class Longest_Increasing_Subsequence {

	public static void main(String[] args) {
		
		int[] arr = {10, 22, 9, 33, 21, 50, 41, 60, 80, 1};
		
		LongestIncreasingSubsequence(arr);
	}
	
	private static void LongestIncreasingSubsequence(int[] arr) {
		
		int[] strg = new int[arr.length];
		
		strg[0] = 1;
		int omax = 0;
		
		for(int i = 1; i < strg.length; i++) {
			
			strg[i] = 1;
			for(int j = 0; j < i; j++) {
				
				if(arr[i] > arr[j]) {
					strg[i] = Math.max(strg[j] + 1, strg[i]);
				}
			}
			
			omax = Math.max(strg[i], omax);
		}
		
		System.out.println("Length of LIS = " + omax);
		
		for(int val : strg) {
			System.out.print(val + " ");
		}
	}
}