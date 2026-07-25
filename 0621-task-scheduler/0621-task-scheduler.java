class Solution {
    public int leastInterval(char[] tasks, int n) {
        int []freq=new int[26];
        //frequency array
        for(int i=0;i<tasks.length;i++){
            freq[tasks[i]-'A']++;
        }
        //heap
        PriorityQueue<Integer>pq=new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int i:freq){
            if(i>0){
                pq.add(i);
            }
        }

        int time = 0;
        while(!pq.isEmpty()){
            List<Integer>remaining=new ArrayList<Integer>();
            int task=0;
            for(int i=1;i<=n+1;i++){
                if (pq.isEmpty()) break;
                int frequency=pq.poll();
                frequency--;
                if(frequency>0) remaining.add(frequency);
                task++;
            }

            for(int i:remaining){
                pq.add(i);
            }

            if (!pq.isEmpty()) {
                time += n + 1;
            } else {
                time += task;
                }
      
        }





    return time;
    }
}
