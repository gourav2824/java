import java.util.HashMap;

public class HashMap_Client {

	public static void main(String[] args) {
		
		highestFrequencyCharacter("abbaccbbaabbddbb");
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
}