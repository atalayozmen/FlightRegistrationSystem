
import java.util.Scanner;

import javax.swing.JOptionPane;

public class DVD extends Content {
	Date rentDate;
	
	Scanner myScanner = new Scanner(System.in);
	Genre genre;
	
	public DVD(String newGenre){
		super();
		this.genre = Genre.valueOf(newGenre);
		
	}
	public DVD(){
		super();
		this.genre=Genre.OTH;
		
	}
	@Override
	public void displayInfo(){
		
		JOptionPane.showMessageDialog(null,"id:"+id+"\n"+ 
				"title:"+title+"\n"+
				"artist:"+artist+"\n"+
				"genre:"+genre.getDescription()+"\n"+
				"length:"+length+"\n"
				 , "Content info", JOptionPane.PLAIN_MESSAGE);
		
		
		
	}
	public int returnid() {
		return id;
		
	}
	public void updateRentDate() {
		rentDate=new Date();
	}
	
	@Override
	public double calculatecost(int x) 
	{
		if(x <= 7)
			costPerDay = 1.0;
		else if (x <= 14)
			costPerDay = 1.2;
		else
			costPerDay = 2.0;
		
		return x*costPerDay;
		
		
	}
}

