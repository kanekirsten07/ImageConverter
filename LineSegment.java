import java.util.ArrayList;


public class LineSegment {
	
	private ArrayList<Point> myline;
	private int size;
	
	public LineSegment()
	{
		myline = new ArrayList<Point>();
		size = 0;
	}
	
	public void addPoint(Point p)
	{
		myline.add(p);
		size++;
	}
	
	
	public int getSize()
	{
		return size;
	}

}
