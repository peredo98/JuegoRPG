import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

public abstract class Item{
	private int imgx, imgy, imgw, imgh;
	private String url;
	
	public Item(int imgx, int imgy, int imgw, int imgh, String url){
		this.imgx = imgx;
		this.imgy = imgy;
		this.imgw = imgw;
		this.imgh = imgh;
		this.url = url;
	}

	public void setImgx(int imgx){
		this.imgx = imgx;
	}
	public int getImgx(){
		return imgx;
	}
	public void setImgy(int imgy){
		this.imgy = imgy;
	}
	public int getImgy(){
		return imgy;
	}
	public void setImgw(int imgw){
		this.imgw = imgw;
	}
	public int getImgw(){
		return imgw;
	}
	public void setImgh(int imgh){
		this.imgh = imgh;
	}
	public int getImgh(){
		return imgh;
	}
	public void setUrl(String url){
		this.url = url;
	}
	public String getUrl(){
		return url;
	}
	public BufferedImage getImage(){
		BufferedImage img = null;
		try {
  			img = ImageIO.read(new File(url));
  			img = img.getSubimage(imgx, imgy, imgw, imgh);
		} 
		catch (IOException e) {
		}
		return img;
	}

}