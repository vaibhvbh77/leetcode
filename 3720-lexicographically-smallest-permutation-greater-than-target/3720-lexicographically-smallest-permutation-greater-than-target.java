class Solution {
    public String lexGreaterPermutation(String s, String target) {

        int freq[] = new int[26];

        // Count characters in s
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        StringBuilder ans = new StringBuilder();

        int i = 0;

        // Go left to right
        while (i < target.length()) {

            int x = target.charAt(i) - 'a';

            // 1. Same character is available
            if (freq[x] > 0) {

                freq[x]--;
                ans.append(target.charAt(i));
                i++;
            }

            // 2. Same character is NOT available
            else {

                // Try smallest character greater than target[i]
                int greater = -1;

                for (int j = x + 1; j < 26; j++) {
                    if (freq[j] > 0) {
                        greater = j;
                        break;
                    }
                }

                // Found a greater character
                if (greater != -1) {

                    ans.append((char)('a' + greater));
                    freq[greater]--;

                    // Put remaining characters in sorted order
                    for (int j = 0; j < 26; j++) {
                        while (freq[j] > 0) {
                            ans.append((char)('a' + j));
                            freq[j]--;
                        }
                    }

                    return ans.toString();
                }

                // No greater character.
                // Backtrack to previous matched position.
                while (ans.length() > 0) {

                    i--;

                    char last = ans.charAt(ans.length() - 1);
                    ans.deleteCharAt(ans.length() - 1);

                    // Restore the character
                    freq[last - 'a']++;

                    int y = target.charAt(i) - 'a';

                    // Try to bump this position
                    for (int j = y + 1; j < 26; j++) {

                        if (freq[j] > 0) {

                            ans.append((char)('a' + j));
                            freq[j]--;

                            // Fill remaining characters smallest first
                            for (int k = 0; k < 26; k++) {
                                while (freq[k] > 0) {
                                    ans.append((char)('a' + k));
                                    freq[k]--;
                                }
                            }

                            return ans.toString();
                        }
                    }
                }

                return "";
            }
        }

        // We matched the whole target exactly.
        // But we need STRICTLY greater, so backtrack.
        while (ans.length() > 0) {

            i--;

            char last = ans.charAt(ans.length() - 1);
            ans.deleteCharAt(ans.length() - 1);
            freq[last - 'a']++;

            int x = target.charAt(i) - 'a';

            for (int j = x + 1; j < 26; j++) {

                if (freq[j] > 0) {

                    ans.append((char)('a' + j));
                    freq[j]--;

                    for (int k = 0; k < 26; k++) {
                        while (freq[k] > 0) {
                            ans.append((char)('a' + k));
                            freq[k]--;
                        }
                    }

                    return ans.toString();
                }
            }
        }

        return "";
    }
}