class Solution {
    public boolean checkPerfectNumber(int num) {
        int sum=0;
        for(int i=1;i*i<num;i++){
            if(num%i==0){
                sum+=i;
                

                if(num/i!=num)
                    sum+=num/i;

            }
            
        }
        // System.out.println(sum+" "+num);
        return sum==num;
        
    }
}