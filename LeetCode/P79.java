/*
* URL: https://leetcode.com/problems/word-search/
* TITLE: Word Search
* DIFFICULTY: MEDIUM
* */

/*
* m * n 크기의 캐릭더가 있는 배열이 있음.
* 여기에서 주어지는 word가 있는지 확인
* */
public class P79 {
    static String WORD;
    static char[][] BOARD;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static boolean result;
    static boolean[][] PATH;

    public static void main(String[] args) {
        P79 SOL = new P79();
        SOL.exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCB");
    }

    public boolean exist(char[][] board, String word) {
        WORD = word;
        BOARD = board;
        result = false;
        PATH = new boolean[board.length][board[0].length];

        for(int i = 0; i < board.length; i++){
            for(int j = 0 ; j < board[i].length; j++){
                if(word.charAt(0) == board[i][j]){
                    System.out.println(i + " " + j);
                    PATH[i][j] = true;
                    dfs(i,j,1, String.valueOf(word.charAt(0)));
                    PATH[i][j] = false;
                }
            }
        }
        System.out.println(result);
        return result;
    }

    public void dfs(int y, int x, int level, String cur){
        if(result){
            return;
        }
        if(cur.length()-1 > level){
            return;
        }
        if(cur.equals(WORD)){
            System.out.println(cur);
            result = true;
            return;
        }

        for(int i = 0 ; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(!isOut(nx, ny) && BOARD[ny][nx] == WORD.charAt(level) && !result && !PATH[ny][nx]){
                PATH[ny][nx] = true;
                dfs(ny, nx, level + 1, cur + String.valueOf(BOARD[ny][nx]));
                PATH[ny][nx] = false;
            }
        }
    }

    public boolean isOut(int x, int y){
        return (x < 0 || y < 0 || BOARD.length <= y || BOARD[0].length <= x);
    }
}
