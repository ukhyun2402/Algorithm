/*
* URL: https://leetcode.com/problems/find-all-duplicates-in-an-array/
* TITLE: Find All Duplicates in an Array
* DIFFICULTY: MEDIUM
* */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* nums라는 n크기의 배열이 주어진다. 그리고 nums배열은 1~n의 값을 가지며 각각의 숫자는 1번 또는 2분 나타남
* 2번씩 나오는 숫자들을 리턴
* */
public class P442 {
    public static void main(String[] args) {
        P442 SOL = new P442();
        SOL.findDuplicates(new int[]{4,3,2,7,8,2,3,1});
    }
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> answer = new ArrayList<>();
        boolean[] isShow = new boolean[nums.length + 1];

        for(int i = 0 ; i < nums.length; i++){
            if(isShow[nums[i]]){
                answer.add(nums[i]);
            } else {
                isShow[nums[i]] = true;
            }
        }
//        System.out.println(Arrays.toString(isShow));
//        System.out.println(answer);
        return answer;
    }
}
