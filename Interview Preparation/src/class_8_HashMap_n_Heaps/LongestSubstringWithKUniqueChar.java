package class_8_HashMap_n_Heaps;

import java.util.HashSet;

public class LongestSubstringWithKUniqueChar {

	public static void main(String[] args) {
		
		String s = "aabacbebebe";
		int k = 3;
		System.out.println(ques(s, k));
	}
	
	public static int ques(String s, int k) {
		
		HashSet<Character> set = new HashSet<>();
		
		int i = -1;
		int j = 0;
		int max = 0;
		
		while(j < s.length()) {
			
			if(set.size() > k) {
				max = Math.max(max, j - i - 1);
				i++;
				set.remove(s.charAt(i));
			}
			
			else {
				set.add(s.charAt(j));
				j++;
			}
		}
		
		return max;
	}
}