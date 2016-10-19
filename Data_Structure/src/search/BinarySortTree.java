package search;

import static org.hamcrest.CoreMatchers.instanceOf;

import dataStructure.tree.BinaryNode;

public class BinarySortTree<E> {
	protected BinaryNode<E> root;

	public BinarySortTree() {
		root = null;
	}

	public boolean isEmpty() {
		return false;
	}

	public void inOrder() {

	}

	private void inOrder(BinaryNode<E> p) {

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public BinaryNode<E> search(E value) {
		if (value == null || !(value instanceof Comparable)) {
			return null;
		}
		Comparable cmpobj = (Comparable) value;
		BinaryNode<E> p = this.root;
		while (p != null && cmpobj.compareTo(p.data) != 0) {
			System.out.println(p.data + "?");
			if (cmpobj.compareTo(p.data) < 0) {
				p = p.left;
			} else {
				p = p.right;
			}
		}
		return p;
	}

	public BinaryNode<E> search_recursion(E value) {
		if (value == null || this.root == null) {
			return null;
		}
		return search_recursion(value, this.root);

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public BinaryNode<E> search_recursion(E value, BinaryNode<E>p){
		 Comparable cmpobj = (Comparable) value;
		 	if(p==null){
		 		return null;
		 	}
		 	if(cmpobj.compareTo(p.data) == 0){
				return p;
				
			}else {
				System.out.println(p.data + "?");
				if(cmpobj.compareTo(p.data) < 0){
					return search_recursion(value, p.left);
				}else {
					return search_recursion(value, p.right);
				}
			}	
		 	
			
		
		 
	 }

	@SuppressWarnings("unchecked")
	public boolean insert(E value){
		
		if(value == null ||!(value instanceof Comparable)){
			return false;
		}
		Comparable<E>cmpobj = (Comparable<E>) value;
		
		
		BinaryNode<E>p = this.root;
		while (p!=null) {
			if(cmpobj.compareTo(value)<0){
				p = p.left;
			}else {
				p = p.right;
			}
		}
		p = new BinaryNode<>(value);
		
		return true;
		
	}
	
	public boolean insert_recursion(E value) {
		if (value == null || !(value instanceof Comparable)) {
			return false;
		}
		if (root == null) {
			root = new BinaryNode<>(value);
			return true;
		}
		return insert_recursion(value, root);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private boolean insert_recursion(E value, BinaryNode<E> p) {
		Comparable cmpobj = (Comparable) value;
		if (cmpobj.compareTo(p.data) == 0) {
			return false;
		}
		if (cmpobj.compareTo(p.data) < 0) {
			if (p.left == null) {
				p.left = new BinaryNode<>(value);
				return true;
			} else {
				return insert_recursion(value, p.left);
			}
		} else {
			if (p.right == null) {
				p.right = new BinaryNode<>(value);
				return true;
			} else {
				return insert_recursion(value, p.right);
			}
		}

	}

	public E remove(E value) {
		if (root == null || value == null || !(value instanceof Comparable)) {
			return null;
		}
		return remove(value, root, null);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private E remove(E value, BinaryNode<E> p, BinaryNode<E> parent) {
		Comparable cmpobj = (Comparable) value;
		if (p != null) {
			if (cmpobj.compareTo(p.data) < 0) {
				return remove(value, p.left, p);
			} else {
				if (cmpobj.compareTo(p.data) > 0) {
					return remove(value, p.right, p);
				} else {
					if (p.left != null && p.right != null) {
						BinaryNode<E> innext = p.right;
						while (innext.left != null) {
							innext = innext.left;
						}
						p.data = innext.data;
						return remove(p.data, p.right, p);
					} else {
						if (parent == null) {
							if (p.left != null) {
								root = p.left;
							} else {
								root = p.right;
							}
							return p.data;
						}
						if (p == parent.left) {
							if (p.left != null) {
								parent.left = p.left;
							} else {
								parent.left = p.right;
							}
						} else {
							if (p.left != null) {
								parent.right = p.left;
							} else {
								parent.right = p.right;
							}
						}
					}
				}
			}
		}
		return null;
	}

}
