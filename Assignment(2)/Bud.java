


public class Bud {
	
	private String name, transaction;
	private int    price;
	
	/**
	 * a constructor to register a new bid.
	 * @param name
	 * @param transaction
	 * @param price
	 */
	
	public Bud(String name, String transaction, int price){
		this.name= name;
		this.transaction = transaction;
		this.price = price;
		
	}
	

	/**
	 * A method that returns the buyer or sellers name
	 * @return String
	 */
	
	public String getName(){
		return name;
	}
	
	/**
	 * 
	 * @return string
	 **/
	
	public String getTransaktions(){
		return transaction;
	}
	
	/**
	 * a method that returns the price.
	 * @return int
	 */
	
	public int getPris(){
		return price;
	}
	
	/**
	 * a method that sets a new price.
	 * @param newPrice
	 * @return void
	 * 
	 */
	
	public void setNewPrice(int newPrice){
		price = newPrice;
	}
	

}
