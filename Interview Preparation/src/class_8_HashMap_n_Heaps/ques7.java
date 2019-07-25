package class_8_HashMap_n_Heaps;
import java.util.Scanner;

public class ques7 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		String[] arr = new String[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = sc.next();
		}
		
		ques(arr);
	}
	
	private static void ques(String[] arr) {
		
		int count = 0;
		
		for(int i = 0; i < arr.length; i++) {
			
			for(int j = 0; j < arr.length; j++) {
				
				if(i == j) {
					continue;
				}
				
				String s;
				s = arr[i] + arr[j];
				
				boolean found = true;
				
				int l = 0;
				int r = s.length() - 1;
				while(true) {
					
					if(s.charAt(l) != s.charAt(r)) {
						found = false;
						break;
					}
					
					l++;
					r--;
					
					if(l >= r) {
						break;
					}
				}
				
				if(found == true) {
					count++;
				}
			}
		}
		
		System.out.println(count);
	}
}