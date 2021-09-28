package LeetCode;

public class Longest_Substring_Without_Repeating_characters {
    public static void main(String[] args) {
        Solution a = new Solution();
        int b = a.lengthOfLongestSubstring(" ");
        System.out.println(b);
    }

    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            int count = 0;
            String sub = "";
            for(int i = 0 ; i < s.length() ; i++){
                for(int j = i; j < s.length(); j++){
                    char c = s.charAt(j);
                    if(sub.indexOf(c) != -1){
                        count = Math.max(count, sub.length());
                        sub = "";
                        break;
                    }
                    sub += String.valueOf(c);
                }
            }
            return Math.max(count, sub.length());
        }
    }
}

