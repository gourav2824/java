package class_8_HashMap_n_Heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FourSum {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int target = sc.nextInt();
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		ArrayList<ArrayList<Integer>> ans = fourSum(arr, target);

		for (ArrayList<Integer> a : ans) {
			for (int element : a) {
				System.out.print(element + ", ");
			}
			System.out.println();
		}
	}

	public static ArrayList<ArrayList<Integer>> fourSum(int[] arr, int target) {

		ArrayList<ArrayList<Integer>> list = new ArrayList<>();

		Arrays.sort(arr);
		int n = arr.length;

		int i = 0;
		while (i < n) {

			int j = i + 1;
			while (j < n) {

				int sum = target - (arr[i] + arr[j]);
				int l = j + 1;
				int r = n - 1;

				while (l < r) {

					if (arr[l] + arr[r] < sum) {
						l++;
						while (l < r && arr[l] == arr[l - 1]) {
							l++;
						}
					}

					else if (arr[l] + arr[r] > sum) {
						r--;
						while (l < r && arr[r] == arr[r + 1]) {
							r--;
						}
					}

					else {
						list.add(new ArrayList<>(Arrays.asList(arr[i], arr[j], arr[l], arr[r])));

						l++;
						r--;

						while (l < r && arr[l] == arr[l - 1]) {
							l++;
						}

						while (l < r && arr[r] == arr[r + 1]) {
							r--;
						}
					}
				}

				j++;
				while (j < n && arr[j] == arr[j - 1]) {
					j++;
				}
			}

			i++;
			while (i < n && arr[i] == arr[i - 1]) {
				i++;
			}
		}

		return list;
	}
}