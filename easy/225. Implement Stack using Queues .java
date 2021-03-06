class MyStack {

    private Queue<Integer> queue1;
    private Queue<Integer> queue2;
    /** Initialize your data structure here. */
    public MyStack() {
        queue1 = new LinkedList<Integer>();
        queue2 = new LinkedList<Integer>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        queue1.offer(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int result = 0;
        while (!queue1.isEmpty()) {
            result = queue1.poll();
            if (!queue1.isEmpty()) {
                queue2.offer(result);
            }
        }
        while (!queue2.isEmpty()) {
            queue1.offer(queue2.poll());
        }
        return result;
    }
    
    /** Get the top element. */
    public int top() {
        int result = 0;
        while (!queue1.isEmpty()) {
            result = queue1.poll();
            queue2.offer(result);
        }
        while (!queue2.isEmpty()) {
            queue1.offer(queue2.poll());
        }
        return result;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */