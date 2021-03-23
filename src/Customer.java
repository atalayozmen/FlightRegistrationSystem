
import java.util.Scanner;

import javax.swing.JOptionPane;

import java.util.InputMismatchException;

public class Customer implements Displayable, Comparable<Customer> {
	private int id;
	String name;
	String surname;
	String email;
	private int age;
	private int postCode;
	
	static int customerCount = 0;
	
	
	int[] rentalDVDArray = new int[20];
	int rentalDVDArrayIndex=0;
	
	Scanner myScanner = new Scanner(System.in);
	
	@Override
	public int compareTo(Customer customer1)
	{
		
		return this.age - customer1.getAge();
	
	}
	
	public Customer()
	{
		String stringID = JOptionPane.showInputDialog("Enter id");
		
		
		id = Integer.parseInt(stringID);
				
		
		boolean hasDigit = false;
		
		
		
		while(true)
		{
		try
		{
		
		name = JOptionPane.showInputDialog("Enter name");
		
		for(char c: name.toCharArray()) {
			if(Character.isDigit(c)) {
				hasDigit = true;
			}
			else
				hasDigit = false;
		}
		
		if(hasDigit)
		{
			throw new InputMismatchException();
		}
		
		}
		catch(InputMismatchException inputMismatchException)
		{			
			JOptionPane.showMessageDialog(null, "Name cannot contain any numbers!","Error", JOptionPane.ERROR_MESSAGE);
		}
		
		
		
		if(!hasDigit)
			break;
		}
		
		
		surname = JOptionPane.showInputDialog("Enter surname");
		
		String ageStr = JOptionPane.showInputDialog("Enter age");
		age = Integer.parseInt(ageStr);
		
		
		String postCodeStr = JOptionPane.showInputDialog("Enter postal code");
		postCode = Integer.parseInt(postCodeStr);
		
		
		email = JOptionPane.showInputDialog("Enter email");
		customerCount++;
	}

	public void displayInfo()
	{
		JOptionPane.showMessageDialog(null,"id:"+id+"\n"+ 
				"name:"+name+"\n"+
				"surname:"+surname+"\n"+
				"age:"+age+"\n"+
				"postal code:"+postCode+"\n"+
				"email:"+email+"\n" , "Customer info", JOptionPane.PLAIN_MESSAGE);
		
		//System.out.println("id:"+id+"\n"+ 
			//	"name:"+name+"\n"+
				//"surname:"+surname+"\n"+
				//"age:"+age+"\n"+
				//"postal code:"+postCode+"\n"+
				//"email:"+email+"\n");
	}

	public int getId()
	{
		return id;
	}

	public int getAge()
	{
		return age;
	}

	public int getPostCode()
	{
		return postCode;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public void setAge(int age) 
	{
		this.age = age;
	}

	public void setPostCode(int postCode) 
	{
		this.postCode = postCode;
	}
	public void setArray(int input) 
	{
		rentalDVDArray[rentalDVDArrayIndex] = input;
		rentalDVDArrayIndex++;
		
	}

}
