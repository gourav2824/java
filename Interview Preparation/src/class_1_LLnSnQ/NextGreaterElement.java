package class_1_LLnSnQ;

import java.util.Stack;

public class NextGreaterElement {

	public static void main(String[] args) {

		int arr[] = {1, 3, 4, 2, 4};

		int[] nge = new int[arr.length];	// nge -> Next Greater Element
		Stack<Integer> st = new Stack<>();

		nge[nge.length - 1] = -1;

		for (int i = nge.length - 1; i >= 0; i--) {

			while ((st.empty() == false) && (arr[i] >= st.peek())) {
				st.pop();
			}

			if (st.empty()) {
				nge[i] = -1;
			}

			else {
				nge[i] = st.peek();
			}

			st.push(arr[i]);
		}

		for (int val : nge) {
			System.out.print(val + " ");
		}
	}
}