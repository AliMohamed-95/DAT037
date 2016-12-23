

import java.util.Comparator;

public class ComparatorBuy implements Comparator<Bud> {
	
	private String name1,
				   name2;
	private int    price1,
				   price2;
	@Override
	/**
	 * This method compares two object of bud type and returns -1,0,1 depending 
	 * on how the two bids relate to each other.
	 */
	public int compare(Bud o1, Bud o2){
		name1 = o1.getName();
		price1 = o1.getPris();
		name2 = o2.getName();
		price2 = o2.getPris();
		
		if((name1.compareTo(name2)==0) && (price1==price2)){
			return 0;
		}
		else if(price1>=price2){
			return 1;
		}
		else{
			return -1;
		}
	}
}
