package test4;

import java.util.*;

public class Ques4 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		HashSet<Long> set = new HashSet<>();
		
		int[] nums = {2, 3, 5, 7};
		long count = 0;
		
		for(int num : nums) {
			
			for(long i = 2; i <= n; i++) {
				
				if(set.contains(i) == false && i % num == 0) {
					count++;
					set.add(i);
				}
			}
		}
		
		System.out.println(count);
	}
}