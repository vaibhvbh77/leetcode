class Solution {
    public int brokenCalc(int startValue, int target) {
        if(target<startValue)
            return startValue-target;
        int count=0;
        while(startValue!=target){
             if(target<startValue)
             {count+=startValue-target;break;}
            else if(target%2!=0)
            {target++;count++;}
            else
            {target=target/2;count++;}
            
        }
        return count;
        
    }
}