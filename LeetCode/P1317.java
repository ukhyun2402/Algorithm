/*
* URL: https://leetcode.com/problems/convert-integer-to-the-sum-of-two-no-zero-integers/
* TITLE: Convert Integer to the Sum of Two No-Zero Integers
* DIFFICULTY: EASY
* */

/*
* n 정수가 주어짐. 0이 아니고 0이 포함되어있지 않은 숫자 2개를 더해 n 을 만들 수 있는 조합 반환
* */
public class P1317 {

    public int[] getNoZeroIntegers(int n) {
        for(int i = 1; i < n; i++){
            int j = n - i;

            if(!(isZeroContain(i) || isZeroContain(j))){
                return new int[]{i,j};
            }
        }
        return null;
    }

    public boolean isZeroContain(int n){
        for(char c : String.valueOf(n).toCharArray()){
            if(c == '0') return true;
        }
        return false;
    }

    public static void main(String[] args) {
        P1317 SOL = new P1317();
        SOL.getNoZeroIntegers(11);
    }
}
