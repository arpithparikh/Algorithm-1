class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int res = 0;
        int curRes = 0;
        int num = 0;
        char op = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            if (c == '+' || c == '-' || c == '*' || c == '/' || i == s.length() - 1) {
                switch (op) {
                    case '+' : curRes += num;
                        break;
                    case '-' : curRes -= num;
                        break;
                    case '*' : curRes *= num;
                        break;
                    case '/' : curRes /= num;
                        break;
                }
                if (c == '+' || c == '-' || i == s.length() - 1) {
                    res += curRes;
                    curRes = 0;
                }
                op = c;
                num = 0;
            }
        }
        return res;
    }
}