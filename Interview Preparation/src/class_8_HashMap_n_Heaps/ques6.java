package class_8_HashMap_n_Heaps;
import java.util.*;

public class ques6 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		ques(arr);
	}

	private static void ques(int[] arr) {
		
		ArrayList<Integer> a = new ArrayList<>();
		
		for(int i = 0; i < arr.length; i++) {
			a.add(arr[i]);
			Collections.sort(a);
			
			if(a.size() % 2 != 0) {
				double d = 1.0 * a.get(((a.size() + 1) / 2) - 1);
				System.out.println(d);
			}
			
			else {
				double d = (1.0 * (a.get((a.size() / 2) - 1) + a.get(a.size() / 2))) / 2;
				System.out.println(d);
			}
		}
	}
}