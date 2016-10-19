package dataStructure.tree;

public class CompleteBinaryTree<E> extends BinaryTree<E>{

	public CompleteBinaryTree() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CompleteBinaryTree(E[] levelorder){
		this.root = create(levelorder, 0);
	}
	private BinaryNode<E> create(E[] levelorder, int i) {
		BinaryNode<E>p = null;
		if(i<levelorder.length){
			p = new BinaryNode<E>(levelorder[i]);
			p.left = create(levelorder, 2*i +1);
			p.right = create(levelorder, 2*i +2);
		}
		return p;
	}
}
