import java.util.*;

public class LazyStudent {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int t = sc.nextInt();
		int m = sc.nextInt();

		int q = nCr(n, t);
		int p = q - nCr(n - m, t);
		
		if(q % p == 0) {
			q = q / p;
			p = p / p;
		}
		
		int ans = p * mod(q);
		
		System.out.println(ans);
	}

	private static int nCr(int n, int r) {

		if (r == 0) {
			return 1;
		}

		if (r == 1) {
			return n;
		}

		if (r == n) {
			return 1;
		}

		int ncr = nCr(n, r - 1);
		ncr = ncr * (n - r + 1);
		ncr = ncr / r;

		return ncr;
	}

	private static int mod(int q) {

		int m = 1000000007;
		q = q % m;
		
		for (int i = 1; i < m; i++) {
			if ((q * i) % m == 1) {
				return i;
			}
		}

		return 0;
	}
}