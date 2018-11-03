
public class Print_Pattern {

	public static void main(String[] args) {

		String str = "ddiddidd";

		printPattern_d_i(str);
	}

	private static void printPattern_d_i(String str) {

		Stack st = new Stack(str.length() + 1);
		int n = 1;

		for (int i = 0; i < str.length(); i++) {

			if (str.charAt(i) == 'd') {

				st.push(n);
				n++;
			}

			else {

				st.push(n);
				n++;

				for (int k = 0; k <= st.size() + 1; k++) {
					System.out.print(st.pop() + " ");
				}
			}
		}

		st.push(n);
		for (int k = 0; k <= st.size() + 1; k++) {
			System.out.print(st.pop() + " ");
		}
	}
}