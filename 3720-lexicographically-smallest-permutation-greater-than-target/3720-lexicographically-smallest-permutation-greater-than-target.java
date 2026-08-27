class Solution {
    public String lexGreaterPermutation(String s, String target) {

        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        StringBuilder ans = new StringBuilder();

        // Match target from left to right
        for (int i = 0; i < target.length(); i++) {

            int x = target.charAt(i) - 'a';

            // Same character available
            if (freq[x] > 0) {
                ans.append(target.charAt(i));
                freq[x]--;
                continue;
            }

            // Can't match -> try to make this position bigger
            return build(ans, freq, target, i);
        }

        // Matched entire target.
        // Need to make it STRICTLY greater.
        return build(ans, freq, target, target.length() - 1);
    }

    private String build(StringBuilder ans, int[] freq,
                         String target, int i) {

        while (i >= 0) {

            // Restore the character at this position
            if (ans.length() > i) {
                char c = ans.charAt(i);
                freq[c - 'a']++;
                ans.deleteCharAt(i);
            }

            // Find smallest character > target[i]
            int x = target.charAt(i) - 'a';

            for (int j = x + 1; j < 26; j++) {

                if (freq[j] > 0) {

                    ans.append((char) ('a' + j));
                    freq[j]--;

                    // Remaining characters smallest first
                    for (int k = 0; k < 26; k++) {
                        while (freq[k] > 0) {
                            ans.append((char) ('a' + k));
                            freq[k]--;
                        }
                    }

                    return ans.toString();
                }
            }

            // Can't increase this position.
            // Go one position left.
            i--;
        }

        return "";
    }
}