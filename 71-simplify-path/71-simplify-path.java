class Solution {
    public String simplifyPath(String path) {
        Stack<String> s=new Stack();
        for(String str: path.split("/"))
        {
            if(str.equals(".."))
            {
                if(!s.isEmpty())
                {
                    s.pop();
                }
            }
            else if(!str.isEmpty() && !str.equals("."))
            {
                s.push("/"+str);
            }

        }
        String str="";
        while(!s.isEmpty())
        {
            str=s.pop()+str;
        }
        return str.isEmpty() ? "/" : str;
    }
}