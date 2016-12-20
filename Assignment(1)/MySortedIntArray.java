
import java.io.IOException;
/**
 * This has class has two methods: readFile and member. and a constructor that calls the methods. 
 * @author Ali Mohamud
 * @author Ali Mohamed
 */
public class MySortedIntArray implements MyIntSet {
	public int[] arrayfinal;
/**
 * 
 * This constructor has two parameters the element we search after and the file name.
 * <p>This constructor calls the methods and printout what the member method returns. <p>
 * @param elemnt 
 * the element we are looking for.
 * @param fil
 * the file with the integers.
 * @throws IOException
 * throws an exception if the file are not found.
 */
	public MySortedIntArray(int[] array, int elemnt){
		arrayfinal = array;
		System.out.println(member(elemnt));
	}
	
/**
 * Because we can not divide the array we use pointer instead.
 * @param element the element we are looking for.
 * @return If a match is done the true, otherwise false.
 * 
 */

		public boolean member(int element){		
			int index_begin = 0;
			int index_end = arrayfinal.length - 1;
			
			
			while (index_begin <= index_end) {
				int mid = (index_begin + index_end) >>> 1;
				int midValue = arrayfinal [mid];
			
				if (midValue < element){
					index_begin = mid + 1;
				}
				else if (midValue > element){
					index_end = mid - 1;
				}
				else
				return true; 
			}
			return false;  
		    }

	}
	


