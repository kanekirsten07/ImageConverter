import java.util.ArrayList;
public class houghTransform {
	private ArrayList<LineSegment> diagonal;
	private ArrayList<LineSegment> vertical;
	private ArrayList<LineSegment> horizontal;
	Point previouspoint = new Point(-1, -1, 0);
	
	public void runHoughTransform(ArrayList<ArrayList<Integer>> a)
	{
		
		diagonal = diagonalRun(a);
		vertical = verticalRun(a);
		horizontal = horizontalRun(a);
	}
	
	private ArrayList<LineSegment> diagonalRun(ArrayList<ArrayList<Integer>> a)
	{
		for(int r = 0; r < a.size(); r++)
		{
			int columnstart = 0;
			//for(int c = columnstart)
		}
			
		return null;
	}
	
	private ArrayList<LineSegment> verticalRun(ArrayList<ArrayList<Integer>> a)
	{
		
		for(int j = 0; j< a.get(0).size(); j++)
		{
			LineSegment templines = new LineSegment();
		for(int i = 0; i < a.size(); i++)
		{
			Point p2 = new Point(j, i, a.get(j).get(i));
			
			if((a.get(j).get(i)) == previouspoint.getColor())
			{
				if(templines.getSize()== 0)
				{
					templines.addPoint(previouspoint);
					templines.addPoint(p2);
				}
			}
			previouspoint = p2;
			 
		}
		}
		return null;
	}
	
	private ArrayList<LineSegment> horizontalRun(ArrayList<ArrayList<Integer>> a)
	{
		for (int i = 0; i < a.size(); i++)
		{
			LineSegment templines = new LineSegment();
			for(int j = 0; j < a.get(i).size(); j++)
			{
				Point p2 = new Point(j, i, a.get(j).get(i));
				
				if((a.get(j).get(i)) == previouspoint.getColor())
				{
					if(templines.getSize()== 0)
					{
						templines.addPoint(previouspoint);
						templines.addPoint(p2);
					}
				}
				previouspoint = p2;
			}
		}
		
		return null;
	}
	
	
	
	

}



