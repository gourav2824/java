import java.util.Scanner;

public class ChefAndSecretIngredients {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		int tno = 1;
		while(tno <= t) {
			
			int n = sc.nextInt();
			String[] s = new String[n];
			
			for(int i = 0; i < n; i++) {
				s[i] = sc.next();
			}
			
			int minLen = Integer.MAX_VALUE;
			int minidx = 0;
			
			for(int i = 0; i < s.length; i++) {
				
				if(s[i].length() < minLen) {
					minidx = i;
					minLen = s[i].length();
				}
			}
			
			int spi = 0;
			
			String ingredients = "";
			for(char ch : s[minidx].toCharArray()) {
				
				boolean found = false;
				for(char c : ingredients.toCharArray()) {
					if(c == ch) {
						found = true;
						break;
					}
				}
				
				if(found == false) {
					ingredients += ch;
				}
			}
			
			for(char ch : ingredients.toCharArray()) {
				
				boolean ifound = true;
				
				for(String str : s) {
					
					boolean chFound = false;
					for(char c : str.toCharArray()) {
						
						if(c == ch) {
							chFound = true;
							break;
						}
					}
					
					if(chFound == false) {
						ifound = false;
						break;
					}
				}
				
				if(ifound == true) {
					spi ++;
				}
			}
			
			System.out.println(spi);
			
			tno ++;
		}
	}
}