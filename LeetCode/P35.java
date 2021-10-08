/*
* URL: https://leetcode.com/problems/search-insert-position/
* TITLE: Search Insert Position
* DIFFICULTY: EASY
* */

/*
* 중복이없는 정렬된 배열이 주어집니다. 거기서 주어지는 타겟 숫자가 위치한 인덱스를 반환하세요
* 만약 없다면 어디에 위치해야 할지 인덱스를 반환해주세요
* */
public class P35 {

    public static void main(String[] args) {
        P35 SOL = new P35();
        System.out.println(SOL.searchInsert(new int[]{1}, 0));
    }

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length -1;

        while(true){
            int center = (left + right) / 2;

            if(nums[left] == target || nums[right] == target){
                return nums[left] == target ? left : right;
            }

            if(Math.abs(left - right) <= 1){
                if(nums[left] > target){
                    return left;
                } else {
                    if(nums[right] > target){
                        return right;
                    } else {
                        return right +1;
                    }
                }
            }

            if(nums[center] > target){
                right = center;
            } else {
                left =center;
            }
        }
    }
}
