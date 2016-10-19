package dataStructure.tree;

public class ThreadBinaryTree<E> {
	private ThreadBinaryNode<E>root;
	
	public ThreadBinaryTree(){
		root = null;
	}
	public ThreadBinaryTree(E[] preorder){
		root = create(preorder);
		inorderThread(root);
	}
	private int i = 0;
	private ThreadBinaryNode<E>create(E[] preorder){
		ThreadBinaryNode<E>p = null;
		if(i<preorder.length){
			E elem = preorder[i];
			i++;
			if(elem != null){
				p = new ThreadBinaryNode<E>(elem);
				p.left = create(preorder);
				p.right = create(preorder);
			}
		}
		return p;
	}
	private ThreadBinaryNode<E>front = null;
	//������������p���Ϊ����������p��ǰ�������front
	private void inorderThread(ThreadBinaryNode<E>p){
		if(p!=null){
			inorderThread(p.left);
			if(p.left==null){
				p.ltag = 1;
				p.left = front;
			}
			if(p.right == null){
				p.rtag = 1;
			}
			if(front!=null&&front.rtag==1){
				front.right = p;
			}
			front = p;
			inorderThread(p.right);
		}
	}
	//����p���и������µĺ�̽��
	public ThreadBinaryNode<E> inNext(ThreadBinaryNode<E>p){
		if(p.rtag ==1){
			p = p.right;
		}else{
			p = p.right;
			while(p.ltag == 0){
				p = p.left;
			}
		}
		return p;
	}
	public void inOrder(){
		ThreadBinaryNode<E>p = root;
		if(p!=null){
			System.out.println("�и����������");
			while(p.ltag == 0){
				p = p.left;
			}
			do{
				System.out.print(p.data);
				p = inNext(p);
			}while(p!=null);
			System.out.println(); 
		}
	}
}
