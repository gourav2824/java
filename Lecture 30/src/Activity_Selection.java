import java.util.Arrays;

public class Activity_Selection {

	public static void main(String[] args) {
		
		int[] starts = {3, 0, 1, 8, 5, 5};
		int[] ends = {4, 6, 2, 9, 9, 7};
		
		ActivitySelection(starts, ends);
	}
	
	private static void ActivitySelection(int[] starts, int[] ends) {
		
		Activity[] activities = new Activity[starts.length];
		
		for(int i = 0; i < activities.length; i++) {
			activities[i] = new Activity(starts[i], ends[i]);
		}
		
		Arrays.sort(activities);
		int last = 0;
		int count = 1;
		
		for(int i = 1; i < activities.length; i++) {
			
			if(activities[i].start > activities[last].end) {
				last = i;
				count ++;
			}
		}
		
		System.out.println(count);
	}
}