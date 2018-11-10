
public class QueueToStackAdapter {
	
	Dynamic_Queue dq;
	Dynamic_Queue hq;
	
	public QueueToStackAdapter(int cap) {
		dq = new Dynamic_Queue(cap);
		hq = new Dynamic_Queue(cap);
	}
	
	public void push(int val) {
		
		hq.enqueue(val);
		
		while(dq.size() > 0) {
			hq.enqueue(dq.dequeue());
		}
		
		Dynamic_Queue temp = hq;
		hq = dq;
		dq = temp;
	}
	
	public int pop() {
		return dq.dequeue();
	}
	
	public int top() {
		return dq.front();
	}
}