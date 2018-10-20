
public class Dynamic_Programming {

	public static void main(String[] args) {
		
		int[] arr = {5, 2, 4, 6, 3};
		int sum = 10;
		boolean[][] strg = new boolean[arr.length + 1][sum + 1];
		
		SubSets(arr, strg, sum);
		printSubSets(strg, arr, strg.length - 1, strg[0].length - 1, "");
	}
	
	private static void SubSets(int[] arr, boolean[][] strg, int sum) {
		
		for(int i=0; i < strg.length; i++) {
			for(int j=0; j < strg[0].length; j++) {
				
				if(i == 0) {
					if(j == 0)
						strg[i][j] = true;
				}
				
				else {
					
					if(strg[i - 1][j] == true) {
						strg[i][j] = true;
					}
					
					else {
						if(j - arr[i - 1] >= 0) {
							strg[i][j] = strg[i - 1][j - arr[i - 1]];
						}
					}
				}
			}
		}
		
		System.out.println(strg[strg.length - 1][strg[0].length - 1]);
	}
	
	private static void printSubSets(boolean[][] strg, int[] arr, int i, int j, String asf) {
		
		if(j == 0) {
			System.out.println(asf);
			return;
		}
		
		if(i == 0) {
			return;
		}
		
		if(strg[i - 1][j] == true) {
			printSubSets(strg, arr, i - 1, j, asf);
		}
		
		if(j >= arr[i - 1] && strg[i - 1][j - arr[i - 1]] == true) {
			printSubSets(strg, arr, i - 1, j - arr[i - 1], asf + arr[i - 1] + " ");
		}
	}
}