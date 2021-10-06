/*
 * URL: https://leetcode.com/problems/minimum-difference-between-highest-and-lowest-of-k-scores/
 * TITLE: Minimum Difference Between Highest and Lowest of K Scores
 * DIFFICULTY: EASY
 * */

import java.util.Arrays;
import java.util.Collections;

/*
 * 배열인 nums을 인자로 받고, nums[i]는 i번째 학생의 스코어를 나타냄
 * 그리고 k 인자도 받을거임
 *
 * k 명의 학생을 뽑았을때 최고값과 최소값의 차이 중 제일 작은 것을 반환
 * */
public class P1984 {
    static int MIN;
    static boolean[] USED;

    public static void main(String[] args) {
        P1984 SOL = new P1984();
        System.out.println(SOL.minimumDifference(new int[]{41900, 69441, 94407, 37498, 20299, 10856, 36221, 2231, 54526, 79072, 84309, 76765, 92282, 13401, 44698, 17586, 98455, 47895, 98889, 65298, 32271, 23801, 83153, 12186, 7453, 79460, 67209, 54576, 87785, 47738, 40750, 31265, 77990, 93502, 50364, 75098, 11712, 80013, 24193, 35209, 56300, 85735, 3590, 24858, 6780, 50086, 87549, 7413, 90444, 12284, 44970, 39274, 81201, 43353, 75808, 14508, 17389, 10313, 90055, 43102, 18659, 20802, 70315, 48843, 12273, 78876, 36638, 17051, 20478
        }, 5));
    }

    //    // WAY1 BRUTE
//    public int minimumDifference(int[] nums, int k) {
//        USED = new boolean[nums.length];
//        MIN = Integer.MAX_VALUE;
//        dfs(nums, k, 0);
//
//        return MIN;
//    }
//
//    public void dfs(int[] nums, int k, int level) {
//        if (usedCount() == k) {
//            int min = Integer.MAX_VALUE;
//            int max = Integer.MIN_VALUE;
//
//            for (int i = 0; i < USED.length; i++) {
//                if (USED[i]) {
////                    System.out.print(nums[i] + " ");
//                    min = Math.min(nums[i], min);
//                    max = Math.max(nums[i], max);
//                }
//            }
////            System.out.println();
//            MIN = Math.min(max - min, MIN);
//            return;
//        }
//
//        for(int i = level ; i < nums.length; i++){
//            USED[i] = true;
//            dfs(nums, k, level + 1);
//            USED[i] = false;
//        }
//    }
//
//    public int usedCount(){
//        int count = 0;
//        for (boolean b : USED) {
//            if (b) count++;
//        }
//        return count;
//    }
    // WAY2 SORTING
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int MIN = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - (k-1); i++) {
            for (int j = i + (k-1); j < nums.length; j++) {
                MIN = Math.min(nums[j] - nums[i], MIN);
            }
        }
        return MIN;
    }
}
