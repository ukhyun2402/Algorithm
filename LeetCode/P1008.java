/*
 * URL: https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
 * TITLE: Construct Binary Search Tree from Preorder Traversal
 * DIFFICULTY: MEDIUM
 * */

/*
 * 이진트리 만들기
 * */
public class P1008 {
    public static void main(String[] args) {
        P1008 sol = new P1008();
        sol.bstFromPreorder(new int[]{8, 5, 1, 7, 10, 12});
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        int index = 1;
        TreeNode cursor = root;
        while (index < preorder.length) {
            int nextNum = preorder[index];
            if (cursor.val > nextNum) { // LEFT
                if(cursor.left == null){
                    cursor.left = new TreeNode(preorder[index++]);
                    cursor = root;
                } else {
                    cursor = cursor.left;
                }
            } else if (cursor.val < nextNum) { //RIGHT
                if(cursor.right == null) {
                    cursor.right = new TreeNode(preorder[index++]);
                    cursor = root;
                } else {
                    cursor = cursor.right;
                }
            }
        }
        return root;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
