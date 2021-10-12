/*
 * URL: https://leetcode.com/problems/guess-number-higher-or-lower/
 * TITLE: Guess Number Higher or Lower
 * DIFFICULTY: EASY
 * */


/*
 * 추측게임을 시작하겠습니다.
 * 1 ~ n 까지의 숫자중 한개를 선택합니다. 그리고 우리는 그 숫자를 맞추어야 합니다.
 *
 * 만약 숫자가 틀리다면 그 숫자에 대해 높은지 낮은지를 알려줍니다.
 *
 * -1 => 추측값보다 답이 낮은
 * 1 => 추측값보다 답이 높음
 * 0 => 정답
 * */
public class P374 {
    public static void main(String[] args) {
        P374 SOL = new P374();
        SOL.guessNumber(1);
    }

    public int guessNumber(int n) {
        long max = n;
        long min = 1;
        long guessNum = (max + min) / 2;

        if(guess((int)max) == 0) return (int)max;
        if(guess((int)min) == 0) return (int)min;

        while (guess((int)guessNum)!= 0) {
            if (guess((int)guessNum) == 1) {
                min = guessNum;
            } else {
                max = guessNum;
            }
            guessNum = (max + min) / 2;
        }
        return (int)guessNum;
    }

    public int guess(int num) {
        int target = 1;
        if (num == target) {
            return 0;
        } else if (num > target) {
            return -1;
        } else {
            return 1;
        }
    }
}
