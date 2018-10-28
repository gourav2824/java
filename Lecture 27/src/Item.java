
public class Item implements Comparable<Item>{
	
	int weight;
	int value;
	double ratio;
	
	public void set(int wt, int val) {
		this.weight = wt;
		this.value = val;
		this.ratio = val * 1.0 / wt;
	}
	
	@Override
	public int compareTo(Item other) {
		
		if(this.ratio > other.ratio)
			return 1;
		
		else if(this.ratio < other.ratio)
			return -1;
		
		else
			return 0;
	}
}