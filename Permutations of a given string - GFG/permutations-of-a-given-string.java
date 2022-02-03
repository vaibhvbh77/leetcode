// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            List<String> ans = obj.find_permutation(S);
            for( int i = 0; i < ans.size(); i++)
            {
                System.out.print(ans.get(i)+" ");
            }
            System.out.println();
                        
        }
	}
}

// } Driver Code Ends


class Solution {
    public List<String> find_permutation(String S) {
        char[]arr=S.toCharArray();
        List<String>ans=new ArrayList<>();
        boolean []flag=new boolean[S.length()];
        ArrayList<Character> list=new ArrayList<Character>();
        per(arr,ans,flag,list);
        Collections.sort(ans);
        return ans;
    }
    public void per(char []arr,List<String>ans,boolean[]flag,ArrayList<Character> S){
        if(S.size()==arr.length){
            String s="";
            for(char x:S){
                s+=x;
            }
            ans.add(s);
            return ;
        }
        for(int i=0;i<arr.length;i++){
            if(flag[i]==false){
                flag[i]=true;
                S.add(arr[i]);
                per(arr,ans,flag,S);
                flag[i]=false;
                S.remove(S.size()-1);
                
            }
        }
        
    }
}