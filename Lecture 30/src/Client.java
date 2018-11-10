
public class Client {

	public static void main(String[] args) {
		
//		Two_Stacks ts = new Two_Stacks(5);
//		
//		ts.push1(10);
//		ts.push1(20);
//		ts.push1(30);
//		ts.push2(40);
//		ts.push2(50);
//		ts.push2(60);
//		
//		System.out.println(ts.pop1());
//		System.out.println(ts.pop2());
//		
//		System.out.println(ts.top1());
//		System.out.println(ts.top2());
		
		QueueToStackAdapter qts = new QueueToStackAdapter(5);
		
		qts.push(10);
		qts.push(20);
		qts.push(30);
		qts.push(40);
		
		System.out.println(qts.top() + " " + qts.pop());
		System.out.println(qts.top() + " " + qts.pop());
		System.out.println(qts.top() + " " + qts.pop());
		System.out.println(qts.top() + " " + qts.pop());
	}
}