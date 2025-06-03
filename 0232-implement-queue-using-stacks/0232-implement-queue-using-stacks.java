class MyQueue {
    private final Stack<Integer> input;
    private final Stack<Integer> output;

    public MyQueue() {
        input=new Stack<>();
        output=new Stack<>();
    }
    
    public void push(int x) {
        input.push(x);
    }
    
    public int pop() {
        peek(); // we do peek() here just to see whether output is empty or not 
        return output.pop();
    }
    
    public int peek() {
        if(output.empty()){
            while(!input.empty()){
                output.push(input.pop()); 
            }
        }
        return output.peek(); //The line return output.peek(); in the peek() method is for when the user explicitly calls .peek() — i.e., to see the front element of the queue without removing it. It is not for the benefit of pop()

        //int front = q.peek();  // \U0001f448 this is where return output.peek() is used

    }
    
    public boolean empty() {
        return input.empty() && output.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */