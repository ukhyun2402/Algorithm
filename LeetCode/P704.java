/*
* URL: https://leetcode.com/problems/binary-search/
* TITLE: Binary Search
* DIFFICULTY: EASY
* */

/*
*  오름차순으로 정렬된 nums배열 제공. search 함수를 이용해 target을 찾고 인덱스를 반환 만약 없으면 -1
* */
public class P704 {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int center = (left + right) / 2;

            if(Math.abs(left-right) <= 1){
                if(nums[left] == target) return left;
                if(nums[right] == target) return right;
                return -1;
            }

            if (nums[center] == target) {
                System.gc();
                return center;
            } else if (nums[center] > target) {
                right = center;
            } else if (nums[center] < target) {
                left = center;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        P704 SOL = new P704();
        System.out.println(SOL.search(new int[]{5}, -5));
    }
}
