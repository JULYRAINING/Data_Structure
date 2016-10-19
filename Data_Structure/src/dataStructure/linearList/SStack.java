package dataStructure.linearList;

public interface SStack<E> {
	boolean isEmpty();
	boolean push(E element);
	E pop();
	E get();
}
