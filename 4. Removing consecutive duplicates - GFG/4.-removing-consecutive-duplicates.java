// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//taking the length of the string
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    
		    //taking the string
		   String str = br.readLine().trim();
		   
		   //calling removeConsecutiveDuplicates method of class solve
		   System.out.println(new Solution().removeConsecutiveDuplicates(str));
		}
	}
}// } Driver Code Ends




class Solution
{
    //Function to remove consecutive duplicates from given string using Stack.
    public static String removeConsecutiveDuplicates(String str)
    {
        ArrayDeque<Character>st=new ArrayDeque<>();
        st.push(str.charAt(0));
          String res=""+str.charAt(0);
        for(int i=1;i<str.length();i++){
            if(st.peek()==str.charAt(i))
            continue;
            else
            {
                st.push(str.charAt(i));
                res+=str.charAt(i);
            }
        }
     
        
        
        return res;
    }
    
}