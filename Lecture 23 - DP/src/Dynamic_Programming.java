
public class Dynamic_Programming {

	public static void main(String[] args) {
		
		int[] arr = {5, 2, 4, 6, 3};
		SubSets(arr, 10);
		
	}
	
	private static void SubSets(int[] arr, int sum) {
		
		boolean[][] strg = new boolean[arr.length + 1][sum + 1];
		
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
							if(strg[i - 1][j - arr[i - 1]] == true) {
								strg[i][j] = true;
							}
						}
					}
				}
			}
		}
		
		System.out.println(strg[strg.length - 1][strg[0].length - 1]);
	}

}
