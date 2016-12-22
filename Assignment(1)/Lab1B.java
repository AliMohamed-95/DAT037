import java.io.*;
import java.util.*;

public class Lab1B {
	/**
	 * @author Ali Mohamed & Ali Mohamud
	 * @since 2016-11-07
	 * @course DAT037
	 * 
	 */
	
	/**
	 * The method readFile reads a file containing a Integer and returns an array of that same data type. 
	 * @param filename The parameter is the name of the file, that method will try to read
	 * @return The method  will return a integer array.
	 * @throws IOException if the file is not found. 
	 * 
	 */
	public static Integer[] readFile(String filename) throws IOException{
		Scanner file = new Scanner(new File(filename));
		int counter = 0;
		while(file.hasNext()){
			counter+=1;
			file.next();
		}
		file.close();
		Integer[] outputArray = new Integer[counter];
		Scanner file1 = new Scanner(new File(filename));
		for(int i=0; i<=outputArray.length-1;i++){
			outputArray[i] = file1.nextInt();
			
		}
		file1.close();
		
		return outputArray;
	}
	
		
	
	
	public static void main(String[] args)throws IOException{
		
			  new MySortedArray<Integer>(readFile(args[1]),Integer.parseInt(args[0]));
	}
		

		
}
