/*
 * URL: https://leetcode.com/problems/rotate-array/
 * TITLE: Rotate Array
 * DIFFICULTY: MEDIUM
 * */

import java.util.Arrays;

/*
 * 오른쪽 방향으로 N번 순환한 배열을 리턴
 * */
public class P189 {
    public static void main(String[] args) {
        P189 SOL = new P189();
        SOL.rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
    }

    public void rotate(int[] nums, int k) {
        int[] result = nums.clone();

        for(int i = 0 ; i < nums.length; i++){
            int inputIndex = (i + k) % nums.length;
            nums[inputIndex] = result[i];
        }
        System.out.println(Arrays.toString(nums));
    }
}
