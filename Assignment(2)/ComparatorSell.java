

import java.util.Comparator;

public class ComparatorSell implements Comparator<Bud> {
	
	private String 	name1,
					name2;
	private int		price1,
					price2;
	/**
	 * This method compares two object of bud type and returns -1,0,1 depending 
	 * on how the two bids relate to each other
	 */
	
	@Override
	public int compare(Bud o1, Bud o2) { 
		
		name1 = o1.getName();
		name2 = o2.getName();
		price1 = o1.getPris();
		price2 = o2.getPris();
		
		if(name1.equals(name2) &&(price1==price2))
			
			return 0;
		
		else if (price1>=price2)
			
			return -1;
		
		else 
			
			return 1;
	
		
	}

}
