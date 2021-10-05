import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * URL: https://leetcode.com/problems/most-visited-sector-in-a-circular-track/
 * TITLE: Most Visited Sector in a Circular Track
 * DIFFICULTY: EASY
 * */

/*
 * 변수 N과 rounds 정수 배열이 주어짐. n개 구역으로 나누어진 원형 트랙이 있음
 * 이 트랙에서는 마라톤이 열릴 예정임. 마라톤은 m 라운드로 이루어져 있으며 i 번째 라운드는 round[i-1]구역부터 시작함
 * 그리고는 rounds[i]구역에서 종료함. 예를 들어 1 라운드는 rounds[0] 구역에서 시작하고 rounds[1]에서 종료함
 *
 * 제일 많이 방문된 구역들을 오름차순으로 정리해 반환
 *
 * */
public class P1560 {
    public static void main(String[] args) {
        P1560 SOL = new P1560();
        SOL.mostVisited(4, new int[]{1,3,1,2});
    }

    public List<Integer> mostVisited(int n, int[] rounds) {
        int[] visited = new int[n + 1];
        List<Integer> answer = new ArrayList<>();
        int MAX = Integer.MIN_VALUE;

        boolean isFirst = true;

        for (int i = 1; i < rounds.length; i++) {
            System.out.print("ROUND " + i + ": ");
            int start = rounds[i-1];
//            int end = rounds[i] + (isFirst? 1 : 0);
            int end = rounds[i];
            isFirst = false;
            while(true){
                if(start > n){
                    start = 1;
                }
                if (start == end) break;
                System.out.print(start + " ");
                visited[start]++;
                MAX = Math.max(visited[start], MAX);
                start++;
            }
            System.out.println();
        }

        visited[rounds[rounds.length-1]]++;
        MAX = Math.max(visited[rounds[rounds.length-1]], MAX);

        for(int i = 0 ; i < visited.length;i++){
            if(visited[i] == MAX) {
                answer.add(i);
            }
        }
        System.out.println(Arrays.toString(visited));
        return answer;
    }
}
