/*
* URL: https://leetcode.com/problems/implement-stack-using-queues/
* TITLE: Implement Stack using Queues
* DIFFICULTY: EASY
* */

/*
* LIFO의 자료구조를 2개의 큐를 이용해 구현하라.
* (큐 이용안해도 될 것 같아서 이걸로 함)
* */
public class P225 {

    public static void main(String[] args) {
        MyStack obj = new MyStack();
        obj.push(1);
        obj.push(2);
        System.out.println(obj.top());
        System.out.println(obj.pop());
        System.out.println(obj.empty());
    }
}

class MyStack {
    int[] queue;
    int cursor = 0;
    int top = -1;

    public MyStack() {
        queue = new int[101];
    }

    public void push(int x) {
        queue[this.cursor++] = x;
        top++;
    }

    public int pop() {
        cursor--;
        return queue[top--];
    }

    public int top() {
        return queue[top];
    }

    public boolean empty() {
        return cursor == 0;
    }
}

