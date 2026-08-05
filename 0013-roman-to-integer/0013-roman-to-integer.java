class Solution {
    public int romanToInt(String s) {
        int res=value(s.charAt(0));
        for(int i=1;i<s.length();i++){
            int previous = value(s.charAt(i - 1));
            int current = value(s.charAt(i));
            if(previous>=current){
                res=res+current;
            }
            else{
                res=res-previous-previous+current;
            }
        }
        return res;
    }
    public int value(char c){
        if(c=='I')
        return 1;
        if(c=='V')
        return 5;
        if(c=='X')
        return 10;
        if(c=='L')
        return 50;
        if(c=='C')
        return 100;
        if(c=='D')
        return 500;
        if(c == 'M')
        return 1000;

        return -1;

    }
}