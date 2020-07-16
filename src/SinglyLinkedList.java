public class SinglyLinkedList<V> {

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.print();
        list.remove(2);
        list.print();
        list.remove(5);
        list.print();
    }

    public Node head;

    public SinglyLinkedList(V value){
        head = new Node(value);
    }

    public SinglyLinkedList() {
        head = null;
    }

    public void insert(V value) {
        Node newNode = new Node(value);
        newNode.next = null;
        if (head == null) {
            head = newNode;
        } else {
            Node last = head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = newNode;
        }
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

    public void remove(V value) {
        if (head == null) return;
        Node prev = null;
        Node currentNode = head;

        if (currentNode.data == value) {
            head = currentNode.next;
            System.out.println(value + " was found and removed!");
            return;
        }

        while (currentNode != null) {
            if (currentNode.data == value) {
                prev.next = currentNode.next;
                System.out.println(value + " was found and removed!");
                return;
            }
            prev = currentNode;
            currentNode = currentNode.next;
        }

        if (currentNode == null) {
            System.out.println(value + " was not found!");
        }
    }

    public class Node {

        V data;
        Node next;

        public Node(V data) {
            this.data = data;
        }

    }


}
