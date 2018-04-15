class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        List<Integer> temp = new ArrayList<Integer>();
        helper(candidates, res, temp, target, 0);
        return res;
    }
    private void helper(int[] candidates, List<List<Integer>> res, List<Integer> temp, int target, int start) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            temp.add(candidates[i]);
            helper(candidates, res, temp, target - candidates[i], i);
            temp.remove(temp.size() - 1);
        }
    }
}