public class DoublyLinkedList<V> {


    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.print();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.print();
        list.remove(3);
        list.print();
        list.remove(1);
        list.print();
    }

    Node head, tail;

    public DoublyLinkedList() {
        head = null;
        tail = null;
    }

    public DoublyLinkedList(V value) {
        head = new Node(value);
        tail = head;
    }

    public void insert(V value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = tail = newNode;
            head.previous = null;
            tail.next = null;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
            tail.next = null;
        }
    }

    public void remove(V value) {
        if (head == null) return;

        if (head.data == value) {
            if (head.next != null) {
                head = head.next;
            } else {
                head = null;
            }
            System.out.println(value + " was found and removed from head!");
            return;
        }

        Node currentNode = head;
        while (currentNode != null) {
            if (currentNode.data == value) {
                if (currentNode.next == null) {
                    tail = tail.previous;
                }
                currentNode.previous.next = currentNode.next;
                System.out.println(value + " was found and removed!");
                return;
            }
            currentNode = currentNode.next;
        }

        System.out.println(value + " wasn't found!");
    }

    public void print() {
        if (head == null) {
            System.out.println("The linked list is empty.");
            return;
        }

        Node currentNode = head;
        System.out.println("Linked List: ");
        while (currentNode != null) {
            System.out.println(currentNode.data);

            currentNode = currentNode.next;
        }
    }

    public class Node {

        V data;
        Node next;
        Node previous;

        public Node(V data) {
            this.data = data;
        }

    }

}
