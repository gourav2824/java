package class_1_LLnSnQ;

import java.util.Stack;

public class PostfixExpressions {
	
	static Stack<Integer> ns = new Stack<>();
	static Stack<String> ss = new Stack<>();
	
	public static void main(String[] args) {
		
//		String s = "2 3 2 * - -46 2 / 45 2 % - + 8 *";
		String s = "8 4 6 * 3 / - 4 1 1 + / +";
		
		System.out.println("Value = " + postfixEvaluation(s));
		System.out.println("Infix Expression = " + postfixToInfix(s));
		System.out.println("Prefix Expression = " + postfixToPrefix(s));	// * + - 2 * 3 2 - / -46 2 % 45 2 8
		
	}
	
	public static int postfixEvaluation(String s) {
		
		int i = 0;
		boolean negative = false;
		
		while(i < s.length()) {
			char ch = s.charAt(i);
			
			if(ch == ' ') {
				i++;
				continue;
			}
			
			else if(ch >= '0' && ch <= '9') {
				
				String str = "";
				while(i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
					str = str + s.charAt(i);
					i++;
				}
				
				i--;
				
				int num = Integer.parseInt(str);
				if(negative == true) {
					num = (-1) * num;
					negative = false;
				}
				
				ns.push(num);
			}
			
			else {
				
				if(ch == '-') {
					i++;
					if(i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
						negative = true;
						continue;
					}
					i--;
				}
				
				evalNum(ch);
			}
			
			i++;
		}
		
		int val = ns.pop();
		return val;
	}

	private static void evalNum(char ch) {
		
		int val1 = ns.pop();
		int val2 = ns.pop();
		int val;
		
		if(ch == '+') {
			val = val2 + val1;
		}
		
		else if(ch == '-') {
			val = val2 - val1;
		}
		
		else if(ch == '*') {
			val = val2 * val1;
		}
		
		else if(ch == '/') {
			val = val2 / val1;
		}
		
		else if(ch == '%') {
			val = val2 % val1;
		}
		
		else if(ch == '^') {
			val = (int)Math.pow(val2, val1);
		}
		
		else {
			return;
		}
		
		ns.push(val);
	}
	
	public static String postfixToInfix(String s) {
		
		int i = 0;
		boolean negative = false;
		
		while(i < s.length()) {
			char ch = s.charAt(i);
			
			if(ch == ' ') {
				i++;
				continue;
			}
			
			else if(ch >= '0' && ch <= '9') {
				
				String str = "";
				while(i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
					str = str + s.charAt(i);
					i++;
				}
				
				i--;
				
				if(negative == true) {
					str = "-" + str;
					negative = false;
				}
				
				ss.push(str);
			}
			
			else {
				
				if(ch == '-') {
					i++;
					if(i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
						negative = true;
						continue;
					}
					i--;
				}
				
				evalStringInfix(ch);
			}
			
			i++;
		}
		
		String str = ss.pop();
		return str;
	}

	private static void evalStringInfix(char ch) {
		
		String str1 = ss.pop();
		String str2 = ss.pop();
		String str;
		
		str = "(" + str2 + " " + ch + " " + str1 + ")";
		ss.push(str);
	}
	
	public static String postfixToPrefix(String s) {
		
		int i = 0;
		boolean negative = false;
		
		while(i < s.length()) {
			char ch = s.charAt(i);
			
			if(ch == ' ') {
				i++;
				continue;
			}
			
			else if(ch >= '0' && ch <= '9') {
				
				String str = "";
				while(i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
					str = str + s.charAt(i);
					i++;
				}
				
				i--;
				
				if(negative == true) {
					str = "-" + str;
					negative = false;
				}
				
				ss.push(str);
			}
			
			else {
				
				if(ch == '-') {
					i++;
					if(i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
						negative = true;
						continue;
					}
					i--;
				}
				
				evalStringPrefix(ch);
			}
			
			i++;
		}
		
		String str = ss.pop();
		return str;
	}

	private static void evalStringPrefix(char ch) {
		
		String str1 = ss.pop();
		String str2 = ss.pop();
		String str;
		
		str = ch + " " + str2 + " " + str1;
		ss.push(str);
	}
}