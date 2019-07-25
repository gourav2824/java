package class_1_LLnSnQ;

public class DecodingAStringAtIndex {
	
	public static void main(String[] args) {
		
//		String s = "abc3x2yz";
		String s = "a3bc3xy";
//		int k = 17;
		int k = 14;
		
		System.out.println(decodeIndex(s, k));
	}
	
	public static String decodeIndex(String s, int k) {
        
		int size = 0;
        
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            
            if(ch >= '0' && ch <= '9'){
                String str = Character.toString(ch);
                size = size * Integer.parseInt(str);
            }
            
            else{
                size++;
            }
        }
        
        String ans = "";
        int i = s.length() - 1;
        
        while(i >= 0){
            char ch = s.charAt(i);
            
            if(ch >= '0' && ch <= '9'){
                
                String str = Character.toString(ch);
                int num = Integer.parseInt(str);
                
                k = k % size;
                size = size / num;
                i--;
                continue;
            }
            
            if(((k) % size) == 0){
                ans = ans + ch;
                break;
            }
            
            k = k % size;
            size--;
            i--;
        }
        
        return ans;
    }
}