import java.util.Deque;

public class MyDeque<E> {
    private MyNode<E> left;
    private MyNode<E> right;

    private int count;

    public int getCount() {
        return count;
    }

    public void addLeft(E item) {
        MyNode<E> l = left;
        MyNode<E> newNode = new MyNode<>(null, item, left);
        left = newNode;
        if (l == null) {
            right = newNode;
        } else {
            l.prev = newNode;
        }
        count++;
    }

    public void addRight(E item) {
        MyNode<E> r = right;
        MyNode<E> newNode = new MyNode<>(right, item, null);
        right = newNode;
        if (r == null) {
            left = newNode;
        } else {
            r.next = newNode;
        }
        count++;
    }

    public E pollLeft() {
        MyNode<E> node = left;
        left = left.next;
        count--;
        return node.item;
    }

    public E pollRight() {
        MyNode<E> node = right;
        right = right.prev;
        count--;
        return node.item;
    }

    public void printFromLeft() {
        MyNode<E> x = left;
        StringBuilder text = new StringBuilder();
        do {
            text.append(x.item).append(" ");
            x = x.next;
        } while (x != null);
        System.out.println(text);
    }

    public void printFromRight() {
        MyNode<E> x = right;
        StringBuilder text = new StringBuilder();
        do {
            text.append(x.item).append(" ");
            x = x.prev;
        } while (x != null);
        System.out.println(text);
    }
}