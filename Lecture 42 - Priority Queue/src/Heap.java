import java.util.ArrayList;

public class Heap {
	
	private ArrayList<Integer> data = new ArrayList<>();
	private boolean max = false;
	
	public Heap() {
		
	}
	
	public Heap(int[] arr) {
		
		for(int val : arr) {
			data.add(val);
		}
		
		for(int i = data.size() / 2 - 1; i >= 0; i--) {
			DownHeapify(i);
		}
	}
	
	public Heap(boolean max) {
		this.max = max;
	}
	
	public Heap(int[] arr, boolean max) {
		
		this.max = max;
		
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
		
		if(isHigherPriority(pi, ci) == false) {
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
		
		if(lci < data.size() && isHigherPriority(mini, lci) == false) {
			mini = lci;
		}
		
		if(rci < data.size() && isHigherPriority(mini, rci) == false) {
			mini = rci;
		}
		
		if(mini != pi) {
			swap(pi, mini);
			DownHeapify(mini);
		}
	}
	
	private boolean isHigherPriority(int pi, int ci) {
		
		if(max == false) {
			return data.get(pi) < data.get(ci);
		}
		
		else {
			return data.get(pi) > data.get(ci);
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