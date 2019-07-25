package class_1_LLnSnQ;

import java.util.Stack;

public class PrefixExpressions {
	
	static Stack<Integer> ns = new Stack<>();
	static Stack<String> ss = new Stack<>();
	
	public static void main(String[] args) {
		
		String s = "* + - 2 * 3 2 - / -46 2 % 45 2 8";
		
		System.out.println("Value = " + prefixEvaluation(s));
		System.out.println("Infix Expression = " + prefixToInfix(s));
		System.out.println("Postfix Expression = " + prefixToPostfix(s));
	}
	
	public static int prefixEvaluation(String string) {
		
		String[] strings = string.split(" ");
		
		String s = strings[strings.length - 1];
		for(int i = strings.length - 2; i >= 0; i--) {
			s = s + " " + strings[i];
		}
		
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
			val = val1 + val2;
		}
		
		else if(ch == '-') {
			val = val1 - val2;
		}
		
		else if(ch == '*') {
			val = val1 * val2;
		}
		
		else if(ch == '/') {
			val = val1 / val2;
		}
		
		else if(ch == '%') {
			val = val1 % val2;
		}
		
		else if(ch == '^') {
			val = (int)Math.pow(val1, val2);
		}
		
		else {
			return;
		}
		
		ns.push(val);
	}
	
	public static String prefixToInfix(String string) {
		
		String[] strings = string.split(" ");
		
		String s = strings[strings.length - 1];
		for(int i = strings.length - 2; i >= 0; i--) {
			s = s + " " + strings[i];
		}
		
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
		
		str = "(" + str1 + " " + ch + " " + str2 + ")";
		ss.push(str);
	}
	
	public static String prefixToPostfix(String string) {
		
		String[] strings = string.split(" ");
		
		String s = strings[strings.length - 1];
		for(int i = strings.length - 2; i >= 0; i--) {
			s = s + " " + strings[i];
		}
		
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
				
				evalStringPostfix(ch);
			}
			
			i++;
		}
		
		String str = ss.pop();
		return str;
	}

	private static void evalStringPostfix(char ch) {
		
		String str1 = ss.pop();
		String str2 = ss.pop();
		String str;
		
		str = str1 + " " + str2 + " " + ch;
		ss.push(str);
	}
}