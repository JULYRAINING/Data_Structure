package dataStructure.linearList;

public class SortedHSLinkedList<E> extends HSLinkedList<E> {
	public SortedHSLinkedList(){
		super();
	}
	public boolean add(E element){
		if(element ==null ||!(element instanceof Comparable)){
			return false;
		}
		Comparable<E> cmp = (Comparable<E>) element;
		Node<E>front = this.head, p = front.next;
		while(p!=null && cmp.compareTo(p.data)>0){
			front = p;
			p =p.next;
		}
		front.next = new Node<E>(element, p);
		if(p == null){
			this.rear = front.next;
		}
		this.n++;
		return true;
	}
	public boolean remove(E element){
		if(element == null || !(element instanceof Comparable)){
			return false;
		}
		Comparable<E> cmp = (Comparable<E>) element;
		Node<E>front = this.head, p = front.next;
		while(p != null && cmp.compareTo(p.data)>0){
			front = p;
			p = p.next;
		}
		if(p ==null){
			return false;
		}
		if(cmp.compareTo(p.data) == 0){
			front.next = p.next;
		}
		
		if(p == this.rear){
			this.rear = front;
		}
		this.n--;
		return true;
	}
	public void re(int i){
		
	}
	public void re(Integer i){
		
	}
	public static void main(String args[]){
		SortedHSLinkedList<Integer>list = new SortedHSLinkedList<>();
		int n = 10;
		System.out.print("insert: ");
		for(int i = 0; i<n; i+=2){
			int k = (int)(Math.random()*100);
			list.add(new Integer(i));
			System.out.print(i+ " ");
		}
//		remove by index
		list.remove(3);
//		remove by element
		list.remove(new Integer(4));

		System.out.println("\nlist: " + list.toString());
	}
}
