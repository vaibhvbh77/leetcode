class Solution {
    public String removeKdigits(String num, int k) {

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < num.length(); i++) {

            while (!st.isEmpty() &&
                   k > 0 &&
                   st.peek() > num.charAt(i)) {

                k--;
                st.pop();
            }

            st.push(num.charAt(i));
        }

        // If k is still remaining, remove from the end
        while (k > 0 && !st.isEmpty()) {
            st.pop();
            k--;
        }

        StringBuilder ans = new StringBuilder();

        while (!st.isEmpty()) {
            ans.append(st.pop());
        }

        ans.reverse();

        // Remove leading zeros
        int i = 0;

        while (i < ans.length() - 1 && ans.charAt(i) == '0') {
            i++;
        }

        return ans.substring(i)==""?"0":ans.substring(i);
    }
}