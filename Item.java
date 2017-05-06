package MI_lecke;

public class Item{
	public int width;
	public int height;
	public int number;
	
	
	public Item(int width, int height, int number){
		this.width=width;
		this.height=height;
		this.number=number;
		
	}

	
	public void write(){
		System.out.println("("+width+ "," + height+ ")");
		
	}

}
