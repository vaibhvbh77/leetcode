class Solution {
    public int compareVersion(String version1, String version2) {
        String []arr=version1.split("[.]");
        String []arr2=version2.split("[.]");
        int i=0;
        int j=0;
    
    
        while(i<arr.length&&j<arr2.length){
            System.out.println(i);
            System.out.println(j);
            int a=Integer.parseInt(arr[i]);
            int b=Integer.parseInt(arr2[j]);
              i++;
            j++;
            if(a==b)
                continue;
            if(a>b)
                return 1;
            else if(a<b)
                return -1;
            
          
            
        }
        while(i<arr.length){
            int a=Integer.parseInt(arr[i]);
            i++;
            if(a>0)
                return 1;
        }
         while(j<arr2.length){
            int a=Integer.parseInt(arr2[j]);
             j++;
            if(a>0)
                return -1;
        }
        
        return 0;
    }
}