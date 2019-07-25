import java.util.Scanner;

public class ques6 {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
        lexcico(1, scn.nextInt());
	}
	
	public static void lexcico(int start, int end) {
		
		for(int i = 1; i < 10; i++) {
			lexicoOutput(end, ""+i);
		}
    }
	
	private static void lexicoOutput(int end, String s) {
		
		if(Integer.parseInt(s) < end) {
			System.out.println(s);
		}
		
		else if(Integer.parseInt(s) > end) {
			return;
		}
		
		for(int i = 0; i < 10; i++) {
			lexicoOutput(end, s + i);
		}
	}

}
