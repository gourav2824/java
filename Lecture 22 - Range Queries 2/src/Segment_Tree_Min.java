
public class Segment_Tree_Min {
	
	static int[] ba;
	static int[] sa;
	
	public static void main(String[] args) {
		
		ba = new int[] {8, 19, 2, -6, 5, 12};
		int h = getLog(ba.length, false);
		int sz = (1 << (h + 1)) - 1;
		sa = new int[sz];
		
		build(0, 0, ba.length - 1);
		
		System.out.println(query(0, 0, ba.length - 1, 1, 3));	//-6
		System.out.println(query(0, 0, ba.length - 1, 0, 2));	//2
		update(0, 0, ba.length - 1, 3, 10);
		System.out.println(query(0, 0, ba.length - 1, 1, 3));	//2
		System.out.println(query(0, 0, ba.length - 1, 0, 2));	//2
		update(0, 0, ba.length - 1, 1, -10);
		System.out.println(query(0, 0, ba.length - 1, 1, 3));	//2
		System.out.println(query(0, 0, ba.length - 1, 0, 2));	//2
	}
	
	private static int getLog(int n, boolean floor) {
		
		int log = 0;
		
		while((1 << log) < n) {
			log ++;
		}
		
		if(floor && (1 << log) > n) {
			log --;
		}
		
		return log;
	}
	
	private static void build(int si, int ss, int se) {
		
		if(ss == se) {
			sa[si] = ba[ss];
			return;
		}
		
		int mid = (ss + se) / 2;
		build(2 * si + 1, ss, mid);
		build(2 * si + 2, mid + 1, se);
		
		sa[si] = Math.min(sa[2 * si + 1], sa[2 * si + 2]);
	}
	
	private static int query(int si, int ss, int se, int qs, int qe) {		
		
		if(ss >= qs && se <= qe) {		// segment starts after the query starts and segment ends before the query ends
			return sa[si];
		}
		
		else if(se < qs || ss > qe) {		// segment ends before the query starts or segment starts after the query ends
			return Integer.MAX_VALUE;
		}
		
		else {							// if a part of segment is in the query
			int mid = (ss + se) / 2;
			int lc = query(2 * si + 1, ss, mid, qs, qe);
			int rc = query(2 * si + 2, mid + 1, se, qs, qe);
			return Math.min(lc, rc);
		}
	}
	
	private static void update(int si, int ss, int se, int bi, int delta) {
		
		if(ss == se) {
			ba[bi] += delta;
			sa[si] += delta;
			return;
		}
		
		int mid = (ss + se) / 2;
		
		if(bi <= mid) {
			update(2 * si + 1, ss, mid, bi, delta);
		}
		
		else {
			update(2 * si + 2, mid + 1, se, bi, delta);
		}
		
		sa[si] = Math.min(sa[2 * si + 1], sa[2 * si + 2]);
	}
}