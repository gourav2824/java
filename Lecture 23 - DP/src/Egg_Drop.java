
public class Egg_Drop {

	public static void main(String[] args) {
		
		int floors = 10;
		int eggs = 2;
		int[][] qb = new int[eggs + 1][floors + 1];
		
		System.out.println(EggDrop(floors, eggs, qb));
	}
	
	private static int EggDrop(int floors, int eggs, int[][] qb) {		// Minimum Attempts
		
		if(eggs == 1 || floors == 1 || floors == 0) {
			return floors;
		}
		
		if(qb[eggs][floors] != 0) {
			return qb[eggs][floors];
		}
		
		int ma = Integer.MAX_VALUE;
		
		for(int k = 1; k < floors; k++) {
			
			int c1 = EggDrop(floors - k, eggs, qb);		// Minimum Attempts when egg survives
			int c2 = EggDrop(k - 1, eggs - 1, qb);		// Minimum Attempts when egg breaks
			
			int c = Math.max(c1, c2);					// Maximum of both Minimum attempts
			ma = Math.min(c, ma);						// Minimum Attempts
		}
		
		qb[eggs][floors] = ma + 1;
		return qb[eggs][floors];
	}
}