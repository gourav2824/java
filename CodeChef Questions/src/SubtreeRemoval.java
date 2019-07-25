import java.util.*;
import java.io.*;

public class SubtreeRemoval {
	
	static class Reader 
    { 
        final private int BUFFER_SIZE = 1 << 16; 
        private DataInputStream din; 
        private byte[] buffer; 
        private int bufferPointer, bytesRead; 
 
        public Reader() 
        { 
            din = new DataInputStream(System.in); 
            buffer = new byte[BUFFER_SIZE]; 
            bufferPointer = bytesRead = 0; 
        } 
 
        public Reader(String file_name) throws IOException 
        { 
            din = new DataInputStream(new FileInputStream(file_name)); 
            buffer = new byte[BUFFER_SIZE]; 
            bufferPointer = bytesRead = 0; 
        } 
 
        public String readLine() throws IOException 
        { 
            byte[] buf = new byte[64]; // line length 
            int cnt = 0, c; 
            while ((c = read()) != -1) 
            { 
                if (c == '\n') 
                    break; 
                buf[cnt++] = (byte) c; 
            } 
            return new String(buf, 0, cnt); 
        } 
 
        public int nextInt() throws IOException 
        { 
            int ret = 0; 
            byte c = read(); 
            while (c <= ' ') 
                c = read(); 
            boolean neg = (c == '-'); 
            if (neg) 
                c = read(); 
            do
            { 
                ret = ret * 10 + c - '0'; 
            }  while ((c = read()) >= '0' && c <= '9'); 
 
            if (neg) 
                return -ret; 
            return ret; 
        } 
 
 
        private void fillBuffer() throws IOException 
        { 
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE); 
            if (bytesRead == -1) 
                buffer[0] = -1; 
        } 
 
        private byte read() throws IOException 
        { 
            if (bufferPointer == bytesRead) 
                fillBuffer(); 
            return buffer[bufferPointer++]; 
        } 
 
        public void close() throws IOException 
        { 
            if (din == null) 
                return; 
            din.close(); 
        } 
    }

	public static void main(String[] args) throws java.lang.Exception {
		
		Reader sc = new Reader();
		int t = sc.nextInt();
		int tno = 0;
		
		while(tno < t) {
			
			int n = sc.nextInt();
			int x = sc.nextInt();
			
			int[] a = new int[n + 1];
			
			for(int i = 1; i <= n; i++) {
				a[i] = sc.nextInt();
			}
			
			HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
			
			for(int i = 0; i < n - 1; i++) {
				
				int n1 = sc.nextInt();
				int n2 = sc.nextInt();
				
				if(map.containsKey(n1) == false) {
					map.put(n1, new ArrayList<>());
				}
				
				map.get(n1).add(n2);
				
				if(map.containsKey(n2) == false) {
					map.put(n2, new ArrayList<>());
				}
				
				map.get(n2).add(n1);
			}
			
			long profit = 0;
			
			if(n == 1){
			    profit = Math.max(a[1], -x);
			}
			
			else{
			    HashSet<Integer> visited = new HashSet<>();
			    profit = subtreeRemove(map, visited, a, x, 1);
			}
			
			System.out.println(profit);
			tno ++;
		}
	}
	
	private static long subtreeRemove(HashMap<Integer, ArrayList<Integer>> map, HashSet<Integer> visited, int[] a, int x, int node) {
		
		visited.add(node);
		long value = a[node];
		
		for(int child : map.get(node)) {
			
			if(visited.contains(child) == false) {
				value += subtreeRemove(map, visited, a, x, child);
			}
		}
		
		return Math.max(value, -x);
	}
}