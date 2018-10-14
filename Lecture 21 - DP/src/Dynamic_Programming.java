
public class Dynamic_Programming {

	public static void main(String[] args) {
		
//		int[][] arr = {
//				{1,0,1,0,1,1,1},
//				{1,0,1,1,0,1,1},
//				{1,1,1,1,0,1,0},
//				{0,1,1,1,1,0,0},
//				{1,0,1,1,1,1,1},
//				{1,1,1,1,1,1,0},
//				{1,0,0,1,1,0,0},
//				{1,0,1,1,1,0,1}
//		};
//		
//		LargestOneSquareMatrix(arr);
		
		printPalindromicSubstrings("abccbc");
	}
	
	public static void LargestOneSquareMatrix(int[][] arr) {
		
		int[][] strg = new int[arr.length][arr[0].length];
		int max = Integer.MIN_VALUE;
		int r = 0, c = 0;
		
		for(int i = arr.length - 1; i >= 0; i--) {
			for(int j = arr[0].length - 1; j >= 0; j--) {
				
				if(arr[i][j] == 1) {
					
					if(i == arr.length - 1 && j == arr[0].length - 1) {
						strg[i][j] = 1;
					}
					
					else if(i == arr.length - 1) {
						strg[i][j] = 1;
					}
					
					else if(j == arr[0].length - 1) {
						strg[i][j] = 1;
					}
					
					else {
						strg[i][j] = 1 + Math.min(strg[i+1][j+1], Math.min(strg[i][j+1], strg[i+1][j]));
						if(strg[i][j] >= max) {
							max = strg[i][j];
							r = i;
							c = j;
						}
					}
				}
			}
		}
		
		System.out.print(max + " at ");
		System.out.println("[" + r + " " + c + "]");
	}
	
	private static void printPalindromicSubstrings(String str) {
		
		boolean[][] strg = new boolean[str.length()][str.length()];
		
		for(int gap = 0; gap < str.length(); gap++) {
			for(int i = 0; i + gap < str.length(); i++) {
				
				int j = i + gap;
				
				if(gap == 0) {
					strg[i][j] = true;
				}
				
				else if(gap == 1) {
					strg[i][j] = str.charAt(i) == str.charAt(j);
				}
				
				else {
					strg[i][j] = str.charAt(i) == str.charAt(j) && strg[i+1][j-1];
				}
				
				if(strg[i][j]) {
					System.out.println(str.substring(i, j+1));
				}
			}
		}
	}
}