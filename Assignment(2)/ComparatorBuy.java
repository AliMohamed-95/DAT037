

import java.util.Comparator;

public class ComparatorBuy implements Comparator<Bud> {
	
	private String namno1,
				   namno2;
	private int    priso1,
				   priso2;
	@Override
	/**
	 * this method compares two object of bud type and returns -1,0,1 depending 
	 * on how the two bids relate to each other
	 */
	public int compare(Bud o1, Bud o2){
		namno1 = o1.getName();
		priso1 = o1.getPris();
		namno2 = o2.getName();
		priso2 = o2.getPris();
		
		if((namno1.compareTo(namno2)==0) && (priso1==priso2)){
			return 0;
		}
		else if(priso1>=priso2){
			return 1;
		}
		else{
			return -1;
		}
	}
}
