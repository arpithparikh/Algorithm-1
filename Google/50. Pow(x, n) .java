class Solution {
    public double myPow(double x, int n) {
        if (x == 0 || n == 1) {
            return x;
        }
        if (n == 0) {
            return 1.0;
        }
        double half = myPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else if (n > 0) {
            return half * half * x;
        } else {
            return half * half / x;
        }
    }
}