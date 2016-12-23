


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Lab2{
	PriorityQueue<Bud> SellQueue = new PriorityQueue<Bud>(new ComparatorBuy());
	PriorityQueue<Bud> buyQeue = new PriorityQueue<Bud>(new ComparatorSell());
	
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
			SellQueue.insert(new Bud(q,w,e));
			Bidding();
		}
		if(w.compareTo(new String("K"))==0){
			buyQeue.insert(new Bud(q,w,e));
			Bidding();
		}
		
	}
	/**
	 * This method compares if the buyer or seller wants to change the price and the change the price accordingly. 
	 * then it calls the bidding method to make the transaction. 
	 * @param name
	 * @param tranaction
	 * @param oldPrice
	 * @param newPrice
	 */
	public void transaktion(String name, String tranaction, int oldPrice, int newPrice){
		
		if(tranaction.compareTo(new String("NS"))==0){
			
			if(SellQueue.findValue(new Bud(name,tranaction,oldPrice))==-1){
				
				throw new IllegalArgumentException("The bid that you are trying to change dosen't exist");
			}
			
			else if(oldPrice<newPrice){
				
				SellQueue.heap.get(SellQueue.findValue(new Bud(name,tranaction,oldPrice))).setNewPrice(newPrice);
				SellQueue.bubbelDown(SellQueue.findValue(new Bud(name,tranaction,newPrice)));				
				Bidding();
			}
			
			else if(oldPrice>newPrice){
				
				SellQueue.heap.get(SellQueue.findValue(new Bud(name,tranaction,oldPrice))).setNewPrice(newPrice);
				SellQueue.bubbelUp(SellQueue.findValue( new Bud(name,tranaction,newPrice)));
				Bidding();
			}

			return;
		}
		
		if(tranaction.compareTo(new String("NK"))==0){
			
			if(buyQeue.findValue(new Bud(name,tranaction,oldPrice))==-1){
				
				throw new IllegalArgumentException("The bid that you are trying to change dosen't exist");
			}
			
			else if(oldPrice<newPrice){
				
				buyQeue.heap.get(buyQeue.findValue(new Bud(name,tranaction,oldPrice))).setNewPrice(newPrice);
				buyQeue.bubbelUp(buyQeue.findValue(new Bud(name,tranaction,newPrice)));
				Bidding();
			}
			
			else if(oldPrice>newPrice){
				
				buyQeue.heap.get(buyQeue.findValue(new Bud(name,tranaction,oldPrice))).setNewPrice(newPrice);
				buyQeue.bubbelDown(buyQeue.findValue( new Bud(name,tranaction,newPrice)));
				Bidding();
			}
	
			return;
		}
	}
	/**
	 * this method makes the transaction 
	 * between the buyer and the seller and prints out the 
	 * buyer, the seller and the price of the transaction.
	 */
	public void Bidding(){

		if(SellQueue.heap.size()>0 && buyQeue.heap.size()>0){
			
			if(buyQeue.heap.get(0).getPris()>= SellQueue.heap.get(0).getPris()){
				
				System.out.println(buyQeue.heap.get(0).getName() + " köper från "+ SellQueue.heap.get(0).getName()+ " för " + buyQeue.heap.get(0).getPris() + " kr");
				SellQueue.deleteMin();
				buyQeue.deleteMin();	
			}
		}
	}
	
	/**
	 * This method reads a *.txt file and puts it content as new bids.
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
	 * This method prints out the orderbok.
	 * @return void
	 */
	public void orderBok (){

		System.out.println("\nOrderbok");
		System.out.print("Säljare: ");

		while(SellQueue.heap.size()!=0){
			
			
			System.out.print(SellQueue.heap.get(0).getName() + " "+SellQueue.heap.get(0).getPris()+", ");
			SellQueue.deleteMin();
		}
		
		System.out.println("");
		System.out.print("Köpare: ");
		while(buyQeue.heap.size()!=0){
			
			System.out.print(buyQeue.heap.get(0).getName() + " "+buyQeue.heap.get(0).getPris()+", ");
			buyQeue.deleteMin();
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException{
		new Lab2(args[0]);
		 

		 
	}
}