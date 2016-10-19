package dataStructure.linearList;

public interface QQueue<E> {
	
	boolean isEmpty();
	boolean enqueue(E element);
	E dequeue(); 
}
