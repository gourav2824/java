import java.util.Scanner;

public class FriendOrGirlfriend {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int tno = 0;
		
		while(tno < t) {
			
			int n = sc.nextInt();
			String s = sc.next();
			char x = sc.next().charAt(0);
			
			int substrs = 0;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j <= n; j++) {
					if(i < j) {
						String str = s.substring(i, j);
						
						for(char c : str.toCharArray()) {
							if(c == x) {
								substrs ++;
								break;
							}
						}
					}
				}
			}
			
			System.out.println(substrs);
			tno ++;
		}
	}
}