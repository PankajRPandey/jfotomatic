import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.image.*;

public class Crop {
MainUI mui;
Image clone;
Component co;
  public Crop() {
  }

public BufferedImage cropImage(Image scaledImage,int x,int y,int w,int h)
{
    //clone = co.createImage(new FilteredImageSource(scaledImage.getSource(),new CropImageFilter(x, y, w, h)));
	//clone=scaledImage;
    BufferedImage bi=new BufferedImage(scaledImage.getWidth(null),scaledImage.getHeight(null),1);
	Graphics g=bi.getGraphics();
	g.drawImage(scaledImage,0,0,null);
	g.dispose();

	BufferedImage cropped=bi.getSubimage(x,y,w,h);

	return cropped;

}
public Image getCroppedImage()
{
	return clone;
}



}
