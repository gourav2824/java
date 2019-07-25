package test4;

import java.util.Scanner;

public class Ques_RangeAddition_Version_2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int q = sc.nextInt();
        int m = sc.nextInt();
        
        int[] arr = new int[n];
        int[][] qarr = new int[q][2];
        
        for(int i = 0; i < q; i++){
            
            int s = sc.nextInt();
            int e = sc.nextInt();
            
            qarr[i][0] = s - 1;
            qarr[i][1] = e - 1;
            
            arr[qarr[i][0]] += 1;
            if(qarr[i][1] + 1 < n){
                arr[qarr[i][1] + 1] -= 1;
            }
        }
        
        int totalm = 0;
        int psum = 0;
        
        for(int i = 0; i < n; i++){
            
            psum += arr[i];
            arr[i] = psum;
            
            if(arr[i] == m){
                totalm++;
            }
        }
        
        int[] msf = new int[n];
        int[] mp1sf = new int[n];
        
        int mcount = 0;
        int mp1count = 0;
        
        for(int i = 0; i < n; i++){
            
            if(arr[i] == m){
                mcount += 1;
            }
            
            msf[i] = mcount;
            
            if(arr[i] == m + 1){
                mp1count += 1;
            }
            
            mp1sf[i] = mp1count;
        }
        
        int max = 0;
        
        for(int i = 0; i < q; i++){
            
            int s = qarr[i][0];
            int e = qarr[i][1];
            
            int mc = 0;
            int mp1c = 0;
            
            if(s == 0){
                mc = msf[e];
                mp1c = mp1sf[e];
            }
            
            else{
                mc = msf[e] - msf[s - 1];
                mp1c = mp1sf[e] - mp1sf[s - 1];
            }
            
            int count = totalm - mc + mp1c;
            max = Math.max(max, count);
        }
        
        System.out.println(max);
	}
}