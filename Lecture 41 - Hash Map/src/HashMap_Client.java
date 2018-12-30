import java.util.HashMap;

public class HashMap_Client {

	public static void main(String[] args) {
		
//		highestFrequencyCharacter("abbaccbbaabbddbb");
		
		int[] one = {5, 1, 3, 1, 2, 2, 1};
		int[] two = {2, 2, 4, 1, 1, 5, 2};
		
		getCommonElements1(one, two);
		getCommonElements2(one, two);
	}
	
	public static void highestFrequencyCharacter(String word) {
		
		HashMap<Character, Integer> frequencies = new HashMap<>();
		
		Integer maxFreq = Integer.MIN_VALUE;
		Character ch = word.charAt(0);
		
		for(int i = 0; i < word.length(); i++) {
			
			char key = word.charAt(i);
			
			if(frequencies.containsKey(key) == true){
				int value = frequencies.get(key);
				frequencies.put(key, value + 1);
			}
			
			else {
				frequencies.put(key, 1);
			}
			
			int value = frequencies.get(key);
			if(value > maxFreq) {
				maxFreq = value;
				ch = key;
			}
		}
		
		System.out.println(ch);
	}
	
	public static void getCommonElements1(int[] one, int[] two) {
		
		HashMap<Integer, Integer> freqMap = new HashMap<>();
		
		for(int i : one) {
			freqMap.put(i, freqMap.containsKey(i) ? freqMap.get(i) + 1: 1);
		}
		
		for(int val : two) {
			if(freqMap.containsKey(val)) {
				System.out.print(val + " ");
				freqMap.remove(val);
			}
		}
		
		System.out.println();
	}
	
	public static void getCommonElements2(int[] one, int[] two) {
		
		HashMap<Integer, Integer> freqMap = new HashMap<>();
		
		for(int i : one) {
			freqMap.put(i, freqMap.containsKey(i) ? freqMap.get(i) + 1: 1);
		}
		
		for(int val : two) {
			if(freqMap.containsKey(val) && freqMap.get(val) > 0) {
				System.out.print(val + " ");
				freqMap.put(val, freqMap.get(val) - 1);
			}
		}
		
		System.out.println();
	}
}