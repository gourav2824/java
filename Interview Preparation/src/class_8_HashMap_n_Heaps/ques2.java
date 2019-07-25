package class_8_HashMap_n_Heaps;

import java.util.Scanner;
import java.util.*;

public class ques2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		String s = sc.next();
		String r = sc.next();
		
		System.out.println(ques(s, r));
	}
	
	public static String ques(String s, String r) {
		
		HashMap<Character, Integer> rmap = new HashMap<>();
		HashMap<Character, Integer> map = new HashMap<>();
		
		for(char ch : r.toCharArray()) {
			rmap.put(ch, rmap.containsKey(ch) ? rmap.get(ch) + 1 : 1);
		}
		
		int n = r.length();
		
		int i = -1;
		int j = -1;
		int mi = -1;
		int mj = -1;
		int count = 0;
		int min = Integer.MAX_VALUE;
		
		while(j < s.length()) {
			
			if(count == n) {
				
				int len = j - i;
				if(len < min) {
					min = len;
					mi = i;
					mj = j;
				}
				
				i++;
				char ch = s.charAt(i);
				map.put(ch, map.get(ch) - 1);
				if(rmap.containsKey(ch) && map.get(ch) < rmap.get(ch)) {
					count--;
				}
			}
			
			else {
				j++;
				
				if(j == s.length()) {
					continue;
				}
				
				char ch = s.charAt(j);
				map.put(ch, map.containsKey(ch) ? map.get(ch) + 1 : 1);
				if(rmap.containsKey(ch) && map.get(ch) <= rmap.get(ch)) {
					count++;
				}
			}
		}
		
		String str = s.substring(mi + 1, mj + 1);
		return str;
	}
}