import java.util.Scanner;

public class ChefAndBeautifulDigit {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int tno = 0;
		
		while(tno < t) {
			
			long n = sc.nextLong();
			long d = sc.nextLong();
			
			long quo = n;
			long len = 0;
			
			while(quo != 0) {
				quo = quo / 10;
				len ++;
			}
			
			long num = n;
			long i = len;
			
			while(i > 0) {
				
				long div1 = (long) (Math.pow(10, i));
				long div2 = (long) (Math.pow(10, i-1));
				
				long high = num / div1;
				long low = num % div2;
								
				quo = low;
				long lowlen = 0;
				
				while(quo != 0) {
					quo = quo / 10;
					lowlen ++;
				}
								
				long mul = (long) Math.pow(10, lowlen);
				long temp = high * mul;
				
				temp = temp + low;
				
				temp = temp * 10;
				temp = temp + d;
								
				if(temp < num) {
					num = temp;
					i = len;
				}
				
				else {
					i--;
				}
			}
			
			System.out.println(num);
			tno ++;
		}
	}
}