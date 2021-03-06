class Solution {
    public int strStr(String s, String t) {
        if (s == null || t == null || t.length() > s.length()) {
            return -1;
        }
        for (int i = 0; i <= s.length() - t.length(); i++) {
            int j = 0;
            for (j = 0; j < t.length(); j++) {
                if (s.charAt(i + j) != t.charAt(j)) {
                    break;
                }
            }
            if (j == t.length()) {
                return i;
            }
        }
        return -1;
    }
}

class Solution {
    public int strStr(String s, String t) {
        if (s == null || s.length() < t.length() || t == null) {
            return -1;
        }
        int i, j;
        for (i = 0; i <= s.length() - t.length(); i++) {
            for (j = 0; j < t.length(); j++) {
                if (s.charAt(i + j) != t.charAt(j)) {
                    break;
                }
            }
            if (j == t.length()) {
                return i;
            }
        }
        return -1;
    }
}