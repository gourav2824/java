
public class Fenwick_Tress {
	
	static int[] fa;
	static int[] arr;
	public static void main(String[] args) {
		
		arr = new int[] {2, 5, 9, -3, -6, 0, 7, 1, -1, 8, -7, 3, -4, -5, 6, 7};
		fa = new int[arr.length + 1];
		
		build();
		
		System.out.println(query(3, 10));	// -1
		System.out.println(query(5, 12));	// 7
		update(6, 5);
		System.out.println(query(3, 10)); 	// 4
		System.out.println(query(5, 12));	// 12
	}
	
	private static void build() {
		
		for(int i = 0; i < arr.length; i++) {
			update(i, arr[i]);
		}
	}
	
	private static void update(int idx, int delta) {
		
		idx++;
		while(idx < fa.length) {
			
			fa[idx] += delta;
			idx += (idx & -idx);
		}
	}
	
	public static int query(int l, int r) {
		
		return getPrefixSum(r) - getPrefixSum(l - 1);
	}
	
	public static int getPrefixSum(int idx) {
		idx++;
		int sum=0;
		while(idx > 0) {
			sum += fa[idx];
			idx -= (idx & -idx);
		}
		return sum;
	}
}