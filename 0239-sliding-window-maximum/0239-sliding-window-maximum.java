class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
         int[] ans = new int[n - k + 1];
         ArrayDeque<Integer>dq=new ArrayDeque<>();
         for(int i=0;i<k;i++){
            while(dq.isEmpty()==false && nums[dq.peekLast()]<=nums[i]){
                dq.pollLast();
            }
            dq.offerLast(i);
         }
         ans[0]=nums[dq.peekFirst()];

        // ------------------------------------------------
        // Step 2: Process the remaining elements
        // ------------------------------------------------

        for(int i=k;i<n;i++){
            // Remove the element which has gone outside
            // the current window
            if (dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            // adding new and removing all lesser
            while(!dq.isEmpty()&&nums[i]>=nums[dq.peekLast()]){
                dq.pollLast();
            }

            dq.offerLast(i);
            // every window ans
            ans[i-k+1]= nums[dq.peekFirst()];

        }

         return ans;
    }
}