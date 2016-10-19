package dataStructure.tree;
/**
 * Ê÷
 * @author TF
 *
 */
public interface TTree<E> {
	boolean isEmpty();
	E getRoot();
	E getParent(E child);
	int getChildCount(E parent);
	E getFirstChild(E parent);
	E getNextSibling(E element);
	void traverse();
	void insert(E parent, E element);
	void remove(E parent);
	void clear();
}
