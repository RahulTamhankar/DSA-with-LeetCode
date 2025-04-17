import java.util.Stack;

class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        // Push to minStack if it's empty or val is smaller or equal to the current min
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        // Pop from minStack too if it's the same as the top of the main stack
        if (stack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}


/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */


 //Example
//  MinStack minStack = new MinStack();
// minStack.push(-2);   // stack: [-2], minStack: [-2]
// minStack.push(0);    // stack: [-2, 0], minStack: [-2]
// minStack.push(-3);   // stack: [-2, 0, -3], minStack: [-2, -3]
// minStack.getMin();   // returns -3
// minStack.pop();      // stack: [-2, 0], minStack: [-2]
// minStack.top();      // returns 0
// minStack.getMin();   // returns -2
