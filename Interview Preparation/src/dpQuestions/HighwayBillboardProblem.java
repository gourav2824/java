package dpQuestions;
import java.util.*;

public class HighwayBillboardProblem {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int m = sc.nextInt();
		int n = sc.nextInt();
		
		int[] pos = new int[n];
		for(int i = 0; i < n; i++) {
			pos[i] = sc.nextInt();
		}
		
		int[] revenue = new int[n];
		for(int i = 0; i < n; i++) {
			revenue[i] = sc.nextInt();
		}
		
		int t = sc.nextInt();
		
		System.out.println(maxRevenue(m, n, pos, revenue, t));
	}
	
	private static int maxRevenue(int m, int n, int[] pos, int[] revenue, int t) {
		
		HashMap<Integer, Integer> map = new HashMap<>();
		TreeSet<Integer> set = new TreeSet<>();
		
		for(int i = 0; i < n; i++) {
			map.put(pos[i], revenue[i]);
			set.add(pos[i]);
		}
		
		int omax = revenue[0];
		
		for(int i = 1; i < n; i++) {
			
			int curr = pos[i];
			
			if(set.lower(curr) != null) {
				
				int lower = set.lower(curr);
				if(curr - lower > t) {
					map.put(curr, Math.max(map.get(curr), map.get(lower) + revenue[i]));
				}
			}
			
			if(set.lower(curr - t) != null) {
				
				int lower = set.lower(curr - t);
				map.put(curr, Math.max(map.get(curr), map.get(lower) + revenue[i]));
			}
			
			omax = Math.max(omax, map.get(curr));
		}
		
		return omax;
	}
}