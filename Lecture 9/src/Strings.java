import java.util.Scanner;

public class Strings {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String s = "abc";
		//PrintChar(s);
		//SubStrings(s);
		//System.out.print(IsPalindrome(s));
		//PalindromicSubStrings(s);
		PrintPermutations(s);
	}
	
	public static void PrintChar(String s) {
		
		for(int i=0; i < s.length(); i++) {
			System.out.println(s.charAt(i));
		}
	}
	
	public static void SubStrings(String s) {
		
		for(int i=0; i < s.length(); i++) {
			for(int j=i+1; j <= s.length(); j++) {
				
				System.out.println(s.substring(i, j));
			}
		}
	}
	
	public static boolean IsPalindrome(String s) {
		
		int left = 0;
		int right = s.length()-1;
		
		while(right > left) {
			if(s.charAt(left) != s.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
	
	public static void PalindromicSubStrings(String s) {
		
		for(int i=0; i < s.length(); i++) {
			for(int j=i+1; j <= s.length(); j++) {
				
				String ss = s.substring(i, j);
				boolean check = IsPalindrome(ss);
				
				if(check == true)
					System.out.println(ss);
			}
		}
	}
	
	public static void PrintPermutations(String s) {
		
		int limit = 1;
		for(int i=1; i <= s.length(); i++) {
			limit *= i;
		}
		
		for(int i=0; i < limit; i++) {
			
			int info = i;
			String ques = s;
			String ans = "";
			
			for(int div = s.length(); div >= 1; div--) {
				
				int r = info % div;
				info = info / div;
				
				ans += ques.charAt(r);
				ques = ques.substring(0, r) + ques.substring(r+1);
			}
			
			System.out.println(ans);
		}
	}
}