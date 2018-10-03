import java.util.ArrayList;

public class Recursion {

	public static void main(String[] args) {
		
		int[] arr = {10, 20, 30, 40, 50};
		int sum = 50;
		//ArrayList<Integer> set = new ArrayList<>();
		
		//printTargetSubset(arr, 0, sum, "", 0);
		//printTargetSubset(arr, 0, sum, new ArrayList<Integer>(), 0);
		
		//printSetsWithEqualSum(arr, 0, new ArrayList<Integer>(), new ArrayList<Integer>(), 0, 0);
		//printPermutationsS("abc", "");
		//printPermutationsSB(new StringBuilder("abc"), new StringBuilder(""));
		printPermutationsQuesChoice(new StringBuilder("abc"), new StringBuilder(""));
	}
	
	private static void printTargetSubset(int[] arr, int vidx, int sum, String set, int sos) {
		
		if(vidx == arr.length) {
			if(sos == sum) {
				System.out.println(set);
			}
			return;
		}
		
		printTargetSubset(arr, vidx + 1, sum, set + arr[vidx] + " ", sos + arr[vidx]);
		printTargetSubset(arr, vidx + 1, sum, set, sos);
	}
	
	private static void printTargetSubset(int[] arr, int vidx, int sum, ArrayList<Integer> set, int sos) {
		
		if(vidx == arr.length) {
			if(sos == sum) {
				System.out.println(set);
			}
			return;
		}
		
		set.add(arr[vidx]);
		printTargetSubset(arr, vidx + 1, sum, set, sos + arr[vidx]);
		set.remove(set.size() - 1);
		printTargetSubset(arr, vidx + 1, sum, set, sos);
	}
	
	private static void printSetsWithEqualSum(int[] arr, int vidx, 
											ArrayList<Integer> s1, ArrayList<Integer> s2,
											int sos1, int sos2) {
		
		if(vidx == arr.length) {
			if(sos1 == sos2) {
				System.out.println(s1 + " " + s2);
			}
			return;
		}
		
		s1.add(arr[vidx]);
		printSetsWithEqualSum(arr, vidx + 1, s1, s2, sos1 + arr[vidx], sos2);
		s1.remove(s1.size() - 1);
		
		s2.add(arr[vidx]);
		printSetsWithEqualSum(arr, vidx + 1, s1, s2, sos1, sos2 + arr[vidx]);
		s2.remove(s2.size() - 1);
	}
	
	private static void printPermutationsS(String ques, String ans) {
		
		if(ques.length() == 0) {
			System.out.println(ans);
			return;
		}
		
		char ch = ques.charAt(0);
		String roq = ques.substring(1);
				
		for(int i=0; i <= ans.length(); i++) {
			
			String left = ans.substring(0, i);
			String right = ans.substring(i);
			
			printPermutationsS(roq, left + ch + right);
		}
	}
	
	private static void printPermutationsSB(StringBuilder ques, StringBuilder ans) {
		
		if(ques.length() == 0) {
			System.out.println(ans);
			return;
		}
		
		char ch = ques.charAt(0);
		ques.deleteCharAt(0);
		
		for(int i=0; i <= ans.length(); i++) {
			
			ans.insert(i, ch);
			printPermutationsSB(ques, ans);
			ans.deleteCharAt(i);
		}
		ques.insert(0, ch);
	}
	
	private static void printPermutationsQuesChoice(StringBuilder ques, StringBuilder ans) {
		
		if(ques.length() == 0) {
			System.out.println(ans);
			return;
		}
		
		for(int i=0; i < ques.length(); i++) {
			
			char ch = ques.charAt(i);
			ques.deleteCharAt(i);
			ans.append(ch);
			
			printPermutationsQuesChoice(ques, ans);
			
			ans.deleteCharAt(ans.length() - 1);
			ques.insert(i, ch);
		}
	}
	
	private static void CryptoArithmetic(String s1, String s2, String s3, int[] arr) {
		
		
	}
}