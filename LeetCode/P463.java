// URL: https://leetcode.com/problems/island-perimeter/
// NAME: Island Perimeter

 /*1은 땅, 0은 물 대각선이 아닌 상하좌우로 연결되어 있음. 땅은 호수가 없음
 이는 땅 중간에 물이 없음을 뜻함. 물과 접하고 있는 모서리 갯수 구하기
 */
public class P463 {
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int count;

    // 우 좌 하 상
    public int islandPerimeter(int[][] grid) {
        count = 0;
        for(int i = 0 ; i < grid.length; i++){
            for (int j = 0 ; j < grid[i].length; j++){
                if(grid[i][j] == 1){
                    for(int k = 0 ; k < 4; k++){
                        if(!isOut(j + dx[k],i + dy[k], grid[0].length, grid.length)){
                            if(grid[i + dy[k]][j + dx[k]] == 0){
                                count++;
                            }
                        } else {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

    public boolean isOut(int x, int y, int length_x, int length_y){
        return x < 0 || x >= length_x || y < 0 || y >= length_y;
    }

    public static void main(String[] args) {
        P463 SOL = new P463();
        int result = SOL.islandPerimeter(new int[][]{
                 {0,1,0,0}
                ,{1,1,1,0}
                ,{0,1,0,0}
                ,{1,1,0,0}
        });
        System.out.println(result);
    }
}
