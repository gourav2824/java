
public class Activity implements Comparable<Activity>{
	
	int start;
	int end;
	
	public Activity(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public int compareTo(Activity o) {
		return this.end - o.end;
	}
}