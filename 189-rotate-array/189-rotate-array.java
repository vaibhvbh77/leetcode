class Solution {
    public void rotate(int[] nums, int k) {
        if(nums.length<=1)
            return ;
        
         k=k%nums.length;
        
        
        rev(nums,0,nums.length-1);
        rev(nums,0,k-1);
        rev(nums,k,nums.length-1);
              
    }
    
     public void rev(int arr[],int l,int h)
 {
     while(l<h)
     {
         int temp=arr[l];
         arr[l]=arr[h];
         arr[h]=temp;
         l++;
         h--;
         
         
     }
     
     
     
 }
    

}
