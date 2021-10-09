/*
 * URL: https://leetcode.com/problems/squares-of-a-sorted-array/
 * TITLE: Squares of a Sorted Array
 * DIFFICULTY: EASY
 * */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
 * 정렬되어있지 않은 배열 nums가 주어진다,.제곱하여 오름차순으로 정렬후 리턴
 * */
public class P977 {
    public static void main(String[] args) {
        P977 SOL = new P977();
        SOL.sortedSquares(new int[]{-4, -1, 0, 3, 10});
    }

    //    public int[] sortedSquares(int[] nums) {
//        ArrayList<Integer> result = new ArrayList<>();
//
//        for(int i = 0 ; i < nums.length; i++){
//            result.add(nums[i] * nums[i]);
//        }
//
//        Collections.sort(result);
//        int[] answer = new int[result.size()];
//        for(int i = 0; i < answer.length; i++){
//            answer[i] = result.get(i);
//        }
//        return answer;
//    }
    // Ohter one
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int i = 0, j = n - 1;

        for(int p = n -1; p >= 0; p--){
            if(Math.abs(nums[i]) > Math.abs(nums[j])){
                result[p] = nums[i] * nums[i];
                i++;
            } else{
                result[p] = nums[j] * nums[j];
                j--;
            }
        }
        return result;
    }
}
