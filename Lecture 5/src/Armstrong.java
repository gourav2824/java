import java.util.Scanner;

public class Armstrong {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int arm = sc.nextInt();
		int sr = sc.nextInt();
		int er = sc.nextInt();
		boolean result;
		
		int power = getLength(er);
		
		if(arm == calculate(arm, power))
			result = true;
		else
			result = false;
		
		System.out.println(result);
		
		for(int i=sr; i<=er; i++)
		{
			if(i == calculate(i, power))
				System.out.print(i + " ");
		}
	}
	
	private static int getLength(int n) {
		
		int len = 0;
		while(n > 0)
		{
			n = n / 10;
			len++;
		}
		return len;
	}
	
	private static int calculate(int n, int power) {
		
		int quo, rem, num=0;
		
		quo = n;
		for(int i=1; i<=power; i++)
		{
			rem = quo % 10;
			quo = quo / 10;
			
			num += Math.pow(rem, power);
		}
		
		return num;
	}
}