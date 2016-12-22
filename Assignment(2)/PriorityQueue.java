
import java.util.ArrayList;
import java.util.Comparator;


public class PriorityQueue<E>{

public ArrayList<E> heap = new ArrayList<E>();
private Comparator<? super E> c;
	
	public PriorityQueue(Comparator<? super E> comparator) {
		c = comparator;
	}
	
	/**
	 * This method inserts the new element in the priorityArray. 
	 * @param a
	 */
	public void insert(E a){
		heap.add(a);
		bubbelUp(heap.size()-1);
		
	}
	
	/**
	 * This method searches after a bid in the priorityArray.
	 * @param e
	 * @return the position of the bid. 
	 */
	public int findValue(E e){
		for(int i=0; i<heap.size();i++){
			if(c.compare(e, heap.get(i))==0)
				return i;
		}
			return -1;
	}
	
	public E getMin(){
		return heap.get(0);
	}
	
	/**
	 * this method takes the index and returns the minor of it's children.
	 * @param k
	 * @return 
	 */
	
	public int minOfChild(int k){
		if(getLeftChild(k)==-1){
			return -1;
		}
		else if(getRightChild(k)==-1){
			return getLeftChild(k);
		}
		else if(c.compare(heap.get(getLeftChild(k)),heap.get(getRightChild(k)))<=0){
			return getLeftChild(k);
		}
		else{
			return getRightChild(k);
		}
	}
	/**
	 * the method takes a index and returns the left child.
	 * @param q
	 * @return
	 */
	public int getLeftChild(int q){
		if (((2*q)+1) > (heap.size() -1)){
			return -1;
		}
		return ((2*q)+1);
	}
	/**
	 * this method takes a index and retuns the right child.
	 * @param q
	 * @return
	 */
	public int getRightChild(int q){
		if (((2*q)+2) > (heap.size()-1)){
			return -1;
		}
		return ((2*q)+2);
	}	
	/**
	 * this method takes an index and returns it's parent
	 * @param k
	 * @return
	 */
	public int getParrent(int k){
		if(k%2==0){
			return ((k-2)/2);
		else
			return ((k-1)/2);	
	}
	/**
	 * this method takes an index and positioning its contents in right place upwards.
	 * @param k
	 */
	public void bubbelUp(int k){
		while((getParrent(k)!=-1 && k!=0 && 
				(c.compare(heap.get(k), heap.get(getParrent(k))))<=0)){				
				replace(getParrent(k),k);
				k = getParrent(k);
		}
	}

	/**
	 * this method takes an index and positioning its contents in right place downwards. 
	 * @param a
	 */
	public void bubbelDown(int a){ 
		int index =a;
		int temp;
		while(getLeftChild(index)!=-1){
				
			if (c.compare(heap.get(index), heap.get(minOfChild(index)))<=0){
				break;
			}
	
			else{
				temp = minOfChild(index);
				replace(index,minOfChild(index));
				index = temp;
			}
		}		
	}
	
	/**
	 * remove the root of the tree.
	 */
	public void deleteMin(){
		if(heap.size()<1){
			throw new IllegalArgumentException("N�tt blev galet");
		}
		else{
			replace(0,heap.size()-1);
			heap.remove(heap.size()-1);
			bubbelDown(0); 
		}
	}
	/**
	 * this method takes two index and swap the contents of them.
	 * @param q
	 * @param w
	 */
	public void replace (int q, int w){
		if( q>heap.size()-1 || w>heap.size()-1){
			throw new IllegalArgumentException("provided index dosen't exsist");
		}
		E temp = heap.get(w);
		heap.set(w, heap.get(q));
		heap.set(q, temp);
	}
}
