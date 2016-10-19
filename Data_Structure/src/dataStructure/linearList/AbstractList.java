package dataStructure.linearList;

import java.util.Iterator;

public abstract class AbstractList<E> implements Iterable<E>{

	public abstract Iterator<E> iterator();
	
	public String toString(){
		Iterator<E>it = iterator();
		String str = "(";
		while(it.hasNext()){
			E element = it.next();
			str += element.toString();
			if(it.hasNext()){
				str += ",";
			}
		}
		return str += ")";
	}
	public boolean contain(E obj){
		if(obj!=null){
			Iterator<E>it = iterator();
			while(it.hasNext()){
				if(obj.equals(it.next())){
					return true;
				}
			}
		}
		return false; 
	}

}
