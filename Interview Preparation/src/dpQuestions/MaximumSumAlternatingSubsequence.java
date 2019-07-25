package dpQuestions;
import java.util.*;

public class MaximumSumAlternatingSubsequence {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		int[] inc = new int[n];
		int[] dec = new int[n];
		boolean[] validDec = new boolean[n];
		boolean[] validStart = new boolean[n];
		validStart[0] = true;

		for (int i = 0; i < n; i++) {

			inc[i] = arr[i];
			dec[i] = arr[i];

			for (int j = i - 1; j >= 0; j--) {

				if (validStart[j] == true) {

					if (arr[j] > arr[i]) {
						validStart[i] = true;
						dec[i] = Math.max(dec[i], inc[j] + arr[i]);
						validDec[i] = true;
					}

					else if (arr[j] < arr[i]) {
						if (validDec[j] == true) {
							validStart[i] = true;
							inc[i] = Math.max(inc[i], dec[j] + arr[i]);
						}
					}

					else {
						continue;
					}
				}
			}
		}

		int omax = 0;

		for (int i = 0; i < n; i++) {
			omax = Math.max(omax, inc[i]);
		}

		for (int i = 0; i < n; i++) {
			omax = Math.max(omax, dec[i]);
		}

		System.out.println(omax);

		// System.out.println("arr = " + Arrays.toString(arr));
		// System.out.println("inc = " + Arrays.toString(inc));
		// System.out.println("dec = " + Arrays.toString(dec));
	}
}