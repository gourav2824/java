package class_1_LLnSnQ;

import java.util.Scanner;
import java.util.Stack;

public class decodingAString {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
//        String s = sc.next();
        
        String s = "3[a2[c]]";
        System.out.println(decode(s));
	}
	
	public static String decode(String s) {
        
        Stack<String> st = new Stack<>();
        
        int i = s.length() - 1;
        while(i >= 0){
            
            char ch = s.charAt(i);
            String chs = Character.toString(ch);
            
            if(ch >= '0' && ch <= '9'){
                String str = chs;
                i--;
                while(i >= 0 && s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                    str = Character.toString(s.charAt(i)) + str;
                    i--;
                }
                
                int num = Integer.parseInt(str);
                str = st.pop();
                
                String nstr = "";
                for(int k = 0; k < num; k++){
                	nstr = nstr + str;
                }
                
                st.push(nstr);
                i++;
            }
            
            else if(ch == ']'){
                st.push(chs);
            }
            
            else if(ch == '['){
                String str = "";
                while(st.peek().equals("]") == false){
                    str = str + st.pop();
                }
                st.pop();
                st.push(str);
            }
            
            else{
                String str;
                if(st.size() == 0 || st.peek().equals("]")){
                    st.push("");
                }
                str = chs + st.pop();
                st.push(str);
            }
            
            i--;
        }
        
        String str = "";
        while(st.size() > 0){
            str = str + st.pop();
        }
        
        return str;
    }
}