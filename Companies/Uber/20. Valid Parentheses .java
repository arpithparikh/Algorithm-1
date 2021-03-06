class Solution {
    public boolean isValid(String s) {
        if (s == null) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                stack.push(c);
            } else if (!stack.isEmpty() && map.get(stack.peek()) == c) {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}