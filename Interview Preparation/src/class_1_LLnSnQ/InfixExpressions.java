package class_1_LLnSnQ;

import java.util.HashMap;
import java.util.Stack;

public class InfixExpressions {
	
	static HashMap<Character, Integer> map = new HashMap<>();
	static Stack<Integer> ns = new Stack<>();
	static Stack<String> ss = new Stack<>();
	static Stack<Character> os = new Stack<>();
	
	public static void main(String[] args) {
		
		map.put('+', 1);
		map.put('-', 1);
		map.put('*', 2);
		map.put('/', 2);
		map.put('%', 2);
		map.put('^', 3);
		
//		String s = "((2 - 3 * 2) + (-46 / 2 - 45 % 2)) * 8";
//		String s = "2 * 4 - 7 / (6 - 3 * 4)";
//		String s = "8 - 4 * 6 / 3 + 4 / (1 + 1)";
//		String s = "4 * 2 ^ 3";
		String s = "8 - 4 * 6 / 3 + 4 / (1 + 1)";
		
		System.out.println("Value = " + infixEvaluation(s));
		System.out.println("Postfix Expression = " + infixToPostfix(s));
		System.out.println("Prefix Expression = " + infixToPrefix(s));
	}
	
	public static int infixEvaluation(String s) {
		
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
				while(i < s.length() && s.charAt(i) != ' ' && s.charAt(i) != ')') {
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
			
			else if(ch == '(') {
				os.push(ch);
			}
			
			else if(ch == ')') {
				while(os.peek() != '(') {
					eval(os.pop());
				}
				os.pop();
			}
			
			else {
				
				if(ch == '-') {
					i++;
					if(s.charAt(i) >= '0' && s.charAt(i) <= '9') {
						negative = true;
						continue;
					}
				}
				
				if(os.size() == 0 || os.peek() == '(') {
					os.push(ch);
				}
				
				else if(map.get(ch) > map.get(os.peek())) {
					os.push(ch);
				}
				
				else {
					while(os.size() > 0 && os.peek() != '(' && map.get(ch) <= map.get(os.peek())) {
						eval(os.pop());
					}
					os.push(ch);
				}
			}
			
			i++;
		}
		
		while(os.size() > 0) {
			eval(os.pop());
		}
		
		int val = ns.pop();
		return val;
	}
	
	public static void eval(char ch) {
		
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
	
	public static String infixToPostfix(String s) {
		
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
				while(i < s.length() && s.charAt(i) != ' ' && s.charAt(i) != ')') {
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
			
			else if(ch == '(') {
				os.push(ch);
			}
			
			else if(ch == ')') {
				while(os.peek() != '(') {
					evalString(os.pop());
				}
				os.pop();
			}
			
			else {
				
				if(ch == '-') {
					i++;
					if(s.charAt(i) >= '0' && s.charAt(i) <= '9') {
						negative = true;
						continue;
					}
				}
				
				if(os.size() == 0 || os.peek() == '(') {
					os.push(ch);
				}
				
				else if(map.get(ch) > map.get(os.peek())) {
					os.push(ch);
				}
				
				else {
					while(os.size() > 0 && os.peek() != '(' && map.get(ch) <= map.get(os.peek())) {
						evalString(os.pop());
					}
					os.push(ch);
				}
			}
			
			i++;
		}
		
		while(os.size() > 0) {
			evalString(os.pop());
		}
		
		String str = ss.pop();
		return str;
	}
	
	public static String infixToPostfixForPrefix(String s) {
		
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
				while(i < s.length() && s.charAt(i) != ' ' && s.charAt(i) != ')') {
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
			
			else if(ch == '(') {
				os.push(ch);
			}
			
			else if(ch == ')') {
				while(os.peek() != '(') {
					evalString(os.pop());
				}
				os.pop();
			}
			
			else {
				
				if(ch == '-') {
					i++;
					if(s.charAt(i) >= '0' && s.charAt(i) <= '9') {
						negative = true;
						continue;
					}
				}
				
				if(os.size() == 0 || os.peek() == '(') {
					os.push(ch);
				}
				
				else if(map.get(ch) >= map.get(os.peek())) {
					os.push(ch);
				}
				
				else {
					while(os.size() > 0 && os.peek() != '(' && map.get(ch) < map.get(os.peek())) {
						evalString(os.pop());
					}
					os.push(ch);
				}
			}
			
			i++;
		}
		
		while(os.size() > 0) {
			evalString(os.pop());
		}
		
		String str = ss.pop();
		return str;
	}
	
	public static void evalString(char ch) {
		
		String str1 = ss.pop();
		String str2 = ss.pop();
		String str;
		
		str = str2 + " " + str1 + " " + ch;
		
		ss.push(str);
	}
	
	public static String infixToPrefix(String s) {
		
		String reverse = new StringBuilder(s).reverse().toString();
		String str = "";
		
		for(char ch : reverse.toCharArray()) {
			if(ch == ')') {
				str = str + '(';
			}
			else if(ch == '(') {
				str = str + ')';
			}
			else {
				str = str + ch;
			}
		}
		
		String postfix = infixToPostfixForPrefix(str);
		String prefix = new StringBuilder(postfix).reverse().toString();
		
		return prefix;
	}
}