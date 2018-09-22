import java.util.Scanner;

public class SumOfTwoArrays {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the no. of elements in 1st Array : ");
		int n1 = sc.nextInt();
		
        int[] arr1 = new int[n1];
        System.out.print("Enter the Elements of 1st Array : ");
        for(int i=0; i<n1; i++){
            arr1[i] = sc.nextInt();
        }
        
        System.out.print("Enter the no. of elements in 2nd Array : ");
        int n2 = sc.nextInt();
        
        int[] arr2 = new int[n2];
        System.out.print("Enter the Elements of 2nd Array : ");
        for(int i=0; i<n2; i++){
            arr2[i] = sc.nextInt();
        }
        
        int n;
        if(n1 >= n2)
            n = n1+1;
        else
        	n = n2+1;
        
        int[] res = new int[n];
        
        int i=n1-1, j=n2-1, k=n-1, carry=0, digit, count=0;
        while((i>=0) || (j>=0) || (carry > 0)){
            
            if((i>=0) && (j>=0)){
                digit = (arr1[i] + arr2[j] + carry) % 10;
                carry = (arr1[i] + arr2[j] + carry) / 10;
            }
            
            else if((i>=0) && (j<0)){
                digit = (arr1[i] + carry) % 10;
                carry = (arr1[i] + carry) / 10;
            }
            
            else if((i<0) && (j>=0)){
                digit = (arr2[j] + carry) % 10;
                carry = (arr2[j] + carry) / 10;
            }
            
            else {
            	digit = carry;
            	carry = 0;
            }
            
            res[k] = digit;
            count++;
            i--;
            j--;
            k--;
        }
        
        System.out.print("Resultant Array : ");
        for(i=(n-count); i<n; i++){
            System.out.print(res[i] + " ");
        }
	}
}