

import java.util.Iterator;
import java.util.List;
import Lab3Help.*;

public class DijkstraStringPath implements Path<String> {
	
	 private DijkstraPath<String> Dijkstra = new DijkstraPath<String>();
	 private List<BStop> stops;
	 private List<BLineTable> lines;

	public DijkstraStringPath(List<BStop> stops,List<BLineTable> lines){
		this.stops = stops;
		this.lines = lines;
		makeGraph();
	}

	private void makeGraph(){
		final Graph<String> graph = new Graph<String>();
		BLineStop[] f;
		
		for(BStop e:stops){
			graph.addNode(e.getName());
		}
		
		for(int i=0; i<lines.size();i++){
			f= lines.get(i).getStops();
			
			for(int k=1; k<f.length; k++){
				String name = f[k-1].getName();
				graph.AddConnection(name,f[k].getName(),f[k].getTime());
				
			}
		}
		
		Dijkstra.graph = graph;
	}	
	
	@Override
	public void computePath(String fromNode, String toNode) {
		Dijkstra.dijkstra(fromNode, toNode);
	}
	@Override	
	public Iterator<String> getPath() {		
		return Dijkstra.getPath().iterator();
	}
	
	@Override
	public int getPathLength(){
		return Dijkstra.getPathLength();
	}
}