// { Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.sumOfDigits(N));
        }
    }
}// } Driver Code Ends


//User function Template for Java
class Solution{
    static int sumOfDigits(int N) {
        return sumf(N,0);
    }
    public static int sumf(int n,int sum){
        if(n==0)
        return sum;
        
        sum+=n%10+sumf(n/10,sum);
        
        return sum;
    }
}
       