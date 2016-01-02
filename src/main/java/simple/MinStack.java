package simple;

/**
 * Created by bruce on 14-11-12.
 */
public class MinStack {
    int top = -1;
    int[] s = new int[1000000];
    int[] min = new int[1000000];
    public void push(int x) {
        top++;
        s[top] = x;
        if(top == 0) {
            min[top] = x;
        } else {
            if(x<min[top-1]) {
                min[top] = x;
            } else {
                min[top] = min[top-1];
            }
        }
    }

    public void pop() {
        top--;
    }

    public int top() {
        return s[top];
    }

    public int getMin() {
        return min[top];
    }

    public static void main(String[] args) {
        MinStack s = new MinStack();
        s.push(3);
        s.push(5);
        s.pop();
        s.getMin();
    }
}
