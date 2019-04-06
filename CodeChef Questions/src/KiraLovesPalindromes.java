import java.util.Scanner;

public class KiraLovesPalindromes {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int n = s.length();
		int substrs = 0;
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j <= n; j++) {
				
				if(i < j) {
					String s1 = s.substring(i, j);
					
					for(int p = j; p < n; p++) {
						for(int q = j; q <= n; q++) {
							
							if(p < q) {
								if(i != p || j != q) {
									
									String s2 = s.substring(p, q);
									String str = s1 + s2;
									
									int low = 0, high = str.length() - 1;
									boolean found = true;
									
									while(low < high) {
										
										if(str.charAt(low) != str.charAt(high)) {
											found = false;
											break;
										}
										
										low ++;
										high --;
									}
									
									if(found == true) {
										substrs ++;
									}
								}
							}
						}
					}
				}
			}
		}
		
		System.out.println(substrs);
	}
}