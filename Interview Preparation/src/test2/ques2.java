package test2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class ques2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
		
		for(int i = 0; i < m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			if(map.containsKey(x) == false) {
				map.put(x, new HashSet<>());
			}
			
			map.get(x).add(y);
		}
		
		System.out.println(party(n, map));
	}
	
	public static int party(int n, HashMap<Integer, HashSet<Integer>> map) {
		
		int idx;
		int left = 0;
		int right = n - 1;
		
		while(left != right) {
			
			if(map.containsKey(left) && map.get(left).contains(right)) {
				left++;
			}
			
			else {
				right--;
			}
		}
		
		idx = left;
		if(map.containsKey(idx)) {
			return -1;
		}
		
		for(int key : map.keySet()) {
			if(map.get(key).contains(idx) == false) {
				return -1;
			}
		}
		
		return idx;
	}

}
