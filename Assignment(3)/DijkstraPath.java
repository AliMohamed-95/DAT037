import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class DijkstraPath<E> {
	
	private HashMap<E, E> nodeMapPath = new HashMap<E, E>();
	private HashMap<E, Integer> nodeMapDistance = new HashMap<E, Integer>();
	private HashMap<E, Boolean> nodeMapVisited = new HashMap<E, Boolean>();
	private PriorityQueue<E> prio = new PriorityQueue<>(new Comparator<E>(){
		
		@Override
		public int compare(E o1, E o2){
			return nodeMapDistance.get(o1).compareTo(nodeMapDistance.get(o2));
		}
	});
	
	public E start, stop;
	public Graph<E> graph;

	/**
	 * The method takes two parameters in order to initialize the methods computePath() and Iinitialize(). </p>
	 * @param start The start node. 
	 * @param stop	The stop node. 
	 */
		public void dijkstra(E startNode, E stopNode){
			this.start = startNode;
			this.stop = stopNode;
			initiate();
			computePath();
		}
		/**
		 *  The method initializes nodeMapDistance and nodeMapPath to infinity and false
		 */
		
		public void initiate(){

			for(E i:graph.nodeSet.keySet()){
				nodeMapVisited.put(i, false);
				nodeMapDistance.put(i,Integer.MAX_VALUE);
				nodeMapPath.put(i, null);
			}
			prio.clear();
		}
		/**
		 * The the method updates the HashMaps nodeMapDistance and nodeMapPath with the values that's given as parameters.</P>
		 * @param name Name of the node to update
		 * @param path Node in which the connection is with.
		 * @param distance The new distance to the node
		 */
		
		public void update(E name, E path, Integer distance){
			nodeMapPath.put(name, path);
			nodeMapDistance.put(name, distance);
			
		}
		
		/**
		 * The method dijkstra calculates the minimum cost between two nodes in the Graph<E> class. The Graph object cant't contain negative weights.</p>
		 * The method is dependent of the HashMaps nodeMapDistance, nodeMapPath and nodeMapVisited. The method is also dependent of PriorityQueue prio.
		 */
				
		public void computePath(){
			
			update(start,start,0);
			prio.add(start);

			while(!prio.isEmpty()){
				
				E currentNode = prio.poll();
		
				if(!nodeMapVisited.get(currentNode)){
					
					for(Edge<E> e: graph.getConnections(currentNode)){
						
						E neighbour = e.getName();
						
						int newDistance = e.getWeight()+nodeMapDistance.get(currentNode);
						
						if(newDistance<nodeMapDistance.get(neighbour)){
							
							update(neighbour,currentNode,newDistance);
							prio.add(neighbour);
						}
					}
				}
				
				nodeMapVisited.put(currentNode, true);
			}

		 }
		
		/**
		 * The method uses the HashMap nodeMapPath to recalculate the nodes needed to visit in order to get the stop node.</p>
		 * @return The function returns an ArrayList of type E.
		 */

		public ArrayList<E> getPath(){
			E tempString = this.stop;
			ArrayList<E> tempArray = new ArrayList<E>();
			
			if(nodeMapPath.get(tempString)==null)
				return tempArray;

			while(tempString.equals(start)!=true){
				
					tempArray.add(tempString);
					tempString =nodeMapPath.get(tempString);
			}
			
			tempArray.add(start);
			
			return Collections.reverse(tempArray); 
			
		}
		
		/** Method returns the shortest distance
		 * @return int
		 */
		
		public int getPathLength(){
			return nodeMapDistance.get(stop);
		}		
}
		