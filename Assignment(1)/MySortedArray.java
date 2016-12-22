

public class MySortedArray<E extends Comparable<? super E>> implements MySet<E>{

	public E[] MultiArray;
	
	/**
	 * The constructor has two parameters in order to match a given element to any element in array of type <E>.
	 * The constructor passes the second argument to generic method member.
	 * @param array The array that is to be searched. Array of type arbitrary.
	 * @param element The element that method will try to match.
	 * @return True weather the specified element is matched, otherwise false. 
	 */

	public MySortedArray(E[] array, E element){
		MultiArray = array;		
		System.out.println(member(element));
	}


	/** 
	 * The method, member, returns a boolean weather the specified
	 * parameter matches an element in a generic Array. The generic Array must be ordered such that, 
	 * (A[0]<=A[1]...A[n-1]<=A[n]). 
	 * 	  
	 * @param  elem a generic type that method will try to match
	 * @return boolean True weather the specified element is matched, otherwise false. 
	 * 
	 */
	
	public boolean member(E element){
		int index_begin, index_end, mid;
		E midValue;
		index_end = MultiArray.length-1;
		index_begin = 0;
		
		while(index_begin<=index_end){
			
			mid = (index_begin+index_end)/2;
			midValue = MultiArray[mid];
			
			if(element.compareTo(midValue)<0){
				index_end = mid - 1;
			}
			else if(element.compareTo(midValue)>0){
				index_begin = mid + 1;
			}
			else{
				return true;
			}
		}
		return false;
		
	}
	
		
}