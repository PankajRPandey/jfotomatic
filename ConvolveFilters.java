import java.awt.*;
import java.awt.image.*;

public class ConvolveFilters implements StaticMatrices
{
	public ConvolveFilters()
	{}
	public static BufferedImage Sharpen(BufferedImage src)
	{
		int w=src.getWidth();
		int h=src.getHeight();
		BufferedImage dest=new BufferedImage(w,h,src.getType());
		Kernel kernel = new Kernel(3, 3, SHARPEN_MATRIX);
		ConvolveOp op = new ConvolveOp(kernel);
		op.filter(src,dest);
		return dest;
	}
	public static BufferedImage Blur(BufferedImage src)
	{
		int w=src.getWidth();
		int h=src.getHeight();
		BufferedImage dest=new BufferedImage(w,h,src.getType());
		Kernel kernel = new Kernel(3, 3, BLUR_MATRIX);
		ConvolveOp op = new ConvolveOp(kernel);
		op.filter(src,dest);
		return dest;
	}
	public static BufferedImage EdgeDetect(BufferedImage src)
	{
		int w=src.getWidth();
		int h=src.getHeight();
		BufferedImage dest=new BufferedImage(w,h,src.getType());
		Kernel kernel = new Kernel(3, 3, EDGE_MATRIX);
		ConvolveOp op = new ConvolveOp(kernel);
		op.filter(src,dest);
		return dest;
	}

}