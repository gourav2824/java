import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a=0, b=1, i=0, c;
        
        while(i<n)
        {
            c = a + b;
            a = b;
            b = c;
            i++;
        }
        
        System.out.print(a);

	}
}