import java.util.ArrayList;


public class LineSegment {
	
	private ArrayList<Point> myline;
	
	public LineSegment()
	{
		myline = new ArrayList<Point>();
	}
	
	public void addPoint(Point p)
	{
		myline.add(p);
	}
	

}
