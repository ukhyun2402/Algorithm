import java.util.Arrays;

/*
 * URL: https://leetcode.com/problems/move-zeroes/
 * TITLE: Move Zeroes
 * DIFFICULTY: EASY
 * */

/*
 * 배열에 주어진 0을 맨 뒤로 옮기기
 * */
public class P283 {
    public static void main(String[] args) {
        P283 SOL = new P283();
        SOL.moveZeroes(new int[]{0, 1, 0,});
    }

    public void moveZeroes(int[] nums) {
        int zero_index = nums.length - 1;
        for(int i = 0; i < zero_index;){
            if(nums[i] == 0){
                for(int j = i; j < zero_index; j++){
                    nums[j] = nums[j+1];
                }
                nums[zero_index] = 0;
                zero_index--;
            }
            else{
                i++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

}
