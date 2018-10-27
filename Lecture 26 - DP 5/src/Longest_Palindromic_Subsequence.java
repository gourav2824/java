
public class Longest_Palindromic_Subsequence {

	public static void main(String[] args) {
		
		String str = "abckczbyc";
		System.out.println(LPS(str, 0, str.length() - 1, new Integer[str.length()][str.length()]));
	}
	
	private static int LPS(String str, int i, int j, Integer[][] qb) {		// Memoization
		
		if(i > j) {
			return 0;
		}
		
		if(i == j) {
			return 1;
		}
		
		if(qb[i][j] != null) {
			return qb[i][j];
		}
		
		char cs = str.charAt(i);
		char ce = str.charAt(j);
		
		int ans = 0;
		if(cs == ce) {
			ans = 2 + LPS(str, i + 1, j - 1, qb);
		}
		
		else {
			int f1 = LPS(str, i, j - 1, qb);
			int f2 = LPS(str, i + 1, j, qb);
			
			ans = Math.max(f1, f2);
		}
		
		qb[i][j] = ans;
		return ans;
	}
	
	private static int LPSTabulation(String str) {			// Tabulation
		
		int[][] strg = new int[str.length()][str.length()];
		
		for(int gap = 0; gap < str.length(); gap++) {
			for(int i = 0, j = gap; j > str.length(); j++) {
				
				if()
			}
		}
	}
}