


public class Bud {
	
	private String namn,transaktion;
	private int    pris;
	/**
	 * a method to register a new bid.
	 * @param q
	 * @param w
	 * @param e
	 */
	public Bud(String q, String w, int e){
		namn= q;
		transaktion = w;
		pris = e;
		
	}
	
	/**
	 * a method to register if a buyer or seller change their bid.
	 * @param q
	 * @param w
	 * @param e
	 * @param r
	 */
	public Bud(String q, String w, int e, int r){
		namn = q;
		transaktion = w;
		pris = e;
	}
	/**
	 * a method that returns the buyer or sellers name
	 * @return
	 */
	public String getName(){
		return namn;
	}
	/**
	 * 
	 * @return
	 **/
	public String getTransaktions(){
		return transaktion;
	}
	/**
	 * a method that returns the buyer or sellers price
	 * @return
	 */
	public int getPris(){
		return pris;
	}
	/**
	 * a method that returns the buyer or sellers changed price.
	 * @param q
	 */
	public void NyttPris(int q){
		pris = q;
	}
	

}
