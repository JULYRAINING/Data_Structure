package dataStructure;

/**
 * 线性表抽象类型
 * @author TF
 *
 * @param <E>
 */
public interface LList<E> {
	boolean isEmpty();
	int length();
	E get(int index);
	E set(int index, E element);
	boolean add(int index, E element);
	boolean add(E element);
	E remove(int index);
	void clear();
}
