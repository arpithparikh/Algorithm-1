class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}

class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int[] res = new int[nums.length];
        int len = 0;
        res[0] = nums[0];
        len++;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < res[0]) {
                res[0] = nums[i];
            } else if (res[len - 1] < nums[i]) {
                res[len++] = nums[i]; 
            } else {
                int index = binarySearch(res, 0, len - 1, nums[i]);
                res[index] = nums[i];
            }
        }
        return len;
    }
    private int binarySearch(int[] res, int start, int end, int target) {
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (res[mid] == target) {
                return mid;
            } else if (res[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (res[start] == target) {
            return start;
        } else {
            return end;
        }
    }
}