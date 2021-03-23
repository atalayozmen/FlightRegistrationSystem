import java.util.Scanner;
public class Date {
	int day;
	int month;
	int year;
	
	Scanner input = new Scanner(System.in);
	
	public Date()
	{
		System.out.printf("Enter day \n");
		String str1=input.nextLine();
		this.day=Integer.parseInt(str1);
		System.out.printf("Enter month \n");
		String str2=input.nextLine();
		this.month=Integer.parseInt(str2);
		System.out.printf("Enter year \n");
		String str3=input.nextLine();
		this.month=Integer.parseInt(str3);
	}
	
}
