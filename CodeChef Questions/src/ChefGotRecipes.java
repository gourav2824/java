import java.util.Arrays;
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
			
			HashSet<Character> sets[] = new HashSet[n];
			
			for(int i = 0; i < n; i++) {
				
				d[i] = sc.next();
				sets[i] = new HashSet<>();
				
				for(char ch : d[i].toCharArray()) {
					if(sets[i].contains(ch) == false) {
						sets[i].add(ch);
					}
				}
			}
			
			int noOfMeals = 0;
			Character[] vowelsArr = {'a', 'e', 'i', 'o', 'u'};
			HashSet<Character> vowels = new HashSet<>(Arrays.asList(vowelsArr));
			
			for(int i = 0; i < n; i++) {
				for(int j = i + 1; j < n; j++) {
					
//					String meal = d[i] + d[j];
//					HashSet<Character> vowels = new HashSet<>();
					
//					for(char ch : meal.toCharArray()) {
//						if(vowels.contains(ch) == false) {
//							vowels.add(ch);
//						}
//						
//						if(vowels.size() == 5) {
//							noOfMeals ++;
//							break;
//						}
//					}
					
					boolean found = true;
					
					for(char ch : vowels) {
						if(sets[i].contains(ch) == false && sets[j].contains(ch) == false) {
							found = false;
							break;
						}
					}
					
					if(found == true) {
						noOfMeals ++;
					}
				}
			}
			
			System.out.println(noOfMeals);
			tno ++;
		}
	}
}