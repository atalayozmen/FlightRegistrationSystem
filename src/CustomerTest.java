import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;

public class CustomerTest {



	public static void main(String args[]) {

		
		ArrayList<Displayable> displayableArray = new ArrayList<Displayable>();
		
		String input = JOptionPane.showInputDialog("1. Create a new Customer \n2. Create a new DVD \n"
				+ " 3. Create a new DVD with genre \n"+
		"4. Create a new Digital Movie \n" +
		"5. Rent a DVD\n" +
		"6. Display Customer Information \n"+
		"7. Display Content Information \n"+
		"8. Display number of customers \n"+
		"9. Display All Contents in order\n" +
		"10. Display All Customers in order\n" +
		"11. Write a review for a Digital Movie.\n"+
		"12. Display reviews for a Digital Movie.\n"+
		"0. Exit \n");
		
		Scanner myScanner = new Scanner(System.in);
		int choice = Integer.parseInt(input);
		
		

		while(choice != 0) 
		{
			  
			if(choice == 1) 
			{
				
				displayableArray.add(new Customer());
			}

			else if(choice == 2) 
			{
				
				displayableArray.add(new DVD());
				
			}

			else if(choice == 3) 
			{			
				String genre = JOptionPane.showInputDialog("Enter genre");								
				displayableArray.add(new DVD(genre));
			}
			else if (choice==4) 
			{
				displayableArray.add(new DigitalMovie());
				
			}
			else if(choice == 5) {
				System.out.println("Enter customer id");
				int idInput = myScanner.nextInt();
				myScanner.nextLine();
				boolean foundTheCustomer = false;
				boolean foundTheDVD=false;
				
				for(int i=0; i<displayableArray.size(); i++)
				{
					if(displayableArray.get(i) instanceof Customer)
					{
						Customer downcastedCustomer = (Customer) displayableArray.get(i);
						if(downcastedCustomer.getId() == idInput)
						{
							foundTheCustomer = true;
							System.out.println("Enter DVD id");
							int id2= myScanner.nextInt();
							myScanner.nextLine();
							
							for(int j=0; j<displayableArray.size(); j++)
							{
								if(displayableArray.get(j) instanceof Content) //direkt dvd mi diye sorsam yoksa content diye mi? content mi diye soruyorum
								{
									Content downcastedContent = (Content) displayableArray.get(j);
									if(downcastedContent.returnid() == id2) //if (contentArray[j].returnid() == id2)
									{
										foundTheDVD = true;
										downcastedContent.updateRentDate();
										int saveid = downcastedContent.returnid();
										downcastedCustomer.setArray(saveid);
										break;
									}
								}
							}
						}
					}
					
					
				}
				
				if(!foundTheDVD)
					System.out.println("DVD with the given id is not found.");
			
				if(!foundTheCustomer)
					System.out.println("Customer with the given id is not found.");
				
			}
				
				
				

			else if(choice == 6) //burada kaldýk. 13.04.2020 10:50 - devam
			{
				
				String stringID = JOptionPane.showInputDialog("Enter customer id");
				int id = Integer.parseInt(stringID);
				
			
				boolean found = false;
				for(int i=0; i<displayableArray.size(); i++)
				{
					if(displayableArray.get(i) instanceof Customer)
					{
						Customer downcastedCustomer = (Customer) displayableArray.get(i);
						
						if(downcastedCustomer.getId() == id)
						{
							downcastedCustomer.displayInfo();
							found = true;
							break;
						}
					}
					
					
				}
				if(!found)
					JOptionPane.showMessageDialog(null, "Customer with the given id is not found.","Customer not found", JOptionPane.ERROR_MESSAGE);
					
				
			}

			else if(choice == 7) {
				String stringDVDId = JOptionPane.showInputDialog("Enter content id"); 
				int DVDId = Integer.parseInt(stringDVDId);
				int rentTime;
				double result;
				boolean foundIt = false;
				
				for (int i = 0; i<displayableArray.size(); i++)
				{
					if(displayableArray.get(i) instanceof Content)
					{
						Content downcastedContent = (Content) displayableArray.get(i);
						
						if(downcastedContent.returnid() == DVDId) 
						{
							foundIt = true;
							downcastedContent.displayInfo();
							
							if(downcastedContent instanceof DigitalMovie)
								JOptionPane.showMessageDialog(null, "How long would you like to rent that Digital Movie?", "?", JOptionPane.QUESTION_MESSAGE);
							else if(downcastedContent instanceof DVD)
								JOptionPane.showMessageDialog(null, "How long would you like to rent that DVD?", "?", JOptionPane.QUESTION_MESSAGE);
							
							
							String rentTimeStr = JOptionPane.showInputDialog("Rent time");
							rentTime = Integer.parseInt(rentTimeStr);
							result = downcastedContent.calculatecost(rentTime);
							JOptionPane.showMessageDialog(null, "The rental cost for"+rentTime+" days is " +result+ "\n", "Info", JOptionPane.INFORMATION_MESSAGE);
							break;
						}
					}
				}
				if(!foundIt)
					System.out.println("DVD with the given id is not found.");
				
				
			}

			else if(choice == 8) {
				System.out.println("Number of Customers:"+Customer.customerCount);
			}
			
			else if(choice == 9) {
				List<Content> list = new ArrayList<Content>();
				Content downcastedContent;
				
				for(int j=0; j<displayableArray.size(); j++)
				{
					if(displayableArray.get(j) instanceof Content)
					{
						downcastedContent = (Content) displayableArray.get(j);
						list.add(downcastedContent);
					}
				}
				
				
				Collections.sort(list, new LengthComparator());
				
				for(int i=0; i<list.size(); i++)
				{
					list.get(i).displayInfo();
				}
				
				
			}
			
			else if(choice == 10) {
				List<Customer> list = new ArrayList<Customer>();
				Customer downcastedCustomer;
				
				for(int i=0; i<displayableArray.size(); i++)
				{
					if(displayableArray.get(i) instanceof Customer)
					{
						downcastedCustomer = (Customer) displayableArray.get(i);
						list.add(downcastedCustomer);
					}
				}
				
				Collections.sort(list);
				
				for(int j=0; j<list.size(); j++)
				{
					list.get(j).displayInfo();
				}
			}
			
			else if(choice == 11) 
			{
				Scanner s = new Scanner(System.in);
				boolean foundTheCustomer = false;
				boolean foundTheDigitalMovie = false;
				Customer downcastedCustomer;
				DigitalMovie downcastedDigitalMovie = null;
				int idInput;
				int digitalMovieIdInput =0;
				
				System.out.println("Please enter customer id");
				idInput = s.nextInt();
				s.nextLine();
				
				
				for(int i=0; i<displayableArray.size(); i++)
				{
					if(displayableArray.get(i) instanceof Customer)
					{
						downcastedCustomer = (Customer) displayableArray.get(i);
						if(downcastedCustomer.getId() == idInput)
						{
							foundTheCustomer = true;
						}
					}
				}
				
				if(foundTheCustomer)
				{
					System.out.println("Please enter digital movie id");
					digitalMovieIdInput = s.nextInt();
					s.nextLine();
					
					for(int j=0; j<displayableArray.size(); j++)
					{
						if(displayableArray.get(j) instanceof DigitalMovie)
						{
							downcastedDigitalMovie = (DigitalMovie) displayableArray.get(j);
							if(downcastedDigitalMovie.getId() == digitalMovieIdInput)
							{
								foundTheDigitalMovie = true;
							}
						}
					}
				}
				else
				{
					System.out.println("Customer with given id is not found");
				}
				
				if(foundTheDigitalMovie && foundTheCustomer)
				{
					downcastedDigitalMovie.addToHashMap(idInput, new Review());
				}
				else
				{
					System.out.println("Digital movie with given id is not found");
				}
							
				
					
			}
			
			else if(choice == 12)
			{
				Scanner s = new Scanner(System.in);
				int digitalMovieIdInput;
				DigitalMovie downcastedDigitalMovie = null; 
				boolean foundTheDigitalMovie = false;
				
				System.out.println("Enter Digital Movie id");
				digitalMovieIdInput = s.nextInt();
				
				for(int i=0; i<displayableArray.size(); i++)
				{
					if(displayableArray.get(i) instanceof DigitalMovie)
					{
						downcastedDigitalMovie = (DigitalMovie) displayableArray.get(i);
						if(downcastedDigitalMovie.getId() == digitalMovieIdInput)
						{
							foundTheDigitalMovie = true;
						}
					}
				}
				
				if (foundTheDigitalMovie)
				{
					downcastedDigitalMovie.displayReview();
				}
				
				
			}

			
			input = JOptionPane.showInputDialog("1. Create a new Customer \n2. Create a new DVD \n"
					+ " 3. Create a new DVD with genre \n"+
			"4. Create a new Digital Movie \n" +
			"5. Rent a DVD\n" +
			"6. Display Customer Information \n"+
			"7. Display Content Information \n"+
			"8. Display number of customers \n"+
			"9. Display All Contents in order\n" +
			"10. Display All Customers in order\n" +
			"11. Write a review for a Digital Movie.\n"+
			"12. Display reviews for a Digital Movie.\n"+
			"0. Exit \n");
			
			
			choice = Integer.parseInt(input);
		}

	}

}
