package MI_lecke;

import java.util.ArrayList;

import java.util.Collections;
import java.util.Comparator;




public class Baggage {
	public int[] matrix;
	public int rows;
	public int columns;
	public ArrayList<Item> items;
	
	
	public Baggage(int width,int height){
		matrix= new int[width*height];
		for(int i=0;i<matrix.length;i++){
			 matrix[i]=0;
		}
		columns = width;
		rows= height;
		items=null;
		
		
	}
	public void addItems(Item[] items){
		this.items=new ArrayList<Item>();
		
		for(int i =0; i< items.length;i++){
			this.items.add(new Item(items[i].width,items[i].height,items[i].number));
		}	
		
	}
	public boolean fillBaggage(){
		Collections.sort(this.items, new Comparator<Item>(){
		     public int compare(Item o1, Item o2){
		         if(o1.height == o2.height){
		        	 if(o1.width == o2.width){	 
			        	 return 0;
			         }
			         return o1.width > o2.width ? -1 : 1;
		         } 
		             
		         return o1.height > o2.height ? -1 : 1;
		     }
		});
		
		//======================================================================
		//sorrend: height majd width
		//======================================================================
		boolean siker=true;
		for (Item it : items) {
		    if(!addItem(it)){
		    	siker=false;
		    	break;
		    }
		}
		if(siker==true)return true;
		
		//======================================================================
		//sorrend: width*height
		//======================================================================
		
		
		for(int i=0;i<matrix.length;i++){
			 matrix[i]=0;
		}
		
		Collections.sort(this.items, new Comparator<Item>(){
		     public int compare(Item o1, Item o2){

		         return o1.height*o1.width > o2.height* o2.width ? -1 : 1;
		     }
		});
		
		siker=true;
		for (Item it : items) {
		    if(!addItem(it)){
		    	siker=false;
		    	break;
		    }
		}
		
		return siker;
	}
	
	public boolean addItem(Item it){
		for(int i = 0;i< columns;i++){
			for(int j=0;j< rows;j++){
				if(tryAddItemToPlace(it,i,j)){
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean tryAddItemToPlace(Item it, int x, int y){
		for(int i = y;i< y+it.height;i++){
			for(int j=x;j<x+it.width;j++){
				if(i>=rows || j >= columns || matrix[i*columns+j]!=0){
					return false;
				}
			}
		}
		for(int i = y;i< y+it.height;i++){
			for(int j=x;j<x+it.width;j++){
				matrix[i*columns+j]=it.number;
			}
		}
		
		return true;
		
	}
	public void writeMatrix(){
		
		int j=1;
		
		for(int i = 0; i< matrix.length;i++){
			System.out.print(matrix[i]);
			if(j==columns && i!=matrix.length-1){
				System.out.println("");
				j=1;
			}
			else{
				System.out.print("\t");
				j++;
			}
			
		}
		
	}
}