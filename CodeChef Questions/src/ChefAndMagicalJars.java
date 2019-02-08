import java.util.Scanner;

public class ChefAndMagicalJars {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		int tno = 1;
		while(tno <= t){
		    
		    int n = sc.nextInt();
		    int[] A = new int[n];
		    
		    for(int i = 0; i < n; i++){
		        A[i] = sc.nextInt();
		    }
		    
		    long jars = 0;
		    for(int val : A) {
		    	jars += val;
		    }
		    
		    jars = jars - n + 1;
		    
		    System.out.println(jars);
		    
		    tno ++;
		}
	}
}