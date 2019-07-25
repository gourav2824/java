package class_8_HashMap_n_Heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class FourSum2 {

	public static void main(String[] args) {
		
		int[] A = {2, -2};
		int[] B = {0, 1};
		int[] C = {1, 0};
		int[] D = {-2, 2};
		
		System.out.println(fourSumCount(A, B, C, D));
	}
	
	public static class Pair1 {
 	    
 	    int x;
 	    int y;
 	    
 	    public Pair1(int x, int y){
 	        this.x = x;
 	        this.y = y;
 	    }
 	}
 	
 	public static class Pair {
 	    
 	    int a, b, c, d;
 	    int[] arr = new int[4];
 	    
 	    public Pair(int a, int b, int c, int d){
 	        
 	        this.a = this.arr[0] = a;
 	        this.b = this.arr[1] = b;
 	        this.c = this.arr[2] = c;
 	        this.d = this.arr[3] = d;
 	        
 	        Arrays.sort(arr);
 	    }
 	    
 	    @Override
 	    public int hashCode(){
 	        return Math.max(Math.max(this.a, this.b), 
 	                        Math.max(this.c, this.d));
 	    }
 	    
 	    @Override
 	    public boolean equals(Object o){
 	        
 	        Pair op = (Pair)o;
 	        return (this.arr[0] == op.arr[0]) && (this.arr[1] == op.arr[1])
 	            && (this.arr[2] == op.arr[2]) && (this.arr[3] == op.arr[3]);
 	    }
 	}
 	
 	public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
 	    
 	    int n = A.length;
 	    
 	    HashMap<Integer, ArrayList<Pair1>> map1 = new HashMap<>();
 	    HashMap<Integer, ArrayList<Pair1>> map2 = new HashMap<>();
 	    
 	    for(int i = 0; i < n; i++){
 	        for(int j = 0; j < n; j++){
 	            
 	            int sum = A[i] + B[j];
 	            
 	            if(map1.containsKey(sum) == false){
 	                map1.put(sum, new ArrayList<>());
 	            }
 	            
 	            map1.get(sum).add(new Pair1(A[i], B[j]));
 	        }
 	    }
 	    
 	    for(int i = 0; i < n; i++){
 	        for(int j = 0; j < n; j++){
 	            
 	            int sum = C[i] + D[j];
 	            
 	            if(map2.containsKey(sum) == false){
 	                map2.put(sum, new ArrayList<>());
 	            }
 	            
 	            map2.get(sum).add(new Pair1(C[i], D[j]));
 	        }
 	    }
 	    
 	    HashSet<Pair> set = new HashSet<>();
 	    
 	    for(int sum : map1.keySet()){
 	        
 	        int t = 0 - sum;
 	        
 	        if(map2.containsKey(t)){
 	            
 	            ArrayList<Pair1> a1 = map1.get(sum);
 	            ArrayList<Pair1> a2 = map2.get(t);
 	            
 	            for(Pair1 p1 : a1){
 	                for(Pair1 p2 : a2){
 	                    set.add(new Pair(p1.x, p1.y, p2.x, p2.y));
 	                }
 	            }
 	        }
 	    }
 	    
 	    return set.size();
 	}
}