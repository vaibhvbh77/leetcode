class Solution {
    public String multiply(String num1, String num2) {

        int[] res = new int[num1.length() + num2.length()];
        int []first=new int[num1.length()];
        int []second=new int[num2.length()];
        for(int i=0;i<num1.length();i++){
            first[i]=match(num1.charAt(i));
        }
         for(int i=0;i<num2.length();i++){
            second[i]=match(num2.charAt(i));
        }

        for(int i=first.length-1;i>=0;i--){
            for (int j = second.length - 1; j >= 0; j--) {
                int temp=first[i]*second[j];
                int onesPosition=i+j+1;
                int carryPosition=i+j;

                int total = res[onesPosition] + temp;
                res[onesPosition]=total%10;
                res[carryPosition]+= total / 10;

            }
        }




        String ans=new String("");
        int i=0;
       while (i < res.length && res[i] == 0) {
     i++;
}
while (i < res.length) {
    ans=ans+res[i];
    i++;
}

        return ans.equals("")?"0":ans;
    }
    public int match(char a){
        int matcher=0;
        if(a=='0') matcher=0;
        if(a=='1') matcher=1;
        if(a=='2') matcher=2;
        if(a=='3') matcher=3;
        if(a=='4') matcher=4;
        if(a=='5') matcher=5;
        if(a=='6') matcher=6;
        if(a=='7') matcher=7;
        if(a=='8') matcher=8;
        if(a=='9') matcher=9;
        return matcher;
    }
}
