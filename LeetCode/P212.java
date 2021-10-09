import java.util.ArrayList;
import java.util.List;

/*
 * URL: https://leetcode.com/problems/word-search-ii/
 * TITLE: Word Search II
 * DIFFICULTY: HARD
 * */
public class P212 {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int[][] visited;
    static List<String> ANSWER;

    public static void main(String[] args) {
        P212 SOL = new P212();
//        SOL.findWords(new char[][]{{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}}, new String[]{"oath", "pea", "eat", "rain"});
        SOL.findWords(new char[][]{{'a','a'}}, new String[]{"aaa"});

    }

    public List<String> findWords(char[][] board, String[] words) {
        ANSWER = new ArrayList<>();

        visited = new int[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {

                for (int s = 0; s < words.length; s++) {
                    if (board[i][j] == words[s].charAt(0)) {
                        visited[i][j] = 1;
                        dfs(words[s], i, j, board, 1);
                        visited[i][j] = 0;
                    }
                }
            }
        }
        System.out.println(ANSWER);
        return ANSWER;
    }

    public void dfs(String word, int i, int j, char[][] board, int level) {
        if(level > word.length()){
            return;
        }
        if (level == word.length()) {
            if(!ANSWER.contains(word)){
                ANSWER.add(word);
            }
            return;
        }
        for (int k = 0; k < 4; k++) {
            int new_i = i + dy[k];
            int new_j = j + dx[k];
            if (isIn(new_i, new_j) && visited[new_i][new_j] == 0 && board[new_i][new_j] == word.charAt(level)) {
                visited[new_i][new_j] = 1;
                dfs(word, new_i, new_j, board, level + 1);
                visited[new_i][new_j] = 0;
            }
        }
    }

    public boolean isIn(int i, int j) {
        return i >= 0 && j >= 0 && i < visited.length && j < visited[0].length;
    }
}
