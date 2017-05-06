package MI_lecke;

import java.util.Scanner;



public class Main {
	public static void writeMatrix(int[] matrix, int width){
		
		int j=1;
		
		for(int i = 0; i< matrix.length;i++){
			System.out.print(matrix[i]+" ");
			if(j==width){
				System.out.println("");
				j=1;
			}
			else j++;
			
		}
		
	}
	
	
	public static void main(String[] args)
	{
		 
		Scanner scanner = new Scanner(System.in); 
		 
		while(scanner.hasNext())
		{
			int height = scanner.nextInt();
			int width =scanner.nextInt();
			 
			int count=scanner.nextInt();
			 
			 
			 
			Baggage b=new Baggage(width,height);
			 
			 
			Item[] items=new Item[count];
			 
			 
			 for(int i=0;i < count; i++){ 
					
				 items[i]= new Item(0,0,i+1);
				 items[i].height =scanner.nextInt();
				 items[i].width= scanner.nextInt();	 
				
			 }
			 
			 
			 
			 b.addItems(items);	 
			 b.fillBaggage();
			
			 b.writeMatrix();
		}
		scanner.close();
		 
		 

	}
}