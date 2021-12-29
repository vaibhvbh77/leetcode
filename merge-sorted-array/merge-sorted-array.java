class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        
        int arr[]=new int[m+n];
        
        
        int i=0;
        int j=0;
        int count=0;
        while(i<m&&j<n){
         if(nums1[i]>nums2[j])
             arr[count++]=nums2[j++];
            else 
                arr[count++]=nums1[i++];
            
            
        }
        while(i<m){
 
               arr[count++]=nums1[i++];
            
            
        }
         while(j<n){
 
               arr[count++]=nums2[j++];
            
            
        }
        for(int k=0;k<m+n;k++)
            nums1[k]=arr[k];
        
    }
}