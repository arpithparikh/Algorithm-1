class Solution {
    public int distributeCandies(int[] candies) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i : candies) {
            set.add(i);
        }
        return set.size() >= candies.length / 2 ? candies.length / 2 : set.size();
    }
}