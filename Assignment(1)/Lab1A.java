import java.io.File;
import java.io.IOException;
import java.util.Scanner;
/**
 * <p>This class is the main class the constructor MySortedIntArray and give it <p>the parameters so we can run our program from the command line. <p>
 * @author Ali Mohamud
 * @author Ali Mohamed
 *
 */

public class Lab1A {
	public static void main (String[] arg) throws IOException{
		 new MySortedIntArray(readFile(arg[1]),Integer.parseInt(arg[0]));		 
	}
	
/**
 * This method uses scanner to read the file and a while loop to know how many integers are in the file.
 * <p> Then when we know the length of the array we use a for loop to implent it.<p>
 * @param fileName
 * @return an array with the integers inside the file.
 * @throws IOException
 * throws an exception if the file are not found
 */
	public static int[] array;
	public static int[] readFile (String fileName) throws IOException{			
		Scanner fil = new Scanner(new File (fileName));						
		int counter=0;
		while(fil.hasNext()){	
			counter++;
			fil.nextInt();
		}
		fil.close();
		array = new int [counter];
		Scanner fil1 = new Scanner(new File (fileName));
		for(int i=0; i<array.length; i++){
			array [i] = fil1.nextInt();
		}
		fil1.close();
		return array;
	}	
}
