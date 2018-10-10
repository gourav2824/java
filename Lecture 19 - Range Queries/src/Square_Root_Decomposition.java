
public class Square_Root_Decomposition {
	
	static int[] arr;
	static int[] sqrt;
	static int bs;
	static int bc;

	public static void main(String[] args) {
		
		arr = new int[] {2, 6, 7, 9, -5, 8, 1, 4, 4, 12, 7};
		bs = (int)Math.sqrt(arr.length);
		bc = (int)Math.ceil(arr.length * 1.0 / bs);
		sqrt = new int[bc];
		
		preprocess();
		System.out.println(query(1, 7));
		update(5, 10);
		System.out.println(query(1, 7));
	}
	
	public static void preprocess() {
		
		for(int i=0; i < arr.length; i++) {
			
			sqrt[i / bs] += arr[i];
		}
	}
	
	public static void update(int idx, int val) {
		
		sqrt[idx / bs] += val - arr[idx];
		arr[idx] = val;
	}
	
	public static int query(int left, int right) {
		
		int lbn = left / bs;
		int rbn = right / bs;
		
		int res = 0;
		
		for(int i=left; i < (lbn + 1) * bs; i++) {
			res += arr[i];
		}
		
		for(int i = lbn + 1; i < rbn; i++) {
			res += sqrt[i];
		}
		
		for(int i = rbn * bs; i <= right; i++) {
			res += arr[i];
		}
		
		return res;
	}

}
