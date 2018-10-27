
public class Edit_Distance {

	public static void main(String[] args) {
		
		String s1 = "abcdeghi";
		String s2 = "acdfgkhi";
		
		System.out.println(EditDistance(s1, s2, new Integer[s1.length() + 1][s2.length() + 1]));
	}
	
	private static int EditDistance(String s1, String s2, Integer[][] qb) {		// Memoization
		
		if(s1.length() == 0) {
			return s2.length();		// Delete
		}
		
		else if(s2.length() == 0) {
			return s1.length();		// Insert
		}
		
		if(qb[s1.length()][s2.length()] != null) {
			return qb[s1.length()][s2.length()];
		}
		
		char ch1 = s1.charAt(0);
		String ros1 = s1.substring(1);
		char ch2 = s2.charAt(0);
		String ros2 = s2.substring(1);
		
		int ans;
		
		if(ch1 == ch2) {
			ans = EditDistance(ros1, ros2, qb);
		}
		
		else {
			
			int ans1 = EditDistance(ros1, ros2, qb) + 1;	// Replace
			
			int ans2 = EditDistance(ros1, s2, qb) + 1;		// Insert
			
			int ans3 = EditDistance(s1, ros2, qb) + 1; 		// Delete
			
			ans = Math.min(ans1, Math.min(ans2, ans3));
		}
		
		qb[s1.length()][s2.length()] = ans;
		return ans;
	}
}