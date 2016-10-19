package dataStructure.linearList;

public class ReverseLinkedList<E> extends SinglyLinkedList<E> {
	public ReverseLinkedList(){
		super();
	}
	public void reverse(){
		Node<E>p = this.head, q = null, front = null;
		while(p!=null){
			q = p.next;
			p.next = front;
			front = p;
			p = q;
		}
		this.head = front;
	}
	public static void main(String args[]){
		ReverseLinkedList<Integer>list = new ReverseLinkedList<Integer>();
		for(int i = 1; i <10000; i++){
			list.add(new Integer(i));
		}
		System.out.println("单链表"+list.toString());
		long begin = System.currentTimeMillis();
		list.reverse();
		System.out.println("运行时间："+(System.currentTimeMillis()-begin));
		System.out.println("单链表"+list.toString());
	}
}
