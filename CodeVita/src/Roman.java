import java.util.*;

public class Roman {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		long num = n;
		
		while(num < 4000) {
						
			String s = DecimalToRoman(num);
			int len = s.length();
			
			int base = 0;
			for(int i = 0; i < len; i++) {
				int b = (s.charAt(i) - 'A') + 10 + 1;
				base = Math.max(base, b);
			}
			
			long val = 0;
			long mul = 1;
			
			for(int i = len - 1; i >= 0; i--) {
				int c = (s.charAt(i) - 'A') + 10;
				val += c * mul;
				mul = mul * base;
			}
			
			num = val;
		}
		
		System.out.println(num);
	}
	
	public static class Pair {

		int n;
		String val;

		Pair(int n, String val) {
			this.n = n;
			this.val = val;
		}
	}
	
	public static String DecimalToRoman(long num) {
        
        Pair p1 = new Pair(1, "I");
        Pair p2 = new Pair(4, "IV");
        Pair p3 = new Pair(5, "V");
        Pair p4 = new Pair(9, "IX");
        Pair p5 = new Pair(10, "X");
        Pair p6 = new Pair(40, "XL");
        Pair p7 = new Pair(50, "L");
        Pair p8 = new Pair(90, "XC");
        Pair p9 = new Pair(100, "C");
        Pair p10 = new Pair(400, "CD");
        Pair p11 = new Pair(500, "D");
        Pair p12 = new Pair(900, "CM");
        Pair p13 = new Pair(1000, "M");
        
        Pair[] arr = {p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13};
        long n = num;
        String ans = "";
        
        int i = arr.length - 1;
        while(n > 0 && i >= 0){
            
            if(n >= arr[i].n){
                ans = ans + arr[i].val;
                n = n - arr[i].n; 
            }
            
            else{
                i--;
            }
        }
        
        return ans;
    }
}