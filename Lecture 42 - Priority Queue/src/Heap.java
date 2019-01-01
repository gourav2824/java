import java.util.ArrayList;

public class Heap {
	
	private ArrayList<Integer> data = new ArrayList<>();
	
	public Heap(int[] arr) {
		
		for(int val : arr) {
			data.add(val);
		}
		
		for(int i = data.size() / 2 - 1; i >= 0; i--) {
			DownHeapify(i);
		}
	}
	
	public void add(int val) {
		
		data.add(val);
		UpHeapify(data.size() - 1);
	}
	
	private void UpHeapify(int ci) {
		
		if(ci == 0) {
			return;
		}
		
		int pi = (ci - 1) / 2;
		
		if(data.get(ci) < data.get(pi)) {
			swap(pi, ci);
			UpHeapify(pi);
		}
	}

	private void swap(int i, int j) {
		
		int ith = data.get(i);
		int jth = data.get(j);
		
		data.set(i, jth);
		data.set(j, ith);
	}

	public int remove() {
		
		swap(0, data.size() - 1);
		int rv = data.remove(data.size() - 1);
		DownHeapify(0);
		return rv;
	}
	
	private void DownHeapify(int pi) {
		
		int mini = pi;
		
		int lci = pi * 2 + 1;
		int rci = pi * 2 + 2;
		
		if(lci < data.size() && data.get(lci) < data.get(mini)) {
			mini = lci;
		}
		
		if(rci < data.size() && data.get(rci) < data.get(mini)) {
			mini = rci;
		}
		
		if(mini != pi) {
			swap(pi, mini);
			DownHeapify(mini);
		}
	}

	public int peek() {
		return data.get(0);
	}
	
	public int size() {
		return data.size();
	}
	
	public boolean isEmpty() {
		return data.size() == 0;
	}
	
	public void display() {
		System.out.println(data);
	}
}