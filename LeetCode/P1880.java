// URL: https://leetcode.com/problems/check-if-word-equals-summation-of-two-words/
// NAME: Check if Word Equals Summation of Two Words


/*
* 알파벳값은 각 알파벳 이전의 갯수. (예 a -> 0, b -> 1....)
* 알파벳으로 이루어진 단어들은 각각 치환되는 숫자가 연결되어 변환됨. acb -> 021 - > 21
* firstWord + secondWord = targetWord 가 되는지 확인
* */
public class P1880 {
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        int a = convertor(firstWord);
        int b = convertor(firstWord);
        int c = convertor(firstWord);
        return a + b == c;
    }

    public int convertor(String s){
        int result = 0;

        for(int i = s.length()-1; i >= 0; i--){
            result += (int) ((s.charAt(i) - 'a') * Math.pow(10,(s.length() - i - 1)));
        }
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        P1880 SOL = new P1880();
        SOL.convertor("cba");

    }
}
