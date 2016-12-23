
import java.util.ArrayList;
import java.util.HashMap;

public class Graph<E>{
	
	public HashMap<E, ArrayList<Edge<E>>> nodeSet = new HashMap<E, ArrayList<Edge<E>>>(1);
	
		/**
		 * addNode will add a node with parameter name to the HashMap nodeSet.
		 * @param name The name of the node that the method will try to add
		 * @throws IllegalArgumentException 
		 */
		
		public void addNode(E name){
			
			if(nodeSet.get(name)==null)
				nodeSet.put(name, new ArrayList<Edge<E>>());
			else
				throw new IllegalArgumentException("The node you're trying to add already exsist");
		}
		
		/**
		 * AddConnection will add a new edge to existing node. If the cost of the new edge i smaller then the existing edge, 
		 * the method will substitute the edges.</p>
		 * @param source The name of the node that will have a edge.
		 * @param target The name of the node that is connected to parent node.
		 * @param weight The edge cost between the parent node and the children node.
		 */
		public void AddConnection(E source, E target, int weight){

			Edge<E> newedge = new Edge<E>(target,weight);

			for(Edge<E> oldEdge : getConnections(source)) {
				if(target.equals(oldEdge.getName())) {
					
					if(weight < oldEdge.getWeight()) {
						oldEdge.setConnection(target, weight);
					}
					
					return;
				}
			}
			
			nodeSet.get(source).add(newedge);
			
		}
		/**
		 * The method return a arrayList of edges from a given node.</p>
		 * @param name The name of the node
		 * @return ArrayList<E>
		 * @throws IllegalArgumentException
		 */
		
		public ArrayList<Edge<E>> getConnections(E name){
			if(nodeSet.get(name)==null)
				throw new IllegalArgumentException("The node dosen't exsist");
			
			else
				return nodeSet.get(name);
		}
}

class Edge<E> implements Comparable<Edge<E>>{
	
	private E name;
	private int weight;
	
		/**
		 * The constructor initializes the variables name and weight. Through the method setConnection().
		 * @param name The name of the edge
		 * @param weight The weight from parent node and children node.
		 */
	
		Edge(E name, int weight){
			setConnection(name,weight);
		}
	/**
	 * setConnection changes the values name and weight
	 * @param name The new name
	 * @param weight The new weight
	 */
		public void setConnection(E name, int weight){
			this.name = name;
			this.weight = weight;
		}
	/**
	 * The method returns the value stored in name.
	 * @return E
	 */
		public E getName(){
			return name;
		}
		
		/**
		 * getWeight returns the value stores in weight
		 * @return Integer
		 */
		
		public int getWeight(){
			return weight;
		}
		/** The method compares to Edge objects and then returns value bigger or smaller then 0 if the objects are unequal and 0 is the objects are equal.
		 *@param a The name of the object
		 *@return Integer
		 */
		
		@Override
		public int compareTo(Edge<E> a){
			if((this.name.equals(a.name)) &&(this.weight==a.weight)){
				return 0;
			}
			else if(this.weight>=a.weight){
				return 1;
			}
			else {
				return -1;
			}
			
			
		}
		
	
}


	





