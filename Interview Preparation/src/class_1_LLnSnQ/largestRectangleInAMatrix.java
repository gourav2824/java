package class_1_LLnSnQ;

import java.util.Stack;

public class largestRectangleInAMatrix {

	public static void main(String[] args) {
		
		int[][] arr = {{1, 0, 1, 0, 0},
					   {1, 0, 1, 1, 1},
					   {1, 1, 0, 1, 1},
					   {1, 0, 0, 1, 1}};
		
		System.out.println(maxArea(arr));
	}
	
	public static int maxArea(int[][] arr) {
		
		int maxArea = Integer.MIN_VALUE;
		int[] ht = new int[arr[0].length];
		
		for(int i = 0; i < arr.length; i++) {
			
			for(int j = 0; j < arr[0].length; j++) {
				
				if(arr[i][j] == 0) {
					ht[j] = 0;
				}
				
				else {
					ht[j] = ht[j] + arr[i][j];
				}
			}
			
			int area = largestAreaInARow(ht);
			maxArea = Math.max(maxArea, area);
		}
		
		return maxArea;
	}
	
	public static int largestAreaInARow(int[] ht) {
		
		int[] rightMin = new int[ht.length];
        int[] leftMin = new int[ht.length];
        
        rightMin[ht.length - 1] = ht.length;
        leftMin[0] = -1;
        
        Stack<Integer> st = new Stack<>();
        
        for(int i = ht.length - 1; i >= 0; i--){
            
            while((st.empty() == false) && (ht[st.peek()] >= ht[i])){
                st.pop();
            }
            
            if(st.empty()){
                rightMin[i] = ht.length;
            }
            
            else{
                rightMin[i] = st.peek();
            }
            
            st.push(i);
        }
        
        Stack<Integer> st1 = new Stack<>();
        
        for(int i = 0; i < ht.length; i++){
            
            while((st1.empty() == false) && (ht[st1.peek()] >= ht[i])){
                st1.pop();
            }
            
            if(st1.empty()){
                leftMin[i] = -1;
            }
            
            else{
                leftMin[i] = st1.peek();
            }
            
            st1.push(i);
        }
        
        int[] len = new int[ht.length];
        
        for(int i = 0; i < ht.length; i++){
            len[i] = (rightMin[i] - leftMin[i]) - 1;
        }
        
        int maxArea = Integer.MIN_VALUE;
        
        for(int i = 0; i < ht.length; i++){
            
            int area = ht[i] * len[i];
            
            if(area > maxArea){
                maxArea = area;
            }
        }
        
        return maxArea;
	}
}