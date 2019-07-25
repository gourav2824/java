package class_8_HashMap_n_Heaps;
import java.util.*;

public class ques4 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		ques(arr);
	}

	private static void ques(int[] arr) {
		
		HashSet<Integer> set = new HashSet<>();
		HashMap<Integer, Integer> map = new HashMap<>();
		
		int i = -1;
		int j = -1;
		int count = 0;
		
		while(j < arr.length) {
			
			if(j + 1 < arr.length && set.contains(arr[j + 1])) {
				i++;
				set.remove(arr[i]);
			}
			
			else {
				j++;
				
				if(j == arr.length) {
					continue;
				}
				
				set.add(arr[j]);
				count += set.size();
			}
		}
		
		for(int val : arr) {
			map.put(val, map.containsKey(val) ? map.get(val) + 1 : 1);
		}
		
		int dup = 0;
		
		for(int val : map.keySet()) {
			if(map.get(val) > 1) {
				dup += map.get(val);
				dup--;
			}
		}
		
		System.out.println(count - dup);
	}
}