class Solution {
    public int racecar(int target) {
        // can direct arrive target
        // need turn right once after passing te target
        // need turn right before passing the target
        int[] dp = new int[10001];
        for (int i = 0; i <= 13; i++) {
            dp[(1 << i) - 1] = i;
        }
        helper(dp, target);
        return dp[target];
    }
    private int helper(int[] dp, int target) {
        if (dp[target] != 0) {
            return dp[target];
        }
        int n = (int)(Math.log(target) / Math.log(2)) + 1;
        dp[target] = n + 1 + helper(dp, (1 << n) - 1 - target);
        for (int i = 0; i < n - 1; i++) {
            // 转向也算一步
            dp[target] = Math.min(dp[target], (n - 1) + 1 + i + 1 + helper(dp, target - (1 << (n - 1)) + (1 << i)));
        }
        return dp[target];
    }
}class Solution {
    public int[] nextGreaterElements(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i : nums) {
            res.add(i);
        }
        for (int i : nums) {
            res.add(i);
        }
        int[] result = new int[nums.length];
        for (int i = 0; i < result.length; i++) {
            int max = nums[i];
            int j;
            for (j = i + 1; j < res.size(); j++) {
                if (res.get(j) > max) {
                    result[i] = res.get(j);
                    break;
                }
            }
            if (j == res.size()) {
                result[i] = -1;
            }
        }
        return result;
    }
}