package class_1_LLnSnQ;

import java.io.*;
import java.util.*;

public class Div {
	static HashMap<Character, Integer> map = new HashMap<Character, Integer>();

	public static void main(String[] args) {
		map.put('+', 1);
		map.put('-', 1);
		map.put('*', 2);
		map.put('/', 2);
		map.put('%', 2);
		map.put('^', 3);
		String str = "8 - 4 * 6 / 3 + 4 / (1 + 1)";
		String s = "((2 - 3 * 2) + (-46 / 2 - 45 % 2)) * 8";
		int a = ((2 - 3 * 2) + (-46) / 2 - 45 % 2) * 8;
		System.out.println(evaluation(s));
		System.out.println(to_postfix(s));
		System.out.println(to_prefix(s));

	}

	private static int evaluation(String str) {
		Stack<Character> op = new Stack<>();
		Stack<Integer> no = new Stack<>();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch == ' ')
				continue;
			if (ch == '(')
				op.push(ch);
			else if (ch == ')') {
				while (op.size() > 0 && op.peek() != '(') {
					eval(no, op);
				}
				op.pop();
			} else if (ch >= '0' && ch <= '9') {
				String val = "";
				while (i < str.length() && !(str.charAt(i) < '0' || str.charAt(i) > '9')) {
					ch = str.charAt(i);
					val += ch;
					i++;	
				}
				i--;
				no.push(Integer.parseInt(val));
			} else {
				if(ch=='-' && str.charAt(i+1)!=' ') {
					i++;
					String val = "";
					while (i < str.length() && !(str.charAt(i) < '0' || str.charAt(i) > '9')) {
						ch = str.charAt(i);
						val += ch;
						i++;	
					}
					i--;
					no.push(-1*Integer.parseInt(val));
					continue;
				}
				while (op.size() > 0 && op.peek() != '(' && map.get(op.peek()) >= map.get(ch)) {
					eval(no, op);
				}
				op.push(ch);
			}
		}
		while (no.size() != 1) {
			eval(no, op);
		}
		return no.pop();
	}

	private static void eval(Stack<Integer> no, Stack<Character> op) {
		char opr = op.pop();
		int v1 = no.pop();
		int v2 = no.pop();
		if (opr == '+')
			no.push(v2 + v1);
		else if (opr == '-')
			no.push(v2 - v1);
		else if (opr == '*')
			no.push(v2 * v1);
		else if (opr == '/')
			no.push(v2 / v1);
		else if (opr == '%')
				no.push(v2 % v1);
		else if (opr == '^')
			no.push((int) Math.pow(v2, v1));
	}

	private static void eval1(Stack<String> no, Stack<Character> op) {
		char opr = op.pop();
		String v1 = no.pop();
		String v2 = no.pop();
		no.push(v2+" " + v1+" " + opr);
	}

	private static String to_prefix(String str) {
		StringBuilder s = new StringBuilder(str).reverse();
		StringBuilder rs = new StringBuilder("");
		for (int i = 0; i < str.length(); i++) {
			char ch = s.charAt(i);
			if (ch == '(')
				ch = ')';
			else if (ch == ')')
				ch = '(';
			rs.append(ch);
		}
		rs = new StringBuilder(to_postfix(rs.toString()));
		return rs.reverse().toString();

	}

	private static String to_postfix(String str) {
		Stack<Character> op = new Stack<>();
		Stack<String> no = new Stack<>();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch == ' ')
				continue;
			if (ch == '(')
				op.push(ch);
			else if (ch == ')') {
				while (op.size() > 0 && op.peek() != '(') {
					eval1(no, op);
				}
				op.pop();
			} else if (ch >= '0' && ch <= '9') {
				String val = "";
				while (i < str.length()&& (ch=='-' || (ch >='0' && ch <= '9'))) {
					val += ch;
					i++;
					if (i >= str.length())
						break;
					ch = str.charAt(i);
				}
				i--;
				no.push(val);
			} else {
				if(ch=='-' && str.charAt(i+1)!=' ') {
					i++;
					String val = "-";
					while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
						ch = str.charAt(i);
						val += ch;
						i++;	
					}
					i--;
					no.push(val);
					continue;
				}
				while (op.size() > 0 && op.peek() != '(' && map.get(op.peek()) >= map.get(ch)) {
					eval1(no, op);
				}
				op.push(ch);
			}
		}
		while (op.size() >0) {
			eval1(no, op);
		}
		return no.pop();

	}

}