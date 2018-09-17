class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] freq= new int[26];
        for (char c: licensePlate.toLowerCase().toCharArray()) if (Character.isLowerCase(c)) freq[c-'a']++;
        String res="";
        for (String s: words) if ((res.length()==0 || s.length()<res.length()) && ok(Arrays.copyOf(freq, 26), s)) res=s;
        return res;
    }
    public boolean ok(int[] freq, String s){
        for (char c: s.toCharArray()) freq[c-'a']--;
        for (int f: freq) if (f>0) return false;
        return true;
    }
}