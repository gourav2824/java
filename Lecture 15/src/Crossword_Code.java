import java.util.Scanner;

public class Crossword_Code {

	public static void main(String[] args) {
		
//		char[][] crossword = {
//				{+,-,+,+,+,+,+,+,+,+},
//				{+,-,+,+,+,+,+,+,+,+},
//				{+,-,+,+,+,+,+,+,+,+},
//				{+,-,-,-,-,-,+,+,+,+},
//				{+,-,+,+,+,-,+,+,+,+},
//				{+,-,+,+,+,-,+,+,+,+},
//				{+,+,+,+,+,-,+,+,+,+},
//				{+,+,-,-,-,-,-,-,+,+},
//				{+,+,+,+,+,-,+,+,+,+},
//				{+,+,+,+,+,-,+,+,+,+}
//				};
		
//		String[] words = {LONDON,DELHI,ICELAND,ANKARA};
		
		Scanner scn = new Scanner(System.in);
		char[][] crossword = new char[10][10];
		for(int i = 0; i < 10; i++){
			crossword[i] = scn.nextLine().toCharArray();
		}
		String[] words = scn.nextLine().split(";");
		Crossword(crossword, words, 0);
	}
	
	public static void Crossword(char[][] crossword, String[] words, int widx) {
		
		if(widx == words.length) {
			for(int r=0; r < crossword.length; r++) {
				for(int c=0; c < crossword[r].length; c++) {
					System.out.print(crossword[r][c]);
				}
				System.out.println();
			}
			return;
		}
		
		for(int r=0; r < crossword.length; r++) {
			for(int c=0; c < crossword[r].length; c++) {
				
				if((crossword[r][c] == '-') || (crossword[r][c] == words[widx].charAt(0))) {
					
					if(cpwHoriz(crossword, words[widx], r, c)) {
						boolean[] reset = pwHoriz(crossword, words[widx], r, c);
						Crossword(crossword, words, widx + 1);
						upwHoriz(crossword, words[widx], r, c, reset);
					}
					
					if(cpwVert(crossword, words[widx], r, c)) {
						boolean[] reset = pwVert(crossword, words[widx], r, c);
						Crossword(crossword, words, widx + 1);
						upwVert(crossword, words[widx], r, c, reset);
					}
				}
			}
		}
	}
	
	private static boolean cpwHoriz(char[][] crossword, String word, int r, int c) {
		
		if(c + word.length() > crossword[0].length) {
			return false;
		}
		
		for(int i=0; i < word.length(); i++) {
			
			if(crossword[r][c + i] != '-' && crossword[r][c + i] != word.charAt(i)) {
				return false;
			}
		}
		
		// Exact Fit
		
		return true;
	}
	
	private static boolean[] pwHoriz(char[][] crossword, String word, int r, int c) {
		
		boolean[] reset = new boolean[word.length()];
		for(int i=0; i < word.length(); i++) {
			reset[i] = crossword[r][c + i] == word.charAt(i);
			crossword[r][c + i] = word.charAt(i);
		}
		return reset;
	}
	
	private static void upwHoriz(char[][] crossword, String word, int r, int c, boolean[] reset) {
		
		for(int i=0; i < word.length(); i++) {
			if(!reset[i]) {
				crossword[r][c + i] = '-';
			}
		}
	}
	
	private static boolean cpwVert(char[][] crossword, String word, int r, int c) {
		
		if(r + word.length() > crossword[0].length) {
			return false;
		}
		
		for(int i=0; i < word.length(); i++) {
			
			if(crossword[r + i][c] != '-' && crossword[r + i][c] != word.charAt(i)) {
				return false;
			}
		}
		
		// Exact Fit
		
		return true;
	}
	
	private static boolean[] pwVert(char[][] crossword, String word, int r, int c) {
		
		boolean[] reset = new boolean[word.length()];
		for(int i=0; i < word.length(); i++) {
			reset[i] = crossword[r + i][c] == word.charAt(i);
			crossword[r + i][c] = word.charAt(i);
		}
		return reset;
	}
	
	private static void upwVert(char[][] crossword, String word, int r, int c, boolean[] reset) {
		
		for(int i=0; i < word.length(); i++) {
			if(!reset[i]) {
				crossword[r + i][c] = '-';
			}
		}
	}
}