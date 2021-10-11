/*
* URL: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
* TITLE: Two Sum II - Input array is sorted
* DIFFICULTY: EASY
* */

import java.util.Arrays;

/*
* 오름차순으로 정렬된 1차원배열이 주어짐. 합이 target이 되는 2개의 숫자 인덱스 구하기
* 인덱스는 0을 1로 생각해 반환
* 
* 중복되는 숫자는 없으며 답은 항상 있음
* */
public class P167 {
    public static void main(String[] args) {
        P167 SOL = new P167();
        System.out.println(Arrays.toString(SOL.twoSum(new int[]{2,7,11,15}, 9)));
    }
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while(true){
            int nLeft = numbers[left];
            int nRight = numbers[right];

            if(nLeft + nRight == target){
                return new int[]{left + 1, right + 1};
            }
            if(nLeft + nRight < target){
                left++;
            }else{
                right--;
            }
        }
    }
}
