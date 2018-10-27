
public class Longest_Common_Subsequence {

	public static void main(String[] args) {
		
		String s1 = "aebg";
		String s2 = "abcg";
		
//		System.out.println(lcs(s1, s2, new Integer[s1.length() + 1][s2.length() + 1]));
		System.out.println(lcsTab(s1, s2));
	}
	
	private static int lcs(String s1, String s2, Integer[][] qb) {		// Memoization
		
		if(s1.length() == 0 || s2.length() == 0) {
			return 0;
		}
		
		if(qb[s1.length()][s2.length()] != null) {
			return qb[s1.length()][s2.length()];
		}
		
		char ch1 = s1.charAt(0);
		String ros1 = s1.substring(1);
		char ch2 = s2.charAt(0);
		String ros2 = s2.substring(1);
		
		int ans = 0;
		
		if(ch1 == ch2) {
			ans = 1 + lcs(ros1, ros2, qb);
		}
		
		else {
			int f1 = lcs(s1, ros2, qb);
			int f2 = lcs(ros1, s2, qb);
			
			ans = Math.max(f1, f2);
		}
		
		qb[s1.length()][s2.length()] = ans;
		return ans;
	}
	
	private static int lcsTab(String s1, String s2) {
		
		int[][] strg = new int[s1.length() + 1][s2.length() + 1];
		
		for(int i = strg.length - 2; i >= 0; i--) {
			for(int j = strg[0].length - 2; j >= 0; j--) {
				
				if(s1.charAt(i) == s2.charAt(j)) {
					
					strg[i][j] = 1 + strg[i + 1][j + 1];
				}
				
				else {
					strg[i][j] = Math.max(strg[i][j + 1], strg[i + 1][j]);
				}
			}
		}
		
		return strg[0][0];
	}
}