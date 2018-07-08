On2, On
class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s == null || s.length() == 0) {
        	return 0;
        }
        if (s.length() <= k) {
            return s.length();
        }
        HashSet<Character> set = new HashSet<>();
        int start = 0;
        int end = 0;
        int max = 0;
        while (end < s.length()) {
        	if (!set.contains(s.charAt(end)) && set.size() < k) {
                set.add(s.charAt(end));
        		end++;
        		max = Math.max(max, end - start);
        	} else if (set.contains(s.charAt(end))) {
        		end++;
        		max = Math.max(max, end - start);
        	} else {
        		start++;
        		end = start;
        		set.clear();
        	}
        }
        return max;
    }
}


class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() <= k) {
            return s.length();
        }
        int[] count = new int[256];
        int res = 0;
        int diff = 0;
        int left = 0;
        for (int right = 0; right< s.length(); right++) {
            count[s.charAt(right)]++;
            if (count[s.charAt(right)] == 1) {
                diff++;
            }
            if (diff <= k) {
                res = Math.max(res, right - left + 1);
            }
            while (diff > k) {
                count[s.charAt(left)]--;
                if (count[s.charAt(left)] == 0) {
                    diff--;
                }
                left++;
            }
        }
        return res;
    }
}