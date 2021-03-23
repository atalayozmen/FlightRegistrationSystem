import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import java.util.*;


public class DigitalMovie extends Content {
	String streamingServer;
	
	Map<Integer, Review> customerReviews = new HashMap<Integer, Review>();
	
	Scanner s = new Scanner(System.in);
	
	public DigitalMovie()
	{
		super();
		this.streamingServer = JOptionPane.showInputDialog("Enter streaming server");
			
	}
	
	public void addToHashMap(int customerID, Review review)
	{
		customerReviews.put(customerID, review);
	}
	
	public void displayReview()
	{
		double totalRating=0;
		int ctr=0;
		
		for(Map.Entry mapElement : customerReviews.entrySet())
		{
			ctr++;
			
			Integer key = (Integer) mapElement.getKey();
			Review value = ((Review) mapElement.getValue());
			
			System.out.printf("Customer Id: %d\n", key);
			System.out.printf("Rating: %.2f \n", value.getStarRating());
			System.out.printf("Comment: %s \n \n", value.getComment());
			totalRating = totalRating + value.getStarRating();
			
		}
		
		double averageRating = totalRating / ctr;
		
		System.out.printf("The average star-rating of the movie is: %.2f\n\n", averageRating);
	}
	
	@Override
	public void displayInfo()
	{
		JOptionPane.showMessageDialog(null,"id:"+id+"\n"+ 
				"title:"+title+"\n"+
				"artist:"+artist+"\n"+
				"genre:"+genre.getDescription()+"\n"+
				"length:"+length+"\n"+
				"streaming service:"+streamingServer+"\n" , "Content info", JOptionPane.PLAIN_MESSAGE);
		
	}
	
	
	@Override
	public double calculatecost(int x) 
	{
		if(x <= 7)
			costPerDay = 1.0;
		else if (x <= 14)
			costPerDay = 0.8;
		else
			costPerDay = 0.5;
		
		return x*costPerDay;
		
		
	}

}
