import java.util.Scanner;

public class reverse {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a Number : ");
		int n = sc.nextInt();
		int rem;
		int div = n;
		
		while(div>0)
		{
			rem = div%10;
			div = div/10;
			System.out.print(rem);
		}
		
	}

}
