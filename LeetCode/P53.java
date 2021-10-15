import java.util.Arrays;
/*
* URL: https://leetcode.com/problems/maximum-subarray/submissions/
* TITLE:  Maximum Subarray
* DIFFICULTY: EASY
* */


public class P53 {
    public static void main(String[] args) {
        P53 sol = new P53();
        sol.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
//        sol.maxSubArray(new int[]{5,4,-1,7,8});
//        sol.maxSubArray(new int[]{-2,-1});
    }

    public int maxSubArray(int[] nums) {
        int[] memo = new int[nums.length];
        memo[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            memo[i] = Math.max(nums[i], memo[i-1] + nums[i]);
        }
        System.out.println(Arrays.toString(memo));
        return getMax(memo);
    }

    public int getMax(int[] nums){
        int max = Integer.MIN_VALUE;
        for(int num : nums){
            max = Math.max(num, max);
        }
        System.out.println(max);
        return max;
    }
}
