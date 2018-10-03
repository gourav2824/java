
public class RecursionWithQuesAnsApproach {

	public static void main(String[] args) {
		
		//SubSequence("abc", "");
		//SubSequenceWithAscii("ab", "");
		//GetKeyPadCodes("781", "");
		//getBoardPath(0, 10, "");
		//getMatrixPaths(0, 0, 3, 3, "");
		//getAllPaths(0, 0, 3, 3, "");
		int[][] arr = {
				{0,1,0,0,0},
				{0,1,0,1,0},
				{0,0,0,0,0},
				{0,1,0,1,0},
				{0,1,1,0,0}
		};
		
		boolean[][] visited = new boolean[5][5];
		
		FloodFill(0, 0, arr, visited, "");
	}
	
	static String[] codes = {"yz","abc","de","fghi","jk","lm","nop","qrst","uv","wx"};
	
	public static void SubSequence(String ques, String ans) {
		
		if(ques.length() == 0) {
			System.out.println(ans);
			return;
		}
		
		char ch = ques.charAt(0);
		String roq = ques.substring(1);
		
		SubSequence(roq, ans + ch);
		SubSequence(roq, ans + "");
	}
	
	public static void SubSequenceWithAscii(String ques, String ans) {
		
		if(ques.length() == 0) {
			System.out.println(ans);
			return;
		}
		
		char ch = ques.charAt(0);
		String roq = ques.substring(1);
		
		SubSequenceWithAscii(roq, ans + "");
		SubSequenceWithAscii(roq, ans + ch);
		SubSequenceWithAscii(roq, ans + (int)ch);
	}
	
	public static void GetKeyPadCodes(String ques, String ans) {
		
		if(ques.length() == 0) {
			System.out.print(ans + " ");
			return;
		}
		
		int num = ques.charAt(0) - '0';
		String roq = ques.substring(1);
		
		String code = codes[num];
		
		for(int i=0; i<code.length(); i++) {
			
			GetKeyPadCodes(roq, ans + code.charAt(i));
		}
	}
	
	public static void getBoardPath(int src, int dest, String ans) {
		
		if(src == dest) {
			System.out.print(ans + " ");
			return;
		}
		
		if(src > dest) {
			return;
		}
		
		for(int i=1; i<=6; i++) {
			getBoardPath(src+i, dest, ans+i);
		}
	}
	
	public static void getMatrixPaths(int sr, int sc, int dr, int dc, String ans) {
		
		if(sr == dr && sc == dc) {
			System.out.print(ans + " ");
			return;
		}
		
		if(sr > dr || sc > dc) {
			return;
		}
		
		getMatrixPaths(sr, sc+1, dr, dc, ans + "H");
		getMatrixPaths(sr+1, sc, dr, dc, ans + "V");
	}
	
	public static void getAllPaths(int sr, int sc, int dr, int dc, String ans) {
		
		if(sr == dr && sc == dc) {
			System.out.print(ans + " ");
			return;
		}
		
		if(sr > dr || sc > dc) {
			return;
		}
		
		for(int i=1; i<=dc; i++) {
			getAllPaths(sr, sc+i, dr, dc, ans+"H"+i);
		}
		
		for(int i=1; i<=dr; i++) {
			getAllPaths(sr+i, sc, dr, dc, ans+"V"+i);
		}
		
		int min;
		if(dr <= dc)
			min = dr;
		else
			min = dc;
		
		for(int i=1; i<=min; i++) {
			getAllPaths(sr+i, sc+i, dr, dc, ans+"D"+i);
		}
	}
	
	public static void FloodFill(int sr, int sc, int[][] arr, boolean[][] visited, String ans) {
		
		if(sr == arr.length-1 && sc == arr[0].length-1) {
			System.out.println(ans);
			return;
		}
		
		if(sr<0 || sc<0 || sr>arr.length-1 || sc>arr[0].length-1 || arr[sr][sc]==1 || visited[sr][sc] == true) {
			return;
		}
		
		visited[sr][sc] = true;
		
		FloodFill(sr-1, sc, arr, visited, ans + "T");
		FloodFill(sr, sc+1, arr, visited, ans + "R");
		FloodFill(sr+1, sc, arr, visited, ans + "D");
		FloodFill(sr, sc-1, arr, visited, ans + "L");
		
		visited[sr][sc] = false;
	}
}