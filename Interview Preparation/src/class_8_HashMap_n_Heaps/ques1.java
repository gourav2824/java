package class_8_HashMap_n_Heaps;
import java.io.*;
import java.util.*;

public class ques1 {

	static int time = 0;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
        DensityStack ds = new DensityStack();
        int n = sc.nextInt();
        
        for(int i = 0; i < n; i++){
            
            String s = sc.next();
            
            if(s.equals("DensityStack")){
                System.out.println("null");
            }
            
            else if(s.equals("pop")){
                System.out.println(ds.pop());
            }
            
            else{
                String[] op = s.split(" ");
                if(op[0].equals("push")){
                    System.out.println(op[0] + ", " + op.length);
                    int x = Integer.parseInt(op[1]);
                    ds.push(x);
                    System.out.println("null");
                }
            }
        }
	}
	
public static class Pair {
        
        int x;
        int f;
        int t;
        
        Pair(int x, int f, int t){
            this.x = x;
            this.f = f;
            this.t = t;
        }
    }
    
    public static class DensityStack {
        
        // Stack<Integer> st;
        HashMap<Integer, Pair> map;
        // PriorityQueue<Pair> pq;
        
        public DensityStack(){
            // st = new Stack<>();
            map = new HashMap<>();
            // pq = new PriorityQueue();
        }
        
        public void push(int x){
            // st.push(x);
            
            if(map.containsKey(x) == false){
                map.put(x, new Pair(x, 1, time));
            }
            
            else{
                Pair p = map.get(x);
                p.f += 1;
                p.t = time;
            }
            
            time++;
        }
        
        public int pop(){
            
            int val = 0;;
            int max = 0;
            int tm = 0;
            for(int x : map.keySet()){
                if(map.get(x).f > max){
                    max = map.get(x).f;
                    tm = map.get(x).t;
                    val = x;
                }
                
                else if(map.get(x).f == max){
                    if(map.get(x).t > tm){
                        max = map.get(x).f;
                        tm = map.get(x).t;
                        val = x;
                    }
                }
            }
            
            map.get(val).f -= 1;
            if(map.get(val).f == 0){
                map.remove(val);
            }
            return val;
        }
    }
}