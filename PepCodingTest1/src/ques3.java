import java.util.Scanner;

public class ques3 {

	static String[] codes = { ".", "abc", "def", "gh", "jkl", "mno", "pqrs", "tuv", "wx", "yz" };
	
	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		String s = scn.nextLine();
		System.out.println(keyPad(s, codes, ""));
	}
	
	public static int keyPad(String str, String[] codes, String ans) {
		
		for(int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			int n = (int)(ch - '0');
			
			String s1 = codes[n];
			
			for(char c : s1.toCharArray()) {
				
			}
		}
	}

}
