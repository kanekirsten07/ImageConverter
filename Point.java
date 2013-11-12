
public class Point {

	
	private int x;
	private int y;
	//Default to zero to prevent errors
	private int color = 0;
	
	public Point(int newx, int newy, int newcolor)
	{
		this.x = newx;
		this.y = newy;
		this.color = newcolor;
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public int getColor()
	{
		return color;
	}
	
	public void setX(int x)
	{
		this.x = x;
	}
	
	public void setY(int y)
	{
		this.y = y;
	}
	public void setColor(int newcolor)
	{
		this.color = newcolor;
	}
}
