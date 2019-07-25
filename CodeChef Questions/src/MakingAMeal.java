import java.util.HashMap;
import java.util.Scanner;

public class MakingAMeal {

	public static void main(String[] args) {
		
		Scanner sc =  new Scanner(System.in);
		int t = sc.nextInt();
		int tno = 0;
		
		while(tno < t) {
			
			int n = sc.nextInt();
			
			String meal = "codechef";
//			HashMap<Character, Integer> map = new HashMap<>();
			int[] arr = new int[meal.length()];
			
//			for(char ch : meal.toCharArray()) {
//				map.put(ch, 0);
//			}
			
			for(int i = 0; i < n; i++) {
				
				String str = sc.next();
				
				for(char ch : str.toCharArray()) {
//					if(map.containsKey(ch)) {
//						map.put(ch, map.get(ch) + 1);
//					}
					
					for(int k = 0; k < meal.length(); k++) {
						if(ch == meal.charAt(k)) {
							arr[k] = arr[k] + 1;
						}
					}
				}
			}
			
			int maxMeals = Integer.MAX_VALUE;
			
//			for(char ch : map.keySet()) {
//				maxMeals = Math.min(maxMeals, map.get(ch));
//			}
			
			for(int val : arr) {
//				System.out.println(val);
				maxMeals = Math.min(maxMeals, val);
			}
			
			System.out.println(maxMeals);
			tno++;
		}
	}
}