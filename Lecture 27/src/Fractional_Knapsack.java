import java.util.Arrays;

public class Fractional_Knapsack {

	public static void main(String[] args) {
		
		int[] weights = {10, 40, 20, 30};
		int[] values = {60, 40, 100, 120};
		int capacity = 50;
		
		fractionalKnapsack(weights, values, capacity);
	}
	
	private static void fractionalKnapsack(int[] weights, int[] values, int capacity) {
		
		Item[] items = new Item[weights.length];
		
		for(int i = 0; i < items.length; i++) {
			items[i] = new Item();
			items[i].set(weights[i], values[i]);
		}
		
		Arrays.sort(items);
		
		int rc = capacity;
		int vib = 0;
		int i = items.length - 1;
		
		while(rc > 0) {
			
			if(rc >= items[i].weight) {
				rc -= items[i].weight;
				vib += items[i].value;
				i--;
			}
			
			else {
				vib += items[i].value * rc / items[i].weight;
				rc = 0;
			}
		}
		
		System.out.println("Maximum Value in Fractional Knapsack = " + vib);
	}
}