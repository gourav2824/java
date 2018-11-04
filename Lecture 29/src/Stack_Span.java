
public class Stack_Span {

	public static void main(String[] args) {
		
		int[] arr = {30, 40, 50, 45, 48, 60, 20, 25, 38, 32, 37, 50};
		
		StackSpan(arr);
	}
	
	private static void StackSpan(int[] arr) {		// arr -> prices
		
		Stack st = new Stack(arr.length);
		int[] spans = new int[arr.length];
		
//		int idx = 0;
//		
//		for(int i = 0; i < arr.length; i++) {
//			
//			if(st.isEmpty()) {
//				st.push(i);
//				spans[i] = i + 1;
//			}
//			
//			else if(arr[st.top()] > arr[i]) {
//				spans[i] = i - st.top();
//				st.push(i);
//			}
//			
//			else {
//				while(arr[st.top()] < arr[i]) {
//					
//					st.pop();
//				}
//			}
//		}
		
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