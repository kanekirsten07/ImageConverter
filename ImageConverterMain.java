import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;


public class ImageConverterMain {
	private static JFrame frame;
	
	
	public static void main(String[] args)
	{
		String filename = File.separator+"Users";
		JFileChooser fc = new JFileChooser(new File(filename));
		
		fc.showOpenDialog(frame);
		
		File selFile = fc.getSelectedFile();
		
		convertToArray(selFile);
		
	}
	
	public static void convertToArray(File myimg)
	{
		BufferedImage bi;
		try {
			bi = ImageIO.read(myimg);
			int w = bi.getWidth();
			int h = bi.getHeight();
			//int [] newImage = bi.getRGB(0, 0, w, h, null, 0, w);
			int value[][] = new int[w][h];
			for(int i=0; i<w; i++)
			{
				for(int k = 0; k<h; k++)
				{
					value[i][k] = bi.getRGB(i,k);
					System.out.println(value[i][k]);
				}
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
