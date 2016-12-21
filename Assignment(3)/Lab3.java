


import java.io.IOException;
import Lab3Help.*;
import java.util.Iterator;
import java.util.List;



public class Lab3 {
	

	
	public static void main(String[] arg) throws MalformedData, IOException{
		
		Lab3File fileParser = new Lab3File();
		List<BStop> stops = fileParser.readStops(arg[0]);
		List<BLineTable> lines = fileParser.readLines(arg[1]);
		new GUI(stops, lines, new DijkstraStringPath(stops, lines));
		
		
		
		
		Lab3File t2 = new Lab3File();
		DijkstraStringPath pathIterator = new DijkstraStringPath(t2.readStops(arg[0]),t2.readLines(arg[1]));
		pathIterator.computePath(arg[2],arg[3]);
		System.out.println(pathIterator.getPathLength());
		Iterator<String> test = pathIterator.getPath();
		while(test.hasNext()){
			System.out.println(test.next());
		}
	}
}



