import java.util.Comparator;

public class LengthComparator implements Comparator<Content> {
	
	public int compare(Content content1, Content content2)
	{
		int lengthCompare = content2.getLength() - content1.getLength();
				
		return lengthCompare;
	}

}
