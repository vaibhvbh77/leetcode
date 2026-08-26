class Solution {
    public String shortestBeautifulSubstring(String s, int k) {

        String poss = "";

        for (int i = 0; i < s.length(); i++) {

            int count = 0;

            for (int j = i; j < s.length(); j++) {

                if (s.charAt(j) == '1')
                    count++;

                if (count == k) {

                    String current = s.substring(i, j + 1);

                    if (poss.equals("") ||
                            current.length() < poss.length() ||
                            (current.length() == poss.length()
                                    && current.compareTo(poss) < 0)) {

                        poss = current;
                    }

                }
            }
        }

        return poss;
    }
}