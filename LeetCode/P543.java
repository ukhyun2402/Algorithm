/*
 * URL: https://leetcode.com/problems/diameter-of-binary-tree/
 * TITLE: Diameter of Binary Tree
 * DIFFICULTY: EASY
 * */

import java.util.ArrayDeque;
import java.util.Queue;

/*
 * root라는 바이너리 트리가 주어지면 그 트리의 최장길이를 구하시오
 * 길이는 한 노드에서 다른 노드로 이어지는 선을 말함
 * */
public class P543 {
    int count = Integer.MIN_VALUE;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        P543 SOL = new P543();
        SOL.diameterOfBinaryTree(root);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        System.out.println(count);
        return count;
    }

    public int dfs(TreeNode root) {
        if(root == null) return 0;

        int left = dfs(root.left);
        int right = dfs(root.right);

        int height = left + right;
        count = Math.max(height, count);
        return Math.max(left, right) + 1;
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