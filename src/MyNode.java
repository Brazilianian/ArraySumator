public class MyNode<E> {
    MyNode<E> prev;
    E item;
    MyNode<E> next;

    public MyNode(MyNode<E> prev, E item, MyNode<E> next) {
        this.prev = prev;
        this.item = item;
        this.next = next;
    }
}
