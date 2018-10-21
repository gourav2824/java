
public class Minimum_Jumps {

	public static void main(String[] args) {
		
		int[] arr = {3, 4, 0, 1, 2, 0, 3, 1, 0, 2, 1};
		
		MinJumps(arr);
	}
	
	private static void MinJumps(int[] arr) {
		
		Integer[] strg = new Integer[arr.length];
		
		strg[strg.length - 1] = 0;
		
		for(int i = strg.length - 2; i >= 0; i--) {
			
			if(arr[i] > 0) {
				for(int j = i + 1; j <= i + arr[i] && j < strg.length; j++) {
					
					if(strg[j] != null) {
						
						if(strg[i] == null || strg[j] + 1 < strg[i]) {
							strg[i] = strg[j] + 1;
						}
					}
				}
			}
		}
		
		System.out.println(strg[0]);
	}
}