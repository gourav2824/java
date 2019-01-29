
public class KMP_Algo {

	public static void main(String[] args) {
		
		String s = "jfdklfjfdkshafsdfbdfhfuyeiuyrrewjfdkjbvbscvhdjfdkhfdskfh";		// jfdk @ 0, 6, 32, 45
		String p = "jfdk";
		
		solve(s, p);
	}
	
	public static void solve(String s, String p) {
		
		int[] lps = preprocess(p);
		
		int i = 0;
		int j = 0;
		
		while(i < s.length()) {
			
			if(s.charAt(i) == p.charAt(j)) {
				i++;
				j++;
				
				if(j == p.length()) {
					System.out.println(p + " found at " + (i - j));
					j = lps[j - 1];
				}
			}
			
			else {
				if(j > 0) {
					j = lps[j - 1];
				}
				else {
					i++;
				}
			}
		}
	}
	
	public static int[] preprocess(String p) {
		
		int[] lps = new int[p.length()];
		
		int i = 1;
		int l = 0;
		
		while(i < p.length()) {
			
			if(p.charAt(l) == p.charAt(i)) {
				l++;
				lps[i] = l;
				i++;
			}
			
			else {
				if(l > 0) {
					l = lps[l - 1];
				}
				else {
					i++;
				}
			}
		}
		
		return lps;
	}
}