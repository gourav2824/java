
public class Stock_Span {

	public static void main(String[] args) {
		
		int[] arr = {30, 40, 50, 45, 48, 60, 20, 25, 38, 32, 37, 50};
		
		StockSpan(arr);
	}
	
	private static void StockSpan(int[] arr) {		// arr -> prices
		
		Stack st = new Stack(arr.length);
		int[] spans = new int[arr.length];
		
		spans[0] = 1;
		st.push(0);
		
		for(int i = 1; i < arr.length; i++) {
			
			// Pop
			while(st.isEmpty() == false && arr[i] > arr[st.top()]) {
				
				st.pop();
			}
			
			// Span
			spans[i] = st.size() == 0 ? i + 1 : i - st.top();
			
			// Push
			st.push(i);
		}
		
		for(int val : spans) {
			System.out.print(val + " ");
		}
	}
}