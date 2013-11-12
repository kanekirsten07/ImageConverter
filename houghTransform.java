import java.util.ArrayList;
public class houghTransform {
	private ArrayList<LineSegment> rightdiagonal = new ArrayList<LineSegment>();
	private ArrayList<LineSegment> leftdiagonal = new ArrayList<LineSegment>();
	private ArrayList<LineSegment> vertical = new ArrayList<LineSegment>();
	private ArrayList<LineSegment> horizontal = new ArrayList<LineSegment>();
	int vertedges = 0;
	int horedges = 0;
	int diagrightEdges = 0;
	int diagleftEdges = 0;
	
	private int width;
	private int height;
	
	public void runHoughTransform(int[][] a)
	{
		width = a[0].length;
		height = a.length;
		diagonalRun(a);
		verticalRun(a);
		 horizontalRun(a);
		
		System.out.println("Vertical Lines: " + vertical.size());
		System.out.println("Horizontal Lines: " + horizontal.size());
		System.out.println("Right Diagonal LInes: "+ rightdiagonal.size());
		System.out.println("Left Diagonal LInes: "+ leftdiagonal.size());
		System.out.println("Vert Edges Detected: " + vertedges);
		System.out.println("Hor Edges Detected: " + horedges);
		System.out.println("Diag left Edges Detected: " + diagleftEdges);
		System.out.println("Diag right Edges Detected: " + diagrightEdges);
	}
	
	private void diagonalRun(int[][] a)
	{
		
		//1.
		// Left to right, going up to the right each iteration of c
		for(int r = 1; r <height && r >= 0; r++)
		{
			LineSegment templines = new LineSegment();
			Point previouspoint = new Point(-1, -1, 0);
			
			for(int c = 0, newrow=r; newrow >= 0 && c < width; c++, newrow--)
			{
				Point p2 = new Point(newrow, c, a[newrow][c]);
				//System.out.print(newrow);
				//System.out.println(c);
				if((a[r][c]) == previouspoint.getColor())
				{
					if(templines.getSize()== 0)
					{
						templines.addPoint(previouspoint);
						templines.addPoint(p2);
						edgeDetection(2, a, p2);
					}
					else
					{
						templines.addPoint(p2);
						edgeDetection(2, a, p2);
					}
				}
				previouspoint = p2;
				
			}
			if(templines.getSize() != 0)
			{
			 leftdiagonal.add(templines);
			}
			
			if(r == height-1)
			{
				for(int columnstart = 1; columnstart < width; columnstart++)
				{
				for(int c = columnstart, newrow=r; newrow >= 0 && c < width; c++, newrow--)
				{
					Point p2 = new Point(newrow, c, a[newrow][c]);
					//System.out.print(newrow);
					//System.out.println(c);
					if((a[r][c]) == previouspoint.getColor())
					{
						if(templines.getSize()== 0)
						{
							templines.addPoint(previouspoint);
							templines.addPoint(p2);
							edgeDetection(2, a, p2);
						}
						else
						{
							templines.addPoint(p2);
							edgeDetection(2, a, p2);
						}
					}
					previouspoint = p2;
					
				}
				}
				if(templines.getSize() != 0)
				{
				 leftdiagonal.add(templines);
				}
			}
		
		}
		
		
		
		// 3.
		// Left to right going up to the left each iteration of c
		for(int r = height-1; r >=0 ; r--)
		{
			int newcolumnstart;
			System.out.println(r);
			LineSegment templines = new LineSegment();
			Point previouspoint = new Point(-1, -1, 0);
			if(r==height-2)
			{
				 newcolumnstart = width-1;
			}
			else
			{
				newcolumnstart = 1;
			}
			for(int columnstart = newcolumnstart; columnstart < width; columnstart++)
			{
			for(int c = columnstart, newrow= r; newrow >= 0 && c >= 0 ; c--, newrow--)
			{
				Point p2 = new Point(newrow, c, a[newrow][c]);
				System.out.print(newrow);
				System.out.println(c);
				if((a[r][c]) == previouspoint.getColor())
				{
					if(templines.getSize()== 0)
					{
						templines.addPoint(previouspoint);
						templines.addPoint(p2);
						edgeDetection(3, a, p2);
					}else
					{
						templines.addPoint(p2);
						edgeDetection(3, a, p2);
					}
				}
				previouspoint = p2;
			}
			}
			if(templines.getSize() != 0)
			{
			 rightdiagonal.add(templines);
			}
			
		}
		
	}
	
	private void verticalRun(int [][] a)
	{
		
		for(int j = 0; j< width; j++)
		{
			LineSegment templines = new LineSegment();
			Point previouspoint = new Point(-1, -1, 0);
		for(int i = 0; i < height; i++)
		{
			Point p2 = new Point(i, j, a[i][j]);
			
			if((a[i][j]) == previouspoint.getColor())
			{
				if(templines.getSize()== 0)
				{
					templines.addPoint(previouspoint);
					templines.addPoint(p2);
					edgeDetection(0, a, p2);
				}else
				{
					templines.addPoint(p2);
					edgeDetection(0, a, p2);
				}
			}
			previouspoint = p2;
			
		}
		if(templines.getSize() != 0)
		{
		 this.vertical.add(templines);
		}
		}
		
	}
	
	private void horizontalRun(int [][] a)
	{
		for(int j = 0; j< height; j++)
		{
			LineSegment templines = new LineSegment();
			Point previouspoint = new Point(-1, -1, 0);
		for(int i = 0; i < width; i++)
		{
			Point p2 = new Point(j, i, a[j][i]);
			
			if((a[j][i]) == previouspoint.getColor())
			{
				if(templines.getSize()== 0)
				{
					templines.addPoint(previouspoint);
					templines.addPoint(p2);
					edgeDetection(1, a, p2);
				}
				else
				{
				templines.addPoint(p2);
				edgeDetection(1, a, p2);
				}
			}
			previouspoint = p2;
			
		}
		if(templines.getSize() != 0)
		{
		 this.horizontal.add(templines);
		}
		}
		
	
	}
	
	private void edgeDetection(int detectionMode, int[][]a, Point p)
	{
		/*
		 *  detectionMode:
		 *  0: Vertical
		 *  1: Horizontal
		 *  2: Right Diagonal
		 *  3: Left Diagonal
		 */
		
		switch(detectionMode)
		{
		case(0):
			//Check on the left and right sides
			if(p.getX()-1 >0)
			{
				int edgecolor = a[p.getX()-1][p.getY()];
				int mycolor = a[p.getX()][p.getY()];
				if(Math.abs(edgecolor - mycolor) > 5)
				{
					vertedges++;
				}
			}
		if(p.getX()+1 < height)
		{
			int edgecolor = a[p.getX()+1][p.getY()];
			int mycolor = a[p.getX()][p.getY()];
			if(Math.abs(edgecolor - mycolor) > 5)
			{
				vertedges++;
			}
		}
			break;
		case(1):
			//Check top and bottom
			if(p.getY()-1 >0)
			{
				int edgecolor = a[p.getX()][p.getY()-1];
				int mycolor = a[p.getX()][p.getY()];
				if(Math.abs(edgecolor - mycolor) > 5)
				{
					horedges++;
				}
			}
		if(p.getY()+1 < width)
		{
			int edgecolor = a[p.getX()][p.getY()+1];
			int mycolor = a[p.getX()][p.getY()];
			if(Math.abs(edgecolor - mycolor) > 5)
			{
				horedges++;
			}
		}
			break;
		case(2):
			//Diagonal Right
			if(p.getX()-1 >0 && p.getY() -1 > 0)
			{
				int edgecolor = a[p.getX()-1][p.getY()-1];
				int mycolor = a[p.getX()][p.getY()];
				if(Math.abs(edgecolor - mycolor) > 5)
				{
					diagrightEdges++;
				}
			}
		if(p.getX()+1 < height && p.getY()+1 < width)
		{
			int edgecolor = a[p.getX()+1][p.getY()+1];
			int mycolor = a[p.getX()][p.getY()];
			if(Math.abs(edgecolor - mycolor) > 5)
			{
				diagrightEdges++;
			}
		}
			break;
		case(3):
			//Diagonal Left
			if(p.getX()-1 >0 && p.getY() +1 < width)
			{
				int edgecolor = a[p.getX()-1][p.getY()+1];
				int mycolor = a[p.getX()][p.getY()];
				if(Math.abs(edgecolor - mycolor) > 5)
				{
					diagleftEdges++;
				}
			}
		if(p.getX()+1 < height && p.getY()-1 > 0)
		{
			int edgecolor = a[p.getX()+1][p.getY()-1];
			int mycolor = a[p.getX()][p.getY()];
			if(Math.abs(edgecolor - mycolor) > 5)
			{
				diagleftEdges++;
			}
		}
			break;
		}
		
	}
	
	
	
	

}



