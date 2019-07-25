package class_8_HashMap_n_Heaps;

import java.util.*;

public class ques3 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int tar = sc.nextInt();
		int n = sc.nextInt();

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		ques(arr, n, tar);
	}

	private static void ques(int[] arr, int n, int tar) {

		Arrays.sort(arr);
		int i = 0;

		while (i < arr.length) {

			int j = i + 1;

			while (j < arr.length) {

				int sum = tar - (arr[i] + arr[j]);

				int l = j + 1;
				int r = n - 1;

				while (l < r) {

					if (l < r && arr[l] + arr[r] == sum) {

						System.out.println(arr[i] + " " + arr[j] + " " + arr[l] + " " + arr[r]);

						l++;
						while (l < r && arr[l - 1] == arr[l]) {
							l++;
						}

						r--;
						while (l < r && arr[r] == arr[r + 1]) {
							r--;
						}
					}

					else if (l < r && arr[l] + arr[r] < sum) {

						l++;
						while (l < r && arr[l - 1] == arr[l]) {
							l++;
						}
					}

					else {
						r--;
						while (l < r && arr[r] == arr[r + 1]) {
							r--;
						}
					}
				}

				j++;
				while (j < arr.length && arr[j - 1] == arr[j]) {
					j++;
				}
			}

			i++;
			while (i < arr.length && arr[i - 1] == arr[i]) {
				i++;
			}
		}
	}
}