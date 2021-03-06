import java.awt.*;
import java.awt.image.*;
import javax.imageio.IIOImage;
public class BandEffects implements StaticMatrices
{
	static Raster srcRaster;
	static WritableRaster dstRaster;

	public static BufferedImage RedBandEff(BufferedImage Img)
	{
	        	int w = Img.getWidth();   
	        	int h = Img.getHeight();  
		BufferedImage srcImg=new BufferedImage(w,h,Img.getType()); 
		Graphics2D g2=srcImg.createGraphics();
		g2.drawImage(Img,0,0,null);
		g2.dispose();
		srcRaster=srcImg.getRaster();
		BufferedImage dstImg=new BufferedImage(w,h,Img.getType());
		dstRaster=dstImg.getRaster();
		BandCombineOp bandCombineOp = new BandCombineOp(RED_BAND_MATRIX, null);
		bandCombineOp.filter(srcRaster, dstRaster);
		return dstImg;
	}
	public static BufferedImage BlueBandEff(BufferedImage Img)
	{
	        	int w = Img.getWidth();   
	        	int h = Img.getHeight();  
		BufferedImage srcImg=new BufferedImage(w,h,Img.getType()); 
		Graphics2D g2=srcImg.createGraphics();
		g2.drawImage(Img,0,0,null);
		g2.dispose();
		srcRaster=srcImg.getRaster();
		BufferedImage dstImg=new BufferedImage(w,h,Img.getType());
		dstRaster=dstImg.getRaster();
		BandCombineOp bandCombineOp = new BandCombineOp(BLUE_BAND_MATRIX, null);
		bandCombineOp.filter(srcRaster, dstRaster);
		return dstImg;
	}
	public static BufferedImage GreenBandEff(BufferedImage Img)
	{
	        	int w = Img.getWidth();   
	        	int h = Img.getHeight();  
		BufferedImage srcImg=new BufferedImage(w,h,Img.getType()); 
		Graphics2D g2=srcImg.createGraphics();
		g2.drawImage(Img,0,0,null);
		g2.dispose();
		srcRaster=srcImg.getRaster();
		BufferedImage dstImg=new BufferedImage(w,h,Img.getType());
		dstRaster=dstImg.getRaster();
		BandCombineOp bandCombineOp = new BandCombineOp(GREEN_BAND_MATRIX, null);
		bandCombineOp.filter(srcRaster, dstRaster);
		return dstImg;
	}
	public static BufferedImage InverseBandEff(BufferedImage Img)
	{
	        	int w = Img.getWidth();   
	        	int h = Img.getHeight();  
		BufferedImage srcImg=new BufferedImage(w,h,Img.getType()); 
		Graphics2D g2=srcImg.createGraphics();
		g2.drawImage(Img,0,0,null);
		g2.dispose();
		srcRaster=srcImg.getRaster();
		BufferedImage dstImg=new BufferedImage(w,h,Img.getType());
		dstRaster=dstImg.getRaster();
		BandCombineOp bandCombineOp = new BandCombineOp(INVERSE_BAND_MATRIX, null);
		bandCombineOp.filter(srcRaster, dstRaster);
		return dstImg;
	}
	public static BufferedImage AverageBandEff(BufferedImage Img)
	{
	        	int w = Img.getWidth();   
	        	int h = Img.getHeight();  
		BufferedImage srcImg=new BufferedImage(w,h,Img.getType()); 
		Graphics2D g2=srcImg.createGraphics();
		g2.drawImage(Img,0,0,null);
		g2.dispose();
		srcRaster=srcImg.getRaster();
		BufferedImage dstImg=new BufferedImage(w,h,Img.getType());
		dstRaster=dstImg.getRaster();
		BandCombineOp bandCombineOp = new BandCombineOp(AVERAGE_BAND_MATRIX, null);
		bandCombineOp.filter(srcRaster, dstRaster);
		return dstImg;
	}

}