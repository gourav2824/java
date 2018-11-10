
public class Two_Stacks {
	
	int[] arr;
	int tos1;
	int tos2;
	
	public Two_Stacks(int cap) {
		arr = new int[cap];
		tos1 = -1;
		tos2 = arr.length;
	}
	
	public void push1(int val) {
		
		if(tos1 + 1 == tos2) {
			System.out.println("Stack 1 is full");
			return;
		}
		
		tos1++;
		arr[tos1] = val;
	}
	
	public int pop1() {
		if(tos1 == -1) {
			System.out.println("Stack 1 is full");
			return -1;
		}
		
		int rv = arr[tos1];
		arr[tos1] = 0;
		tos1--;
		return rv;
	}
	
	public int top1() {
		if(tos1 == -1) {
			System.out.println("Stack 1 is full");
			return -1;
		}
		
		int rv = arr[tos1];
		return rv;
	}
	
	public void push2(int val) {
		if(tos2 - 1 == tos1) {
			System.out.println("Stack 2 is full");
			return;
		}
		
		tos2--;
		arr[tos2] = val;
	}
	
	public int pop2() {
		if(tos1 == arr.length) {
			System.out.println("Stack 2 is full");
			return -1;
		}
		
		int rv = arr[tos2];
		arr[tos2] = 0;
		tos2 ++;
		return rv;
	}
	
	public int top2() {
		if(tos1 == arr.length) {
			System.out.println("Stack 2 is full");
			return -1;
		}
		
		int rv = arr[tos2];
		return rv;
	}
}