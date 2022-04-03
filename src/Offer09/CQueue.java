package Offer09;

import java.util.ArrayDeque;
import java.util.Deque;

class CQueue {
    Deque<Integer> s1 = new ArrayDeque<>();
    Deque<Integer> s2 = new ArrayDeque<>();

    public CQueue() {
    }

    public void appendTail(int value) {
        s1.push(value);
    }

    public int deleteHead() {
        if (s2.size() <= 0) {//只要栈1有数据，就先pop，然后push到栈2
            while (s1.size() > 0) {
                int data = s1.peek();
                s1.pop();
                s2.push(data);
            }
        }
        if (s2.size() == 0){//如果连栈2都没数据，则结束
            return -1;
        }
        int res = s2.peek();//delete
        s2.pop();
        return res;
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
