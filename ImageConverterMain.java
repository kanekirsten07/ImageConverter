import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;


public class ImageConverterMain {
	private static JFrame frame;
	private static ArrayList<ArrayList<Integer>> mylist = new ArrayList<ArrayList<Integer>>();
	private static ArrayList<Integer> innerlist;
	private static int [][] newlist;
	private static int [][] newlist2;
	private static houghTransform h = new houghTransform();
	public static void main(String[] args)
	{
		String filename = File.separator+"Users";
		JFileChooser fc = new JFileChooser(new File(filename));
		
		fc.showOpenDialog(frame);
		
		File selFile = fc.getSelectedFile();
		
		convertToArray(selFile);
		h.runHoughTransform(newlist);
	}
	
	public static void convertToArray(File myimg)
	{
		BufferedImage bi;
		try {
			bi = ImageIO.read(myimg);
			int w = bi.getWidth();
			int h = bi.getHeight();
			//int [] newImage = bi.getRGB(0, 0, w, h, null, 0, w);
			PrintWriter out = new PrintWriter(new FileWriter("output.txt"));
			int value[][] = new int[h][w];
			//newlist = new int[h][w];
			//newlist = new int[h][w];
			//System.out.println(w);
			//System.out.println(h);
			for(int i=0; i<h; i++)
			{
				for(int k = 0; k<w; k++)
				{
					innerlist = new ArrayList<Integer>();
					value[i][k] = bi.getRGB(k,i);
					//System.out.print(value[i][k]);
					innerlist.add(value[i][k]);
				}
				mylist.add(innerlist);
				//System.out.println("");
				
			}
			newlist = value;
			out.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	


}
