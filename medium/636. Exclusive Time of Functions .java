class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Stack<int[]> stack = new Stack<>();
        for (String log : logs) {
            String[] strs = log.split(":");
            int index = Integer.valueOf(strs[0]);
            int time = Integer.valueOf(strs[2]);
            if (strs[1].equals("start")) {
                stack.push(new int[]{index, time});
            } else {
                int executedTime = time - stack.pop()[1] + 1;
                res[index] += executedTime;
                if (!stack.isEmpty()) {
                    res[stack.peek()[0]] -= executedTime;
                }
            }
        }
        return res;
    }
}