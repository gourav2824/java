
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
//		printPalindromicSubstrings("abccbc");
		
//		String str = "abccbc";
//		System.out.println(MinPalindromicCuts(str, 0, str.length() - 1));
//		Integer[][] qb = new Integer[str.length()][str.length()];
//		System.out.println(MinPalindromicCutsMem(str, 0, str.length() - 1, qb));
		
		int[] dims = {10, 20, 30, 40, 50, 60};
		System.out.println(MatrixChainMultiplication(dims, 0, dims.length - 1));
		
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
	
	private static int MinPalindromicCuts(String str, int i, int j) {
		
		if(IsPalindrome(str, i, j)) {
			return 0;
		}
		
		int minc = Integer.MAX_VALUE;
		
		for(int cp = i; cp < j; cp++) {
			
			int c1 = MinPalindromicCuts(str, i, cp);
			int c2 = MinPalindromicCuts(str, cp + 1, j);
			int tc = c1 + c2 + 1;
			minc = Math.min(minc, tc);
		}
		
		return minc;
	}
	
	private static boolean IsPalindrome(String str, int i, int j) {
		
		int left = i;
		int right = j;
		
		while(left < right) {
			
			if(str.charAt(left) != str.charAt(right)) {
				return false;
			}
			
			left++;
			right--;
		}
		
		return true;
	}
	
	private static int MinPalindromicCutsMem(String str, int i, int j, Integer[][] qb) {
		
		if(IsPalindrome(str, i, j)) {
			return 0;
		}
		
		if(qb[i][j] != null) {
			return qb[i][j];
		}
		
		int minc = Integer.MAX_VALUE;
		
		for(int cp = i; cp < j; cp++) {
			
			int c1 = MinPalindromicCutsMem(str, i, cp, qb);
			int c2 = MinPalindromicCutsMem(str, cp + 1, j, qb);
			int tc = c1 + c2 + 1;
			minc = Math.min(minc, tc);
		}
		
		qb[i][j] = minc;
		return minc;
	}
	
	private static int MatrixChainMultiplication(int[] dims, int i, int j) {
		
		if(i + 1 == j) {
			return 0;
		}
		
		int minc = Integer.MAX_VALUE;
		
		for(int cp = i+1; cp < j; cp++) {
			
			int c1 = MatrixChainMultiplication(dims, i, cp);
			int c2 = MatrixChainMultiplication(dims, cp, j);
			int muc = dims[i] * dims[cp] * dims[j];
			
			int tc = c1 + c2 + muc;
			minc = Math.min(minc, tc);
		}
		
		return minc;
	}
}