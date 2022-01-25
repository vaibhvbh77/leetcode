class Solution {
    public boolean validMountainArray(int[] arr) {
        
        
//        1iteration finding the max element 
        int max=0;
        
        for(int i=0;i<arr.length;i++){
            if(arr[i]>arr[max])
                max=i;
        }
        
        if(arr[max]==arr[0]||arr[max]==arr[arr.length-1])
            return false;
        for(int i=0;i<max;i++){
            if(arr[i]<arr[i+1])
                continue;
            else
                return false;
        }
         for(int i=max;i<arr.length-1;i++){
            if(arr[i]>arr[i+1])
                continue;
            else
                return false;
        }
        return true;
        
        
        
    }
}