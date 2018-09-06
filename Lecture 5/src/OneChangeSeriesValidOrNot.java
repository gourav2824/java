import java.util.Scanner;

public class OneChangeSeriesValidOrNot {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int prev = sc.nextInt();
		int curr = sc.nextInt();
		
		boolean goingDown = prev > curr;
		int change = 0;
		
		for(int i=3; i<=n; i++)
		{
			prev = curr;
			curr = sc.nextInt();
			
			if(goingDown == true)
			{
				if(curr > prev)
				{
					goingDown = false;
					change++;
				}
			}
			
			else
			{
				if(curr < prev)
				{
					goingDown = true;
					change++;
				}
			}
		}
		
		boolean res;
		if(change <= 1)
			res = true;
		else
			res = false;
		
		System.out.print(res);
	}
}