/*
 * URL: https://leetcode.com/problems/implement-trie-prefix-tree/
 * TITLE: Implement Trie (Prefix Tree)
 * DIFFICULTY: MEDIUM
 * */

/*
 * prefix tree 구현
 * */
public class P208 {
    public static void main(String[] args) {

    }

    class Trie {

        Node root;

        class Node {
            Node[] childs;
            boolean isEnd;

            Node() {
                childs = new Node[26];
                isEnd = false;
            }
        }

        public Trie() {
            root = new Node();
        }

        public void insert(String word) {
            Node cur = root;

            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);

                if (cur.childs[ch - 'a'] == null) {
                    cur.childs[ch - 'a'] = new Node();
                }

                cur = cur.childs[ch - 'a'];
            }

            cur.isEnd = true;
        }

        public boolean search(String word) {
            Node cur = root;

            for(int i = 0 ; i < word.length(); i++){
                char c = word.charAt(i);
                if(cur.childs[c - 'a'] == null) {
                    return false;
                }
                cur = cur.childs[c - 'a'];
            }
            return cur.isEnd;
        }

        public boolean startsWith(String prefix) {
            Node cur = root;

            for(char c : prefix.toCharArray()){
                if(cur.childs[c - 'a'] == null){
                    return false;
                }
                cur = cur.childs[c - 'a'];
            }
            return true;
        }
    }
}
