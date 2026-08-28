class Solution {

    public String lexPalindromicPermutation(String s, String target) {

        int n = s.length();

        // Count characters
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // Check if palindrome is possible
        int odd = 0;
        char middle = 0;

        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 == 1) {
                odd++;
                middle = (char) ('a' + i);
            }
        }

        if (odd > 1) {
            return "";
        }

        // We only need to construct the first half
        int halfLength = n / 2;

        int[] halfFreq = new int[26];

        for (int i = 0; i < 26; i++) {
            halfFreq[i] = freq[i] / 2;
        }

        StringBuilder half = new StringBuilder();

        // Try to match target from left to right
        int i = 0;

        while (i < halfLength) {

            int x = target.charAt(i) - 'a';

            // Same character available
            if (halfFreq[x] > 0) {

                half.append(target.charAt(i));
                halfFreq[x]--;
                i++;
            }

            else {
                break;
            }
        }

        /*
         * We either:
         *
         * 1. Got stuck while matching target
         * OR
         * 2. Matched the complete first half
         *
         * In both cases, try to make some position bigger.
         */

        if (i == halfLength) {

            // We matched the whole first half.
            // Construct the complete palindrome and check it.
            String candidate = makePalindrome(half, middle);

            if (candidate.compareTo(target) > 0) {
                return candidate;
            }

            // Exact half wasn't enough.
            // Backtrack from the last position.
            i--;
        }

        while (i >= 0) {

            // Restore the character we had matched at i
            if (half.length() > i) {

                char removed = half.charAt(i);

                half.deleteCharAt(i);

                halfFreq[removed - 'a']++;
            }

            // Try smallest character greater than target[i]
            int x = target.charAt(i) - 'a';

            for (int j = x + 1; j < 26; j++) {

                if (halfFreq[j] > 0) {

                    // Make this position greater
                    half.append((char) ('a' + j));
                    halfFreq[j]--;

                    // Fill remaining half with smallest characters
                    for (int k = 0; k < 26; k++) {

                        while (halfFreq[k] > 0) {
                            half.append((char) ('a' + k));
                            halfFreq[k]--;
                        }
                    }

                    // Now make the full palindrome
                    return makePalindrome(half, middle);
                }
            }

            // Can't make this position greater.
            // Go one position to the left.
            i--;
        }

        return "";
    }

    public String makePalindrome(StringBuilder half, char middle) {

        String left = half.toString();

        String right = new StringBuilder(left)
                .reverse()
                .toString();

        if (middle == 0) {
            return left + right;
        }

        return left + middle + right;
    }
}