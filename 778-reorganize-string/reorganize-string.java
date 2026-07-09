class Solution {
    public String reorganizeString(String s) {

        int[] hash = new int[26];

        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i) - 'a']++;
        }

        int max = 0;
        int letter = 0;

        for (int i = 0; i < 26; i++) {
            if (hash[i] > max) {
                max = hash[i];
                letter = i;
            }
        }

        if (max > (s.length() + 1) / 2) {
            return "";
        }

        char[] ans = new char[s.length()];
        int index = 0;

        while (hash[letter] > 0) {
            ans[index] = (char) (letter + 'a');
            index += 2;
            hash[letter]--;
        }

        for (int i = 0; i < 26; i++) {
            while (hash[i] > 0) {

                if (index >= s.length()) {
                    index = 1;
                }

                ans[index] = (char) (i + 'a');
                index += 2;
                hash[i]--;
            }
        }

        return new String(ans);
    }
}