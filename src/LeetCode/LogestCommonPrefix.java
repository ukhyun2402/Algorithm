package LeetCode;

public class LogestCommonPrefix {
    public static void main(String[] args) {
        Solution a = new Solution();
        a.longestCommonPrefix(new String[]{"flower", "flow", "flight"});
    }

    private static class Solution {
        public String longestCommonPrefix(String[] strs) {
            String prefix = "";
            boolean isEnd = false;
            int count = 0;

            if(strs.length == 1){
                return strs[0];
            }

            while(!isEnd){
                char check;
                try{
                    check = strs[0].charAt(count);
                    for(int i = 1; i < strs.length; i++){
                        if(check != strs[i].charAt(count)){
                            isEnd = true;
                            break;
                        }
                    }
                } catch(Exception e){
                    return prefix;
                }

                if(!isEnd){
                    prefix += String.valueOf(check);
                }
                count++;
            }
            System.out.println(prefix);
            return prefix;
        }
    }
}


