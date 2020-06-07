import java.util.ArrayList;

public class HashTable<K, V> {

    // current size of the hashtable
    private int size;

    private ArrayList<HashNode<K, V>> array;

    public HashTable(){
        this.array = new ArrayList<>();
        this.size = 0;

        // Create empty chains
        for (int i = 0; i < 1; i++)
            this.array.add(null);
    }

    public V getValue(K key) {
        int index = getIndex(key);
        HashNode head = this.array.get(index);

        while (head != null) {
            if (head.key.equals(key)) {
                return (V) head.value;
            }
            head = head.next;
        }

        return null;
    }

    public V remove(K key){
        int index = getIndex(key);
        HashNode head = this.array.get(index);
        HashNode prev = null;

        while (head != null) {
            if (head.key.equals(key)) {
                break;
            }
            prev = head;
            head = head.next;
        }

        if (head == null) {
            return null;
        }

        size--;
        if (prev != null) {
            prev.next = head.next;
        } else {
            this.array.set(index, head.next);
        }

        return (V) head.value;
    }

    public V add(K key, V value){
        int index = getIndex(key);
        HashNode head = this.array.get(index);

        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return value;
            }
            head = head.next;
        }

        size++;
        head = this.array.get(index);
        HashNode<K, V> newNode = new HashNode<>(key, value);
        newNode.next = head;
        this.array.set(index, newNode);
        return value;
    }

    public int getIndex(K key){
        int hashCode = key.hashCode();
        return hashCode % this.array.size();
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    public int getSize(){
        return this.size;
    }


    public class HashNode<K, V> {

        public K key;

        public V value;

        public HashNode<K, V> next;

        public HashNode(K key, V value){
            this.key = key;
            this.value = value;
        }

    }

    public static void main(String[] args) {
        HashTable<String, Integer> map = new HashTable<>();
        map.add("test",2);
        map.add("test2",2);
        map.add("test",4);
        map.add("test3",5);
        System.out.println(map.getSize());
        System.out.println(map.remove("test"));
        System.out.println(map.remove("test"));
        System.out.println(map.getSize());
        System.out.println(map.isEmpty());
        map.array.stream().forEach(s -> System.out.println("Key: " + s.key + " Value: " + s.value));
    }

}
