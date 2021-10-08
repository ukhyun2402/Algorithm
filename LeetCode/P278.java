/*
 * URL: https://leetcode.com/problems/first-bad-version/
 * TITLE: First Bad Version
 * DIFFICULTY: EASY
 * */

/*
 * 당신은 프로덕트 매니저이며 새로운 프로젝트를 리드하고있씁니다.
 * 불행하게도, 최신 버젼의 품질체크에 실패했습니다.
 * 이전 버젼을 바탕으로 개발을 하기에 불량한 버젼 이후로 개발된 버젼은 모두 불량입니다.
 *
 * n의 버젼을 가지고 있다고 가정해 봅시다. 시초의 불량버젼을 찾았다면 이후의 버젼은 모두 불량일겁니다.
 *
 * 당신은 API를 하나 제공받습니다. 이 API bool isBadVersion(version)은 이 버젼이 불량인지 아닌지를 확인해줍니다.
 * 이 함수를 가지고 처음의 불량 버젼을 찾아주세요
 * */

public class P278 {
    public static void main(String[] args) {
        P278 SOL = new P278();
        System.out.println(SOL.firstBadVersion(2126753390));
    }

    public int firstBadVersion(int n) {
        int left = 0;
        int right = n;
        while (true) {
            int center = (int)(((long)right + left) / 2);

            if(Math.abs(left- right) <= 1){
                return center + 1;
            }

            if(isBadVersion(center)){
                right = center;
            } else {
                left = center;
            }
        }
    }

    public boolean isBadVersion(int n){
        return n >= 1702766719;
    }
}
