import java.util.Scanner;

public class loop {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a Number : ");
		int n = sc.nextInt();
		int cntr = 1;
		while(cntr<=n)
		{
			System.out.println(cntr);
			cntr++;
		}
	}

}
