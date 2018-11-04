
public class Largest_Area_Histogram {

	public static void main(String[] args) {
		
		int[] arr = {6, 2, 5, 4, 5, 1, 6};
		
		System.out.println(LargestAreaHistogram(arr));
	}
	
	private static int LargestAreaHistogram(int[] arr) {
		
		Stack st = new Stack(arr.length);
		int maxa = Integer.MIN_VALUE;
		
//		st.push(0);
//		for(int i = 1; i <= arr.length; i++) {
//			
//			while(arr[i] < arr[st.top()]) {
//				
//				st.pop();
//				int area = st.isEmpty() ? arr[i - 1] * i : (arr[i - 1] * (i - st.top() - 1));
//				
//				max = Math.max(max, area);
//			}
//			
//			st.push(i);
//		}
//		
//		System.out.println(max);
		
		st.push(0);
		for(int i = 1; i < arr.length; i++) {
			
			while(st.size() > 0 && arr[i] < arr[st.top()]){
				
				int val = arr[st.pop()];
				
				int breadth = 0;
				if(st.size() == 0) {
					breadth = i;
				}
				else {
					breadth = i - st.top() - 1;
				}
				
				int carea = val * breadth;
				maxa = Math.max(maxa, carea);
			}
			
			st.push(i);
		}
		
		while(st.size() > 0){
			
			int val = arr[st.pop()];
			
			int breadth = 0;
			if(st.size() == 0) {
				breadth = arr.length;
			}
			else {
				breadth = arr.length - st.top() - 1;
			}
			
			int carea = val * breadth;
			maxa = Math.max(maxa, carea);
		}
		
		return maxa;
	}
}