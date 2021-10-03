import java.util.Arrays;

// URL : https://leetcode.com/problems/jump-game/
//
public class P55 {
    static int[] arr;

    public static void main(String[] args) {
        P55 a = new P55();
        System.out.println(a.canJump(new int[]{2,3,1,1,0,4}));
    }

//    public boolean canJump(int[] nums) {
//       boolean possible[] = new boolean[nums.length];
//       possible[0] = true;
//       for(int i = 0; i < nums.length; i++){
//           if(possible[i]){
//               for(int j = i; j <= i + nums[i]; j++){
//                   if(possible.length <= j ){
//                       continue;
//                   }
//                   possible[j] = true;
//               }
//           }
//       }
//        System.out.println(Arrays.toString(possible));
//       return possible[nums.length-1];
//    }
    public boolean canJump(int[] nums) {
        int lastIndex = nums.length - 1;
        for(int i = lastIndex; i >= 0; i--){
            if(i + nums[i] >= lastIndex){
                lastIndex = i;
                // return true;
            }
        }
        return lastIndex == 0;
    }

//    public void dfs(int position){
//        if (position == arr.length - 1){
//            System.out.println("HELLO " + position);
//            P55.arrive = true;
//            return;
//        }
//
//        if(position >= arr.length){
//            return;
//        }
//
//        for(int i = 1; i <= arr[position]; i++){
//            System.out.println(position + " => " + (i + position));
//            dfs(i+position);
//        }
//    }
}

