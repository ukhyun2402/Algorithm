/*
 * URL: https://leetcode.com/problems/perfect-squares/
 * TITLE: Perfect Squares
 * DIFFICULTY: MEDIUM
 * */

import java.util.ArrayList;
import java.util.Arrays;

/*
 * 정수 n이 주어짐. 제곱이 되는 수의 합을 통해 최소가 가능하도록 하기
 * */
public class P279 {
    static ArrayList<Integer> perfectNums;
    public static void main(String[] args) {
        P279 sol = new P279();
        sol.numSquares(16);
    }

    public int numSquares(int n) {
        int dp[] = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        // 1-d dp
        for(int i=1; i<=n; ++i){
            for(int j=1; j*j<=i; ++j){
                System.out.println("비교 : " + (i -j*j) + " " + i);
                dp[i] = Math.min(dp[i], dp[i-j*j]+1);
            }
            System.out.println();
        }

        return dp[n];
    }

    public boolean isPossible(int n){
        for(int i = 0 ; i < perfectNums.size(); i++){
            if(n % perfectNums.get(i) == 0 && perfectNums.get(i) != 1 && n > 0) return true;
        }
        return false;
    }
}
