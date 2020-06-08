import java.util.Arrays;

public class StringBuilder {

    private int size;

    private char[] content;

    public StringBuilder() {
        this.size = 0;
        content = new char[10];
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int getSize() {
        return this.size;
    }

    public void append(String str) {
        if (str == null) return;
        int strLength = str.length();
        if (strLength == 0) return;
        int newCount = strLength + this.size;
        if (newCount > content.length) {
            increaseContentSize(newCount);
        }
        str.getChars(0, strLength, this.content, this.size);
        this.size = newCount;
    }

    private void increaseContentSize(int total) {
        int newCapacity = (this.content.length + 1) * 2;
        if (newCapacity < 0) {
            newCapacity = Integer.MAX_VALUE;
        } else if (newCapacity < total) {
            newCapacity = total;
        }
        this.content = Arrays.copyOf(this.content, newCapacity);
    }

    public String toString() {
        return new String(this.content, 0, this.content.length);
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("Test");
        sb.append("Test1");
        sb.append("Test2");
        System.out.println(sb.size);
        System.out.println(sb.toString());
    }

}
