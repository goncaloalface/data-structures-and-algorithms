import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class Queue<T> {

    public static void main(String[] args) {
        Queue queue = new Queue();
        System.out.println(queue.isEmpty());
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println(queue.remove());
        System.out.println(queue.peek());
        System.out.println(queue.isEmpty());
        queue.printQueue();
    }

    private QueueNode<T> first;

    private QueueNode<T> last;


    public Queue(){}

    public void push(T data) {
        QueueNode queueNode = new QueueNode(data);
        if (last != null) last.next = queueNode;
        last = queueNode;
        if (first == null) first = last;
    }

    public T remove() {
        if (first == null) throw new NoSuchElementException();
        T data = first.data;
        first = first.next;
        if (first == null) last = null;
        return data;
    }

    public T peek() {
        if (first == null) throw new NoSuchElementException();
        return first.data;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public void printQueue() {
        if (first == null) throw new EmptyStackException();
        QueueNode currentNode = first;
        while(currentNode != null) {
            System.out.println(currentNode.data);
            currentNode = currentNode.next;
        }
        System.out.println("End of the Queue!");
    }

    public class QueueNode<T>{

        private T data;

        private QueueNode<T> next;

        public QueueNode() {
        }

        public QueueNode(T data) {
            this.data = data;
        }

    }
}
