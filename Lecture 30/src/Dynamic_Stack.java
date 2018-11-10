
public class Dynamic_Stack extends Stack{
	
	public Dynamic_Stack(int cap) {
		super(cap);
	}
	
	public void push(int val) {
		
		if(tos == arr.length - 1) {
			
			int[] olda = arr;
			arr = new int[olda.length * 2];
			
			for(int i = 0; i < olda.length; i++) {
				arr[i] = olda[i];
			}
		}
		
		super.push(val);
	}
}