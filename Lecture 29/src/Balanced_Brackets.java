
public class Balanced_Brackets {

	public static void main(String[] args) {
		
		String str = "[{(a+b)+(c+d)+e}+f])";
		
		System.out.println(balancedBrackets(str));
	}
	
	private static boolean balancedBrackets(String str) {
		
		Stack st = new Stack(str.length());
		
		String obs = "({[";
		String cbs = ")}]";
		
		for(char ch : str.toCharArray()) {
			
			if(obs.indexOf(ch) != -1) {
				st.push(ch);
			}
			
			else if(cbs.indexOf(ch) != -1) {
				if(st.size() == 0) {		// more closing brackets
					return false;
				}
				else if(obs.indexOf(st.top()) != cbs.indexOf(ch)) {		// brackets mismatching
					return false;
				}
				st.pop();
			}
		}
		
		if(st.size() != 0) {		// more opening brackets
			return false;
		}
		
		return true;
	}
}