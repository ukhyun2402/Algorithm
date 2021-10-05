/*
* n만큼의 계단이 주어짐. 한번에 1~2칸 까지 오를 수 있음
* 몇가지의 경우의 수가 있을까요
* */
public class P70 {

    public static void main(String[] args) {
        P70 SOL = new P70();
        System.out.println(SOL.climbStairs(5));
    }
    public int climbStairs(int n) {
        int[] hash = new int[45];
        hash[0] = 1;
        hash[1] = 2;
        hash[2] = 3;

        for(int i = 3; i < n; i++){
            hash[i] = hash[i-1] + hash[i -2];
        }

        return hash[n-1];
    }

//    public void climb(int n, int target){
//        if ( n == target ){
//            count++;
//        }
//        if( n > target){
//            return;
//        }
//
//        for(int i = 1; i <= 2; i++){
//            climb(n + i, target);
//        }
//    }
}
