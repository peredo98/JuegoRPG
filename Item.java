import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

public abstract class Item{
	private int imgx, imgy, imgw, imgh, cellx, cellx1, celly, celly1;
	private String url;
	private Boolean isDragged = false;

	
	public Item(int imgx, int imgy, int imgw, int imgh, String url){
		this.imgx = imgx;
		this.imgy = imgy;
		this.imgw = imgw;
		this.imgh = imgh;
		this.url = url;
	}

	public void setBounds(int cellx, int cellx1, int celly, int celly1){
		this.cellx = cellx;
		this.cellx1 = cellx1;
		this.celly = celly;
		this.celly1 = celly1;
	}

	public void setCellx(int cellx){
		this.cellx = cellx;
	}

	public void setCelly(int celly){
		this.celly = celly;
	}

	public int getCellx(){
		return cellx;
	}
	public int getCellx1(){
		return cellx1;
	}
	public int getCelly(){
		return celly;
	}
	public int getCelly1(){
		return celly1;
	}

	public void setIsDragged(boolean isDragged){
		this.isDragged = isDragged;
	}
	public boolean getIsDragged(){
		return isDragged;
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