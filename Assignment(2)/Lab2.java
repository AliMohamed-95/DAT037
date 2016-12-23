


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Lab2{
	PriorityQueue<Bud> t1 = new PriorityQueue<Bud>(new ComparatorBuy());
	PriorityQueue<Bud> t2 = new PriorityQueue<Bud>(new ComparatorSell());
	
	public Lab2(String q) throws FileNotFoundException{
		
		readFile(q);
		orderBok();
		
	}
	/**
	 * this method compares if the bid are seller or buyer and then calls the Bidding method to make the transaction.  
	 * @param q
	 * @param w
	 * @param e
	 */
	public void transaktion(String q, String w, int e){
		
		if(w.compareTo(new String("S"))==0){
			t1.insert(new Bud(q,w,e));
			Bidding();
		}
		if(w.compareTo(new String("K"))==0){
			t2.insert(new Bud(q,w,e));
			Bidding();
		}
		
	}
	/**
	 *  this method compares if the buyer or seller  
	 *  wants to change the price and the change the price accordingly. 
	 *  then calls the bidding method to make the transaction. 
	 * @param q
	 * @param w
	 * @param e
	 * @param r
	 */
	public void transaktion(String q, String w, int e, int r){
		if(w.compareTo(new String("NS"))==0){
			if(t1.findValue(new Bud(q,w,e))==-1){
				throw new IllegalArgumentException("The -NS-bid that you are trying to change dosen't exist");
			}
			else if(e<r){
				
				t1.heap.get(t1.findValue(new Bud(q,w,e))).NyttPris(r);
				t1.bubbelDown(t1.findValue(new Bud(q,w,r)));
				for(int i=0; i<t1.heap.size();i++){
					
				}
				
				Bidding();
			}
			else if(e>r){
				t1.heap.get(t1.findValue(new Bud(q,w,e))).NyttPris(r);
				t1.bubbelUp(t1.findValue( new Bud(q,w,r)));
				Bidding();
			}
			else if(e==r){
				throw new IllegalArgumentException("why do you wantYOU ARE CRAZY!!!");
			}
			
		}
		if(w.compareTo(new String("NK"))==0){
			if(t2.findValue(new Bud(q,w,e))==-1){
				throw new IllegalArgumentException("The bid -NK-that you are trying to change dosen't exist");
			}
			else if(e<r){
				t2.heap.get(t2.findValue(new Bud(q,w,e))).NyttPris(r);
				t2.bubbelUp(t2.findValue(new Bud(q,w,r)));
				Bidding();
			}
			else if(e>r){
				t2.heap.get(t2.findValue(new Bud(q,w,e))).NyttPris(r);
				t2.bubbelDown(t2.findValue( new Bud(q,w,r)));
				Bidding();
			}
			else if(e==r){
				throw new IllegalArgumentException("YOU ARE CRAZY!!!");
			}
			
		}
	}
	/**
	 * this method makes the transaction 
	 * between the buyer and the seller and prints out the 
	 * buyer, the seller and the price of the transaction.
	 */
	public void Bidding(){

		if(t1.heap.size()>0 && t2.heap.size()>0){
			if(t2.heap.get(0).getPris()>= t1.heap.get(0).getPris()){
				
				System.out.println(t2.heap.get(0).getName() + " köper från "+ t1.heap.get(0).getName()+ " för " + t2.heap.get(0).getPris() + " kr");
				t1.deleteMin();
				t2.deleteMin();
				
			}
		}
	}
	/**
	 * this method reads a txt file
	 * @param filNamn
	 * @throws FileNotFoundException
	 */
	public void readFile(String filNamn) throws FileNotFoundException{
		Scanner fil = new Scanner (new File(filNamn));
		String[] rad;
		int a=0;
		while(fil.hasNext()){
			rad = fil.nextLine().split(" ");
			a = rad.length;
				if(a==3){
					transaktion(rad[0],rad[1], Integer.parseInt(rad[2]));
					rad = null;
				}
				if(a==4){
					transaktion(rad[0],rad[1], Integer.parseInt(rad[2]), Integer.parseInt(rad[3]));
					rad = null;
				}
			
			
		}
		fil.close();
		
	}
	/**
	 * this method prints out the orderbok.
	 */
	public void orderBok (){

		System.out.println("\nOrderbok");

			System.out.print("Säljare: ");

		while(t1.heap.size()!=0){
			System.out.print(t1.heap.get(0).getName() + " "+t1.heap.get(0).getPris()+", ");
			t1.deleteMin();
		}
		System.out.println("");
		System.out.print("Köpare: ");
		while(t2.heap.size()!=0){
				System.out.print(t2.heap.get(0).getName() + " "+t2.heap.get(0).getPris()+", ");
				t2.deleteMin();
			
		}
	}
	public static void main(String[] args) throws FileNotFoundException{
		new Lab2(args[0]);
		 

		 
	}
}