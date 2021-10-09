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
        SOL.rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 7);
    }

    public void rotate(int[] nums, int k) {

        for (int i = 0; i < k; i++) {
            int p1 = 0, p2 = 1, tmp = -1;

            for (int j = 0; j < nums.length; j++) {
                tmp = nums[p2];
                nums[p2] = tmp;
                p1 = (p1 + 1) % nums.length;
                p2 = (p2 + 1) % nums.length;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
