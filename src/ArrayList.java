import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayList<T> {

    private int size;

    private T[] content;

    public ArrayList(Class<T> type) {
        this.size = 0;
        this.content = (T[]) Array.newInstance(type, 10);
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public T get(int index) {
        if (index > index || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return this.content[index];
    }

    public void add(T type) {
        if (size + 1 > this.content.length) {
            increaseContentCapacity();
        }
        this.content[size] = type;
        size++;
    }

    public T remove(int index) {
        if (index > index || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        T value = this.content[index];
        for(int i = index; i < this.content.length - 1; i++) {
            this.content[i] = this.content[i+1];
        }
        size--;
        return value;
    }

    private void increaseContentCapacity() {
        int newCapacity = (this.content.length + 1) * 2;
        if (newCapacity < 0) {
            newCapacity = Integer.MAX_VALUE;
        } else if (newCapacity < this.content.length) {
            newCapacity = this.content.length + 1;
        }
        this.content = Arrays.copyOf(this.content, newCapacity);
    }

    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<>(Integer.class);
        System.out.println(array.isEmpty());
        array.add(1);
        array.add(2);
        System.out.println(array.getSize());
        System.out.println(array.isEmpty());
        array.remove(0);
        System.out.println(array.get(0));
        System.out.println(array.getSize());
    }
}
