import java.util.Scanner;

public class KadanesAlgo {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int tests = sc.nextInt();
		
		for(int i=0; i<tests; i++) {
			
			int n = sc.nextInt();
			int[] arr = new int[n];
			
			for(int k=0; k<n; k++) {
				arr[k] = sc.nextInt();
			}
			
			int sum = SubArrayMaxSum(arr);
			System.out.println(sum);
		}
	}
	
	private static int SubArrayMaxSum(int[] arr) { // KADANES ALGORITHM

		int cmax = arr[0], omax = arr[0], cs = 0, ce = 0, os = 0, oe = 0;
		// os = ostart, oe = oend, cs = current start, ce = current end

		for (int i = 1; i < arr.length; i++) {

			if (arr[i] <= cmax + arr[i]) { // if(cmax >= 0)
				cmax += arr[i];
				ce++;
			} else {
				cs = i;
				ce = i;
				cmax = arr[i];
			}

			if (cmax > omax) {
				omax = cmax;
				os = cs;
				oe = ce;
			}
		}

//		System.out.println("Maximum Sum = " + omax);
//		System.out.print("Sub Array = ");
//		for (int i = os; i <= oe; i++) {
//			System.out.print(arr[i] + " ");
		
		return omax;
	}
}