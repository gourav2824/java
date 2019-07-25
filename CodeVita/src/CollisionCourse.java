import java.io.*;
import java.util.*;

public class CollisionCourse {

	public static void main(String[] args) {
		
		InputStreamReader isr = new InputStreamReader(System.in);    
	    BufferedReader br = new BufferedReader(isr);
	    
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		HashMap<Long, Long> map = new HashMap<>();
		long count = 0;
		
		for(int i = 0; i < n; i++) {
			
			long x = sc.nextLong();
			long y = sc.nextLong();
			long v = sc.nextLong();
			
			long d = (long) Math.sqrt((x * x) + (y * y));
			long time = d / v;
			
			if(map.containsKey(time)) {
				count += map.get(time);
				map.put(time, map.get(time) + 1);
			}
			
			else {
				map.put(time, 1L);
			}
		}
		
		System.out.println(count);
	}
}