import java.util.ArrayList;
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
			
			long substrs = 0;
			ArrayList<Integer> idx = new ArrayList<>();
			
			for(int i = 0; i < n; i++) {
				if(s.charAt(i) == x) {
					idx.add(i);
				}
			}
			
			for(int i = 0; i < idx.size(); i++) {
				
				if(i == 0) {
					substrs += (idx.get(i) + 1) * (n - idx.get(i));
				}
				
				else {
					substrs += (idx.get(i) - idx.get(i - 1)) * (n - idx.get(i));
				}
			}
			
			System.out.println(substrs);
			tno ++;
		}
	}
}