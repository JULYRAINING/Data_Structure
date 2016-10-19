package dataStructure.linearList;

public class SeqStack<E> implements SStack<E> {

	private Object value[];
	private int top;
	
	public SeqStack(int capacity){
		this.value = new Object[Math.abs(capacity)];
		this.top = -1;
	}
	public SeqStack(){
		this(10);
	}
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return this.top == -1;
	}

	@Override
	public boolean push(E element) {
		if(element == null){
			return false;
		}
		if(this.top == value.length -1){
			Object[] temp = this.value;
			this.value = new Object[temp.length*2];
			for(int i = 0; i < temp.length; i++){
				this.value[i] = temp[i];
			}
		}
		this.top++;
		this.value[this.top] = element;
		return true;
	}

	@Override
	public E pop() {
		if(!isEmpty()){
			return (E)this.value[this.top--];
		}
		return null;
	}

	@Override
	public E get() {
		if(!isEmpty()){
			return (E)this.value[this.top];
		}
		return null;
	}
	public String toString(){
		String str = "(";
		if(this.top!=0){
			for(int i = 0; i <= this.top-1; i++){
				str += this.value[i].toString() + ", ";
			}
			str += this.value[this.top].toString();
		}
		return str += ")";
	}
}
