
import java.util.Scanner;

import javax.swing.JOptionPane;

import java.util.InputMismatchException;

public abstract class Content implements Displayable{
	int id;
	String title;
	String artist;
	int length;
	Date rentDate;
	Scanner myScanner = new Scanner(System.in);
	Genre genre;
	double costPerDay = 1.0;
	
	public Content(String newGenre)
	{
		
		
		String stringID = JOptionPane.showInputDialog("Enter id");
		id = Integer.parseInt(stringID);
		
		title = JOptionPane.showInputDialog("Enter title");
		
		artist = JOptionPane.showInputDialog("Enter artist");
		
		
		while(true)
		{
			
			
			
			boolean exceptionHappened = false;
			try {
			String strLength = JOptionPane.showInputDialog("Enter length");
			length = Integer.parseInt(strLength);
			}
			catch(NumberFormatException numberFormatException) {
				exceptionHappened = true;
				JOptionPane.showMessageDialog(null, "length cannot be a String!" , "Error", JOptionPane.WARNING_MESSAGE);
			}
			
			if(!exceptionHappened)
			{
				break;
			}
		}
		
		genre.valueOf(newGenre);
		
	}
	public Content()
	{
		String stringID = JOptionPane.showInputDialog("Enter id");
		id = Integer.parseInt(stringID);
		
		title = JOptionPane.showInputDialog("Enter title");
		
		artist = JOptionPane.showInputDialog("Enter artist");
		
		
		
		while(true)
		{
			
			
			
			boolean exceptionHappened = false;
			try {
			String strLength = JOptionPane.showInputDialog("Enter length");
			length = Integer.parseInt(strLength);
			}
			catch(NumberFormatException numberFormatException) {
				exceptionHappened = true;
				JOptionPane.showMessageDialog(null, "length cannot be a String!" , "Error", JOptionPane.WARNING_MESSAGE);
			}
			
			if(!exceptionHappened)
			{
				break;
			}
		}
		
		this.genre=Genre.OTH;
		
	}
	
	public int returnid() 
	{
		return id;
		
	}
	public void updateRentDate() 
	{
		rentDate = new Date();
	}
	
	public abstract double calculatecost(int x);
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	

}

