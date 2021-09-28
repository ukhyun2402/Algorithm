package LeetCode;

public class Valid_Parentheses {
    public static void main(String[] args) {
        Solution a=  new Solution();
        System.out.println(a.isValid("("));
    }

    private static class Solution {
        public boolean isValid(String s) {
            Stack st = new Stack();
            for(int i = 0 ; i < s.length(); i++){
                char c = s.charAt(i);

                if(c == '{' || c == '(' || c == '['){
                    st.push(new Item(String.valueOf(c)));
                }else{
                    if(st.cursor == null || Math.abs(st.pop().charAt(0) - c) > 2){
                        return false;
                    }
                }
            }
            return st.cursor == null;
        }
    }
}

class Stack{
    Item cursor = null;

    public String pop(){
        Item poppedItem = cursor;
        cursor = poppedItem.prev;
        return poppedItem.value;
    }

    public void push(Item item){
        if(this.cursor != null){
            item.prev = cursor;
        }
        cursor = item;
    }

    public String peek(){
        return cursor.value;
    }
}

class Item{
    String value;
    Item prev = null;

    public Item(String value) {
        this.value = value;
    }
}