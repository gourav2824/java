import java.util.ArrayList;
import java.util.Scanner;

public class RecursionAndArrayLists {

	public static void main(String[] args) {
		
		//ArrayList<Integer> list = new ArrayList<>();
		
		//System.out.println(SubSeqWithAscii("ab"));
		//System.out.println(getKeyPadCodes("781"));
		//System.out.println(getBoardPath(0, 10));
		//System.out.println(getBoardPath(0, 10).size());
		System.out.println(getMatrixPaths(0, 0, 3, 3));
		System.out.println(getMatrixPaths(0, 0, 3, 3).size());
		//System.out.println(DyckWards(0, 0, 3, 3).size());
	}
	
	static String[] codes = {"yz","abc","de","fghi","jk","lm","nop","qrst","uv","wx"};
	
	public static ArrayList<String> SubSeqWithAscii(String str) {
		
		if(str.length() == 0) {
			ArrayList<String> bresult = new ArrayList<>();
			bresult.add("");
			return bresult;
		}
		
		char ch = str.charAt(0);
		String ros = str.substring(1);
		
		ArrayList<String> rresult = SubSeqWithAscii(ros);
		ArrayList<String> mresult = new ArrayList<>();
		
		for(String recs: rresult) {
			mresult.add(recs);
			mresult.add(ch + recs);
			mresult.add((int)ch + recs);
		}
		
		return mresult;
	}
	
	public static ArrayList<String> getKeyPadCodes(String str){
		
		if(str.length() == 0) {
			ArrayList<String> bresult = new ArrayList<>();
			bresult.add("");
			return bresult;
		}
		
		int num = str.charAt(0) - '0';
		String ros = str.substring(1);
		
		String code = codes[num];
		
		ArrayList<String> rresult = getKeyPadCodes(ros);
		ArrayList<String> mresult = new ArrayList<>();
		
		for(String ch : rresult) {
			
			for(int i=0; i<code.length(); i++) {
				mresult.add(code.charAt(i) + ch);
			}
		}
		
		return mresult;
	}
	
	public static ArrayList<String> getBoardPath(int src, int dest){
		
		if(src == dest) {
			ArrayList<String> bresult = new ArrayList<>();
			bresult.add("");
			return bresult;
		}
		
		ArrayList<String> mresult = new ArrayList<>();
		for(int i=1; i<=6 && src + i <= dest; i++) {
			
			ArrayList<String> rresult = getBoardPath(src+i, dest);
			for(String res : rresult) {
				mresult.add(i + res);
			}
		}
		
		return mresult;
	}
	
	public static ArrayList<String> getMatrixPaths(int sr, int sc, int dr, int dc) {
		
		if(sr == dr && sc == dc) {
			ArrayList<String> bresult = new ArrayList<>();
			bresult.add("");
			return bresult;
		}
		
		if(sr > dr || sc > dc) {
			ArrayList<String> bresult = new ArrayList<>();
			return bresult;
		}
		
		ArrayList<String> mresult = new ArrayList<>();
		
		ArrayList<String> hresult = getMatrixPaths(sr, sc+1, dr, dc);
		for(String res : hresult) {
			mresult.add("H" + res);
		}
		
		ArrayList<String> vresult = getMatrixPaths(sr+1, sc, dr, dc);
		for(String res : vresult) {
			mresult.add("V" + res);
		}
		
		return mresult;
	}
	
	public static ArrayList<String> DyckWards(int sr, int sc, int dr, int dc) {
		
		if(sr == dr && sc == dc) {
			ArrayList<String> bresult = new ArrayList<>();
			bresult.add("");
			return bresult;
		}
		
		if(sr > dr || sc > dc|| (sc>sr)) {
			ArrayList<String> bresult = new ArrayList<>();
			return bresult;
		}
		
//		if(sr > sc) {
//			ArrayList<String> bresult = new ArrayList<>();
//			return bresult;
//		}
		
		ArrayList<String> mresult = new ArrayList<>();
		
		ArrayList<String> hresult = getMatrixPaths(sr, sc+1, dr, dc);
		for(String res : hresult) {
			mresult.add("H" + res);
		}
		
		ArrayList<String> vresult = getMatrixPaths(sr+1, sc, dr, dc);
		for(String res : vresult) {
			mresult.add("V" + res);
		}
		
		return mresult;
	}
	
	public static int MountainRange(int n) {
		
	}
}