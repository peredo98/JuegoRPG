import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

public abstract class Character extends GameObject{
	private BufferedImage img = null;
	
	public Character(int x, int y, int imgx, int imgy, String url){
		super(x, y, imgx, imgy, url);
		this.downImgy = imgy;
		this.leftImgy = imgy + 48;
		this.rightImgy = imgy +96;
		this.upImgy = imgy + 144;
		this.anim1 = imgx - 48;
		this.anim2 = imgx;
		this.anim3 = imgx + 48;
	}

	public Character(int x, int y, int imgx, int imgy){
		super(x, y, imgx, imgy);
		this.downImgy = imgy;
		this.leftImgy = imgy + 48;
		this.rightImgy = imgy +96;
		this.upImgy = imgy + 144;
		this.anim1 = imgx - 48;
		this.anim2 = imgx;
		this.anim3 = imgx + 48;
	}


	public void tick(){

	}

	public void render(Graphics g){
		try {
  			  img = ImageIO.read(new File(url));
		} 
		catch (IOException e) {
		}
		img = img.getSubimage(imgx, imgy, 48, 48);
		g.drawImage(img, x, y, 48, 48, null);
	}


}