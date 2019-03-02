import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ChefAndSecretPassword {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		int tno = 0;
		
		while(t > tno) {
			
			int n = sc.nextInt();
			String str = sc.next();
			
			char ch = str.charAt(0);
			ArrayList<Integer> idxs = new ArrayList<>();
			
			for(int i = 0; i < n; i++) {
				if(str.charAt(i) == ch) {
					idxs.add(i);
				}
			}
			
			if(idxs.size() == 1) {
				System.out.println(str);
				tno++;
				continue;
			}
			
			HashMap<String, Integer> map = new HashMap<>();
			int i = 1;
			
			while(i <= idxs.get(0)) {
				
				String sub = str.substring(0, i);
				map.put(sub, 1);
			}
			
			if(idxs.size() == 2) {
				
				for(i = idxs.get(1) + 1; i < n; i++) {
					String sub = str.substring(idxs.get(1), i);
					if(map.containsKey(sub) == true) {
						int val = map.get(sub);
						map.put(sub, val + 1);
					}
				}
				
				int max = Integer.MIN_VALUE;
				String pass = "";
				
				for(String s : map.keySet()) {
					
					if(map.get(s) > max) {
						max = map.get(s);
						pass = s;
					}
					
					if(map.get(s) == max) {
						if(s.length() > pass.length()) {
							pass = s;
						}
					}
				}
				
				System.out.println(pass);
				tno++;
				continue;
			}
			
			int idx = 1;
			
			while(idx < idxs.size() - 1) {
				
				i = idxs.get(idx);
				int j = idxs.get(idx + 1);
				
				for(int k = i + 1; k < j; k++) {
					
					String sub = str.substring(i, k);
					if(map.containsKey(sub) == true) {
						int val = map.get(sub);
						map.put(sub, val + 1);
					}
				}
				
				idx ++;
			}
			
			for(i = idxs.get(idxs.size() - 1) + 1; i < n; i++) {
				
				String sub = str.substring(idxs.get(idxs.size() - 1), i);
				if(map.containsKey(sub) == true) {
					int val = map.get(sub);
					map.put(sub, val + 1);
				}
			}
			
			int max = Integer.MIN_VALUE;
			String pass = "";
			
			for(String s : map.keySet()) {
				
				if(map.get(s) > max) {
					max = map.get(s);
					pass = s;
				}
				
				if(map.get(s) == max) {
					if(s.length() > pass.length()) {
						pass = s;
					}
				}
			}
			
			System.out.println(pass);
			tno++;
		}
	}
}