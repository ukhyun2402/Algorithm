package LeetCode;

public class Merge_Two_Sorted_Line {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        Solution a = new Solution();
        a.mergeTwoLists(l1,l2);
    }

    static class Solution{
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode answer = null;
            ListNode origin = null;
            ListNode l1_cursor = l1;
            ListNode l2_cursor = l2;

            while(l1_cursor != null || l2_cursor != null){
                if(answer == null){

                }
            }
            return answer;
        }
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
