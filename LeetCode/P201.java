/*
 * URL: https://leetcode.com/problems/bitwise-and-of-numbers-range/
 * TITLE: Bitwise AND of Numbers Range
 * DIFFICULTY: MEDIUM
 * */

import java.util.Arrays;

/*
 * left와 right 정수 변수 주어짐. left와 right 사이의 모든 수에 대해서 and 연산
 * */
public class P201 {
    public static void main(String[] args) {
        P201 SOL = new P201();
        SOL.rangeBitwiseAnd(
                2147483646,
                2147483647);
    }

    public int rangeBitwiseAnd(int left, int right) {
        if (log2(left) != log2(right)) return 0;

        char[] bin = getBinary(left);
        for (int j = left + 1; j <= right; j++) {
            if(j < left) break;
            char[] tmp = getBinary(j);
            for (int i = 0; i < bin.length; i++) {
                bin[i] = bin[i] == tmp[i] ? bin[i] : '0';
            }
        }
        System.out.println(getNum(bin));
        return getNum(bin);
    }

    public char[] getBinary(int num) {
        int length = log2(num) + 1;
        char[] nums = new char[length];

        for(int i = length - 1 ; i >= 0; i--){
            nums[i] = (char)('0' + (num % 2));
            num /= 2;
        }
//        System.out.println(Arrays.toString(nums));
        return nums;
    }

    public int getNum(char[] num) {
        int answer = 0;
        for (int i = num.length - 1; i >= 0; i--) {
            if (num[i] == '1') {
                answer += Math.pow(2, Math.abs(i - num.length + 1));
            }
        }
        return answer;
    }

    public int log2(int num) {
        if(num == 0) return 0;
        return (int) (Math.log10(num) / Math.log10(2));
    }
}
