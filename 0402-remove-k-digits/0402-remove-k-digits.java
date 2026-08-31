class Solution {
    public String removeKdigits(String num, int k) {

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < num.length(); i++) {

            char current = num.charAt(i);

            while(k > 0 && !stack.isEmpty() && stack.peek() > current) {
                stack.pop();
                k--;
            }
            stack.push(current);
        }

        // If removals are still left,
        // remove from the end
        while(k > 0) {
            stack.pop();
            k--;
        }

        // Now build answer from stack
        String ans = "";

        while(!stack.isEmpty()) {
            ans += stack.pop();
        }

        String rev="";
        for(int i=ans.length()-1;i>=0;i--)
        rev+=ans.charAt(i);
        int i=0;
        while(i<rev.length()&&rev.charAt(i)=='0'){
            i++;
        }


        return rev.substring(i).isEmpty() ? "0" : rev.substring(i);
    }
}