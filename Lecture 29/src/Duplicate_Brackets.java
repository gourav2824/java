
public class Duplicate_Brackets {

	public static void main(String[] args) {
		
		String str1 = "(a+((b+c)+(d+e))+f)";		// false
		String str2 = "(a+(((b+c)+(d+e)))+f)";		// true
		
		System.out.println(DuplicateBrackets(str2));
	}
	
	private static boolean DuplicateBrackets(String str) {
		
		Stack st = new Stack(str.length());
		
		for(int i = 0; i < str.length(); i++) {
			
			int c = str.charAt(i);
			
			if(c != ')') {
				st.push(c);
			}
			
			else {
				
				if(st.top() == '(') {
					return true;
				}
				
				while(st.top() != '(') {
					st.pop();
				}
				
				st.pop();
			}
		}
		
		return false;
	}
}