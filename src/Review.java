import java.util.Scanner;

public class Review {
	double starRating;
	String comment;
	
	public Review()
	{
		Scanner s = new Scanner(System.in);
		
		System.out.printf("Rate the digital movie on a 1-10 rating scale: ");
		this.starRating = Double.parseDouble(s.nextLine());
		
		
		System.out.printf("Write a short review about the movie: ");
		this.comment = s.nextLine();
		
		
	}

	public double getStarRating() {
		return starRating;
	}

	public void setStarRating(double starRating) {
		this.starRating = starRating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
}
