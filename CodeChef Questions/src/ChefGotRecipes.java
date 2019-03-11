import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class ChefGotRecipes {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int tno = 0;
		
		while(tno < t) {
			
			int n = sc.nextInt();
			String[] d = new String[n];
			
			map = new HashMap<>();
			combinations("aeiou", "");
			
			HashSet<Character> set;
			
			for(int i = 0; i < n; i++) {
				
				d[i] = sc.next();
				set = new HashSet<>();
				
				for(char ch : d[i].toCharArray()) {
					if(set.contains(ch) == false) {
						set.add(ch);
					}
				}
				
				String vowels = "aeiou";
				String str = "";
				
				for(char ch : vowels.toCharArray()) {
					if(set.contains(ch)) {
						str = str + ch;
					}
				}
				
				if(map.containsKey(str)) {
					map.put(str, map.get(str) + 1);
				}
			}
			
			HashMap<String, Integer> temp = map;
			map = new HashMap<>();
			
			for(String str : temp.keySet()) {
				if(temp.get(str) > 0) {
					map.put(str, temp.get(str));
				}
			}
			
			System.out.println(map);
			
			int noOfMeals = 0;
			String vowels = "aeiou";
			
			for(String str1 : map.keySet()) {
				for(String str2 : map.keySet()) {
					
					if(str1.equals(str2)) {
						continue;
					}
					
					String str = str1 + str2;
					boolean valid = true;
					
					for(char ch : vowels.toCharArray()) {
						
						boolean found = false;
						
						for(char chs : str.toCharArray()) {
							if(ch == chs) {
								found = true;
							}
						}
						
						if(found == false) {
							valid = false;
							break;
						}
					}
					
					if(valid == true) {
						int num = map.get(str1) * map.get(str2);
						noOfMeals += num;
					}
				}
			}
			
			noOfMeals = noOfMeals / 2;
			
			if(map.containsKey("aeiou")) {
				int num = map.get("aeiou") * (map.get("aeiou") - 1);
			    num = num / 2;
			    noOfMeals += num;
			}
			
			System.out.println(noOfMeals);
			tno ++;
		}
	}
	
	static HashMap<String, Integer> map;
	
	private static void combinations(String str, String res) {
		
		if(str.length() == 0) {
			if(res.length() > 0) {
				map.put(res, 0);
			}
			return;
		}
		
		char ch = str.charAt(0);
		String ros = str.substring(1);
		
		combinations(ros, res);
		combinations(ros, res + ch);
	}
}