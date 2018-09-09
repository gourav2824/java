import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		char ch = sc.nextLine().charAt(0);
		
		while((ch != 'X') && (ch != 'x')) {
			
			
			if((ch != '+') && (ch != '-') && (ch != '*') && (ch != '/') && (ch != '%'))
				System.out.println("Invalid Operation");
			
			else {
				
				int n1 = sc.nextInt();
				int n2 = sc.nextInt();
				
				if(ch == '+')
					System.out.println(n1 + n2);
				
				else if(ch == '-')
					System.out.println(n1 - n2);
				
				else if(ch == '*')
					System.out.println(n1 * n2);
				
				else if(ch == '/')
					System.out.println(n1 / n2);
				
				else if(ch == '%')
					System.out.println(n1 % n2);
			}
			
			String str = sc.nextLine();
			ch = sc.nextLine().charAt(0);
		}
	}
}