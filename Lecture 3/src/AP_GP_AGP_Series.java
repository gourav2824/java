import java.util.Scanner;

public class AP_GP_AGP_Series {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int d = sc.nextInt();
		int r = sc.nextInt();
		int n = sc.nextInt();
		
		int fap = a + (n-1)*d;
		int fgp = a * (int)Math.pow(r,n-1);
		int fagp = (fap * fgp) / a;
		
		int sap = (n * (a + fap)) / 2;
		int sgp = (a * ((int)Math.pow(r,n) - 1)) / (r - 1);
		
		int term, sagp=0;
		for(int i=1;i<=n;i++)
		{
			term = ((a+(i-1)*d) * (a * (int)Math.pow(r,i-1))) / a;
			sagp += term;
		}
		System.out.print(fap + " " + fgp + " " + fagp + " " + sap + " " + sgp + " " + sagp);
	}
}