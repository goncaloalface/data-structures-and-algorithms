import java.util.EmptyStackException;

public class Stack<T> {

    public static void main(String[] args) {
        Stack stack = new Stack();
        System.out.println(stack.isEmpty());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.peek());
        System.out.println(stack.remove());
        stack.printStack();
    }

    private StackNode<T> top;

    private Stack(){
    }

    public void push(T data) {
        StackNode<T> newNode = new StackNode<>(data);
        newNode.next = top;
        top = newNode;
    }

    public T remove() {
        if (top == null) throw new EmptyStackException();
        T item = top.data;
        top = top.next;
        return item;
    }

    public T peek() {
        if (top == null) throw new EmptyStackException();
        return top.data;
    }

    public boolean isEmpty(){
        return top == null;
    }

    public void printStack() {
        if (top == null) throw new EmptyStackException();
        StackNode currentNode = top;
        while (currentNode != null) {
            System.out.println(currentNode.data);
            currentNode = currentNode.next;
        }
        System.out.println("End of stack!");
    }

    public class StackNode<T> {

        private T data;

        private StackNode<T> next;

        public StackNode(){
        }

        public StackNode(T data) {
            this.data = data;
        }

    }

}
